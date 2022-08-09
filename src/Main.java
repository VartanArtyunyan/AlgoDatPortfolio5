
public class Main {

	public static void main(String[] args) {

		Hashmap h = new Hashmap(128);
		
		h.addBetter("test");
		h.addBetter("ubuntu");
		h.addBetter("test");
		h.addBetter("bmoh");
		h.addBetter("dedy");
		
		System.out.println(h.searchBetter("test"));
		System.out.println(h.searchBetter("ftest"));
	}

}
