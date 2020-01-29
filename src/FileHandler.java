import java.io.*;
import java.util.ArrayList;

class FileHandler {

    //Methode um File zu beschreiben (Abfahrtszeiten)
    void writeFile(ArrayList<String> fileContent, String name) throws IOException {
        PrintStream fileStream = new PrintStream(new File(name));
        for (String s : fileContent) fileStream.println(s);
        fileStream.close();
    }

    //Liste um Files zu lesen (Abfahrtszeiten)
    ArrayList<String> readFile(String name) {
        ArrayList<String> lines = new ArrayList<>();
        try{
            BufferedReader br = new BufferedReader(new FileReader(name));
            for (String line; (line = br.readLine()) != null; ) {
                lines.add(line);
            }
            br.close();
            return lines;
        } catch (IOException E){
            return lines;
        }
    }
}