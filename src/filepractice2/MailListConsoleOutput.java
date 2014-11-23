/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filepractice2;

import java.util.List;
import java.util.Objects;

/**
 *
 * @author mdeboer1
 */
public class MailListConsoleOutput implements Comparable<MailListConsoleOutput>{
    private List<String> mailList;
    public static int outputCount = 0;
    private int count;
    
    public MailListConsoleOutput(){
        outputCount++;
        count = outputCount;
    }
    
    public final void outputData(List<String> list){
        mailList = list;
        int lineNumber = 0;
        for (int i = 0; i < mailList.size(); i++){
            String result = mailList.get(i).replaceAll(",", "");
            String[] fileLines = result.split(" ");
            
            if (lineNumber <= 2){
                if (lineNumber == 0){
                    System.out.println("First Name: " + fileLines[0]);
                    System.out.println("Last Name: " + fileLines[1]);
                    lineNumber++;
                }else if (lineNumber == 1){
                    System.out.println("AddressL " + result);
                    lineNumber++;
                }else if (lineNumber ==2){
                    String[] temp = fileLines[0].split(",");
                    System.out.println("City: " + fileLines[0]);
                    System.out.println("State : " + fileLines[1]);
                    System.out.println("Zip Code: " + fileLines[2] + "\n");
                    lineNumber++;
                }
            }else{
                    lineNumber = 0;
                }
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.count;
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
        final MailListConsoleOutput other = (MailListConsoleOutput) obj;
        if (this.count != other.count) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MailListConsoleOutput{" + "count=" + count + '}';
    }

    @Override
    public int compareTo(MailListConsoleOutput output) {
        int result;
        
        if (this.count == output.count){
            result = 0;
        }
        else if (this.count < output.count){
            result = -1;
        }
        else {
            result = 1;
        }
        return result;
    }
}
