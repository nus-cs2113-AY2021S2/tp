package seedu.duke.editor;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static seedu.duke.common.Constants.BOX_HEIGHT;
import static seedu.duke.common.Constants.BOX_WIDTH;
import static seedu.duke.common.Constants.DEFAULT_FONT_SIZE;
import static seedu.duke.common.Constants.DEFAULT_FONT_STYLE;
import static seedu.duke.common.Constants.FONT_COLOUR_HEADER;
import static seedu.duke.common.Constants.FONT_COLOUR_ICON;
import static seedu.duke.common.Constants.FONT_SIZE_ICON;
import static seedu.duke.common.Constants.SAVE_ICON;
import static seedu.duke.common.Constants.TEXT_AREA_HEIGHT;
import static seedu.duke.common.Constants.TEXT_AREA_WIDTH;
import static seedu.duke.common.Constants.TEXT_EDITOR_HEIGHT;
import static seedu.duke.common.Constants.TEXT_EDITOR_TITLE;
import static seedu.duke.common.Constants.TEXT_EDITOR_WIDTH;

public class TextEditor extends JFrame implements ActionListener {

    public static String[] fontStyles = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
    public static JTextArea textArea = new JTextArea();
    public static JScrollPane scrollPane = new JScrollPane(textArea);
    public static JSpinner fontSizeSpinner = new JSpinner();
    public static JLabel fontSizeLabel = new JLabel(FONT_SIZE_ICON);
    public static JButton fontColourButton = new JButton(FONT_COLOUR_ICON);
    public static JComboBox<String> fontStyleBox = new JComboBox<>(fontStyles);
    public static JButton saveButton = new JButton(SAVE_ICON);
    public static String pathName;

    public TextEditor(String path) {
        setPathName(path);
        setTextEditorTitle();
        setCloseIcon();
        setTextEditorDimension();
        setFontSizeIcon();
        setFontColourIcon();
        setFontStyleIcon();
        setSaveIcon();
        setTextArea();
        setScrollPane();
        setLayout();

    }

    private void setPathName(String path) {
        pathName = path;
    }

    private void setSaveIcon() {
        saveButton.addActionListener(this);
        this.add(saveButton);
    }

    private void setLayout() {
        this.setLayout(new FlowLayout());
        this.setVisible(true);
    }

    private void setFontStyleIcon() {
        String[] fontStyles = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        fontStyleBox = new JComboBox<>(fontStyles);
        fontStyleBox.addActionListener(this);
        fontStyleBox.setSelectedItem(DEFAULT_FONT_STYLE);
        add(fontStyleBox);
    }

    private void setFontColourIcon() {
        this.add(fontColourButton);
        fontColourButton.addActionListener(this);
    }

    private void setFontSizeIcon() {
        fontSizeSpinner.setPreferredSize(new Dimension(BOX_WIDTH, BOX_HEIGHT));
        fontSizeSpinner.setValue(DEFAULT_FONT_SIZE);
        fontSizeSpinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                textArea.setFont(new Font(textArea.getFont().getFamily(), Font.PLAIN,
                        (int) fontSizeSpinner.getValue()));
            }
        });
        add(fontSizeLabel);
        add(fontSizeSpinner);
    }

    private void setScrollPane() {
        scrollPane.setPreferredSize(new Dimension(TEXT_AREA_WIDTH, TEXT_AREA_HEIGHT));
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        add(scrollPane);
    }

    private void setTextArea() {
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setFont(new Font(DEFAULT_FONT_STYLE, Font.PLAIN, DEFAULT_FONT_SIZE));
    }

    private void setTextEditorDimension() {
        this.setSize(TEXT_EDITOR_WIDTH, TEXT_EDITOR_HEIGHT);
    }

    private void setCloseIcon() {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private void setTextEditorTitle() {
        this.setTitle(TEXT_EDITOR_TITLE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == fontColourButton) {
            openFontColourOptions();
        } else if (e.getSource() == fontStyleBox) {
            openFontStyleOptions();
        } else if (e.getSource() == saveButton) {
            saveTextToFile();
        }
    }

    private void saveTextToFile() {
        try {
            FileWriter fileWriter = new FileWriter(pathName);
            fileWriter.write(textArea.getText());
            fileWriter.close();
        } catch (IOException fileNotFoundException) {
            assert false :"File has not been created";
        }
    }

    private void openFontStyleOptions() {
        textArea.setFont(new Font((String) fontStyleBox.getSelectedItem(), Font.PLAIN,
                textArea.getFont().getSize()));
    }

    private void openFontColourOptions() {
        JColorChooser colourChooser = new JColorChooser();
        Color colour = colourChooser.showDialog(null, FONT_COLOUR_HEADER, Color.BLACK);
        textArea.setForeground(colour);
    }
}
