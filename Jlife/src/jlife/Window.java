package jlife;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import javax.swing.JFileChooser;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.KeyStroke;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * @author Jan Konarski
 * @author Maciej Kołek
 */
public class Window extends JFrame implements ActionListener
{
    private final Color gbColor = new Color(70, 70, 70);
    private final Color menuColor = new Color(218, 223, 225);
    private final Color menuItemColor = new Color(53, 53, 53);
    private final Font fontStyle = new Font("Heebo", Font.CENTER_BASELINE, 12);
    
    private final JMenuBar menuBar;
    
    private final JMenu fileMenu;
    private final JMenuItem importItem;
    private final JMenuItem exportItem;
    private final JMenuItem saveItem;
    private final JMenuItem nextItem;
    private final JMenuItem clearItem;
    private final JMenuItem exitItem;
    
    private final JMenu aboutMenu;
    
    private JPanel viewPanel;
    
    private Matrix mat;
    
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
        this.setTitle("JLife");
        
        mat = new Matrix(50, 50);
        
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
        
        {
            viewPanel = new ViewPanel(mat);
            
            JScrollPane scroll = new JScrollPane(viewPanel);
            scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
            scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
            
            this.add(scroll);
        }
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        
        System.out.println(viewPanel.getWidth() + "@" + viewPanel.getHeight());
    }
    
    @Override
    public void actionPerformed( ActionEvent e )
    {
        if( e.getSource() == importItem )
            importGeneration();
        
        if( e.getSource() == exportItem )
            exportGeneration();
        
        if( e.getSource() == saveItem )
            saveImage();
        
        if( e.getSource() == nextItem ) {
            // next
            // rifresh planszy
        }
        
        if ( e.getSource() == clearItem )
            clearBoard();
        
        if( e.getSource() == exitItem )
            System.exit(0);
    }
    
    private void importGeneration() {
        try {
            JFileChooser chooser = new JFileChooser();
            chooser.setDialogTitle("Import generation from file");
            String extension = "JavaScript Object Notation file(.json)";
            FileNameExtensionFilter filter = new FileNameExtensionFilter(extension, ".json");
            chooser.setFileFilter(filter);
            if( chooser.showOpenDialog( this ) != JFileChooser.APPROVE_OPTION )
                throw new Exception( "Importing file error" );

            Gson gson = new Gson();
            File file = chooser.getSelectedFile();
            FileReader reader = new FileReader(file);
            JsonObject jsonObj = gson.fromJson(reader, JsonObject.class);
            
            int width = jsonObj.get("width").getAsInt();
            int height = jsonObj.get("height").getAsInt();
            
            JsonArray jsonArray = jsonObj.get("cells").getAsJsonArray();
            
            Matrix mat = new Matrix(width, height);
            
            for( JsonElement el : jsonArray ) {
                JsonObject elObject = el.getAsJsonObject();
                int x = elObject.get("x").getAsInt();
                int y = elObject.get("y").getAsInt();
                String type = elObject.get("type").getAsString();
                
                int pos = mat.getPosition(x, y);
                mat.matrix[pos] = convertToType(type); 
            }
            
            // rifresh planszy
            
        } catch( Exception e ) {
            JOptionPane.showMessageDialog(null, "Importing file error");
        }
    }
    
    private byte convertToType (String type) {
        switch (type) {
            case "conductor":  return 1;
            case "tail":   return 2;
            case "head": return 1;
            case "empty":  return 0;
            default: return 0;
        }
    }
    
    private void exportGeneration() {
        try {
            JFileChooser chooser = new JFileChooser();
            chooser.setDialogTitle("Export generation from file");
            chooser.setSelectedFile(new File("generation.json"));
            String extension = "JavaScript Object Notation file(.json)";
            FileNameExtensionFilter filter = new FileNameExtensionFilter(extension, ".json");
            chooser.setFileFilter(filter);
            if( chooser.showSaveDialog( this ) != JFileChooser.APPROVE_OPTION )
                throw new Exception( "Exporting file error" );
            
            String fileName = chooser.getSelectedFile().toString();
            if( !fileName.endsWith(".json") )
                chooser.setSelectedFile(new File(fileName + ".json"));
            
            JsonObject jsonObj = new JsonObject();
            jsonObj.addProperty("width", mat.getWidth());
            jsonObj.addProperty("height", mat.getHeight());
            JsonArray jsonArray = new JsonArray();
            for( int i=0; i < mat.getMatrix().length; i++ ) {
                int x = mat.getCoorfinates(i)[0];
                int y = mat.getCoorfinates(i)[1];
                int type = mat.getCell(i);
                if( type == 0 )
                    continue;
                
                JsonObject elObj = new JsonObject();
                elObj.addProperty("x", x);
                elObj.addProperty("y", y);
                elObj.addProperty("type", String.valueOf(type));
                jsonArray.add(elObj);
            }
            jsonObj.add("cells", jsonArray);
            
            Gson gson = new Gson();
            String json = gson.toJson(jsonObj);
            
            File file = chooser.getSelectedFile();
            FileWriter writer = new FileWriter(file);
            writer.write(json);
            writer.close();
            
        } catch( Exception e ) {
            JOptionPane.showMessageDialog(null, "Exporting file error");
        }
    }
    
    private void saveImage() {
        try {
            
            
        } catch( Exception e ) {
            JOptionPane.showMessageDialog(null, "Saving image error");
        }
    }
    
    private void clearBoard() {
        mat = new Matrix(50, 50);
        // rifresh planszy
    }
    
}
