/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package graph.readfile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import graph.database.Reader;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;

/**
 *
 * @author NendiJuned
 */

public class ReadFileDOC extends Reader{
    protected static int numberOfLine;
    protected static File file;
    protected static FileInputStream fis;
    protected static HWPFDocument document;
    protected static WordExtractor extractor;
    
    /**
     * @param path menyimpan destination file tersebut berada
     * @return array string
     * @throws java.io.IOException
     */
    protected String GetDataFromFile(String path) throws IOException{
        file = new File(path);
        fis = new FileInputStream(file);
        document = new HWPFDocument(fis);
        extractor = new WordExtractor(document);
        String fileData = extractor.getText();
        
        return fileData;
    }
    /**
     * @param path menyimpan destination file tersebut berada
     * @return array string
     * @throws java.io.IOException
     * Fungsi ini akan mengembalikan Array dimana array tersebut menyimpan kalimat per satu baris
     */
    protected String[] GetDataFromFilePerBaris(String path) throws IOException{
        file = new File(path);
        fis = new FileInputStream(file);
        document = new HWPFDocument(fis);
        extractor = new WordExtractor(document);
        String[] fileData = extractor.getParagraphText();
        
        return fileData;
    }

    @Override
    public void readFile(String pathFile) {
        try {
            GetDataFromFile(pathFile);
        } catch (IOException ex) {
            Logger.getLogger(ReadFileDOC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}