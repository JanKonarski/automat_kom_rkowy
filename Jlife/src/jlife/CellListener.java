/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jlife;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;

/**
 *
 * @author janek
 */
public class CellListener implements MouseListener {
    
    private final Color types[] = new Color[] {
        new Color(14, 15, 13),
        new Color(31, 58, 147),
        new Color(207, 0, 15),
        new Color(247, 202, 24)
    };
    
    @Override
    public void mouseClicked( MouseEvent e ) {
        JPanel source = (JPanel)e.getSource();
        
        if( source.getBackground().equals(types[0]) )
            source.setBackground(types[1]);
        
        else if (source.getBackground().equals(types[1]) )
            source.setBackground(types[2]);
        
        else if (source.getBackground().equals(types[2]) )  
            source.setBackground(types[3]);
        
        else if (source.getBackground().equals(types[3]) )
            source.setBackground(types[0]);
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
