/**
 * 
 */
package com.anil.java.files;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.Adler32;
import java.util.zip.CheckedInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * @author anila
 * 
 */
public class ZipFileReader {

	public static void main(String[] args) throws IOException {
		String tempdir = System.getProperty("archive_path");
		String zipfile = System.getProperty("zip_path");
		final int BUFFER = 2048;
		BufferedOutputStream dest = null;
		FileInputStream fis = new FileInputStream(zipfile);

		CheckedInputStream checksum = new CheckedInputStream(fis, new Adler32());
		ZipInputStream zis = new ZipInputStream(new BufferedInputStream(
				checksum));

		ZipEntry entry;
		String exitVal = "0";

		while ((entry = zis.getNextEntry()) != null) {

			if (!entry.toString().endsWith(".sql")) {
				System.out.println("Not an sql file");

				exitVal = "-1"; // not sql file
				break;
			}

			int count;
			byte unzipdata[] = new byte[BUFFER];

			// write the files to the disk
			FileOutputStream fos = new FileOutputStream(tempdir + "//"
					+ entry.getName());
			dest = new BufferedOutputStream(fos, BUFFER);

			System.out.println("Extracting entryname : " + entry.getName());

			while ((count = zis.read(unzipdata, 0, BUFFER)) != -1) {
				dest.write(unzipdata, 0, count);
			}

			dest.flush();
			dest.close();
		}

	}

}
