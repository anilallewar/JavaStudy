package com.anil.java.files;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class FileListerOld {
	public static int date;
	private String folder = "C:/Intel"; // The folder which needs to be
										// operated.
	long duration = 0;

	public static void main(String args[]) {
		FileLister flst = new FileLister();
		try {
			flst.duration = Integer.parseInt(args[0]);
			// convert to millisec assuming input was in mins;
			flst.duration = flst.duration * 1000 * 60;
		} catch (Exception e) {
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
			String[] list = null;
			Scanner scanner = null;
			String Pattern="[\\d{1.3}]+.[\\d{1.3}]+.[\\d{1.3}]+.[\\d{1.3}]+-[\\w]*.*";
			String token=null;
			for (String s : lst) {
				scanner=new Scanner(s);
				token=scanner.findInLine(Pattern);
				if (token!=null){
					list=s.split("-");
					fout.write(list[0]);
					fout.write("\n");
				}
				token=null;
			}
			fout.close();
		} catch (IOException e1) {
			System.out.println("Error in getting create time");
		}
		
		ArrayList<String> data = new ArrayList<String>();
		
		//Read the output excel and compare against the file
		try{
			File file = new File("C://output.txt");
			BufferedReader fin = new BufferedReader(new FileReader(file));
			String s;
            while((s = fin.readLine())!=null){
                System.out.println(s);
                data.add(s);
            }
            System.out.println(data);
            //fin=null;
            file = new File("C://Intel/ip3.csv");
            fin = new BufferedReader(new FileReader(file));
            BufferedWriter fout = new BufferedWriter(new FileWriter(new File("C://outputfile.csv")));
            //fout.write("Checking");
            String[] list=null;
            while((s = fin.readLine())!=null){
                System.out.println(s);
                list=s.split(",");
                if (!data.contains(list[0])){
                	System.out.println("Not present: " + list[0]);
                	fout.write(list[0] + "," + "Yes"+"," + list[2]);
                	fout.write("\n");
                }else{
                	System.out.println("Present: " + list[0]);
                	fout.write(list[0] + "," + "No"+"," + list[2]);
                	fout.write("\n");
                }
            }
            fout.close();
            
         }catch(IOException ie){
            	System.out.println("Error while reading and writing file");
         }

	}

	public ArrayList<String> getFileList(long curTime, long duration) {
		ArrayList<String> lst = new ArrayList<String>();
		;
		try {
			File fol = new File(folder);
			if (fol.isDirectory()) {
				File[] files = fol.listFiles();
				for (File f : files) {
					if (f.isFile()) {
						long lastmd = f.lastModified();
						long diff = curTime - lastmd;
						if (diff <= duration)
							lst.add(f.getName());
					}
				}

			} else {
				return null;
			}
		} catch (Exception e) {
			return null;
		}

		return lst;
	}
}