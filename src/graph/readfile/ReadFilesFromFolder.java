/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package graph.readfile;

/**
 *
 * @author NendiJuned
 */

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class ReadFilesFromFolder {
    public static File folder = new File("D:\\Crawl");//directory folder yg menyimpan hasil crawling
    public static List<String> listFiles = new ArrayList();//list untuk menyimpan directory file-file hasil crawling didalam folder
    static String temp = "";
    
    public static Object[] listFilesForFolder(final File folder) throws IOException {    
        for (final File fileEntry : folder.listFiles()) {
            if (fileEntry.isDirectory()) {
                listFilesForFolder(fileEntry);
            }else{
                if (fileEntry.isFile()) {
                    temp = fileEntry.getName();
                    if ((temp.substring(temp.lastIndexOf('.') + 1, temp.length()).toLowerCase()).equals("txt")){
                        listFiles.add(folder.getAbsolutePath()+ "\\" + fileEntry.getName());
                        //System.out.println("File= " + folder.getAbsolutePath()+ "\\" + fileEntry.getName());
                    }
                }
            }
        }
        return listFiles.toArray();
    }
    
    //testing readFiles se-Folder
    public static void main(String[] args) throws IOException {
        System.out.println("Reading files under the folder "+ folder.getAbsolutePath());
        //memanggil list file - file hasil crawling di dalam folder
        //disimpan dalam array object
        Object[] listFile = listFilesForFolder(folder);
        //System.out.println(listFiles);
        for (Object list : listFile) {
            //parsing file HTML pake jSoup
            //Document doc = Jsoup.parse(new File(list), "UTF-8");
            System.out.println(list);
        }
    }
}