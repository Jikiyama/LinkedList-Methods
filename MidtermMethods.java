/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package midterm.methods;

import java.util.LinkedList;
import java.util.ListIterator;

/**
 *
 * @author Jikiy
 */
public class MidtermMethods {

    public static void main(String[] args) {
        LinkedList<String> mySortedList = new LinkedList<>();
        LinkedList<String> myUnSortedList = new LinkedList<>();
   
        String a = "a";
        String b = "b";
        String c = "c";
        String d = "d";
        String e = "e";

      

        mySortedList.addFirst(e);        
        mySortedList.addFirst(d);        
        mySortedList.addFirst(c);
        mySortedList.addFirst(b);
        mySortedList.addFirst(a);      
        
        System.out.println(isSorted(mySortedList));
    }
    public static boolean isSorted(LinkedList<String> list){
        ListIterator myIterator = list.listIterator();
        boolean isSorted = true;
        String testedString = list.getFirst();
        myIterator.next(); //advance the iterator to just after the first
        while (myIterator.hasNext()){
            String nextString = (String) myIterator.next();
            if (testedString.compareTo(nextString) > 0)
                isSorted = false;
            
            testedString = nextString;         
        }
        return isSorted;
    }
    
    public static LinkedList<String> deleteAlt(LinkedList<String> list){
        ListIterator myIterator = list.listIterator();
        boolean alternate = false;
        while(myIterator.hasNext()){
            if (!alternate){
                myIterator.next();
                alternate = true;
            } else {
                myIterator.next();
                myIterator.remove();
                alternate = false;
            }
        }
        return list;
    }
    
}
