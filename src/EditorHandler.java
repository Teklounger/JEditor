import javax.swing.*;
import javax.swing.text.BadLocationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

class EditorHandler {
    private FileHandler fh = new FileHandler();
    private String filename = "";

    void openFile(JTextArea editor) {
        JFileChooser chooser = new JFileChooser();
        int returnvalue = chooser.showOpenDialog(null);
        if (returnvalue == JFileChooser.APPROVE_OPTION) {
            System.out.println("something: " + chooser.getSelectedFile().getAbsolutePath());
            editor.setText(null);
            String[] content = fh.readFile(chooser.getSelectedFile().getAbsolutePath()).toArray(new String[0]);
            for (String line : content) {
                editor.append(line + "\n");
                System.out.println(line);
            }
            filename = chooser.getSelectedFile().getAbsolutePath();
        }
    }

    void saveFile(String[] content) {
        try {
            ArrayList<String> filecontent = new ArrayList<>(Arrays.asList(content));
            if(!filename.equals("") && !filename.isEmpty() && new File(filename).exists()){
                fh.writeFile(filecontent, this.filename);
            } else{
                JFileChooser chooser = new JFileChooser();
                int returnvalue = chooser.showSaveDialog(null);
                if(returnvalue == JFileChooser.APPROVE_OPTION){
                    filename = chooser.getSelectedFile().getAbsolutePath();
                    fh.writeFile(filecontent, filename);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void addSwag(JTextArea editor, String[] content) {
        editor.setText(null);
        ArrayList<String> filecontent = new ArrayList<>(Arrays.asList(content));
        for (int i = 0; i < filecontent.size(); i++) {
            filecontent.set(i, filecontent.get(i)+" Skurr Skurr");
            editor.append(filecontent.get(i) + "\n");
        }
    }

    void clearFile(JTextArea editor){
        editor.setText(null);
        filename = "";
    }

    void markText(JTextArea editor){
        try {
            System.out.println(editor.getText(editor.getSelectionStart(),editor.getSelectionEnd()- editor.getSelectionStart()));
        } catch (BadLocationException e) {
            e.printStackTrace();
        }

    }
}
