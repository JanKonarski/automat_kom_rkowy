package jlife;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

/**
 * @author Jan Konarski
 * @author Maciej Kołek
 */
public class Window extends JFrame implements ActionListener
{
    private Color gbColor = new Color(70, 70, 70);
    private Color menuColor = new Color(218, 223, 225);
    private Color menuItemColor = new Color(53, 53, 53);
    private Font fontStyle = new Font("Heebo", Font.CENTER_BASELINE, 12);
    
    private JMenuBar menuBar;
    
    private JMenu fileMenu;
    private JMenuItem importItem;
    private JMenuItem exportItem;
    private JMenuItem saveItem;
    private JMenuItem nextItem;
    private JMenuItem clearItem;
    private JMenuItem exitItem;
    
    private JMenu aboutMenu;
    
    private JPanel viewPanel;
    
    public Window(int width, int height)
    {
        frameInit();
        
        { //Window Size
            this.setMinimumSize(new Dimension(800, 600));
            this.setPreferredSize(new Dimension(1280, 720));
            this.setMaximumSize(new Dimension(2147483647, 2147483647));
        }
        this.setSize(new Dimension(width, height));
        this.getContentPane().setBackground(gbColor);
        setTitle("JLife");
        
        { //Menu
            menuBar = new JMenuBar();
            menuBar.setBackground(gbColor);

            fileMenu = new JMenu("File");
            fileMenu.setFont(fontStyle);
            fileMenu.setForeground(menuColor);
            menuBar.add(fileMenu);

            importItem = new JMenuItem("Import", 'I');
            importItem.setFont(fontStyle);
            importItem.setForeground(menuItemColor);
            importItem.setAccelerator(KeyStroke.getKeyStroke("ctrl I"));
            importItem.addActionListener(this);
            fileMenu.add(importItem);

            exportItem = new JMenuItem("Export", 'E');
            exportItem.setFont(fontStyle);
            exportItem.setForeground(menuItemColor);
            exportItem.setAccelerator(KeyStroke.getKeyStroke("ctrl E"));
            exportItem.addActionListener(this);
            fileMenu.add(exportItem);
            
            saveItem = new JMenuItem("Save Image", 'S');
            saveItem.setFont(fontStyle);
            saveItem.setForeground(menuItemColor);
            saveItem.setAccelerator(KeyStroke.getKeyStroke("ctrl S"));
            saveItem.addActionListener(this);
            fileMenu.add(saveItem);
            
            fileMenu.addSeparator();
            
            nextItem = new JMenuItem("Next Generation", 'N');
            nextItem.setFont(fontStyle);
            nextItem.setForeground(menuItemColor);
            nextItem.setAccelerator(KeyStroke.getKeyStroke("ctrl N"));
            nextItem.addActionListener(this);
            fileMenu.add(nextItem);
            
            clearItem = new JMenuItem("Clear Generation", 'C');
            clearItem.setFont(fontStyle);
            clearItem.setForeground(menuItemColor);
            clearItem.setAccelerator(KeyStroke.getKeyStroke("ctrl C"));
            clearItem.addActionListener(this);
            fileMenu.add(clearItem);

            fileMenu.addSeparator();

            exitItem = new JMenuItem("Exit", 'x');
            exitItem.setFont(fontStyle);
            exitItem.setForeground(menuItemColor);
            exitItem.setAccelerator(KeyStroke.getKeyStroke("ctrl X"));
            exitItem.addActionListener(this);
            fileMenu.add(exitItem);
            
            aboutMenu = new JMenu("About");
            aboutMenu.setFont(fontStyle);
            aboutMenu.setForeground(menuColor);
            aboutMenu.addActionListener(this);
            menuBar.add(aboutMenu);
            
            setJMenuBar(menuBar);
        }
        
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        setVisible( true );
    }
    
    @Override
    public void actionPerformed( ActionEvent e )
    {
        if(e.getSource() == exitItem)
            System.exit(0);
    }
    
}
