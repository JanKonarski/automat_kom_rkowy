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
        { // head
            Vector<Object> head = new Vector<Object>();
            head.add(new String("head"));
            head.add(new Object[] {
                (byte)1, (int)0, (int)0
            });
            structures.add(head);
        }
        { // tail
            Vector<Object> tail = new Vector<Object>();
            tail.add(new String("tail"));
            tail.add(new Object[] {
                (byte)2, (int)0, (int)0
            });
            structures.add(tail);
        }
        { // cond
            Vector<Object> cond = new Vector<Object>();
            cond.add(new String("cond"));
            cond.add(new Object[] {
                (byte)3, (int)0, (int)0
            });
            structures.add(cond);
        }
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
        { // AND right
            Vector<Object> ANDr = new Vector<Object>();
            ANDr.add(new String("ANDr"));
            ANDr.add(new Object[] {
                (byte)3, (int)0, (int)0,
                (byte)3, (int)0, (int)3,
                (byte)3, (int)1, (int)0,
                (byte)3, (int)1, (int)4,
                (byte)3, (int)1, (int)5,
                (byte)3, (int)1, (int)6,
                (byte)3, (int)2, (int)0,
                (byte)3, (int)2, (int)7,
                (byte)3, (int)3, (int)0,
                (byte)3, (int)3, (int)6,
                (byte)3, (int)3, (int)5,
                (byte)3, (int)3, (int)4,
                (byte)3, (int)4, (int)0,
                (byte)3, (int)4, (int)3,
                (byte)3, (int)5, (int)0,
                (byte)3, (int)5, (int)2,
                (byte)3, (int)5, (int)3,
                (byte)3, (int)5, (int)4,
                (byte)3, (int)6, (int)0,
                (byte)3, (int)6, (int)3,
                (byte)3, (int)7, (int)0,
                (byte)3, (int)7, (int)2,
                (byte)3, (int)7, (int)4,
                (byte)3, (int)8, (int)1,
                (byte)3, (int)8, (int)5,
                (byte)3, (int)9, (int)1,
                (byte)3, (int)9, (int)4,
                (byte)3, (int)9, (int)5,
                (byte)3, (int)9, (int)6,
                (byte)3, (int)10, (int)1,
                (byte)3, (int)10, (int)5,
                (byte)3, (int)11, (int)2,
                (byte)3, (int)11, (int)3,
                (byte)3, (int)11, (int)4,
                (byte)3, (int)11, (int)6,
                (byte)3, (int)12, (int)6
            });
            structures.add(ANDr);
        }
        { // AND down
            Vector<Object> ANDd = new Vector<Object>();
            ANDd.add(new String("ANDd"));
            
            Vector<Object> tmpS = structures.get(structures.size()-1);
            Object[] arr = (Object[])tmpS.get(1);
            Object[] copyArr = new Object[arr.length];
            System.arraycopy(arr, 0, copyArr, 0, arr.length);
            for(int i=0 ; i < copyArr.length ; i+=3) {
                copyArr[i+1] = -(int)arr[i+2];
                copyArr[i+2] = (int)arr[i+1];
            }
            ANDd.add(copyArr);
            structures.add(ANDd);
        }
        { // AND left
            Vector<Object> ANDl = new Vector<Object>();
            ANDl.add(new String("ANDl"));
            
            Vector<Object> tmpS = structures.get(structures.size()-2);
            Object[] arr = (Object[])tmpS.get(1);
            Object[] copyArr = new Object[arr.length];
            System.arraycopy(arr, 0, copyArr, 0, arr.length);

            for(int i=0 ; i < copyArr.length ; i+=3)
                copyArr[i+1] = -(int)copyArr[i+1];
            ANDl.add(copyArr);
            structures.add(ANDl);
        }
        { // AND up
            Vector<Object> ANDu = new Vector<Object>();
            ANDu.add(new String("ANDu"));
            
            Vector<Object> tmpS = structures.get(structures.size()-3);
            Object[] arr = (Object[])tmpS.get(1);
            Object[] copyArr = new Object[arr.length];
            System.arraycopy(arr, 0, copyArr, 0, arr.length);
            for(int i=0 ; i < copyArr.length ; i+=3) {
                copyArr[i+2] = -(int)arr[i+1];
                copyArr[i+1] = (int)arr[i+2];       
            }
            ANDu.add(copyArr);
            structures.add(ANDu);
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
