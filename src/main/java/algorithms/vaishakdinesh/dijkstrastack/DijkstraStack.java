package algorithms.vaishakdinesh.dijkstrastack;

import static org.junit.Assert.assertTrue;

public class DijkstraStack<Item>{
	
	public DijkstraStack(int size) {
		 grow((Item[]) new Object[0],size);
	 }
	  
	/**
	 * Pushes an element onto our stack
	 * 
	 * @param element to be pushed into the stack
	 */
	 public void push(Item element) {
		 if (isFull())
			 grow(arr, 2*size);
		 arr[index] = element;
		 index++;
	 }
	 
	 /**
	  * Pops an item from our stack
	  * 
	  * @return returns the item at the top of the stack
	  */
	 public Item pop(){
		 if (isEmpty())
			 return null;
		 return arr[--index];
	 }
	 
	 /**
	  * 
	  * @return shows you the item at the top of the stack
	  */
	 public Item peek(){
		 if (isEmpty())
			 return null;
		 return arr[index-1];
	 }
	 
	 /**
	  * 
	  * @return returns true if its empty and false otherwise
	  */
	 public boolean isEmpty() {
		 return index == 0;
	 }
	 
	 /**
	  * 
	  * @return returns true if its full and false otherwise
	  */
	 public boolean isFull() {
		 return index == size;
	 }
	 
	 /**
	  * 
	  * @return the size of the stack
	  */
	 public int size() {
		 return size;
	 }
	 
	 /**
	  * 
	  * @param operators the stack that contains the operators
	  * @param values the stack that contains the operands
	  * @param expr the expression to be evaluated
	  */
	 public static void evaluate(DijkstraStack<String> operators,DijkstraStack<Integer> values,String expr){
		 String[] tokens = expr.split(" ");
				 
		 for(String token : tokens){
			 switch(token){
			 case "(": break;
			 case "+":
			 case "-":
			 case "*":
			 case "/":
				 operators.push(token);
				 break;
			 case ")":
				 String operator = operators.pop();
				 Integer val = values.pop();
							
				 switch(operator){
				 case "+": val = values.pop() + val;break;
				 case "-": val = values.pop() - val;break;
				 case "*": val = values.pop() * val;break;
				 case "/": val = values.pop() / val;break;
				 }
				 values.push(val);
				 break;
			 default:
				 Integer num = Integer.parseInt(token);
				 values.push(num);
				 break;	
			 }
		 }
	 }
	 /**
	  * 
	  * @param source the initial array to be grown
	  * @param size the size to be grown to
	  */
	 private void grow(Item[] source, int size){
		 this.size = size;
		 arr = growTheArray(source, size); 
	 }
	    
	 private static<Item> Item[] growTheArray(Item[] source, int size){
		 Item[] newArray = (Item[]) new Object[size];
		 System.arraycopy(source, 0, newArray, 0, source.length);
		 return newArray;
	 }
	 private Item arr[];
	 private int size;
	 private int index = 0;
}
