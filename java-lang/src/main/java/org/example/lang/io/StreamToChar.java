package org.example.lang.io;

import java.io.*;

/**
 * @author lifei
 */
public class StreamToChar {
    public static void main(String[] args) throws FileNotFoundException {
        InputStream in = new FileInputStream("abc.txt");
        Reader reader = new InputStreamReader(in);
        OutputStream out = new FileOutputStream("cba.txt");
        Writer writer = new OutputStreamWriter(out);
    }
}
