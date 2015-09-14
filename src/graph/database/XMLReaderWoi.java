package graph.database;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class XMLReaderWoi {

    public static void main(String[] args) {
        try {
            String uri = "http://inet.detik.com/read/2015/09/14/171633/3018464/319/google-rekrut-veteran-otomotif-untuk-mobil-tanpa-sopir?i992202105";
            Document doc = Jsoup.connect(uri).get();

            Element tanggal = doc.select("div.date").first();
            System.out.println("Tanggal: " + tanggal.text());

            Element title = doc.select("title").first();
            System.out.println("Judul: " + title.text());

            Element author = doc.select("div.author").first();
            System.out.println("Author: " + author.text().split("-")[0].trim());

            Element content = doc.select("div.text_detail").first();
            System.out.println("Content:\n" + content.text());

        } catch (IOException ex) {
            Logger.getLogger(XMLReaderWoi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
