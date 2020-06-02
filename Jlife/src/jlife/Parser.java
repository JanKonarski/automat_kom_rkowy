/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jlife;

import java.util.ArrayList;
import java.util.Vector;

/**
 *
 * @author janek
 */
public class Parser {
    
    ArrayList<Vector<Object>> structures = new ArrayList<Vector<Object>>();
    
    public Parser() {
        
        { // OR right
            Vector<Object> ORr = new Vector<Object>();
            ORr.add(new String("ORr"));
            ORr.add(new Object[] {
                (byte)3, (int)0, (int)0,
                (byte)3, (int)0, (int)4,
                (byte)3, (int)1, (int)0,
                (byte)3, (int)1, (int)2,
                (byte)3, (int)1, (int)4,
                (byte)3, (int)2, (int)1,
                (byte)3, (int)2, (int)2,
                (byte)3, (int)2, (int)3,
                (byte)3, (int)3, (int)2,
                (byte)3, (int)4, (int)2
            });
            structures.add(ORr);
        }
        { // OR up
            Vector<Object> ORu = new Vector<Object>();
            ORu.add(new String("ORu"));
            ORu.add(new Object[] { // (byte)type, (int)x, (int)y
                (byte)3, (int)0, (int)0,
                (byte)3, (int)0, (int)1,
                (byte)3, (int)1, (int)2,
                (byte)3, (int)0, (int)2,
                (byte)3, (int)-1, (int)2,
                (byte)3, (int)2, (int)3,
                (byte)3, (int)0, (int)3,
                (byte)3, (int)-2, (int)3,
                (byte)3, (int)2, (int)4,
                (byte)3, (int)-2, (int)4
            });
            structures.add(ORu);
        }
        { // OR left
            Vector<Object> ORl = new Vector<Object>();
            ORl.add(new String("ORl"));
            ORl.add(new Object[] {
                (byte)3, (int)0, (int)0,
                (byte)3, (int)1, (int)0,
                (byte)3, (int)2, (int)-1,
                (byte)3, (int)2, (int)0,
                (byte)3, (int)2, (int)1,
                (byte)3, (int)3, (int)-2,
                (byte)3, (int)3, (int)0,
                (byte)3, (int)3, (int)2,
                (byte)3, (int)4, (int)-2,
                (byte)3, (int)4, (int)2
            });
            structures.add(ORl);
        }
        { // OR down
            Vector<Object> ORd = new Vector<Object>();
            ORd.add(new String("ORd"));
            ORd.add(new Object[] {
                (byte)3, (int)0, (int)0,
                (byte)3, (int)4, (int)0,
                (byte)3, (int)0, (int)1,
                (byte)3, (int)2, (int)1,
                (byte)3, (int)4, (int)1,
                (byte)3, (int)1, (int)2,
                (byte)3, (int)2, (int)2,
                (byte)3, (int)3, (int)2,
                (byte)3, (int)2, (int)3,
                (byte)3, (int)2, (int)4
            });
            structures.add(ORd);
        }
    }
    
    public Vector<Object> get( String type ) {
        for( String t : new String[] {"0", "1", "2", "3"} )
            if( type.equals(t) ) {
                Vector<Object> cell = new Vector<Object>();
                cell.add(type);
                cell.add(new Object[] {
                    (byte)(type.getBytes()[0] - 48), (int)0, (int)0
                });
                return cell;
            }
        
        for( Vector<Object> obj : structures )
            if( ((String)obj.get(0)).equals(type) )
                return obj;
        
        throw new IllegalArgumentException("");
    }
    
}
