import java.util.ArrayList;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class ParserMain {
	
	private static final String DEFAULT_FILE = "dblp_purified.xml";
	private static final long DEFAULT_LINES = 100000000L;
	
	public static void main(String args[]) throws Exception {
		
		String file = DEFAULT_FILE;
		long numLines = DEFAULT_LINES;
		
		if (args.length > 1){
			file = args[0];
			numLines =  Long.parseLong(args[1]); 
		}
		
		// Create Parser
		StaxParser parser = new StaxParser(file, numLines);
		
		// Parse the entire document
		ArrayList<Author> authorList = parser.getAuthorArrayList();
		ArrayList<Paper> paperList = parser.getPaperArrayList();
		System.out.println("There are: " + paperList.size() + " Papers");

		JSONObject paperInfo = JSONBuilder.getPaperInfo(paperList);
		JSONObject allAuthors = JSONBuilder.getAuthorList(authorList);


		int id = -1;
		Author aut = null;

		



		JSONBuilder.printJSONToFile(paperInfo, "papers.json");
		JSONBuilder.printJSONToFile(allAuthors, "authors.json");
		
		
		// Analyse the dataset
		Analysis statistics = new Analysis(authorList);
		statistics.printToFile("Authors.csv","Links.csv");


		/*
		aut = authorList.get(64);
		id = aut.getID();
		JSONObject singleAuthor = JSONBuilder.getStatisticAboutPapers(aut); 
		JSONBuilder.printJSONToFile(singleAuthor,"cartellaCheNonFaDanni/" + id + ".json");
		*/


		for (int i=0; i<authorList.size(); i++) {

			aut = authorList.get(i);
			id = aut.getID();
			JSONObject singleAuthor = JSONBuilder.getStatisticAboutPapers(aut); 
			JSONBuilder.printJSONToFile(singleAuthor,"cartellaCheNonFaDanni/" + id + ".json");
		}
		/*statistics.getAuthorRank(false);
		ArrayList<RankAuthor> rank = statistics.sortRankAuthorList(false);
		statistics.getRankAuthorJSON(200, false);*/

		// System.out.println(rank);*/
	}
}
