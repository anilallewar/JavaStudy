/**
 * 
 */
package com.anil.java.development;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @author anila
 * 
 */
public class ExternalProcessExample {

	public static void main(String[] args) throws IOException {
		// Process process =
		// Runtime.getRuntime().exec("cmd /c start E:\\Softwares\\Application.exe -id");
		Process process = Runtime.getRuntime().exec("cmd /c start cmd");

		BufferedWriter in = new BufferedWriter(new OutputStreamWriter(process
				.getOutputStream()));
		String line = "2967 ";
		in.write(line);
		in.flush();
		in.close();
		InputStream out = process.getInputStream();
		// clean up if any output in stdout
		BufferedReader brCleanUp = new BufferedReader(
				new InputStreamReader(out));
		while ((line = brCleanUp.readLine()) != null) {
			System.out.println("[Stdout] " + line);
		}
		brCleanUp.close();
		process.destroy();
	}
}
