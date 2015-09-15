package graph.readfile;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.io.IOException;

import jxl.Cell;
import jxl.CellType;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import graph.database.Reader;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReadFileXLS extends Reader{
    public void ReadFileXLS(String path) throws IOException  {
        File inputWorkbook = new File(path);
        Workbook w;
        try {
            w = Workbook.getWorkbook(inputWorkbook);
            // Get the first sheet
            Sheet sheet = w.getSheet(0);
            // Loop over first 10 column and lines
            for (int j = 0; j < sheet.getColumns(); j++) {
                for (int i = 0; i < sheet.getRows(); i++) {
                    Cell cell = sheet.getCell(j, i);
                    CellType type = cell.getType();
                    if (type == CellType.LABEL) {
                      System.out.println(cell.getContents());
                    }

                    if (type == CellType.NUMBER) {
                      System.out.println(cell.getContents());
                    }
                }
            }
        } catch (BiffException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void readFile(String pathFile) {
        try {
            ReadFileXLS(pathFile);
        } catch (IOException ex) {
            Logger.getLogger(ReadFileXLS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
