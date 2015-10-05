import java.util.*;

public class MyStack<AnyType>{
   // Declare member variables here
    Node<AnyType> top;
    
   /**
    * Construct an empty Stack.
    */
   public MyStack( ){
      // TODO: Implement Default Constructor
      top = null;
   }

   /**
    * Empties the list and change the size of this collection to zero.
    */
   private void clear( ){
      // TODO: Implement Clear
      top = null;
   }

   /**
    * Returns the number of items in this collection.
    */
   public int size( ) {
      // TODO: Implement size
      if(top == null){return 0;}
      else{
          Node current = top;
          int size = 1;
          while(current.next != null){
              size += 1;
              current = current.next;
          }
          return size;
      }
   }

   public boolean isEmpty( ) {
      // TODO: Implement check if list is empty
      if(this.size() == 0){return true;}
      return false;
   }

   // Simple push to top of stack of x.   
   public void push( AnyType x )    {
     // TODO: Implement pushing element onto stack
     Node newNode = new Node(x, null);
     if(top == null){top = newNode;}
     else{
         Node old = top;
         top = newNode;
         top.next = old;
     }
   }     

   // returns what is on the top of stack
   public AnyType peek( ) throws NoSuchElementException {
      // TODO: Implement checking the top of the stack
      if(this.isEmpty()){throw new NoSuchElementException();}
      else{
          return top.data;
      }
   }

   // returns top of stack and removes item    
   public AnyType pop( ) throws NoSuchElementException {
      // TODO: Implement removing the top item of the stack
      if(this.isEmpty()){throw new NoSuchElementException();}
      else{
          AnyType toReturn = top.data;
          top = top.next;
          return toReturn;
      }
   }

   /**
    * This is the singly-linked list node.
    */
   private class Node<AnyType>    {
      public AnyType data;
      public Node<AnyType> next;

      public Node(AnyType d, Node<AnyType> n) {
         data = d; 
         next = n;
      }
   }
}
