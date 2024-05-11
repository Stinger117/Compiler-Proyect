package model;

import javax.swing.JTextArea;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author jonat
 */
public class LineNumberUpdater implements DocumentListener{
    
    private JTextArea textArea;
    private JTextArea lineNumberArea;

    public LineNumberUpdater(JTextArea textArea, JTextArea lineNumberArea) {
        this.textArea = textArea;
        this.lineNumberArea = lineNumberArea;
    }

    private void updateLineNumbers() {
        int totalLines = textArea.getLineCount();
        StringBuilder numbersText = new StringBuilder();
        for (int i = 1; i <= totalLines; i++) {
            numbersText.append(i).append("\n");
        }
        lineNumberArea.setText(numbersText.toString());
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        updateLineNumbers();
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        updateLineNumbers();
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        updateLineNumbers();
    }
    
}
