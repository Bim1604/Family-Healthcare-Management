/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dang.logger;

import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 *
 * @author Admin
 */
public class Log {

    public static Logger logger;

    public Log(String filename) throws SecurityException, IOException {
        File f = new File(filename);
        FileHandler fh = new FileHandler(filename, true);
        logger = Logger.getLogger("My Log");
        logger.addHandler(fh);
        SimpleFormatter sf = new SimpleFormatter();
        fh.setFormatter(sf);
    }
}
