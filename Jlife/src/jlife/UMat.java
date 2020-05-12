package jlife;

/**
 * @author Jan Konarski
 * @author Maciej Kołek
 */
public class UMat extends Matrix
{
    
    public UMat( int sizeX, int sizeY )
    {
        if( sizeX < 1 || sizeY < 1)
            throw new IllegalArgumentException( "" );
        
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.matrix = new byte[ sizeX * sizeY ];
    }
    
    public UMat( UMat mat )
    {
        this.sizeX = mat.sizeX;
        this.sizeY = mat.sizeY;
        this.matrix = mat.matrix;
    }
    
    @Override
    public void next()
    {
        
    }
    
}
