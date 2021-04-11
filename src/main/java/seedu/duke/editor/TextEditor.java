package seedu.duke.editor;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


import static seedu.duke.common.Constants.FONT_SIZE_MAX;
import static seedu.duke.common.Constants.FONT_SIZE_MIN;
import static seedu.duke.common.Constants.SAVE_ICON;
import static seedu.duke.common.Constants.TEXT_AREA_HEIGHT;
import static seedu.duke.common.Constants.TEXT_AREA_WIDTH;
import static seedu.duke.common.Constants.TEXT_EDITOR_HEIGHT;
import static seedu.duke.common.Constants.TEXT_EDITOR_TITLE;
import static seedu.duke.common.Constants.TEXT_EDITOR_WIDTH;
import static seedu.duke.common.Messages.NEWLINE;
import static seedu.duke.common.Messages.TEXT_EDITOR_INSTRUCTION;

public class TextEditor extends JFrame implements ActionListener {

    public static String[] fontStyles = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
    public static JTextArea textArea = new JTextArea();
    public static JScrollPane scrollPane = new JScrollPane(textArea);
    public static JComboBox<String> fontStyleBox = new JComboBox<>(fontStyles);
    public static JButton saveButton = new JButton(SAVE_ICON);
    public static String pathName;
    
    private static TextEditor textEditor;

    //@@author H-horizon
    private TextEditor(String path, String fileName) {
        setPathName(path);
        setTextEditorTitle(fileName);
        setCloseIcon();
        setTextEditorDimension();
        setSaveIcon();
        setTextArea();
        setTextAreaToVoid();
        setScrollPane();
        setInstructionText();
        setLayout();
        setShortcutListener();
        loadFile(path);
    }

    //@@author 8kdesign
    public static boolean createNew(String path, String fileName) {
        if (textEditor == null) {
            textEditor = new TextEditor(path, fileName);
            textEditor.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    super.windowClosed(e);
                    textEditor = null;
                }
            });
            return true;
        } else {
            return false;
        }
    }

    private void setInstructionText() {
        this.add(new JLabel(TEXT_EDITOR_INSTRUCTION));
    }

    public static boolean isNull() {
        return textEditor == null;
    }
    
    //@@author H-horizon
    private void loadFile(String filePath) {
        File file = new File(filePath);
        Scanner fileReader = null;
        try {
            fileReader = new Scanner(file);
            while (fileReader.hasNext()) {
                String line = fileReader.nextLine() + NEWLINE;
                textArea.append(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            assert fileReader != null;
            fileReader.close();
        }
    }

    private void setTextAreaToVoid() {
        textArea.setText(null);
    }

    private void setPathName(String path) {
        pathName = path;
    }

    private void setSaveIcon() {
        saveButton.addActionListener(this);
        this.add(saveButton);
    }

    private void setLayout() {
        this.setLocationRelativeTo(null);
        this.setLayout(new FlowLayout());
        this.setVisible(true);
        textArea.requestFocus();
    }

    private void setFontStyleIcon() {
        String[] fontStyles = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        fontStyleBox = new JComboBox<>(fontStyles);
        fontStyleBox.addActionListener(this);
        fontStyleBox.setSelectedItem(textArea.getFont().getFontName());
        add(fontStyleBox);
    }

    public void increaseFontSize() {
        int size = textArea.getFont().getSize();
        if (size >= FONT_SIZE_MAX) {
            return;
        }
        size++;
        textArea.setFont(new Font(textArea.getFont().getFamily(), Font.PLAIN, size));
    }

    public void decreaseFontSize() {
        int size = textArea.getFont().getSize();
        if (size <= FONT_SIZE_MIN) {
            return;
        }
        size--;
        textArea.setFont(new Font(textArea.getFont().getFamily(), Font.PLAIN, size));
    }

    private void setScrollPane() {
        scrollPane.setPreferredSize(new Dimension(TEXT_AREA_WIDTH, TEXT_AREA_HEIGHT));
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        add(scrollPane);
    }

    private void setTextArea() {
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setFont(new Font(textArea.getFont().getFontName(), Font.PLAIN, textArea.getFont().getSize()));
    }

    private void setTextEditorDimension() {
        this.setSize(TEXT_EDITOR_WIDTH, TEXT_EDITOR_HEIGHT);
    }

    private void setCloseIcon() {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private void setTextEditorTitle(String fileName) {
        this.setTitle(String.format(TEXT_EDITOR_TITLE, fileName));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == fontStyleBox) {
            openFontStyleOptions();
        } else if (e.getSource() == saveButton) {
            saveTextToFile();
        }
    }

    public void saveTextToFile() {
        try {
            FileWriter fileWriter = new FileWriter(pathName);
            fileWriter.write(textArea.getText());
            fileWriter.close();
        } catch (IOException fileNotFoundException) {
            assert false : "File has not been created";
        }
    }

    private void openFontStyleOptions() {
        textArea.setFont(new Font((String) fontStyleBox.getSelectedItem(), Font.PLAIN,
                textArea.getFont().getSize()));
    }

    private void setShortcutListener() {
        textArea.addKeyListener(new ShortcutListener(this, this));
    }
}
