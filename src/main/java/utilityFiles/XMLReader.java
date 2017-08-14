package utilityFiles;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

/**
 * Created by NEERAJ on 7/7/2017.
 */
public class XMLReader extends PropertyReader{

    public static synchronized HashMap<String, String> getTestDataBasedOnEnviornment(String testDataFile, String component, String enviornment) {
        HashMap<String, String> testData = new HashMap<String, String>();
        SAXBuilder builder = new SAXBuilder();
        File xmlFile = new File("src/main/java/testdata/" + testDataFile);
        System.out.println(xmlFile.getAbsolutePath());

        try {
            Document document = builder.build(xmlFile);
            Element rootNode = document.getRootElement().getChild("PSA" + enviornment);
            System.out.println("RootNode-->" + rootNode);

            List list = rootNode.getChildren(component);
            System.out.println("List is here-->" + list);

            for (int i = 0; i < list.size(); i++) {
                Element node = (Element) list.get(i);
                List ls = node.getChildren();
                for (int j = 0; j < ls.size(); j++) {
                    Element element = (Element) ls.get(j);
                    testData.put((element.getName()), element.getText());
                }
            }

        } catch (IOException io) {
            System.out.println(io.getMessage());
        } catch (JDOMException jdomex) {
            System.out.println(jdomex.getMessage());
        }

        //System.out.println("HashMap is here"+testData);
        return testData;
    }
}
