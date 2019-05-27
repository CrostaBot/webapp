package it.unipd.dei.webapp.resource;

public class Author {

	private final String name;

	private final String[] papers;

	private final int[] years;

	private final int[] yearStats;

  private final String[] coauthors;

	private final int[] coauthorStats;


	public Author(final String name, final String[] papers, final int[] years, final int[] yearStats, final String[] coauthors, final int[] coauthorStats) {
		this.name = name;
		this.papers = papers;
		this.years = years;
		this.yearStats = yearStats;
    this.coauthors = coauthors;
    this.coauthorStats = coauthorStats;
	}

	public final String getName() {
		return name;
	}

	public final String[] getPapers() {
		return papers;
	}

	public final int[] getYears() {
		return years;
	}

	public final int[] getYearStats() {
		return yearStats;
	}

  public final String[] getCoauthors() {
    return coauthors;
  }

  public final int[] getCoauthorStats() {
    return coauthorStats;
  }

}
