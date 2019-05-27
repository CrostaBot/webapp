-- Drop the clef schema, if exists, and any object within it
DROP SCHEMA IF EXISTS clef CASCADE;

-- Create the clef schema
CREATE SCHEMA clef;
COMMENT ON SCHEMA clef IS 'Schema for containing the objects of the clef';


-- #################################################################################################
-- ## Creation of the tables                                                                      ##
-- #################################################################################################

--
--
-- Version 1.00
CREATE TABLE clef.Author (
	name VARCHAR NOT NULL,
	papers NOT NULL,
	years INT,
  yearStats VARCHAR,
	coauthors VARCHAR,
	coauthorStats INT,
	PRIMARY KEY (name)
);

COMMENT ON TABLE clef.Author IS 'Represents an author.';
COMMENT ON COLUMN clef.Author.name IS 'The name of the author.';
COMMENT ON COLUMN clef.Author.papers IS 'The pulications of the author.';
COMMENT ON COLUMN clef.Author.year IS 'The years for the stats.';
COMMENT ON COLUMN clef.Author.yearStats IS 'The stats over the years of the author.';
COMMENT ON COLUMN clef.Author.coauthors IS 'The coauthors for the stats.';
COMMENT ON COLUMN clef.Author.coauthorStats IS 'The related coauthors of the author.';

--
-- The table represents the manager of an Author
--
-- Version 1.00
CREATE TABLE clef.Paper (
  Title VARCHAR NOT NULL,
	authors VARCHAR NOT NULL,
  year INT NOT NULL,
	mDate VARCHAR NOT NULL,
	PRIMARY KEY (Title)
);

COMMENT ON TABLE clef.Paper IS 'Represent a paper';
COMMENT ON COLUMN clef.Paper.title IS 'The name of the paper.';
COMMENT ON COLUMN clef.Paper.authors IS 'The authors of the paper.';
COMMENT ON COLUMN clef.Paper.year IS 'The year of the paper.';
COMMENT ON COLUMN clef.Paper.mDate IS 'The last change of the paper.';
