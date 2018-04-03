package algorithms.vaishakdinesh.birthdayproblem;

import java.util.Random;

public class BirthdayProblem {
	
	public static double theoreticalAverageCollision(int m){
		return Math.sqrt(Math.PI*m/2);
	}
	
	public static double theoreticalAverageTotalCollisions(int m){
		return m*Math.log(m);
	}
	
	public static double errorPercent(double theory, int practical){
		return Math.abs(((practical-theory)/theory)*100);
	}
	
	public static void main(String[] args){
		int size = 10;
		HashTable<Integer,Integer> hashTable = new HashTable<>(size);
		Random rg = new Random();
		int collisions=0;
		int averageFirstCollisionHashCount=0;
		int runs=10;
		
		for(int trials=0;trials<runs;trials++){
			for(int i=0;i<size;i++){
				Integer key = rg.nextInt(1000);
				hashTable.put(key, key);
			}
			averageFirstCollisionHashCount+=hashTable.getFirstCollisionHashCount();
			hashTable.clearTable(size);
		}
		averageFirstCollisionHashCount=averageFirstCollisionHashCount/runs;
		collisions=0;
		int averageCollisions=0;
		hashTable.clearTable(size);
		
		for(int trials=0;trials<runs;trials++){
			while(!hashTable.isFull()){
				Integer key = rg.nextInt(size);
				hashTable.put(key, key);
				collisions++;
			}
			averageCollisions+=collisions;
			hashTable.clearTable(size);
			collisions=0;
		}
		averageCollisions=averageCollisions/runs;
		
		System.out.println("Theoretical number of hashes before first collision= "+theoreticalAverageCollision(size)+" ");
		System.out.println("Average Practical number of hashes before first collision = "+averageFirstCollisionHashCount);
		System.out.println("Error % = "+errorPercent(theoreticalAverageCollision(size), averageFirstCollisionHashCount));
		System.out.println("---------------------------------------------------------------------------------");
		System.out.println("Theoretical number of hashes before completely filled = "+theoreticalAverageTotalCollisions(size));
		System.out.println("Average practical number of hashes before completely filled = "+averageCollisions);
		System.out.println("Error % = "+errorPercent(theoreticalAverageTotalCollisions(size), averageCollisions));
	}
}
