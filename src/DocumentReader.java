import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class DocumentReader {

    public Map<String, Integer> wordCount = new HashMap<String, Integer>();
    private Integer totalCount = 0;
    public static void main(String[] args) {
        DocumentReader reader = new DocumentReader();
//        reader.parseDocument(new File("C:\\Users\\euj346\\Desktop\\workspace\\semanticanalysis\\resources\\CFR-2016\\title-13\\CFR-2016-title13-vol1.xml"));
        reader.parseDocument(new File("home\\user\\finalproject\\CFR-2016\\title-13\\CFR-2016-title13-vol1.xml"));

    }

    public DocumentInfo parseDocument(File file) {
        DocumentInfo document = new DocumentInfo();
        try {
            DocumentBuilder dBuilder = DocumentBuilderFactory.newInstance()
                    .newDocumentBuilder();
            Document doc = dBuilder.parse(file);

            if (doc.hasChildNodes()) {
                printNote(doc.getChildNodes());
            }
            //document info
            document.setFile(file);
            document.setTotalCount(totalCount);
            document.setWordCount(wordCount);
        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        }
        return document;
    }

    private void printNote(NodeList nodeList) {
        for (int count = 0; count < nodeList.getLength(); count++) {
            Node tempNode = nodeList.item(count);
            // make sure it's element node.
            if (tempNode.getNodeType() == Node.ELEMENT_NODE) {
                // get node name and value
                tokenizeContent(tempNode.getTextContent());
                if (tempNode.hasAttributes()) {
                    // get attributes names and values
                    NamedNodeMap nodeMap = tempNode.getAttributes();
                    for (int i = 0; i < nodeMap.getLength(); i++) {
                        Node node = nodeMap.item(i);
                        tokenizeContent(node.getNodeValue());
                    }
                }
                if (tempNode.hasChildNodes()) {
                    // loop again if has child nodes
                    printNote(tempNode.getChildNodes());
                }
            }
        }
    }

    private void tokenizeContent(String val){
        if(val != null) {
            String[] values = val.replaceAll("^[,\\s]+", "").split("[,\\s]+");
            for (String value : values) {
                if (!wordCount.containsKey(value)) {
                    wordCount.put(value, 0);
                }
                int count = wordCount.get(value) + 1;
                wordCount.put(value, count);
                totalCount++;
            }
        }
    }
}
