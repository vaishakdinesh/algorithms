package algorithms.vaishakdinesh.birthdayproblem;

public class HashTable<K,V> {
	
	@SuppressWarnings("unchecked")
	public HashTable(){
		table = new Node[16];
	}
	
	@SuppressWarnings("unchecked")
	public HashTable(int initCapacity){
		table = new Node[initCapacity];
	}
	
	public int size(){
		return table.length;
	}
	
	public V put(K key, V val){
		if(key == null) return null;
		if(isGrowable && count>=LOAD_FACTOR*size()){
			grow();
		}
		int hash = hash(key);
		for(Node<K,V> node = table[hash]; node != null; node = node.next){
			if(hash == node.hash){ 
				collisions++;
				if(firstCollisionHashCount==0) firstCollisionHashCount=count;
			}
			
            if((hash == node.hash) && key.equals(node.key)){
                V oldData = node.data;
                node.data = val;
                return oldData;
            }
        }
		count++;
		Node<K,V> node = new Node<K,V>(key, val, table[hash], hash);
        table[hash] = node;

        return null;
	}
	
	public boolean remove(K key){
		int hash = hash(key);
		
		Node<K,V> previous =null;
		
		for(Node<K,V> node = table[hash]; node != null; node = node.next){
			if(hash == node.hash && key.equals(node.key)){
				if(previous != null){
					previous.next = node.next;
				}else{
					table[hash] = node.next;
				}
				count--;
				return true;
			}
			previous = node;
		}
		return false;
	}
	
	public V get(K key){
		int hash = hash(key);
		
		for(Node<K,V> node = table[hash]; node != null; node = node.next){
            if(key.equals(node.key))
                return node.data;
        }
        return null;
	}
	
	public boolean isEmpty(){
		return count==0;
	}
	public boolean isFull(){
		for(int i=0;i<table.length;i++){
			if(table[i]==null) return false;
		}
		return true;
	}
	
	public int hashKey(K key){
		return hash(key);
	}
	
	public int getFirstCollisionHashCount(){
		return firstCollisionHashCount;
	}
	
	public int getCollision(){
		return collisions;
	}
	
	public void clearTable(int size){
		table = new Node[size];
		collisions=0;
		firstCollisionHashCount=0;
		count=0;
	}
	
	public void growable(boolean flag){
		isGrowable=flag;
	}
	
	private int hash(K key){
		int hash = key.hashCode();
        int index = (hash & 0x7FFFFFFF) % table.length;
        return index;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void grow(){
		Node[] temp = new Node[table.length];
		System.arraycopy(this.table, 0, temp, 0, table.length);
		table = new Node[table.length*2];
		System.arraycopy(temp, 0,table,0,table.length/2);
	}
	
	static private class Node<K,V>{
		final K key;
        V data;
        Node<K,V> next;
        final int hash;

        public Node(K k, V v, Node<K,V> n, int h){
            key = k;
            data = v;
            next = n;
            hash = h;
        }
        
    }
	
	private static final double LOAD_FACTOR=0.75;
	private int count=0;
	private int collisions=0;
	private int firstCollisionHashCount=0;
	private boolean isGrowable=false;
	private Node<K,V>[] table;
}
