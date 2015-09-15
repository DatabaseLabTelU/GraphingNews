/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package graph.readfile;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import graph.database.Reader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dwiharyanto
 */

public class ReadFileTXT extends Reader{

    /**
     * @param path
     * @return 
     * @throws java.io.IOException
     */
    public  String[] GetDataFromFile(String path) throws IOException{
            FileInputStream fstream = new FileInputStream(path);
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            String strLine;
            String[] splitOut=null;
            while ((strLine = br.readLine()) != null) {
                 splitOut = strLine.split(", ");
                    for (String token : splitOut){
                        System.out.println(token);
                    }
            }
            br.close();
            return splitOut;
        } 

    @Override
    public void readFile(String pathFile) {
        try {
            GetDataFromFile(pathFile);
        } catch (IOException ex) {
            Logger.getLogger(ReadFileTXT.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
    
    

