package algorithms.vaishakdinesh.birthdayproblem;

import org.junit.Test;


public class HashTableTest {
	
	@Test
    public void testConstructor() {
		HashTable<Double,Double> table = new HashTable<Double, Double>();
		
		assert(table!=null);
		assert(table.size()==16);
    }
	
	@Test
    public void testConstructorInitCapacity() {
		HashTable<Double,Double> table = new HashTable<Double, Double>(5);
		
		assert(table!=null);
		assert(table.size()==5);
    }
	
	@Test
    public void testGrow() {
		HashTable<Double,Double> table = new HashTable<Double, Double>(4);
		table.growable(true);
		
		table.put(5.0, 10.0);
		table.put(6.0, 12.0);
		table.put(7.0, 15.0);
		table.put(8.0, 20.0);
		
		assert(table.size()==8);
	}
	
	@Test
    public void testPut() {
		HashTable<Double,Double> table = new HashTable<Double, Double>(10);
		Double val = table.put(5.0, 10.0);
		
		assert(val == null);
		assert(!table.isEmpty());
	}
	
	@Test
    public void testPutSameKey() {
		HashTable<Double,Double> table = new HashTable<Double, Double>(10);
		table.put(5.0, 10.0);
		Double val = table.put(5.0, 12.0);
		
		assert(val == 10.0);
	}
	
	@Test
    public void testPutSameKeyValue() {
		HashTable<Double,Double> table = new HashTable<Double, Double>(10);
		table.put(5.0, 10.0);
		table.put(5.0, 12.0);
		Double val = table.get(5.0);
		assert(val == 12.0);
	}
	
	@Test
    public void testPutNull() {
		HashTable<Double,Double> table = new HashTable<Double, Double>(10);
		Double val = table.put(null, 10.0);
		
		assert(val == null);
	}
	
	@Test
    public void testRemove() {
		HashTable<Double,Double> table = new HashTable<Double, Double>(5);
		table.put(5.0, 10.0);
		table.put(6.0, 12.0);
		table.remove(6.0);
		table.remove(5.0);
		
		assert(table.isEmpty());
	}
	
	@Test
    public void testRemoveEmpty() {
		HashTable<Double,Double> table = new HashTable<Double, Double>(5);
		boolean val=table.remove(5.0);
		
		assert(!val);
	}
	
	@Test
    public void testGet() {
		HashTable<Double,Double> table = new HashTable<Double, Double>(5);
		table.put(5.0, 10.0);
		table.put(6.0, 12.0);
		Double val = table.get(6.0);
		
		assert(val==12.0);
	}
	
	@Test
    public void testGetEmpty() {
		HashTable<Double,Double> table = new HashTable<Double, Double>(5);
		Double val = table.get(6.0);
		
		assert(val==null);
	}
	
	@Test
    public void testHash() {
		HashTable<Double,Double> table = new HashTable<Double, Double>(5);
		int hash = table.hashKey(6.0);
		
		assert(hash == 3);
	}
	
	@Test
    public void testCollision() {
		HashTable<Double,Double> table = new HashTable<Double, Double>(5);
		table.put(6.0, 10.0);
		table.put(6.0, 12.0);
		table.put(6.0, 13.0);
		table.put(6.0, 14.0);
		table.put(6.0, 15.0);
		table.put(6.0, 16.0);
		table.put(7.0, 17.0);
		
		assert(table.getCollision() == 5);
	}
	
	@Test
    public void testFirstCollisionHashCount() {
		HashTable<Double,Double> table = new HashTable<Double, Double>(5);
		
		table.put(6.0, 10.0);
		table.put(7.0, 12.0);
		table.put(8.0, 13.0);
		table.put(10.0, 15.0);
		table.put(12.0, 16.0);
		table.put(7.0, 17.0);
		
		assert(table.getFirstCollisionHashCount() == 5);
	}
	
	@Test
    public void testFirstCollisionHashCountConsistency() {
		HashTable<Double,Double> table = new HashTable<Double, Double>(5);
		
		table.put(6.0, 10.0);
		table.put(7.0, 12.0);
		table.put(8.0, 13.0);
		table.put(10.0, 15.0);
		table.put(12.0, 16.0);
		table.put(7.0, 17.0);
		table.put(7.0, 18.0);
		table.put(7.0, 19.0);
		
		assert(table.getFirstCollisionHashCount() == 5);
	}
	
	@Test
    public void testIsFull() {
		HashTable<Double,Double> table = new HashTable<Double, Double>(5);
		Double d = 0.0;
		while(!table.isFull()){
			table.put(d, d);
			d++;
		}
		
		for(double i=0;i<table.size();i++){
			assert(table.get(i)!=null);
		}
	}
}
