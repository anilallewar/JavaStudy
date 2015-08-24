/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.anil.java.files;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 
 * @author Anil Allewar
 */
public class FileAccess {
	public void createFile() {
		File f = new File("anil.txt");
		File dir = new File("NewDirectory");
		try {
			File f1 = new File("F:\\Program Files\\apache-servicemix-3.6.0-fuse-00-61\\filedir\\in\\pricing\\opis\\Currecy Converter Services Comparision.xlsx");
			System.out
					.println("Checking if file anil1.txt exists in the NewDirectory directory: "
							+ f1.exists());
			System.out
					.println("The system throws an IOException because the FileWriter constructor will create a file but it cannot Create the directory by default");
			System.out.println(f1.getName() + ":" + f1.getPath() + ":"
					+ f1.getParent());
			// Creating the directory manually
			dir.mkdir();
			FileWriter fw = new FileWriter(f1);
			System.out
					.println("This line will NOT be reached unless the directory is created exlicitly before..");
			PrintWriter pw = new PrintWriter(fw);
			pw.println("This is anil here..");
			pw.println("Writing in anil1.txt file");
			pw.flush();
			pw.close();
		} catch (IOException fileNotFound) {
			System.out.println("Got exception:" + fileNotFound.getMessage());
		} finally {
			System.out.print("anil.txt exists?? " + f.exists());
			System.out.println(" NewDirectory exists?? " + dir.exists());
			// throw new IOException();
		}
	}

	public String ReadFile(String filename, String path) {
		File f = new File(path, filename);
		char[] chararray = new char[50];
		try {
			FileReader fr = new FileReader(f);
			/*
			 * fr.read(chararray);
			 * System.out.println("The size of the file in terms of characters is: "
			 * +chararray.length);
			 * System.out.println("Writing file using char array........");
			 * for(char i:chararray){ System.out.print(i); }
			 */
			System.out.println();
			System.out.println("Writing using the buffered writer");
			BufferedReader br = new BufferedReader(fr);
			String s;
			StringBuilder sb = new StringBuilder();
			while ((s = br.readLine()) != null) {
				System.out.println(s);
				sb.append(s);
			}

			return sb.toString();
		} catch (IOException ie) {
			System.out.println("Got IOException in ReadFile method: "
					+ ie.getMessage());
		}
		return null;
	}

	public void deleteFile() {

		try {
			File delDir = new File("deldir");
			delDir.mkdir();
			File delfile1 = new File("deldir", "delfile1.txt");
			delfile1.createNewFile();

			File delFile2 = new File("deldir", "delfile2.txt");
			delFile2.createNewFile();

			// Delete file 1
			delfile1.delete();
			System.out
					.println("Successful in deleting file 1. Checking if file exists: "
							+ delfile1.exists());

			// Attempting to rename
			File newFile = new File("deldir", "NewFile.txt");
			delFile2.renameTo(newFile);

			// The diirectory will be deleted if you have not specifically
			// called createNewFile because no file is created till then
			System.out.println("Attempting to delete directory...Result is: "
					+ delDir.delete()
					+ " The directory will NOT be deleted if it is non-empty ");
			// Delete file 2
			delFile2.delete();
			newFile.delete();

			System.out
					.println("Trying to delete directory after all the file in the directory have been deleted. The result is: "
							+ delDir.delete());

			System.out.println("Checking whether the directory exists: "
					+ delDir.exists());

			File newDir = new File("NewDir");

			delDir.renameTo(newDir);

			System.out
					.println("Checking whether the directory exists with original name after renaming: "
							+ delDir.exists());

			System.out
					.println("Checking whether the NEW directory exists: "
							+ newDir.exists()
							+ ".  Note that directory can be renamed even if it is non-empty");

		} catch (SecurityException se) {
			System.out.println("Got SecurityException in deleteFile() method: "
					+ se.getMessage());
		} catch (IOException ie) {
			System.out.println("Got exception in deleteFile method: "
					+ ie.getMessage());
		}

	}

	public File[] listFiles(String directory, final String extension) {

		File dir = new File(directory);

		FileFilter fileFilter = new FileFilter() {
			public boolean accept(File file) {
				return file.getName().endsWith(extension);
			}
		};
		return dir.listFiles(fileFilter);
	}

	public static void main(String[] args) {
		FileAccess fa = new FileAccess();
		fa.createFile();

		System.out
				.println("The results of fa.ReadFile(\"anil1.txt\", \"NewDirecory\") is: "
						+ fa.ReadFile("anil1.txt", "NewDirectory"));

		fa.deleteFile();

		File[] results = fa.listFiles("NewDirectory", "txt");
		for (File file : results) {
			System.out.println(file.getName());
		}

	}
}
