package algorithms.vaishakdinesh.mergesort;

public class MergeSort<X extends Comparable<X>> {
	
	private MergeSort() { }

    public static <X extends Comparable<X>> void merge(X[] a, X[] aux, int lo, int mid, int hi) {
    	// copy to aux[]
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k]; 
    }
        // merge back to a[]
        int i = lo, j = mid+1;
        for (int k = lo; k <= hi; k++) {
            if      (i > mid)              a[k] = aux[j++];
            else if (j > hi)               a[k] = aux[i++];
            else if (less(aux[j], aux[i])) a[k] = aux[j++];
            else                           a[k] = aux[i++];
        }
    }

    public static <X extends Comparable<X>>X[] sort(X[] a) {
        int n = a.length;
        X[] aux = (X[])new Comparable[n];
        for (int len = 1; len < n; len *= 2) {
            for (int lo = 0; lo < n-len; lo += len+len) {
                int mid  = lo+len-1;
                int hi = Math.min(lo+len+len-1, n-1);
                merge(a, aux, lo, mid, hi);
            }
        }
        assert isSorted(a);
        return a;
    }
    
    private static <X extends Comparable<X>> boolean less(X v, X w) {
        return v.compareTo(w) < 0;
    }
    
    private static <X extends Comparable<X>> boolean isSorted(X[] a) {
        for (int i = 1; i < a.length; i++)
            if (less(a[i], a[i-1])) return false;
        return true;
    }

}
