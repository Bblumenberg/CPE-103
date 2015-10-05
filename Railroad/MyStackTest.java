import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

import java.util.ArrayList;

public class MyStackTest {
   
   @Test
   public void testInitializationOfDifferentTypes() {
      MyStack<Integer> myIntegerStack = new MyStack<Integer>();      
      MyStack<String> myStringStack = new MyStack<String>();
      MyStack<Double> myDoubleStack = new MyStack<Double>();
      MyStack<Float> myFloatStack = new MyStack<Float>();
   }


   @Test
   public void test1Size() {
      MyStack<Integer> myIntegerStack = new MyStack<Integer>();      
      myIntegerStack.push(0);

      assertEquals(1, myIntegerStack.size());
   }
   
   @Test
   public void test2Size() {
      MyStack<Integer> myIntegerStack = new MyStack<Integer>();      
      myIntegerStack.push(0);
      myIntegerStack.push(0);

      assertEquals(2, myIntegerStack.size());
   }
   
   @Test
   public void test3Size() {
      MyStack<Integer> myIntegerStack = new MyStack<Integer>();      
      myIntegerStack.push(0);
      myIntegerStack.push(0);
      myIntegerStack.push(0);

      assertEquals(3, myIntegerStack.size());

   }
   
   @Test
   public void test100Size() {
      MyStack<Integer> myIntegerStack = new MyStack<Integer>();      

      for (int i = 0; i < 100; i++) {
         myIntegerStack.push(0);
      }

      assertEquals(100, myIntegerStack.size());
   }
   
   @Test
   public void testIsEmpty() {
      MyStack<Integer> myIntegerStack = new MyStack<Integer>();      

      assertTrue(myIntegerStack.isEmpty());
   }
  
   @Test
   public void testPushAndPop() {
      MyStack<Integer> myIntegerStack = new MyStack<Integer>();      
      
      for (int i = 0; i < 100; i++) {
         myIntegerStack.push(i);
      }
      
      for (int i = 99; i >= 0; i--) {
         assertEquals(new Integer(i), myIntegerStack.peek());
         assertEquals(new Integer(i), myIntegerStack.pop());
      }
   }

   @Test(expected = java.util.NoSuchElementException.class) 
   public void testNoSuchElementPop() {
      MyStack<Integer> myIntegerStack = new MyStack<Integer>();      
      myIntegerStack.pop(); 
   }
   
   @Test(expected = java.util.NoSuchElementException.class) 
   public void testNoSuchElementPeek() {
      MyStack<Integer> myIntegerStack = new MyStack<Integer>();      
      myIntegerStack.peek(); 
   }

   @Test
   public void testIsEmptyAfterPushPop() {
      MyStack<Integer> myIntegerStack = new MyStack<Integer>();      

      myIntegerStack.push(0);
      myIntegerStack.pop();

      assertTrue(myIntegerStack.isEmpty());
   }

   public static junit.framework.Test suite() {
      return new junit.framework.JUnit4TestAdapter(MyStackTest.class); 
   }

   public static void main(String args[]) {
      org.junit.runner.JUnitCore.main("MyStackTest");
   }
}
