package com.anil.java.strings;

import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author anilallewar
 *
 */
public class RegexExample {

	/**
	 * This method will check for the pattern passed as the second parameter in
	 * the first String. The different regex expressions used are<br><br>
	 * 
	 * Metacharacters 1. <code>\d</code> - A digit 2. <code>\s</code> - A
	 * whitespace character 3. <code>\w</code> - A word character (letters,
	 * digits, or "_" (underscore)) 4. <code> . </code> - Any character
	 * satisfies the . expresssion<br><br>
	 * 
	 * Range matches 1. <code>[abc]</code> - Searches only for a's, b's or c's
	 * 2. <code>[a-fA-F]</code> - Searches for the first six letters of the
	 * alphabet, both cases.<br><br>
	 * 
	 * Quantifiers 1. <code>+</code> - One or more occurrences 2. <code>*</code>
	 * - Zero or more occurrences 3. <code>?</code> - Zero or one occurrence 4.
	 * <code>^</code> - To negate the characters specified
	 * 
	 * @param toBeChecked
	 * @param pattern
	 */
	/**
	 * @param toBeChecked
	 * @param pattern
	 */
	public void checkString(String toBeChecked, String pattern) {
		// Use the Pattern and matcher class
		Pattern pa = Pattern.compile(pattern);
		Matcher ma = pa.matcher(toBeChecked);

		System.out.println("The String to be checked is: " + toBeChecked
				+ " and the pattern to be checked is: " + pattern);

		boolean b = false;
		if (ma.find()) {
			System.out
					.println(String
							.format("Found at least 1 match for pattern [ %s ] in input string: %s",
									pattern, toBeChecked));
			ma.reset();
		}
		// Continue looking through pattern till you keep getting positive
		// results
		while (b = ma.find()) {
			System.out.println("The match(using zero-based index) found at: "
					+ ma.start() + " : " + ma.group() + " : " + ma.end());
		}
		System.out.println();
	}

	public void checkUsingScanner() {
		Scanner s = new Scanner("A654.12.23.45nil 9All98709ewar");
		String token;
		do {
			token = s.findInLine("[\\d]+.[\\d]+.[\\d]+.[\\d]+");
			System.out.println("Found: " + token);
		} while (token != null);
	}

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		RegexExample regExample = new RegexExample();

		/*
		regExample.checkString("abcgagbkabcd", "ab");
		regExample.checkString("abcgagbkabcd", "[abFk]");
		// Any file names that begin with proj1
		regExample.checkString(
				"proj3.txt,proj1sched.pdf,proj1,proj2,proj1.java",
				"proj1([^,])*");
		regExample.checkString(
				"proj3.txt,proj1sched.pdf,proj1,proj2,proj1.java",
				"proj1([^,])+");
		// Find phone numbers - 9 digits with space or - at the 4th and 8th
		// position
		regExample.checkString("8895452-6351",
				"\\d\\d\\d([\\s-])*\\d\\d\\d([\\s-])*\\d\\d\\d\\d");
		// a followed by any cahracter and then c
		regExample.checkString("ac abc a c a71c", "a.c");
		// Self study question 1
		regExample.checkString("ab34ef", "\\d*");
		*/
		// Romil check
		regExample.checkString("/WEB-INF/images/en_US/spacer.jpg",
				"/*/*/*/*.jpg");
		/*
		regExample
				.checkString(
						"123.allewar@yahoo.co.in",
						"([a-z0-9!#$%&'*+/=?^_`{|}~-])+(?:\\.([a-z0-9!#$%&'*+/=?^_`{|}~-])+)*@([a-z0-9!#$%&'*+/=?^_`{|}~-])+(?:\\.([a-z0-9!#$%&'*+/=?^_`{|}~-])+)+");
		// Greedy quantifies
		regExample.checkString("yyxxxyxx", ".*xx");
		FileAccess fileRead = new FileAccess();
		String str = fileRead
				.ReadFile("input.txt",
						"C:\\Anil Allewar\\Trainings\\Code Samples\\Core Java\\JavaStudy");
		System.out.println("The line obtained is: " + str);
		regExample.checkString(str,
				"<span(\\s)+class=\"content\">([\\s\\w\\W\\s])*</span>");

		// Reluctant quantifies

		// The greedy quantifier does in fact read the entire source data, and
		// then it works
		// backwards (from the right) until it finds the rightmost match. At
		// that point, it
		// includes everything from earlier in the source data up to and
		// including the data
		// that is part of the rightmost match.
		regExample.checkString("yyxxx.yxx", ".*?xx");

		// Check scanner
		regExample.checkUsingScanner();

		str = "<link rel=\"edit\" title=\"Products\" href=\"Products(2)\"/><link rel=\"http://schemas.microsoft.com/ado/2007/08/dataservices/related/Categories\" type=\"application/atom+xml;type=entry\" title=\"Categories\" href=\"Products(2)/Category\"/>";
		regExample.checkString(str, "<link rel=\"([^<]*)/related/Categories\"");
		
		str = "/Categories(1)/Products(76)";
		regExample.checkString(str, "\\/([^\\/\\(]+)\\(");
		
		str = "/PointSetField(attribute='X (EASTING)',point_set_id=19)";
		regExample.checkString(str, "\\/([^\\/\\(]+)\\(");

		str = "PointSetField(attribute='X (EASTING)',point_set_id=19)/$value";
		regExample.checkString(str, "([^\\(.]+[\\(.+\\)])+");
		// regExample.checkString(str, "([^/()]+?\\(.+?\\))");
		str="SeismicDataSet(1)/$value";
		regExample.checkString(str, "([^\\(.]+[\\(.+\\)])+");
		
		str="Users skipped in electronic campaign: -1";
		regExample.checkString(str, "Users skipped in electronic campaign: (-[0-9]+)");
		
		str = "CustomerEcampaignData_2144678223_jcpenney_201502230928.csv";
		regExample.checkString(str, "CustomerEcampaignData_2144678223_jcpenney_\\d{12}\\.csv");
		*/
		
		//([^https?:\\/\\/])?([\\da-zA-Z\\.-]+)\\.([a-z\\.]{2,6})([\\/\\w \\.-]*)*\\/?.*$
		
		String urlRegexPattern="(^https?://|www[.])?([\\da-zA-Z\\.-]+)\\.([a-z\\.]{2,6})([\\/\\w \\.-]*)*\\/?.*$";
		regExample.checkString("https://www.regexe.com/a/b/c?d=e", urlRegexPattern);
		regExample.checkString("www.regexe.com/a/b/c?d=e", urlRegexPattern);
		regExample.checkString("http://www.regexe.com/a/b/c?d=e", urlRegexPattern);
		regExample.checkString("http://www.regexe.com/a z/b/c?d=e&f=g", urlRegexPattern);
		regExample.checkString("http://REGExE.com/a_z/b/c?d=e&f=g", urlRegexPattern);
		regExample.checkString("REGExE.com/a_z/b/c?d=e&f=g", urlRegexPattern);
		regExample.checkString("http://flagship.vanguard.com/VGApp/hnw/HomepageOverview",urlRegexPattern);

				/*
		File f = new File("a.txt");
		System.out
				.println("Will creating just a File object without calling createNewFile() create a  new file? -- "
						+ f.isFile());
		*/
	}

}
