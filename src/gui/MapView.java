package gui;

import Structures.AStar;
import Structures.Algorithm;
import Structures.Node;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author tomminikkanen
 */
public class MapView extends JPanel {

    Algorithm pathfinder;
    Node[][] nodes;

    /**
     * Constructor
     * @param pf
     */
    public MapView(Algorithm pf) {
        pathfinder = pf;
        nodes = pf.getNodes();
    }
    
    /**
     * Draws the elements of the given terrain (from algorithm)
     * @param g 
     */
    public void paintComponent(Graphics g) {
        for (int i = 0; i < nodes.length; i++) {
            for (int j = 0; j < nodes[0].length; j++) {
                if (nodes[i][j].getType() == 0) {
                    g.setColor(Color.red);
                } else if (nodes[i][j].getType() == 2) {
                    g.setColor(Color.green);
                } else if (nodes[i][j].getType() == 3) {
                    g.setColor(Color.orange);
                } else {
                    g.setColor(Color.black);
                }
                g.fillRect(i * 10, j * 10, 10, 10);
            }
        }


    }
}
