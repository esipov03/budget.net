package com.hakaton.budshet.service;

import com.hakaton.budshet.convertor.XmlConvertor;
import com.hakaton.budshet.entity.Enterprise;
import com.hakaton.budshet.entity.Process;
import com.hakaton.budshet.model.xml.ProcessXmlModel;
import com.hakaton.budshet.repository.EnterpriseRepository;
import com.hakaton.budshet.repository.ProcessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.StringReader;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProcessService {


    @Autowired
    private EnterpriseRepository enterpriseRepository;

    @Autowired
    private ProcessRepository processRepository;


    public String createProcess(String xmlText) throws ParserConfigurationException, IOException, SAXException, ParseException {
        String message = "Xml файл успешно загружен";
        try {

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new InputSource(new StringReader(xmlText)));

            NodeList nodeList = document.getElementsByTagName("Document");
            List<ProcessXmlModel> processXmlModels = new ArrayList<ProcessXmlModel>();
            for (int i = 0; i < nodeList.getLength(); i++) {
                processXmlModels.add(XmlConvertor.getProcessXml(nodeList.item(i)));
            }

            for (ProcessXmlModel processXml : processXmlModels) {

                Enterprise founder = enterpriseRepository.getEnterpriseByInn(processXml.getInnFounder());
                Enterprise executor = enterpriseRepository.getEnterpriseByInn(processXml.getInnExcecutor());
                String number = processXml.getNumber();
                String status = processXml.getStatus();

                if (executor == null) {
                    return "Ошибка загрузки файла. ИНН:" + processXml.getInnExcecutor() + " не найден";
                }

                if (founder == null) {
                    return "Ошибка загрузки файла. ИНН: " + processXml.getInnFounder() + " не найден";
                }

                Process process = processRepository.getProcessByNumber(number);

                if(process!=null){
                    if(process.getStatusDocument()!=1){
                        process.setStatusDocument(Integer.parseInt(status));
                        process.setComment(xmlText);

                        processRepository.save(process);
                    } else {
                        return "Процесс с номером: " + number + " уже проверен";
                    }


                } else {
                    return "Процесса с номером документа " + number + " не существует";
                }

            }

        } catch (Exception ex) {
            return ex.getMessage();
        }

        return message;
    }

    public ResponseEntity<List<Enterprise>> getEnterpriseByParentId(int id){
        List<Enterprise> enterprises = enterpriseRepository.getEnterpriseByParentId(id);
        return ResponseEntity.ok(enterprises);

    }


}

