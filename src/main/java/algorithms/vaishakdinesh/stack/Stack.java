package algorithms.vaishakdinesh.stack;

public class Stack<Item> {
	
	@SuppressWarnings("unchecked")
	private Item[] items = (Item[]) new Object[30];
	private int N = 0;
	
	public void push(Item item) {
		items[N] = item;
		N++;
	}
		
	public Item pop() {
		if(N==0) return null;
		return items[--N];
	}
	
	private void resize(int max) {
		@SuppressWarnings("unchecked")
		Item[] temp = (Item[]) new Object[max];
		for (int i = 0; i < N; i++)
			temp[i] = this.items[i];
		this.items = temp;
	}	
}