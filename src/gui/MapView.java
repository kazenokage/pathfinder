package gui;

import Structures.AStar;
import Structures.StarNode;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class MapView extends JPanel {
    
    AStar pathfinder;
    StarNode[][] nodes;
    
    public MapView(AStar pf) {
        pathfinder = pf;
        nodes = pf.getNodes();
    }
    
    public void paintComponent(Graphics g) {
        for (int i = 0; i < nodes.length; i++) {
            for (int j = 0; j < nodes[0].length; j++) {
                if(nodes[i][j].getType() == 0) {
                    g.setColor(Color.red);
                } else {
                    g.setColor(Color.black);
                }
                g.fillRect(nodes[i][j].getX()*10,nodes[i][j].getY()*10, 10, 10);
            }
        }
        
        
    }
}
