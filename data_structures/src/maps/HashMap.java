package maps;

import java.util.*;

import trees.LLnode;

public class HashMap<K,V> {
	ArrayList<LLnode<Pair<K,V>>> bucket;
	int size;
	
	public HashMap(){
		size = 0;
		bucket = new ArrayList<>();
		for(int i = 0; i < 10; i++){
			bucket.add(null);
		}
	}
	
	public int sizeOf(){
		return size;
	}
	
	public int hashFn(K key){
		return key.hashCode()%bucket.size();
	}
	
	public void put(K key,V value){
		LLnode<Pair<K, V>> head = bucket.get(hashFn(key));
		size++;
		if(head == null){
			head = new LLnode<>(new Pair<>(key,value));
			bucket.set(hashFn(key), head);
		}else{
			while(head != null){
				head = head.next;
			}
			head = new LLnode<>(new Pair<>(key,value));
		}
		if((1.0*size)/bucket.size() > 0.75){
			rehash();
		}
	}
	
	public void remove(K key){
		int bucketIndex = hashFn(key);
		LLnode<Pair<K, V>> head = bucket.get(bucketIndex);
		LLnode<Pair<K, V>> prev = null;
		size--;
		if(head.data.key == key){
			head = null;
		}else{
			while(head.data.key != key){
				prev = head;
				head = head.next;
			}
			prev.next = null;
		}
	}
	
	private void rehash(){
		ArrayList<LLnode<Pair<K,V>>> temp = bucket;
		bucket = null;
		for(int i = 0; i < 2*temp.size(); i++){
			bucket.add(null);
		}
		size = 0;
		for(LLnode<Pair<K,V>> i : temp){
			LLnode<Pair<K,V>> head = i;
			while(head != null){
				put(head.data.key,head.data.value);				
				head = head.next;
			}
		}
	}
	
	
}
