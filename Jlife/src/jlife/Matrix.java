package jlife;

/**
 * @author Jan Konarski
 * @author Maciej Kołek
 */
public class Matrix
{
    protected int width;
    protected int height;
    protected byte[] matrix;
    
    public Matrix( int width, int height ) {
        if(width < 50 || height < 50)
            throw new IllegalArgumentException();
        
        this.width = width;
        this.height = height;
        this.matrix = new byte[width * height];
        
        for( int i=0; i < matrix.length; i++)
            matrix[i] = 0;
    }
    
    public int getPosition( int x, int y ) {
        if( x < 0 || x > width || y < 0 || y > height)
            throw new IllegalArgumentException();
        
        return y * height + x;
    }
    
    public int[] getCoorfinates( int position ) {
        if( position < 0 || position > matrix.length )
            throw new IllegalArgumentException();
        
        int y = position / height;
        int x = position - y * height;
        return new int[] {x, y};
    }
    
    public void setCell( int x, int y, byte type ) {
        int position = getPosition(x, y);
        matrix[position] = type;
    }
    
    public int getWidth() {
        return width;
    }
    
    public int getHeight() {
        return height;
    }
    
    public byte[] getMatrix() {
        return matrix;
    }
    
    public byte getCell( int x, int y ) {
        int position = getPosition(x, y);
        return matrix[position];
    }
    
    public byte getCell( int position ) {
        if( position < 0 || position > matrix.length )
            throw new IllegalArgumentException();
        
        return matrix[position];
    }
    
    public void next() {
        int coresNum = Runtime.getRuntime().availableProcessors();
        this.next(coresNum);
    }
    
    public void next(int coresNum)
    {
        // next generation with threads
    }
}
