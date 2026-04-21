import java.awt.*;
import java.awt.event.*;

public class SimpleTextEditor extends Frame implements ActionListener {

    private TextArea textArea;
    private MenuItem newItem, clearItem, exitItem;

    public SimpleTextEditor() {
        setTitle("Simple Text Editor");
        setSize(600, 400);
        setLayout(new BorderLayout());

        textArea = new TextArea();
        add(textArea, BorderLayout.CENTER);

        MenuBar menuBar = new MenuBar();
        Menu fileMenu = new Menu("File");

        newItem = new MenuItem("New");
        clearItem = new MenuItem("Clear");
        exitItem = new MenuItem("Exit");

        fileMenu.add(newItem);
        fileMenu.add(clearItem);
        fileMenu.addSeparator();
        fileMenu.add(exitItem);

        menuBar.add(fileMenu);
        setMenuBar(menuBar);

        newItem.addActionListener(this);
        clearItem.addActionListener(this);
        exitItem.addActionListener(this);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();

        if (src == newItem) {
            textArea.setText("");
        } else if (src == clearItem) {
            textArea.setText("");
        } else if (src == exitItem) {
            dispose();
        }
    }

    public static void main(String[] args) {
        new SimpleTextEditor();
    }
}
