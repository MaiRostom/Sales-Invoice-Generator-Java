import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;


public class PrintAll {
    public static void main(String[] args) {

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
        content=printAll(content);


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
        System.out.println("-----------------------------------------------");
        System.out.println("Current Student List");
        System.out.println("-----------------------------------------------");
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

private static String printAll(String content) {
    String data = content.replace("#", ",");
    data = data.replace("$", "\n");

    String[] newData = data.split("\n");

    String finalData = "";

    ArrayList<Student> students = new ArrayList<>();

    for (int i = 0; i < newData.length; i++) {   // rows

        String[] r = newData[i].split(",");
        if (i == 0) {
            for (int k = 0; k < r.length; k++) {  // enhaned for loop   --- first row

                finalData += "id    " + r[0] + "                     " + r[1] + "          ";
            }

        } else {

            Student student = new Student();
            student.setId(i);
            finalData += i + " ";

            //k=5
            for (int k = 0; k < r.length; k++) {  // enhaned for loop

                //////////////////////////////////////////////////////
                student.setName(r[0]);
                student.setEmail(r[2]);

                if (r[k].length() >= 12) {

                    finalData += "  " + r[k];

                } else {

                    //l = 5
                    for (int l = 0; l < 12; l++) {

                        if (l < r[k].length()) //Malcolm Barnes
                        {
                            finalData += " " + r[k].charAt(l);
                        } else {
                            finalData += " ";
                        }
                    }

                }

            }

            students.add(student);

        }
    }


    return content;
    }

}
