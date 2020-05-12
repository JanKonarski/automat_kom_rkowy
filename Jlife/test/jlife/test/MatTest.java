package jlife.test;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.assertEquals;

import jlife.Mat;

/**
 * @author Jan Konarski
 * @author Maciej Kołek
 */
public class MatTest {
    
    private Mat mat;
    
    @Before
    public void setUp()
    {
        mat = new Mat( 5, 5 );
    }
    
    @Test
    public void testGetXsize()
    {
        System.out.println( "Mat X size" );
        int expRes = 5;
        int res = mat.getXsize();
        assertEquals( res, expRes );
    }
    
}
