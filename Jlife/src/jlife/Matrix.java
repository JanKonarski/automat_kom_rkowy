package jlife;

/**
 * @author Jan Konarski
 * @author Maciej Kołek
 */
public abstract class Matrix
{
    protected int sizeX;
    protected int sizeY;
    protected byte[] matrix;
    
    public int getXsize()
    {
        return sizeX;
    }
    
    public int getYsize()
    {
        return sizeY;
    }
    
    public byte[] getMatrix()
    {
        return matrix;
    }
    
    public abstract void next();
}
