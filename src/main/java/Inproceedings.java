import java.util.ArrayList;

public class Inproceedings extends Paper {

	private String booktitle;

	public Inproceedings(String t, String y, String b) {

		super(t, y);
		pType = "inproceedings";
		booktitle = b;
	}

	public Inproceedings(String t, String y, String b, ArrayList<String> l) {

		super(t, y, l);
		pType = "inproceedings";
		booktitle = b;
	}

	public Inproceedings(String t, String y, String m, String k, String b, String e, String[] l) {

		super(t, y, m, k, e, l);
		pType = "inproceedings";
		booktitle = b;
	}

	public String getBooktitle() {

		return booktitle;
	}

}