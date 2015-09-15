package graph.readfile;
 
import java.io.IOException;
import graph.database.Reader;

//iText imports
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;
import java.util.logging.Level;
import java.util.logging.Logger;
 
public class ReadFilePDF extends Reader{
    /**
     * @param args
     */
    public String GetDataFromFile(String path) throws IOException{
        PdfReader reader = new PdfReader(path);
        System.out.println("This PDF has "+reader.getNumberOfPages()+" pages.");
        String page = PdfTextExtractor.getTextFromPage(reader, reader.getNumberOfPages());
        
        return page;
    }

    @Override
    public void readFile(String pathFile) {
        try {
            GetDataFromFile(pathFile);
        } catch (IOException ex) {
            Logger.getLogger(ReadFilePDF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }   
}
