package graph.readfile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import graph.database.Reader;
import java.util.logging.Level;
import java.util.logging.Logger;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dwiharyanto
 */
public class ReadFileHTML extends Reader{
    
    public  String GetDataFromFile(String path) throws IOException{
        StringBuilder contentBuilder = new StringBuilder();
        try {
            BufferedReader in = new BufferedReader(new FileReader(path));
            String str;
            while ((str = in.readLine()) != null) {
                contentBuilder.append(str);
            }
            in.close();
        } catch (IOException e) {
        }

        String content = contentBuilder.toString();
        
        return content;
    }

    @Override
    public void readFile(String pathFile) {
        try {
            GetDataFromFile(pathFile);
        } catch (IOException ex) {
            Logger.getLogger(ReadFileHTML.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}