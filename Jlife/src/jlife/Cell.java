/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jlife;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

/**
 *
 * @author janek
 */
public class Cell extends JPanel {
    
    private Matrix mat;
    private final int position;
    
    private final Color types[] = new Color[] {
        new Color(14, 15, 13),
        new Color(31, 58, 147),
        new Color(207, 0, 15),
        new Color(247, 202, 24)
    };
    
    public Cell( Matrix mat, int position ) {
        this.mat = mat;
        this.position = position;
        
        this.setBorder(BorderFactory.createLineBorder(new Color(78, 78, 78), 1));
        this.setPreferredSize(new Dimension(20, 20));
        int type = mat.getMatrix()[position];
        this.setBackground(types[type]);
    }
    
    public void changeBG() {
        if( this.getBackground().equals(types[0]) ) {
            this.setBackground(types[1]);
            mat.setCell(position, (byte)(0));
        }
        
        else if (this.getBackground().equals(types[1]) ) {
            this.setBackground(types[2]);
            mat.setCell(position, (byte)(1));
        }
        
        else if (this.getBackground().equals(types[2]) ) { 
            this.setBackground(types[3]);
            mat.setCell(position, (byte)(2));
        }
        
        else if (this.getBackground().equals(types[3]) ) {
            this.setBackground(types[0]);
            mat.setCell(position, (byte)(3));
        }
    }
    
    public void reload() {
        byte type = mat.getMatrix()[position];
        this.setBackground(types[type]);
    }
    
}
