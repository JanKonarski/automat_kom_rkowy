package jlife;

import java.util.Vector;

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
    
    public void setCell( int position, byte type ) {
        if( position < 0 || position > matrix.length )
            throw new IllegalArgumentException();
        
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
/*    
    public void next() {
        int coresNum = Runtime.getRuntime().availableProcessors();
        this.next(coresNum);
    }
*/    
//    public void next( int coresNum ) {
    public void next() {
        // next generation with threads
        Vector<Integer> vec = new Vector<Integer>();
        Vector<Byte> vecB = new Vector<Byte>();
        
        for( int i=0; i < matrix.length; i++ ) {
            switch( matrix[i] ) {
            
            case (byte)3:
                int count = countNeighbours( i );
                if( count == 1 || count == 2 ) {
                    vec.addElement(i);
                    vecB.addElement((byte)1);
                }
                break;
                
            case (byte)1: 
                vec.addElement(i);
                vecB.addElement((byte)2);
                break;
                
            case (byte)2:
                vec.addElement(i);
                vecB.addElement((byte)3);
                break;
            }
        }
        
        for( int i=0; i < vec.size(); i++ )
            matrix[vec.get(i)] = vecB.get(i);
    }
    
    private int countNeighbours( int i ) {
        int x = getCoorfinates(i)[0];
        int y = getCoorfinates(i)[1];
        int neighNum = 0;
        
        int startPosX = (x == 0) ? x : x-1;
        int startPosY = (y == 0) ? y : y-1;
        int endPosX = (x >= width) ? x : x+1;
        int endPosY = (y >= height) ? y : y+1;

        for( int rowNum=startPosX; rowNum <= endPosX; rowNum++ )
            for( int colNum=startPosY; colNum <= endPosY; colNum++ )
                if( matrix[getPosition(rowNum, colNum)] == 1 )
                    neighNum++;
                
        return neighNum;
    }
    
    public void clean() {
        for( int i=0; i < matrix.length; i++)
            matrix[i] = 0;
    }
    
}
