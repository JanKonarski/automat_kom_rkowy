/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jlife;

import java.util.Iterator;
import java.util.Vector;

/**
 *
 * @author janek
 */
public class Staff {
    
    private int width;
    private int height;
    private Vector<Cell> cells;
    
    public Staff( int width, int height ) {
        this.width = width;
        this.height = height;
        cells = new Vector<Cell>();
    }
    
    public void add( Cell cell ) {
        cells.add( cell );
    }
    
    public int getWidth() {
        return width;
    }
    
    public int getHeight() {
        return height;
    }
    
    public Vector<Cell> getCells() {
        return cells;
    }
    
}
