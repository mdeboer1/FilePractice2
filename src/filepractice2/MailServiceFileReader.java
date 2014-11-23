/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filepractice2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author mdeboer1
 */
public class MailServiceFileReader {
    private MailListConsoleOutput output;
    
    public MailServiceFileReader(String filePath, MailListConsoleOutput output)
        throws IOException{
        this.output = output;
        readFile(filePath, output);
    }
    
    private void readFile(String filePath, MailListConsoleOutput output) 
            throws IOException {
        File data = new File(filePath);
        BufferedReader reader = null;
        List<String> mailList = new ArrayList<>();
        try{
            reader = new BufferedReader(new FileReader(data));
            String line = reader.readLine();
            while (line != null){
                mailList.add(line);
                line = reader.readLine();
            }
        }catch(IOException ioe){
            ioe.printStackTrace();
            System.out.println("Error");
        }
        finally{
            reader.close();
        }
        output.outputData(mailList);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(this.output);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final MailServiceFileReader other = (MailServiceFileReader) obj;
        if (!Objects.equals(this.output, other.output)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MailServiceFileReader{" + output.toString() + '}';
    }
}
