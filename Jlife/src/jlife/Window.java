package jlife;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;

/**
 * @author Jan Konarski
 * @author Maciej Kołek
 */
public class Window extends JFrame implements ActionListener
{
    private MenuBar menu;
    private JPanel confPanel;
    private JPanel viewPanel;
    
    public Window( int sizeX, int sizeY)
    {
        if( sizeX < 1 || sizeY < 1 )
            throw new IllegalArgumentException( "" );
        
        frameInit();
        
        setSize( sizeX, sizeY );
        setTitle( "JLife" );
        
        setJMenuBar( new MenuBar() );
        
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        setVisible( true );
    }
    
    @Override
    public void actionPerformed( ActionEvent e )
    {
        
    }
    
}
