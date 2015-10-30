package graph.database.extractor;

import graph.database.Node;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 * Extract news from crawled ones and instantiate NewsMiner to be converted to
 * Node
 *
 * @author Febrian
 */
public class NewsExtractor {

    // TODO: only merdeka provided for now
    public static List<Node> readFolder(String uri) {
        List<Node> nodes = new ArrayList<>();
        try {
            File folder = new File(uri);
            for (String folderName : folder.list()) {
                String fileName = uri + "\\" + folderName + "\\html" + folderName + ".txt";
                File file = new File(fileName);
                Document doc = Jsoup.parse(file, "utf-8");
                NewsMiner miner = new MerdekaNewsMiner(doc);
                nodes.add(miner.getAsNode());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return nodes;
    }
}
