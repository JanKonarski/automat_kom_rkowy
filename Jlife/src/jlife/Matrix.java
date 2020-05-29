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
    
    public Matrix(int width, int height) {
        if(width < 50 || height < 50)
            throw new IllegalArgumentException( "" );
        
        this.width = width;
        this.height = height;
        this.matrix = new byte[width * height];
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
    
    public void next() {
        int coresNum = Runtime.getRuntime().availableProcessors();
        this.next(coresNum);
    }
    
    public void next(int coresNum)
    {
        // next generation with threads
    }
}
