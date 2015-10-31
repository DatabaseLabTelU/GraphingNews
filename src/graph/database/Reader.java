/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package graph.database;

import java.awt.image.BufferedImage;
import java.util.List;
import graph.database.*;
import graph.database.extractor.NewsMiner;

/**
 *
 * class yang bertanggung jawab dalam proses pembacaan dokumen
 */
public abstract class Reader {
    private String text;
    private List<BufferedImage> listImage;
    
    /**
     * Default constructor
     */
    public Reader(){
        
    }
    
    /**
     * method ini digunakan untuk membaca file
     * IS : text dan listImage belum terdefinisi
     * FS : text terdefinisi jika didalamnya terdapat text dan listImage terdefinisi jika didalamnya terdapat Image
     * @param pathFile path dari file PDF yang akan dibaca
     */
    public abstract void readFile(String pathFile);
        
    
    /**
     * Contributor : 
     *  - isjhar kautsar (isjhar@gmail.com)
     * method ini digunakan untuk mengubah data dari variable text dan list Image menjadi node
     * @param pathFile path file yang akan dijadikan node
     * @param type type dari file
     * @return data yang telah dikonversi menjadi node
     */
    public Node convertDocToNode(String pathFile){
        // read file
        return null;
    }
    
}
