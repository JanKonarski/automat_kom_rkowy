package jlife.test;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.assertEquals;

import jlife.Matrix;

/**
 * @author Jan Konarski
 * @author Maciej Kołek
 */
public class MatreixTest {
    
    private Matrix mat;
    
    @Before
    public void setUp()
    {
        mat = new Matrix( 50, 50 );
    }
    
    @Test
    public void testGetXsize()
    {
        System.out.println( "Mat X size" );
        int expRes = 50;
        int res = mat.getWidth();
        assertEquals( res, expRes );
    }
    
}
