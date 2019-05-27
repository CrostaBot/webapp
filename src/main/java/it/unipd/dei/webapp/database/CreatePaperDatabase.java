package it.unipd.dei.webapp.database;

import it.unipd.dei.webapp.resource.Author;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public final class CreatePaperDatabase {

	/**
	 * The SQL statement to be executed
	 */
	private static final String STATEMENT = "INSERT INTO clef.Paper (title, authors, year, mDate) VALUES (?, ?, ?, ?)";

	/**
	 * The connection to the database
	 */
	private final Connection con;

	/**
	 * The paper to be stored into the database
	 */
	private final Paper paper;

	/**
	 * Creates a new object for storing an paper into the database.
	 *
	 * @param con
	 *            the connection to the database.
	 * @param paper
	 *            the paper to be stored into the database.
	 */
	public CreatePaperDatabase(final Connection con, final Paper paper) {
		this.con = con;
		this.paper = paper;
	}

	/**
	 * Stores a new paper into the database
	 *
	 * @throws SQLException
	 *             if any error occurs while storing the paper.
	 */
	public void createPaper() throws SQLException {

		PreparedStatement pstmt = null;

		try {
			pstmt = con.prepareStatement(STATEMENT);
			pstmt.setString(1, paper.getTitle());
			pstmt.setString(2, paper.getAuthors());
			pstmt.setInt(3, paper.getYear());
			pstmt.setString(4, paper.getMDate());

			pstmt.execute();

		} finally {
			if (pstmt != null) {
				pstmt.close();
			}

			con.close();
		}

	}
}
