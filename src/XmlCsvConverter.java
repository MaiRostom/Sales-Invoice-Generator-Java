import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;

public class XmlCsvConverter {

    public static void main(String[] args) throws IOException {
//
//        String content= null;
//        try {
//            content = readFile("student-data");
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
        convert("C:\\Users\\EGYPT SRORE\\IdeaProjects\\SimpleLearningManagementSystem\\src\\Xml_CourseData.xml","C:\\Users\\EGYPT SRORE\\IdeaProjects\\SimpleLearningManagementSystem\\src\\csv_StudentXml  Data");
//        content=addID(content);
//        content=parse$(content);
//        content=parseHash(content);
//        System.out.println(content);
    }
    public static void  convert(String fileInputName,String fileOutputName){
        String content= null;
        try {
            content = readFile(fileInputName);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        content= addID(content);
        content=parse$(content);
        content=parseHash(content);
        System.out.println( content);
        try {
            saveFile(content,fileOutputName);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    private static String readFile(String fileInputName) throws IOException {
        Path fileName = Path.of(fileInputName);

        // Now calling Files.readString() method to
        // read the file
        String str = Files.readString(fileName);

        return str;
    }
    private static String addID(String content){
        String[] data = content.split("\\$");
        StringBuilder builder = new StringBuilder();
        builder.append("ID#");
        builder.append(data[0]);
        builder.append("$");
        for(int i=1; i<data.length; i++){
            builder.append(i+"#"+data[1]);
            if(i != data.length-1)
                builder.append("$");
        }
        return builder.toString();
    }

    private static  String parse$(String content){
        return content.replaceAll("\\$","\n");
    }
    private static String parseHash(String content){
        System.out.println("I Parsed the file");

        return  content.replaceAll("#",", ");
    }
    private static void saveFile(String content,String fileOutputName) throws FileNotFoundException {
        PrintWriter out=new PrintWriter(fileOutputName);
        out.println(content);

        System.out.println(content);
    }
}
