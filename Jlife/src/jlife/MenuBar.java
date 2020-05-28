/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jlife;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.util.Enumeration;
import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author janek
 */
public class MenuBar extends JMenuBar implements ActionListener {
    
    private JMenu fileMenu;
    private JMenuItem importItem;
    private JMenuItem exportItem;
    private JMenuItem exitItem;
    
    private JMenu settingsMenu;
    
    private JMenu helpMenu;
    private JMenuItem abouteItem;
    
    public MenuBar() {
        fileMenu = new JMenu( "File" );
        importItem = new JMenuItem( "Import", 'I' );
        exportItem = new JMenuItem( "Export", 'E' );
        exitItem = new JMenuItem( "Exit", 'x' );
        
        fileMenu.add( importItem );
        fileMenu.add( exportItem );
        fileMenu.addSeparator();
        fileMenu.add( exitItem );
        
        importItem.addActionListener( this );
        importItem.setAccelerator( KeyStroke.getKeyStroke( "ctrl I" ) );
        
        exportItem.addActionListener( this );
        exportItem.setAccelerator( KeyStroke.getKeyStroke( "ctrl E" ) );
        
        exitItem.addActionListener( this );
        exitItem.setAccelerator( KeyStroke.getKeyStroke( "ctrl X" ) );
        
        settingsMenu = new JMenu( "Settings" );
        
        helpMenu = new JMenu( "Help" );
        abouteItem = new JMenuItem( "Aboute", 'A' );
        
        helpMenu.add( abouteItem );
        
        abouteItem.addActionListener( this );
        
        add( fileMenu );
        add( settingsMenu );
        add( helpMenu );
    }
    
    @Override
    public void actionPerformed( ActionEvent e ) {
        if( e.getSource() == exitItem )
            System.exit( 0 );
        
        else if( e.getSource() == abouteItem )
            JOptionPane.showMessageDialog( null, "The Game of Life Program v1.0" );
        
        else if( e.getSource() == importItem ) {
            try {
                JFileChooser chooser = new JFileChooser();
                FileNameExtensionFilter filter = new FileNameExtensionFilter( "JavaScript Object Notation file(.json)", "json" );
                chooser.setFileFilter( filter );
                chooser.showOpenDialog( this );
                
                Gson gson = new Gson();
                JsonObject jo = gson.fromJson( new FileReader( chooser.getSelectedFile() ), JsonObject.class );
                
                int width = jo.get( "width" ).getAsInt();
                int height = jo.get( "height" ).getAsInt();
                JsonArray ja = jo.get( "cells" ).getAsJsonArray();
                
                Staff staff = new Staff( width, height );
                for( JsonElement o : ja ) {
                    JsonObject el = o.getAsJsonObject();
                    String type = el.get( "type" ).getAsString();
                    int x = el.get( "x" ).getAsInt();
                    int y = el.get( "y" ).getAsInt();
                    
                    staff.add( new Cell( type, x, y ) );
                }
                
                System.out.println( staff.getWidth() + "x" + staff.getHeight() + "\n" + "Cells: " );
                for( Cell c : staff.getCells() ) {
                    System.out.print( "\t" + c.getType() + "@" );
                    System.out.print( c.getX() + "," );
                    System.out.println( c.getY() );
                }
                
            } catch( Exception ex ) {
                JOptionPane.showMessageDialog( null, "Opening file error" );
            }
        }
    }
    
}
