package com.hakaton.budshet.convertor;

import com.hakaton.budshet.entity.Process;
import com.hakaton.budshet.model.xml.ProcessXmlModel;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class XmlConvertor {

    public static ProcessXmlModel getProcessXml(Node node) {
        ProcessXmlModel processXml = new ProcessXmlModel();
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) node;
            processXml.setDateApproval( getTagValue("DateApproval", element));
            processXml.setDateCreate((getTagValue("DateCreate", element)));
            processXml.setInnExcecutor((getTagValue("InnExcecutor", element)));
            processXml.setInnFounder((getTagValue("InnFounder", element)));
            processXml.setNumber((getTagValue("Number", element)));
            processXml.setType((getTagValue("Type", element)));
            processXml.setStatus((getTagValue("Status", element)));
            processXml.setDateEnd((getTagValue("DateEnd",element)));

            NodeList previousProcessXml = element.getElementsByTagName("ProcessPrevious");
            List<Integer> previousProcess = new ArrayList<>();
            for(int i = 0;i<previousProcessXml.getLength();i++){
                Node item = (Node) previousProcessXml.item(i);
                previousProcess.add(Integer.parseInt(item.getNodeValue()));
            }


            NodeList nextProcessXml = element.getElementsByTagName("ProcessNext");
            List<Integer> nextProcess = new ArrayList<>();
            for(int i = 0;i<nextProcessXml .getLength();i++){
                Node item = (Node) nextProcessXml.item(i);
                nextProcess.add(Integer.parseInt(item.getNodeValue()));
            }

            processXml.setProcessNext(nextProcess);
            processXml.setProcessPrevious(previousProcess);

        }

        return processXml;
    }

    public static String getTagValue(String tag, Element element) {
        NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node node = (Node) nodeList.item(0);
        return node.getNodeValue();
    }
}
