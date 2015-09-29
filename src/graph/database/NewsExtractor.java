package graph.database;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class NewsExtractor {

    public static void main(String[] args) {
        // 1 minute timeout
        int timeout = 60 * 1000;

        try {
            String uri = "http://inet.detik.com/read/2015/09/14/171633/3018464/319/google-rekrut-veteran-otomotif-untuk-mobil-tanpa-sopir?i992202105";
            Document doc = Jsoup.connect(uri).timeout(timeout).get();

            System.out.println("Detikinet");
            Element tanggal = doc.select("div.date").first();
            System.out.println("Tanggal: " + tanggal.text());
            String title = doc.title().split("\\|")[1].trim();
            System.out.println("Judul: " + title);
            Element author = doc.select("div.author").first();
            System.out.println("Author: " + author.text().split("-")[0].trim());
            Element content = doc.select("div.text_detail").first();
            System.out.println("Content:\n" + content.text());

            uri = "http://tekno.kompas.com/read/2015/09/15/07020047/Hilang.2.Tahun.GoPro.Ini.Ungkap.Pemandangan.Luar.Biasa?utm_source=WP&utm_medium=box&utm_campaign=Khlwp";
            doc = Jsoup.connect(uri).timeout(timeout).get();
            System.out.println("Kompas");
            // tanggal = doc.select("h6.dateTop").first();
            System.out.println("Tanggal: NULL");
            title = doc.title().split("\\-")[0];
            System.out.println("Judul: " + title);
            // author = doc.select("div.editor_artikel.left").first();
            System.out.println("Author: NULL");
            // content = doc.select("isi_artikel").first();
            System.out.println("Content: NULL");

            uri = "http://www.merdeka.com/teknologi/2-bulan-diluncurkan-lebih-dari-100-juta-perangkat-pakai-windows-10.html";
            doc = Jsoup.connect(uri).timeout(timeout).get();
            System.out.println("Merdeka");
            tanggal = doc.select("div#mdk-body-news-reporter").first();
            System.out.println("Tanggal: " + tanggal.text().split("\\|")[1].trim());
            title = doc.title();
            System.out.println("Judul: " + title);
            // author = doc.select("div.editor_artikel.left").first();
            System.out.println("Author: " + tanggal.text().split("\\|")[0].trim());
            content = doc.select("div#mdk-body-newsarea").first();
            System.out.println("Content: " + content.text());
        } catch (IOException ex) {
            Logger.getLogger(NewsExtractor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
