package com.anisha.util.testdatagenerator;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;

public class DataGenerationUtil {
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	private static Random r = new Random();

	public static void updateDOB(ExcelModel model) {
		List<String> header = model.header;
		System.out.println("DOB Position : " + header.indexOf("DOB"));
		System.out.println(model.rows.get(0).columns);
		model.rows.stream().forEach(row -> row.columns.set(header.indexOf("DOB"), randomDob()));
	}
	
	public static String randomDob() {
		GregorianCalendar gc = new GregorianCalendar();

		int year = randBetween(1900, 2000);

		gc.set(GregorianCalendar.YEAR, year);

		int dayOfYear = randBetween(1, gc.getActualMaximum(GregorianCalendar.DAY_OF_YEAR));

		gc.set(GregorianCalendar.DAY_OF_YEAR, dayOfYear);
		return sdf.format(gc.getTime());
	}

	public static int randBetween(int start, int end) {
		return start + (int) Math.round(Math.random() * (end - start));
	}

	public static void updateSrcId(ExcelModel model) {
		List<String> header = model.header;
		System.out.println("SrcId Position : " + header.indexOf("SrcId"));
		System.out.println(model.rows.get(0).columns);
		model.rows.stream().forEach(row -> row.columns.set(header.indexOf("SrcId"), "RBH_"+getRandomNumber(14)));
	}

	public static void updateProgramId(ExcelModel model) {
		List<String> header = model.header;
		System.out.println("ProgramId Position : " + header.indexOf("ProgramId"));
		System.out.println(model.rows.get(0).columns);
		model.rows.stream().forEach(row -> row.columns.set(header.indexOf("ProgramId"), getRandomNumber(15)));
	}

	// AARP, EMPL, LYCD, VCD, DRCD, GGPR
	public static void updatePrgCode(ExcelModel model) {
		List<String> header = model.header;
		System.out.println("PrgCode Position : " + header.indexOf("PrgCode"));
		System.out.println(model.rows.get(0).columns);
		model.rows.stream().forEach(row -> row.columns.set(header.indexOf("PrgCode"), getRandomPrgCode(row.columns.get(header.indexOf("PrgCode")))));			
	}

	public static void updateSrcCode(ExcelModel model) {
		List<String> header = model.header;
		System.out.println("SrcCode Position : " + header.indexOf("SrcCode"));
		System.out.println(model.rows.get(0).columns);
		model.rows.stream().forEach(row -> row.columns.set(header.indexOf("SrcCode"), getRandomSource(row.columns.get(header.indexOf("SrcCode")))));			
	}


	public static void updateLRSrcCode(ExcelModel model) {
		List<String> header = model.header;
		System.out.println("LR SrcCode Position : " + header.indexOf("SrcCode"));
		System.out.println(model.rows.get(0).columns);
		model.rows.stream().forEach(row -> row.columns.set(header.indexOf("SrcCode"), "LR"));			
	}

	public static void updateWorkPhone(ExcelModel model) {
		List<String> header = model.header;
		System.out.println("WPhArea Position : " + header.indexOf("WPhArea"));
		System.out.println(model.rows.get(0).columns);
		model.rows.stream().forEach(row -> row.columns.set(header.indexOf("WPhArea"), getRandomNumber(3)));	
		
		System.out.println("WPhNumber Position : " + header.indexOf("WPhNumber"));
		System.out.println(model.rows.get(0).columns);
		model.rows.stream().forEach(row -> row.columns.set(header.indexOf("WPhNumber"), getRandomNumber(7)));			
		
	}
	public static void updateCellPhone(ExcelModel model) {
		List<String> header = model.header;
		System.out.println("CPhArea Position : " + header.indexOf("CPhArea"));
		System.out.println(model.rows.get(0).columns);
		model.rows.stream().forEach(row -> row.columns.set(header.indexOf("CPhArea"), getRandomNumber(3)));	
		
		System.out.println("CPhNumber Position : " + header.indexOf("CPhNumber"));
		System.out.println(model.rows.get(0).columns);
		model.rows.stream().forEach(row -> row.columns.set(header.indexOf("CPhNumber"), getRandomNumber(7)));			
		
	}
	public static void updateHomePhone(ExcelModel model) {
		List<String> header = model.header;
		System.out.println("HPhArea Position : " + header.indexOf("HPhArea"));
		System.out.println(model.rows.get(0).columns);
		model.rows.stream().forEach(row -> row.columns.set(header.indexOf("HPhArea"), getRandomNumber(3)));	
		
		System.out.println("HPhNumber Position : " + header.indexOf("HPhNumber"));
		System.out.println(model.rows.get(0).columns);
		model.rows.stream().forEach(row -> row.columns.set(header.indexOf("HPhNumber"), getRandomNumber(7)));			
		
	}

