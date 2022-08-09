import java.util.*;

public class Hashmap {
	
	int m;
	String[] tabelle;
	
	ArrayList<String>[] tabelleBetter;
	
	public Hashmap(int m) {
		this.m = m;
		tabelle = new String[m];
		tabelleBetter = new ArrayList[m];
		for(int i = 0; i < tabelleBetter.length; i++) {
			tabelleBetter[i] = new ArrayList<>();
		}
	}
	
	public void add(String s) {
		tabelle[computeH(s)] = s;
		show();
	}
	
	public void addBetter(String s) {
		int hashwert = computeH(s);
		if(!tabelleBetter[hashwert].contains(s)) tabelleBetter[hashwert].add(s);
		showBetter();
	}
	
	
	
	public void show() {
		for(int i = 0; i  < tabelle.length; i++) {
			if(tabelle[i] != null)System.out.println("Hashwert: " + i + "  String: " + tabelle[i] );
		}
		System.out.println();
	}
	
	public void showBetter() {
		for(int i = 0; i  < tabelleBetter.length; i++) {
			if(containsValue(i)) {System.out.print("Hashwert: " + i + " String: ");
			for(String s : tabelleBetter[i]) {
				System.out.print(s + "  ");
			}
			System.out.println();
		}
		}
		System.out.println();
	}
	
	public boolean containsValue(int index) {
		return tabelleBetter[index].size() > 0;
	}
	
	public boolean search(String s) {
		return tabelle[computeH(s)] == s;
	}
	
	public boolean searchBetter(String s) {
		return tabelleBetter[computeH(s)].contains(s);
	}

	
	
	public int computeH(String s) {
		int h = 0;
		char[] c = s.toCharArray();
		for(int i = 0; i < c.length; i++) {
			h = h + c[i];
		}
		return h%m;
	}
}
