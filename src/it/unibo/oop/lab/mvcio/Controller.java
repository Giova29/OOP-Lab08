package it.unibo.oop.lab.mvcio;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 
 */
public class Controller {

    private static final String PATH = System.getProperty("user.home")
            + System.getProperty("file.separator")
            + "output.txt";
    private File f;
    /*
     * This class must implement a simple controller responsible of I/O access. It
     * considers a single file at a time, and it is able to serialize objects in it.
     * 
     * Implement this class with:
     * 
     * 1) A method for setting a File as current file
     * 
     * 2) A method for getting the current File
     * 
     * 3) A method for getting the path (in form of String) of the current File
     * 
     * 4) A method that gets a String as input and saves its content on the current
     * file. This method may throw an IOException.
     * 
     * 5) By default, the current file is "output.txt" inside the user home folder.
     * A String representing the local user home folder can be accessed using
     * System.getProperty("user.home"). The separator symbol (/ on *nix, \ on
     * Windows) can be obtained as String through the method
     * System.getProperty("file.separator"). The combined use of those methods leads
     * to a software that runs correctly on every platform.
     */

    public Controller(final File f) {
        this.f = f;
    }

    public Controller() {
        this(new File(PATH));
    }

    /**
     * Sets the file.
     * 
     * @param f
     * the file you want to control
     */
    public void setFile(final File f) {
        this.f = f;
    }
     /**
      * 
      * @return
      * the file.
      */
    public File getFile() {
        return this.f;
    }

    /**
     * 
     * @return
     * the path of the file
     */
    public String getPath() {
        return f.getAbsolutePath();
    }

    /**
     * Writes the string you pass on the file.
     * @param s
     * the string you want to write on the file
     * @throws IOException 
     */
    public void writeOnFile(final String s) throws IOException {
        final FileWriter fw = new FileWriter(f);
        fw.write(s);
        fw.close();
    }
}
