package jlife;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

/**
 * @author Jan Konarski
 * @author Maciej Kołek
 */
public class ViewPanel extends JPanel
{
    
    private final Color types[] = new Color[] {
        new Color(14, 15, 13),
        new Color(31, 58, 147),
        new Color(207, 0, 15),
        new Color(247, 202, 24)
    };
    
    private JPanel[] cells;
    
    public ViewPanel(Matrix mat) {
        this.setBackground(Color.LIGHT_GRAY);
        
        int width = mat.getWidth();
        int height = mat.getHeight();
        this.setLayout(new GridLayout(width, height));
        
        int length = mat.getMatrix().length;
        cells = new JPanel[length];
        int counter = 0;
        for( JPanel cell : cells ) {
            cell = new JPanel();
            cell.setBorder(BorderFactory.createLineBorder(new Color(78, 78, 78), 1));
            cell.setPreferredSize(new Dimension(20, 20));
            cell.addMouseListener(new CellListener());
            int type = mat.getMatrix()[counter];
            cell.setBackground(types[type]);
            
            this.add(cell);
            counter++;
        }
    }
    
}
