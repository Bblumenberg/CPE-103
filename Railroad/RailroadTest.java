import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

import java.util.ArrayList;

public class RailroadTest {
   @Test
   public void givenTest1() {
      ArrayList<String> ret = Railroad.rrSwitch(new int[]{3, 2, 4, 1, 6, 5});
      assertEquals(ret.get(0), "R R R L L R L L R R L L");
      assertEquals(ret.get(1), "3 2 4 1 6 5");
      assertEquals(ret.get(2), "");
      assertEquals(ret.get(3), "");
   }
   
   @Test
   public void givenTest2() {
      ArrayList<String> ret = Railroad.rrSwitch(new int[]{3, 1, 2, 4, 6, 5});
      assertEquals(ret.get(0), "R R R L");
      assertEquals(ret.get(1), "3");
      assertEquals(ret.get(2), "2 1");
      assertEquals(ret.get(3), "4 5 6");
   }
   
   @Test
   public void test() {
      ArrayList<String> ret = Railroad.rrSwitch(new int[]{6, 5, 4, 3, 1, 2});
      assertEquals(ret.get(0), "R R R R R R L L L L");
      assertEquals(ret.get(1), "6 5 4 3");
      assertEquals(ret.get(2), "2 1");
      assertEquals(ret.get(3), "");
   }
   
   @Test
   public void test2() {
      ArrayList<String> ret = Railroad.rrSwitch(new int[]{6, 3, 4, 5, 1, 2});
      assertEquals(ret.get(0), "R R R R R R L");
      assertEquals(ret.get(1), "6");
      assertEquals(ret.get(2), "5 4 3 2 1");
      assertEquals(ret.get(3), "");
   }

   public static junit.framework.Test suite() {
      return new junit.framework.JUnit4TestAdapter(RailroadTest.class); 
   }

   public static void main(String args[]) {
      org.junit.runner.JUnitCore.main("RailroadTest");
   }
}
