/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filepractice2;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author mdeboer1
 */
public class Startup {
    public static void main(String[] args) throws IOException{

    String filePath = "src" + File.separatorChar + "Lab1.txt";
    MailListConsoleOutput output = new MailListConsoleOutput();
    MailServiceFileReader reader = new MailServiceFileReader(filePath, output);
    }
}