import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

public class App {
    public static void main(String[] args) {
        App.build();
    }
    private static void build(){
        EditorHandler eh = new EditorHandler();

        JFrame frame = new JFrame("JEditor");
        frame.setSize(500,500);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        JButton openButton = new JButton("Open");
        buttonPanel.add(openButton);
        JButton saveButton = new JButton("Save");
        buttonPanel.add(saveButton);
        JButton swagButton = new JButton("Swag");
        buttonPanel.add(swagButton);
        JButton clearButton = new JButton("Clear");
        buttonPanel.add(clearButton);
        JButton markButton = new JButton("Mark");
        buttonPanel.add(markButton);
        frame.add("North", buttonPanel);

        JTextArea editor = new JTextArea();
        JScrollPane editorPane = new JScrollPane(editor);
        frame.add("Center", editorPane);

        openButton.addActionListener(actionEvent -> eh.openFile(editor));
        saveButton.addActionListener(actionEvent -> eh.saveFile(editor.getText().split("\n")));
        swagButton.addActionListener(actionEvent -> eh.addSwag(editor, editor.getText().split("\n")));
        clearButton.addActionListener(actionEvent -> eh.clearFile(editor));
        markButton.addActionListener(actionEvent -> eh.markText(editor));

        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
