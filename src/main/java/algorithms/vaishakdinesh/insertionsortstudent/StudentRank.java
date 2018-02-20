package algorithms.vaishakdinesh.insertionsortstudent;

public class StudentRank {
	
	public StudentRank(int n) {
		roster = new Student[n];
		size = 0;
	}
    
    public Student[] getRoster() {
		return roster;
	}
    
    public void addStudent(Student s) {
    		roster[size++] = s;
    }
    
    public void rankStudents() {
    		sort(roster);
    }
    
    /**
     * Uses insertion sort to order the array of students
     * 
     * @param roster the list of all the students to be sorted
     */
    public void sort(Student[] roster) {
    	//TODO Implement insertion sort that sorts the students based on GPA from highest to lowest
    	int size = roster.length;
    	for(int i=0;i<size;i++){
    		for(int j=i; j>0 && higher(roster[j],roster[j-1]);j-- ){
    			exchange(roster, j, j-1);
    		}
    	}
    	
    }
    
    /**
     * 
     * @param s1 student 1
     * @param s2 student 2
     * @return true if student 1 is "greater" than student 2
     */
    public static boolean higher(Student s1, Student s2) {
    	return s1.compareTo(s2)>0;
	}
    
    /**
     * 
     * @param array list of students
     * @param i student at position i
     * @param j student at position j
     */
    private void exchange(Student[] array, int i, int j) {
    		Student s = array[i];
    		array[i] = array[j];
    		array[j] = s;
    }
    
    private Student[] roster;
    private int size;

}
