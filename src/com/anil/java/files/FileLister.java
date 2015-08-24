package com.anil.java.files;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.StringTokenizer;

public class FileLister {
	public static int date;
	private String folder = "C:" + File.separator + "Intel"; // The folder which
																// needs to be
																// operated.
	long duration = 0;

	public static void main(String args[]) {
		FileLister flst = new FileLister();
		try {
			flst.duration = Integer.parseInt(args[0]);
			// convert to millisec assuming input was in mins;
			flst.duration = flst.duration * 1000 * 60;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("invalid duration");
			System.exit(0);
		}
		
		Calendar calendar = Calendar.getInstance();
		long curTime = calendar.getTimeInMillis();
		ArrayList<String> lst = flst.getFileList(curTime, flst.duration);
		System.out.println("This is the list of files:" + lst.toString());
		try {
			File outputFile = new File("C://output.txt");
			FileWriter fout = new FileWriter(outputFile);
			for (String s : lst) {
				fout.write(s);
				fout.write("\n");
			}

			ArrayList<String> arrayList = flst.getListFromCSVFile("C:"
					+ File.separator + "Intel" + File.separator + "ip4.csv");

			for (String s : arrayList) {

				if (!lst.contains(s)) {
					fout.write(s);
					fout.write("\n");

				}
			}
			fout.close();
		} catch (IOException e1) {
			System.out.println("Error in getting create time");
		}

	}

	public ArrayList<String> getFileList(long curTime, long duration) {
		ArrayList<String> lst = new ArrayList<String>();
		
		try {
			File fol = new File(folder);
			if (fol.isDirectory()) {
				File[] files = fol.listFiles();
				for (File f : files) {
					if (f.isFile()) {
						long lastmd = f.lastModified();
						long diff = curTime - lastmd;
						if (diff >= duration)
							lst.add(f.getName());
					}
				}

			}

			else {
				return null;
			}
		} catch (Exception e) {
			return null;
		}

		return lst;
	}

	public ArrayList<String> getListFromCSVFile(String filePath) {
		File file = new File(filePath);
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		DataInputStream dis = null;

		ArrayList<String> csvlist = new ArrayList<String>();

		try {
			fis = new FileInputStream(file);

			// Here BufferedInputStream is added for fast reading.
			bis = new BufferedInputStream(fis);
			dis = new DataInputStream(bis);

			// dis.available() returns 0 if the file does not have more lines.
			while (dis.available() != 0) {

				String line = dis.readLine();
				StringTokenizer st = new StringTokenizer(line, ",");
				csvlist.add(st.nextToken());
			}

			// dispose all the resources after using them.
			fis.close();
			bis.close();
			dis.close();

		} catch (Exception e) {

		}
		return csvlist;
	}
}