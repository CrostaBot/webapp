import java.util.ArrayList;

public class Masterthesis extends Paper {

	private String school;

	public Masterthesis(String t, String y, String s) {

		super(t, y);
		pType = "masterthesis";
		school = s;
	}

	public Masterthesis(String t, String y, String s, ArrayList<String> l) {

		super(t, y, l);
		pType = "masterthesis";
		school = s;
	}

	public Masterthesis(String t, String y, String m, String k, String s, String e, String[] l) {

		super(t, y, m, k, e, l);
		pType = "masterthesis";
		school = s;
	}

	public String getSchool() {

		return school;
	}

}