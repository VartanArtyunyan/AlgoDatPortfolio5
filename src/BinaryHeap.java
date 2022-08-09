import java.util.*;

public class BinaryHeap {

	List<Integer> knotenArray = new ArrayList<>();
	int size = 0;
	
	List<knoten> transArray = new ArrayList<>();
	int tSize = 0;
	
	public class knoten {
		int prio;
		Transaction t;
		public knoten(int prio, Transaction t) {
			this.prio = prio;
			this.t = t;
		}
	}
	
	

	public void insert(int input) {
		knotenArray.add(input);
		int x = size;
		size++;
		while (x >= 0 && knotenArray.get(x) > knotenArray.get((x - 1) / 2)) {
			swap(x, ((x - 1) / 2));
			x = (x - 1) / 2;
		}
	}
	
	public void insertTransaction(int prio, knoten input) {
		transArray.add(input);
		int x = tSize;
		tSize++;
		while(x >= 0 && transArray.get(x).prio > transArray.get((x - 1) / 2).prio) {
			tSwap(x, ((x - 1) / 2));
			x = (x - 1) / 2;
		}
		
	}

	public int extract() {
		int output = knotenArray.get(0);
		knotenArray.set(0, knotenArray.get(size-1));
		size--;
		adjust(0);
		return output;
	}
	
	public Transaction extractTransaction() {
		Transaction output = transArray.get(0).t;
		transArray.set(0, transArray.get(tSize-1));
		tSize--;
		adjustT(0);
		return output;
	}

	public void swap(int index1, int index2) {
		if (index1 < size && index2 < size) {
			int copy = knotenArray.get(index1);
			knotenArray.set(index1, knotenArray.get(index2));
			knotenArray.set(index2, copy);
		}
	}
	
	public void tSwap(int index1, int index2) {
		if (index1 < tSize && index2 < tSize) {
			knoten copy =  transArray.get(index1);
			transArray.set(index1, transArray.get(index2));
			transArray.set(index2, copy);
		}
	}
	
	public void adjust(int x) {
		
		int left = (x * 2) + 1;
		int right = (x * 2) +2;
		int min = x;
		
		if (left < size && knotenArray.get(right) > knotenArray.get(min)) {
			min = right;}
		if (right < size && knotenArray.get(left) > knotenArray.get(min) && left > min) {
			
			min = left;
		}
		if (min != x) {
			swap(x, min);
			adjust(min);
		}
		
	}
	
	public void adjustT(int x) {
		
		int left = (x * 2) + 1;
		int right = (x * 2) +2;
		int min = x;
		
		if(left < tSize && transArray.get(right).prio > transArray.get(min).prio) {
			min = right;}
		if(right < size && transArray.get(left).prio > transArray.get(min).prio && left > min) {
			min = left;
		}
		if(min != x) {
			tSwap(x,min);
			adjustT(min);
		}
		
		
	}
	
	public String toString() {
		String output = "";
		int count = size;
		for(Integer i : knotenArray) {
			if (count == 0) break;
			output = output + i +" ";
			count --;
			
		}
		return output;
	}
	
}










