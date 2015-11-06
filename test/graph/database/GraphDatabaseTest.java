/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package graph.database;

import java.io.File;
import java.io.IOException;
import java.util.NoSuchElementException;
import org.json.simple.parser.ParseException;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Isjhar-pc
 */
public class GraphDatabaseTest {
    
    public GraphDatabaseTest() {
    }

    @Test
    public void testAddNodeFlow() throws Exception {
        GraphDatabase gdb = new GraphDatabase();
        try {
            System.out.println("test");
            Node node = new Node();
            node.addProperty("nama", new Property("basdat1", DataType.String));
            node.setLabel("node1");
            gdb.addNode(node);
            
            node = new Node();
            node.addProperty("nama", new Property("basdat2", DataType.String));
            node.setLabel("node2");
            gdb.addNode(node);
            
            gdb.commit();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (NoSuchElementException ex) {
            ex.printStackTrace();
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        
        assertEquals(gdb.getListGraph().size(), 2);
        File file = new File(gdb.LIST_GRAPH_ID_FILE_NAME);
        if(!file.exists())
        {
            fail(gdb.LIST_GRAPH_ID_FILE_NAME + " tidak ada");
        }
        
        file = new File(gdb.LIST_NODE_ID_FILE_NAME);

        if(!file.exists())
        {
            fail(gdb.LIST_NODE_ID_FILE_NAME + " tidak ada");
        }
    }
    
}