package com.anil.java.development;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.Properties;

public class Driver10 {
	static int x, y;
	public static final String MYPROP_FILE = "MYPROP.FILE";

	public static void swap(int x, int y) {
		Driver10.x = y;
		Driver10.y = x;
	}

	public static void display() {
		System.out.println("X:" + Driver10.x + " " + "Y:" + Driver10.y);
	}

	public static void main(String[] args) throws ParseException {
		swap(10, 11);
		display();
		java.util.Properties p = System.getProperties();

		Iterator<Object> iterator = p.keySet().iterator();
		while (iterator.hasNext()) {
			String key = iterator.next().toString();
			String value = p.getProperty(key);

			System.out.println(key + ":" + value);
		}
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		Date d1 = df.parse("01/15/2006");
		Date d2 = df.parse("12/16/2005");
		Date d3 = df.parse("09/29/2005");
		ArrayList<SampleObject> list = new ArrayList<SampleObject>();
		list.add(new SampleObject("A", d1));
		list.add(new SampleObject("B", d2));
		list.add(new SampleObject("C", d3));
		Collections.sort(list, new DateComparator());
		System.out.println(list);
		System.out.println("**********************");
		System.out.println(System.getProperty(MYPROP_FILE));
		System.out.println(System.getProperty("lisa.jdbc.sim.require.remote"));
		Properties props = new Properties();
		try {
			props.load(new FileInputStream(System.getProperty(MYPROP_FILE)));
		}
		// catch exception in case properties file does not exist
		catch (IOException e) {
			e.printStackTrace();
		}

	}
}

class DateComparator implements Comparator<SampleObject> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	public int compare(SampleObject o1, SampleObject o2) {
		// TODO Auto-generated method stub
		return o1.getDate().compareTo(o2.getDate());
	}

}

class SampleObject {
	/**
	 * @return the sample
	 */
	public String getSample() {
		return sample;
	}

	/**
	 * @param sample
	 *            the sample to set
	 */
	public void setSample(String sample) {
		this.sample = sample;
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date
	 *            the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	private String sample;
	private Date date;

	public SampleObject(String sample, Date date) {
		this.sample = sample;
		this.date = date;
	}

	public String toString() {
		return this.date.toString();
	}
}
