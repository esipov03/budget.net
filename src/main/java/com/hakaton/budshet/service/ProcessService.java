package com.hakaton.budshet.service;

import com.hakaton.budshet.convertor.XmlConvertor;
import com.hakaton.budshet.entity.Enterprise;
import com.hakaton.budshet.entity.Process;
import com.hakaton.budshet.entity.StatusDocument;
import com.hakaton.budshet.entity.TypeDocument;
import com.hakaton.budshet.model.xml.ProcessXmlModel;
import com.hakaton.budshet.repository.EnterpriseRepository;
import com.hakaton.budshet.repository.ProcessRepository;
import com.hakaton.budshet.repository.StatusDocumentRepository;
import com.hakaton.budshet.repository.TypeDocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ProcessService {


    @Autowired
    private EnterpriseRepository enterpriseRepository;

    @Autowired
    private StatusDocumentRepository statusDocumentRepository;

    @Autowired
    private TypeDocumentRepository typeDocumentRepository;

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
                Process process = new Process();

                Date dateApproval = new SimpleDateFormat("dd.MM.yyyy").parse(processXml.getDateApproval());

                Date dateCreate = new SimpleDateFormat("dd.MM.yyyy").parse(processXml.getDateCreate());

                Date dateEnd = new SimpleDateFormat("dd.MM.yyyy").parse(processXml.getDateEnd());
                Enterprise founder = enterpriseRepository.getEnterpriseByInn(processXml.getInnFounder());
                Enterprise executor = enterpriseRepository.getEnterpriseByInn(processXml.getInnExcecutor());
                StatusDocument statusDocument = statusDocumentRepository.findById(Integer.parseInt(processXml.getStatus())).get();
                TypeDocument typeDocument = typeDocumentRepository.findById(Integer.parseInt(processXml.getType())).get();

                List<Process> nextProcess = new ArrayList<>();
                List<Integer> nextProcessXml = new ArrayList<>();
                nextProcessXml = processXml.getProcessNext();
                if(nextProcessXml.size()!=0){
                    for(int i = 0;i<nextProcessXml.size();i++){
                        Process pro = processRepository.findById(nextProcessXml.get(i)).get();

                        if(pro!=null){
                            nextProcess.add(pro);
                        }
                    }
                }


                List<Process> previousProcess = new ArrayList<>();
                List<Integer> previousProcessXml = new ArrayList<>();
                previousProcessXml = processXml.getProcessPrevious();
                if(nextProcessXml.size()!=0){
                    for(int i = 0;i<nextProcessXml.size();i++){
                        Process pro = processRepository.findById(previousProcessXml.get(i)).get();

                        if(pro!=null){
                            previousProcess.add(pro);
                        }
                    }
                }



                if (executor == null) {
                    return "Ошибка загрузки файла. ИНН:" + processXml.getInnExcecutor() + " не найден";
                }

                if (founder == null) {
                    return "Ошибка загрузки файла. ИНН: " + processXml.getInnFounder() + " не найден";
                }

                if(statusDocument==null){
                    return "Ошибка загрузки файла. Статус документа:" + processXml.getStatus() + " не найден";

                }

                if(typeDocument==null){
                    return "Ошибка загрузки файла. Тип документа:" + processXml.getType() + " не найден";

                }


                String number = processXml.getNumber();

                process.setDateApproval(dateApproval);
                process.setDateCreate(dateCreate);
                process.setDateEnd(dateEnd);
                process.setExecutorEnterprise(executor);
                process.setFounderEnterprise(founder);
                process.setNumber(number);
                process.setStatusDocument(statusDocument);
                process.setTypeDocument(typeDocument);
                process.setNextProcess(nextProcess);
                process.setPreviousProcess(previousProcess);
                processRepository.save(process);

            }

        } catch (Exception ex) {
            return ex.getMessage();
        }

        return message;
    }
}