	public static void updateZip(ExcelModel model) {
		List<String> header = model.header;
		System.out.println("CustZip Position : " + header.indexOf("CustZip"));
		System.out.println(model.rows.get(0).columns);
		model.rows.stream().forEach(row -> row.columns.set(header.indexOf("CustZip"), getRandomNumber(5)));		
	}
	
	public static void updateCustStreetLine1(ExcelModel model) {
		List<String> header = model.header;
		System.out.println("CustStLine1 Position : " + header.indexOf("CustStLine1"));
		System.out.println(model.rows.get(0).columns);
		model.rows.stream().forEach(row -> row.columns.set(header.indexOf("CustStLine1"), getRandomNumber(3) + " " + getRandomAlpha(5) + " " + getRandomAddressType()));		
	}

	public static void updateCustStreetLine2(ExcelModel model) {
		List<String> header = model.header;
		System.out.println("CustStLine2 Position : " + header.indexOf("CustStLine2"));
		System.out.println(model.rows.get(0).columns);
		model.rows.stream().forEach(row -> row.columns.set(header.indexOf("CustStLine2"), getRandomAlpha(5) + " " + getRandomAlpha(3)));		
	}

	public static void updateMiddleName(ExcelModel model) {
		List<String> header = model.header;
		System.out.println("MiddleName Position : " + header.indexOf("MiddleName"));
		System.out.println(model.rows.get(0).columns);
		model.rows.stream().forEach(row -> row.columns.set(header.indexOf("MiddleName"), getRandomAlpha(5)));		
	}

	public static void updateFirstName(ExcelModel model) {
		List<String> header = model.header;
		System.out.println("FirstName Position : " + header.indexOf("FirstName"));
		System.out.println(model.rows.get(0).columns);
		model.rows.stream().forEach(row -> row.columns.set(header.indexOf("FirstName"), row.columns.get(header.indexOf("FirstName")) + getRandomAlpha(5)));		
	}
	
	public static void updateLastName(ExcelModel model) {
		List<String> header = model.header;
		System.out.println("LastName Position : " + header.indexOf("LastName"));
		System.out.println(model.rows.get(0).columns);
		model.rows.stream().forEach(row -> row.columns.set(header.indexOf("LastName"), row.columns.get(header.indexOf("LastName")) + getRandomAlpha(5)));		
	}
	
	public static void updateCorelationId(ExcelModel model) {
		List<String> header = model.header;
		System.out.println("CorelationId Position : " + header.indexOf("CorelationId"));
		System.out.println(model.rows.get(0).columns);
		model.rows.stream().forEach(row -> row.columns.set(header.indexOf("CorelationId"), getRandomHexString(22)));		
	}
	
	public static void updateMessgeId(ExcelModel model) {
		List<String> header = model.header;
		System.out.println("MessageId Position : " + header.indexOf("MessageId"));
		System.out.println(model.rows.get(0).columns);
		model.rows.stream().forEach(row -> row.columns.set(header.indexOf("MessageId"), getRandomHexString(22)));		
	}
	
	public static void updateEmail(ExcelModel model) {
		List<String> header = model.header;
		System.out.println("Email Position : " + header.indexOf("Email"));
		System.out.println(model.rows.get(0).columns);
		model.rows.stream().forEach(row -> row.columns.set(header.indexOf("Email"), getRandomEmail()));		
	}
	
