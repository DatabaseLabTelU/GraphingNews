package graph.database.extractor;

import graph.database.Node;
import org.jsoup.nodes.Document;

/**
 * class ini bertanggung jawab untuk proses mining dari text
 */
public abstract class NewsMiner {

    protected Document document;

    public NewsMiner(Document document) {
        this.document = document;
    }

    /**
     * method yang merubah atribut yang diberikan menjadi node
     *
     * @return node
     */
    public abstract Node getAsNode();

    /**
     * method yang digunakan untuk menemukan title yang telah terdefinisi dari
     * variable text <br/>IS : variable text sudah terdefinisi <br/>FS : return
     * title yang ditemukan jika ditemukan atau null jika tidak
     *
     * @return judul berita
     */
    public abstract String getTitle();

    /**
     * method yang digunakan untuk menemukan author yang telah terdefinisi dari
     * variable text <br/>IS : variable text sudah terdefinisi <br/>FS : return
     * author yang ditemukan jika ditemukan atau null jika tidak
     *
     * @return author dari berita
     */
    public abstract String getAuthor();

    /**
     * method yang digunakan untuk menemukan date yang telah terdefinisi dari
     * variable text <br/>IS : variable text sudah terdefinisi <br/>FS : return
     * author yang ditemukan jika ditemukan atau null jika tidak
     *
     * @return tanggal publish berita
     */
    public abstract String getDate();

    /**
     * method yang digunakan untuk menemukan article yang telah terdefinisi dari
     * variable text <br/>IS : variable text sudah terdefinisi <br/>FS : return
     * author yang ditemukan jika ditemukan atau null jika tidak
     *
     * @return artikel dalam berita
     */
    public abstract String getArticle();
}
