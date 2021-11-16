package it.unibo.oop.lab.mvcio2;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import it.unibo.oop.lab.mvcio.Controller;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUIWithFileChooser {

    private static final String TITLE = "Simple GUI with file chooser";
    private static final String PATH = System.getProperty("user.home")
            + System.getProperty("file.separator")
            + "output.txt";
    private File f = new File(PATH);
    private final JFrame frame = new JFrame(TITLE);

    /*
     * TODO: Starting from the application in mvcio:
     * 
     * 1) Add a JTextField and a button "Browse..." on the upper part of the
     * graphical interface.
     * Suggestion: use a second JPanel with a second BorderLayout, put the panel
     * in the North of the main panel, put the text field in the center of the
     * new panel and put the button in the line_end of the new panel.
     * 
     * 2) The JTextField should be non modifiable. And, should display the
     * current selected file.
     * 
     * 3) On press, the button should open a JFileChooser. The program should
     * use the method showSaveDialog() to display the file chooser, and if the
     * result is equal to JFileChooser.APPROVE_OPTION the program should set as
     * new file in the Controller the file chosen. If CANCEL_OPTION is returned,
     * then the program should do nothing. Otherwise, a message dialog should be
     * shown telling the user that an error has occurred (use
     * JOptionPane.showMessageDialog()).
     * 
     * 4) When in the controller a new File is set, also the graphical interface
     * must reflect such change. Suggestion: do not force the controller to
     * update the UI: in this example the UI knows when should be updated, so
     * try to keep things separated.
     */

    public SimpleGUIWithFileChooser() {
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setSize(sw / 2, sh / 2);
        frame.setLayout(new BorderLayout());

        final JPanel writingThingsPanel = new JPanel();
        final JPanel browsePanel = new JPanel();
        writingThingsPanel.setLayout(new BorderLayout());
        browsePanel.setLayout(new BorderLayout());

        final JTextArea ta = new JTextArea();
        final JButton save = new JButton("Save");
        final JButton browse = new JButton("Browse");
        writingThingsPanel.add(ta, BorderLayout.NORTH);
        writingThingsPanel.add(save, BorderLayout.SOUTH);
        browsePanel.add(browse);
        frame.add(writingThingsPanel, BorderLayout.SOUTH);
        frame.add(browsePanel, BorderLayout.NORTH);

        frame.setLocationByPlatform(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                try {
                    new Controller(f).writeOnFile(ta.getText());
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });

        browse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                final JFileChooser fc = new JFileChooser();
                if (fc.showSaveDialog(browse) == JFileChooser.APPROVE_OPTION) {
                    f = fc.getSelectedFile();
                }
            }
        });
    }

    public static void main(final String... args) {
        new SimpleGUIWithFileChooser();
    }
}