	public static String getRandomCity() {
		String[] cities = { "Chicago", "St Louis", "San Fransico", "Detroit", "Vernon Hills", "Riverwoods", "Deerfield",
				"Mundelein" };
		
		return cities[r.nextInt(cities.length)];
	}

	public static String getRandomState() {
		String[] states = { "California,", "Alabama,", "Arkansas,", "Arizona,", "Alaska,", "Colorado,", "Connecticut,",
				"Delaware,", "Florida,", "Georgia,", "Hawaii,", "Idaho,", "Illinois,", "Indiana,", "Iowa,", "Kansas,",
				"Kentucky,", "Louisiana,", "Maine,", "Maryland,", "Massachusetts,", "Michigan,", "Minnesota,",
				"Mississippi,", "Missouri,", "Montana,", "Nebraska,", "Nevada,", "New Hampshire,", "New Jersey,",
				"New Mexico,", "New York,", "North Carolina,", "North Dakota,", "Ohio,", "Oklahoma,", "Oregon,",
				"Pennsylvania,", "Rhode Island,", "South Carolina,", "South Dakota,", "Tennessee,", "Texas,", "Utah,",
				"Vermont,", "Virginia,", "Washington,", "West Virginia,", "Wisconsin,", "Wyoming" };
		
		return states[r.nextInt(states.length)];
	}

	public static String getRandomAddressType() {
		String[] type = { "CRES", "CT  ", "CV  ", "DR  ", "EXPY", "FLDS", "GLN ", "GRN ", "HL  ", "HWY ", "IS  ",
				"LN  ", "LOOP", "PARK", "PASS", "PATH", "PKWY", "PL  ", "PLZ ", "PT  ", "RD  ", "RDG ", "ROW ", "RUN ",
				"SQ  ", "ST  ", "TER ", "TRL ", "VW  ", "WALK", "WAY ", "XING" };
		
		return type[r.nextInt(type.length)];
	}

	/**
	 * Get Random Hex String
	 * 
	 * @param numchars
	 * @return String
	 */
	public static String getRandomHexString(int numchars) {
		
		StringBuffer sb = new StringBuffer();
		while (sb.length() < numchars) {
			sb.append(Integer.toHexString(r.nextInt()));
		}

		return sb.toString().substring(0, numchars);
	}

	/**
	 * Get 5 chars[a-z] random string
	 * 
	 * @return String
	 */
	public static String getRandomNumber(int length) {
		
		String alphabet = "1234567890";
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < length; i++) {
			sb.append(alphabet.charAt(r.nextInt(alphabet.length())));
		}
		return sb.toString();
	}

	/**
	 * Get 5 chars[a-z] random email
	 * 
	 * @return String
	 */
	public static String getRandomEmail() {
		
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < 5; i++) {
			sb.append(alphabet.charAt(r.nextInt(alphabet.length())));
		}
		sb.append("@gmail.com");
		return sb.toString();
	}

	/**
	 * Get 5 chars[a-z] random string
	 * 
	 * @return String
	 */
	public static String getRandomAlpha(int length) {
		
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < length; i++) {
			sb.append(alphabet.charAt(r.nextInt(alphabet.length())));
		}
		return sb.toString();
	}

	/**
	 * Get 5 chars[a-z] random string
	 * 
	 * @return String
	 */
	public static String getRandomSource(String excludeSrc) {
		String[] scr = { "IC", "SM", "HC", "TC" };
		String srcCode  = scr[r.nextInt(scr.length)];
		while(excludeSrc.equalsIgnoreCase(srcCode)) {
			srcCode  = scr[r.nextInt(scr.length)];
		}	
		return srcCode;
	}

	public static String getRandomPrgCode(String excludePrgCode) {
		String[] scr = { "VCD", "LYCD", "AARP" };
		String prgcode  = scr[r.nextInt(scr.length)];
		while(excludePrgCode.equalsIgnoreCase(prgcode)) {
			prgcode  = scr[r.nextInt(scr.length)];
		}	
		return prgcode;
	}
}
