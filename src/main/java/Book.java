import java.util.ArrayList;

public class Book extends Paper {

	private String publisher;

	public Book(String t, String y, String p) {

		super(t, y);
		pType = "book";
		publisher = p;
	}

	public Book(String t, String y, String p,  ArrayList<String> l) {

		super(t, y, l);
		pType = "book";
		publisher = p;
	}

	public Book(String t, String y, String m, String k, String p, String e, String[] l) {

		super(t, y, m, k, e, l);
		pType = "book";
		publisher = p;
	}

	public String getPublisher() {

		return publisher;
	}

}