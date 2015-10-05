import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

import java.util.ArrayList;

public class MyRailroadTest {
   
    private void assertArrayListEqual(ArrayList<String> one, ArrayList<String> two){
        assertTrue(one.size() == two.size());
        for(int i = 0; i < one.size(); i ++){
            assertTrue(one.get(i).equals(two.get(i)));
        }
    }

    @Test
    public void test123456(){
        Railroad R = new Railroad();
        ArrayList<String> result = R.rrSwitch(new int[] {1,2,3,4,5,6});
        EasyList<String> expected = new EasyList<String>("R L R L R L R L R L R L", "1 2 3 4 5 6", "", "");
        assertArrayListEqual(result, expected);
    }
    
    @Test
    public void test654321(){
        Railroad R = new Railroad();
        ArrayList<String> result = R.rrSwitch(new int[] {6,5,4,3,2,1});
        EasyList<String> expected = new EasyList<String>("R R R R R R L L L L L L", "6 5 4 3 2 1", "", "");
        assertArrayListEqual(result, expected);
    }
    
    @Test
    public void test324165(){
        Railroad R = new Railroad();
        ArrayList<String> result = R.rrSwitch(new int[] {3,2,4,1,6,5});
        EasyList<String> expected = new EasyList<String>("R R R L", "3", "2 1", "4 5 6");
        assertArrayListEqual(result, expected);
    }
    
    @Test
    public void test312465(){
        Railroad R = new Railroad();
        ArrayList<String> result = R.rrSwitch(new int[] {3,1,2,4,6,5});
        EasyList<String> expected = new EasyList<String>("R L R L R L R L R L R L", "1 2 3 4 5 6", "", "");
        assertArrayListEqual(result, expected);
    }
    
    //just for fun:
    @Test
    public void test465(){
        Railroad R = new Railroad();
        ArrayList<String> result = R.rrSwitch(new int[] {4,6,5});
        EasyList<String> expected = new EasyList<String>("R R R R L R R L L", "4 6 5", "1 2 3", "");
        assertArrayListEqual(result, expected);
    }

    public static junit.framework.Test suite() {
       return new junit.framework.JUnit4TestAdapter(MyRailroadTest.class);
    }

    public static void main(String args[]) {
       org.junit.runner.JUnitCore.main("MyRailroadTest");
    }
}

/*
 Pseudo Code for Railroad.java:
 
 public class Railroad{
    String moves
    Stack rstk
    Stack mstk
    Stack lstk
 
    Railraoad(){
        do setup
    }
 
    Integer R(){
        pop rstk, push to mskt, save "R" to moves, return value in question
    }
 
    Integer L(){
        pop mstk, push to lstk, save "L" to moves, return value in question
    }
 
    String[] rrSwitch(int[] desired){
        reset moves
        iterate through desired array{
            if(mstk is empty){do R()}
            if(top of mstk is what we want){move it to lstk}
            if(top of mskt is greater than what we want){stop here, not solvable}
            //if top value here is greater than what we want, what we want MUST be 'burried' in mstk
            while(R() != what we want){keep doing R() in while loop}
            //this is why R() has to return value
            L() //move what while loop found to lstk()
        }
        build the string[] from moves, lstk, mstk, and rstk
        return string[]
    }
 }
*/
























