
package gui;

import Structures.Algorithm;
import Structures.Node;
import javax.swing.JFrame;


public class GuiController extends JFrame {
    
    MapView mv;
    
    public GuiController(Algorithm pf, String title) {
        mv = new MapView(pf);
        Node[][] nodes = pf.getNodes();
        setTitle(title);
        setSize(nodes.length*10,nodes[0].length*10+22);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(mv);
    }
    
    public void showGUI() {
        setVisible(true);
    } 
}
