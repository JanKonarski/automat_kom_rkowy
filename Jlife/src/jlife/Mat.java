package jlife;

//import java.lang.Thread;

/**
 * @author Jan Konarski
 * @author Maciej Kołek
 */
public class Mat extends Matrix
{
    
    public Mat( int sizeX, int sizeY )
    {
        if( sizeX < 1 || sizeY < 1)
            throw new IllegalArgumentException( "" );
        
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.matrix = new byte[ sizeX * sizeY ];
    }
    
    public Mat( Mat mat )
    {
        this.sizeX = mat.sizeX;
        this.sizeY = mat.sizeY;
        this.matrix = mat.matrix;
    }
    
    @Override
    public void next()
    {
        int coresNum = Runtime.getRuntime().availableProcessors();
        this.next( coresNum );
    }
    
    public void next( int coresNum )
    {
        // next generation with threads
    }
    
}
