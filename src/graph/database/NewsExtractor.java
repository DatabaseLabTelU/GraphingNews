package graph.database;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class NewsExtractor {

    public static void main(String[] args) {
        try {
            String uri = "http://inet.detik.com/read/2015/09/14/171633/3018464/319/google-rekrut-veteran-otomotif-untuk-mobil-tanpa-sopir?i992202105";
            Document doc = Jsoup.connect(uri).get();

            System.out.println("Detikinet");
            Element tanggal = doc.select("div.date").first();
            System.out.println("Tanggal: " + tanggal.text());
            String title = doc.title();
            System.out.println("Judul: " + title);
            Element author = doc.select("div.author").first();
            System.out.println("Author: " + author.text().split("-")[0].trim());
            Element content = doc.select("div.text_detail").first();
            System.out.println("Content:\n" + content.text());

            uri = "http://tekno.kompas.com/read/2015/09/15/07020047/Hilang.2.Tahun.GoPro.Ini.Ungkap.Pemandangan.Luar.Biasa?utm_source=WP&utm_medium=box&utm_campaign=Khlwp";
            doc = Jsoup.connect(uri).get();
            System.out.println("Kompas");
            // tanggal = doc.select("h6.dateTop").first();
            System.out.println("Tanggal: NULL");
            title = doc.title();
            System.out.println("Judul: " + title);
            // author = doc.select("div.editor_artikel.left").first();
            System.out.println("Author: NULL");
            // content = doc.select("isi_artikel").first();
            System.out.println("Content: NULL");

        } catch (IOException ex) {
            Logger.getLogger(NewsExtractor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
