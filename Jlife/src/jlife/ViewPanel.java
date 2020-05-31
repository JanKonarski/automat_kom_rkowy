package jlife;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;

/**
 * @author Jan Konarski
 * @author Maciej Kołek
 */
public class ViewPanel extends JPanel implements MouseListener {
    
    private final Color types[] = new Color[] {
        new Color(14, 15, 13),
        new Color(31, 58, 147),
        new Color(207, 0, 15),
        new Color(247, 202, 24)
    };
    
    private Matrix mat;
    private Cell[] cells;
    
    public ViewPanel(Matrix mat) {
        this.mat = mat;
        this.setBackground(Color.LIGHT_GRAY);
        
        int width = mat.getWidth();
        int height = mat.getHeight();
        this.setLayout(new GridLayout(width, height));
        
        int length = mat.getMatrix().length;
        cells = new Cell[length];
        for( int i=0; i < length; i++ ) {
            cells[i] = new Cell(mat, i);
            cells[i].addMouseListener(this);
            
            this.add(cells[i]);
        }
    }
    
    public void refresh() {
        int length = cells.length;
        for( int i=0; i < length; i++)
            cells[i].reload();
    }
    
    @Override
    public void mouseClicked( MouseEvent e ) {
        Cell source = (Cell)e.getSource();
        source.changeBG();
    }
    
    @Override
    public void mouseEntered( MouseEvent e ) {}
    
    @Override
    public void mousePressed( MouseEvent e ) {}

    @Override
    public void mouseReleased( MouseEvent e ) {}
    
    @Override
    public void mouseExited( MouseEvent e ) {}
    
}
