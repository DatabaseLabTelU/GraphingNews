/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package graph.database;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Isjhar-pc
 */
public class Test {

    public static void main(String[] args) throws IOException {
        GraphDatabase graphdb = new GraphDatabase();
        Node node = new Node();
        node.setLabel("Berita Olahraga");
        Node node1 = new Node();
        node1.setLabel("Berita Olahraga");
        try {

            node.addProperty("judul", new Property("Timnas Juara", DataType.String));
            node.addProperty("artikel", new Property("Timnas juara tapi bohong", DataType.String));
            node.addProperty("tanggal", new Property("12-12-2015", DataType.String));
            graphdb.addNode(node);

            node1.addProperty("judul", new Property("Timnas Menang", DataType.String));
            node1.addProperty("artikel", new Property("Timnas juara beneran", DataType.String));
            node1.addProperty("tanggal", new Property("12-01-2015", DataType.String));
            graphdb.addNode(node1);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchElementException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }
        graphdb.commit();
    }
}
