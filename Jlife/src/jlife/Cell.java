/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jlife;

/**
 *
 * @author janek
 */
public class Cell {
    
    String type;
    int x;
    int y;
    
    public Cell( String type, int x, int y ) {
        this.type = type;
        this.x = x;
        this.y = y;
    }
    
    public String getType() {
        return type;
    }
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
    
}
