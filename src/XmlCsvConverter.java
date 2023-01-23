import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class XmlCsvConverter {

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException, TransformerException {

            File stylesheet = new File("C:\\Users\\EGYPT SRORE\\IdeaProjects\\SimpleLearningManagementSystem\\src\\stylesheet.xsl");
            File xmlSource = new File("C:\\Users\\EGYPT SRORE\\IdeaProjects\\SimpleLearningManagementSystem\\src\\Xml_CourseData.xml");

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(xmlSource);

            StreamSource stylesource = new StreamSource(stylesheet);
            Transformer transformer = TransformerFactory.newInstance().newTransformer(stylesource);
            Source source = new DOMSource(document);
            Result outputTarget = new StreamResult(new File("C:\\Users\\EGYPT SRORE\\IdeaProjects\\SimpleLearningManagementSystem\\src\\Xml_CourseData.xml"));
            transformer.transform(source, outputTarget);
        }
    }
