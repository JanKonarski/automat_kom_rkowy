package jlife.test;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.assertEquals;

import jlife.UMat;

/**
 * @author Jan Konarski
 * @author Maciej Kołek
 */
public class UMatTest {
    
    private UMat mat;
    
    @Before
    public void setUP()
    {
        mat = new UMat( 5, 5 );
    }
    
    @Test
    public void testGetXsize()
    {
        System.out.println( "UMat X size" );
        int expRes = 5;
        int res = mat.getXsize();
        assertEquals( res, expRes );
    }
    
}
