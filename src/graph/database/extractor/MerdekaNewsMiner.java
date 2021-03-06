package graph.database.extractor;

import graph.database.DataType;
import graph.database.Node;
import graph.database.Property;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/**
 *
 * @author Febrian
 */
public class MerdekaNewsMiner extends NewsMiner {

    public MerdekaNewsMiner(Document document) {
        super(document);
    }

    /**
     * method yang merubah atribut yang diberikan menjadi node
     *
     * @return node
     */
    @Override
    public Node getAsNode() {
        Node n = new Node();
        n.addProperty("author", new Property(getAuthor(), DataType.String));
        n.addProperty("date", new Property(getDate(), DataType.String));
        n.addProperty("title", new Property(getTitle(), DataType.String));
        n.addProperty("article", new Property(getArticle(), DataType.String));
        return n;
    }

    /**
     * method yang digunakan untuk menemukan title yang telah terdefinisi dari
     * variable text <br/>IS : variable text sudah terdefinisi <br/>FS : return
     * title yang ditemukan jika ditemukan atau null jika tidak
     *
     * @return judul berita
     */
    @Override
    public String getTitle() {
        return document.title().split("\\|")[0];
    }

    /**
     * method yang digunakan untuk menemukan author yang telah terdefinisi dari
     * variable text <br/>IS : variable text sudah terdefinisi <br/>FS : return
     * author yang ditemukan jika ditemukan atau null jika tidak
     *
     * @return author dari berita
     */
    @Override
    public String getAuthor() {
        Element author = document.select("div#mdk-body-news-reporter").first();
        if (author == null || !author.text().contains("|")) {
            return null;
        } else {
            return author.text().split("\\|")[0].split(":")[1].trim();
        }
    }

    /**
     * method yang digunakan untuk menemukan date yang telah terdefinisi dari
     * variable text <br/>IS : variable text sudah terdefinisi <br/>FS : return
     * author yang ditemukan jika ditemukan atau null jika tidak
     *
     * @return tanggal publish berita
     */
    @Override
    public String getDate() {
        Element tanggal = document.select("div#mdk-body-news-reporter").first();
        if (tanggal == null || !tanggal.text().contains("|")) {
            return null;
        } else {
            return tanggal.text().split("\\|")[1].trim();
        }
    }

    /**
     * method yang digunakan untuk menemukan article yang telah terdefinisi dari
     * variable text <br/>IS : variable text sudah terdefinisi <br/>FS : return
     * author yang ditemukan jika ditemukan atau null jika tidak
     *
     * @return artikel dalam berita
     */
    @Override
    public String getArticle() {
        Element article = document.select("div#mdk-body-newsarea").first();
        return article == null ? null : article.text();
    }
}
