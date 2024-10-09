package org.code;

import java.util.ArrayList;
import java.util.List;

class HashTable {
	static class Pair {
		private Object key;
		private Object value;
		public Pair() {
		}	
		public Pair(Object key, Object value) {
			this.key = key;
			this.value = value;
		}
	}
	
	private static final int SLOTS = 100;
	private static List<Pair>[] table;
	
	@SuppressWarnings("unchecked")
	public HashTable() {
		table = new List[SLOTS];
		for (int i = 0; i < table.length; i++)
			table[i] = new ArrayList<Pair>();
	}
	
	public void put(Object key, Object value) {
		// decide the slot of the table in which value to be added.
		int index = key.hashCode() % SLOTS;
		// check if key is already present in that slot/bucket.
		for(Pair p:table[index]) {
			if(key.equals(p.key)) {
				p.value = value; // overwrite value if key already present.
				return;
			}
		}
		// if not present, add key-value pair in that slot/bucket.
		Pair pair = new Pair(key, value);
		table[index].add(pair);
	}
	
	public Object get(Object key) {
		// decide the slot of the table in which value to be added.
		int index = key.hashCode() % SLOTS;
		// check if key is already present in that slot/bucket.
		for(Pair p:table[index]) {
			if(key.equals(p.key))
				return p.value;
		}
		// if not found, return null
		return null;
	}
}

public class HashingMain {
	public static void main(String[] args) {
		HashTable ht = new HashTable();
		ht.put(2203, "Analyst");
		ht.put(4605, "Developer");
		ht.put(7401, "Tester");
		ht.put(5998, "HR");
		ht.put(6401, "CEO");
		ht.put(7101, "Manager");
		ht.put(6401, "Director");
		
		int key = 6401;
		Object res = ht.get(key);
		System.out.println(key + " -> " + res);
	}
}
