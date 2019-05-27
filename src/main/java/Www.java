import java.util.ArrayList;

public class Www extends Paper {
 
 	//Year in this case is used to save url

	public Www(String t, String y) {

		super(t, y);
		pType = "www";
	}

	public Www(String t, String y, ArrayList<String> l) {

		super(t, y, l);
		pType = "www";
	}

	public Www(String t, String e, String k, String[] l) {

		super(t, "-", "-", k, e, l);
		pType = "www";
	}

	public String getUrl() {

		return super.getEe();
	}

}