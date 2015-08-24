package com.anil.java.files;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.StringTokenizer;

public class FileReaderUsingArraylist {

	public static void main(String[] args){
		ArrayList list = new ArrayList();
		FileReaderUsingArraylist sample = new FileReaderUsingArraylist();
		sample.readFile(list);
		sample.writeFile(list);
	}
	private void readFile(ArrayList Kitaplist) {

		String bookname = null;
		String bookauthor = null;
		String ISBN = null;
		String YE = null;
		int pages = 0;
		int year = 0;
		int loanid = 0;
		String durum;
		try {
			BufferedReader f = new BufferedReader(new FileReader("D:\\eclipse\\workspace\\JavaStudy\\src\\input.txt"));
			String line = null;
			while ((line = f.readLine()) != null) {
				StringTokenizer tokens = new StringTokenizer(line, "|");
				bookname = tokens.nextToken();
				bookauthor = tokens.nextToken();
				ISBN = tokens.nextToken();
				YE = tokens.nextToken();
				pages = Integer.parseInt(tokens.nextToken());
				year = Integer.parseInt(tokens.nextToken());
				loanid = Integer.parseInt(tokens.nextToken());
				if (loanid == 0) {
					durum = "Uygun";
				} else {
					durum = "Uyede";
				}
				Kitaplist.add(new Object[] { bookname, bookauthor, ISBN, YE,
						pages, year, durum });
			}
		} catch (Exception asd) {
			// BackupErorFrame.setVisible(true);
			// JOptionPane.showMessageDialog( null,
			// " Veri Taban1na balan1rken hata olu_tu. Veri Taban1 kurtarma Penceresini kullan1n1z"
			// ,"Veritaban1 Hatas1 !", JOptionPane.ERROR_MESSAGE );
			System.out.println("Exception in readFile: " + asd.getMessage());
		}
		System.out.println(Kitaplist);
	}

	public void writeFile(ArrayList Kitaplist) {
		try {
			System.out.println("The passed list object: " +Kitaplist);
			BufferedWriter writer = new BufferedWriter(new FileWriter(
					"output.txt"));
			Object[] a = null;
			StringBuffer output = null;
			ListIterator iter = Kitaplist.listIterator();

			while (iter.hasNext()) {
				a = (Object[]) iter.next();
				System.out.println("The object obtained is: " + a);
				output = new StringBuffer();
				int length = a.length;
				for (int i = 0; i < length; i++) {
					output.append(a[i].toString());
					if (i < (length - 1)) {
						output.append("|");
					}
				}
				writer.write(output.toString());
				writer.newLine();	
			}
			writer.close();

		} catch (Exception e) {
			System.out.println("Error in write method: " + e.getMessage());
		}
	}
}
