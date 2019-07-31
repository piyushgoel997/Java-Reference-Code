package Heaps;

public class PQPair<V> {
	V value;
	int priority;
	public PQPair(V value, int priority){
		this.priority = priority;
		this.value = value;
	}
}
