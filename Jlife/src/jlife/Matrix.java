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
    
    public void next(int coresNum) {
        // next generation with threads
        for( int i=0; i < matrix.length; i++) {
            if(matrix[i] == 0)
                continue;
            if(matrix[i] == 1) {
                matrix[i] = 2;
                continue;
            }
            if(matrix[i] == 2) {
                matrix[i] = 3;
                continue;
            }
            if(matrix[i] == 3) {
                if( countNeighbours( i ) == 1 || countNeighbours( i ) == 2 )
                    matrix[i] = 1;
            }
       
        }
    }
    
    private int countNeighbours( int i ){
        int x = getCoorfinates(i)[0];
        int y = getCoorfinates(i)[1];
        int neighNum = 0;
        
        int startPosX = (x - 1 < 0) ? x : x-1;
        int startPosY = (y - 1 < 0) ? y : y-1;
        int endPosX =   (x + 1 > width - 1) ? x : x+1;
        int endPosY =   (y + 1 > height - 1) ? y : y+1;

        for (int rowNum=startPosX; rowNum<=endPosX; rowNum++) {
            for (int colNum=startPosY; colNum<=endPosY; colNum++) {
                if(matrix[i] == 1)
                    neighNum++;
            }
        }
        return neighNum-1;
    }
}

