
package gui;

import Structures.Algorithm;
import Structures.Node;
import javax.swing.JFrame;


/**
 *
 * @author tomminikkanen
 */
public class GuiController extends JFrame {
    
    MapView mv;
    
    /**
     * Constructs a new GuiController
     * 
     * @param pf
     * @param title
     */
    public GuiController(Algorithm pf, String title) {
        mv = new MapView(pf);
        Node[][] nodes = pf.getNodes();
        setTitle(title);
        setSize(nodes.length*10,nodes[0].length*10+22);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(mv);
    }
    
    /**
     * Shows the GUI
     */
    public void showGUI() {
        setVisible(true);
    } 
}
