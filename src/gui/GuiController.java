
package gui;

import Structures.AStar;
import Structures.StarNode;
import java.awt.GridLayout;
import javax.swing.JFrame;


public class GuiController extends JFrame {
    
    MapView mv;
    
    public GuiController(AStar pf) {
        mv = new MapView(pf);
        StarNode[][] nodes = pf.getNodes();
        setSize(nodes.length*10,nodes[0].length*10+22);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(mv);
    }
    
    public void showGUI() {
        setVisible(true);
    } 
}
