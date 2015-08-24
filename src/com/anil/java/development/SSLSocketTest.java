/**
 * 
 */
package com.anil.java.development;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.URL;
import java.security.Security;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

/**
 * @author anila
 * 
 */
public class SSLSocketTest {
	public static void main(String[] args) {
		try {
			System.out.println("Creating Connection..");
			String urlString = "https://wwwcie.ups.com/ups.app/xml/ShipConfirm";
			URL url = new URL(urlString);

			System.out.println("Adding provider ..");
			Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());

			SSLSocketFactory factory = (SSLSocketFactory) SSLSocketFactory
					.getDefault();

			SSLSocket socket = (SSLSocket) factory.createSocket(url.getHost(),
					443);

			StringBuffer stringbuffer = new StringBuffer();
			// java.net.URL url = new
			// java.net.URL("https://wwwcie.ups.com/ups.app/xml/ShipConfirm");

			/*
			 * HttpURLConnection connection = (HttpURLConnection)
			 * url.openConnection(); connection.setDoOutput(true);
			 * connection.setAllowUserInteraction(true);
			 * System.out.println("Client established connection with " +
			 * url.toString()); //out.println("https Connection :- " +
			 * connection);
			 * 
			 * String accessxml = stringbuffer.toString();
			 * out.println(accessxml); OutputStreamWriter out1 = new
			 * OutputStreamWriter(connection.getOutputStream());
			 * 
			 * System.out.println(" OutputStreamWriter out1 : " + out1);
			 * 
			 * out1.write(accessxml); out1.close();
			 * 
			 * System.out.println(" Data sent to the UPS. "); BufferedReader in
			 * = new BufferedReader(new
			 * InputStreamReader(connection.getInputStream()));
			 * 
			 * String responseString=""; String UPSResponse = "";
			 * 
			 * while ((responseString = in.readLine()) != null) { UPSResponse +=
			 * responseString; }
			 * 
			 * System.out.println("Response From UPS Server : " + UPSResponse);
			 * System.out.println("");
			 */

			System.out.println("Sending XML ..");
			String accessxml = stringbuffer.toString();
			PrintWriter out1 = new PrintWriter(new OutputStreamWriter(socket
					.getOutputStream()));
			out1.println("GET " + urlString + " HTTP/1.1");
			out1.println(accessxml);
			out1.println();
			out1.flush();

			System.out.println("Reading response ..");
			System.out.println("Reading response ..1");
			System.out.println("Socket status.. " + socket.isConnected());
			BufferedReader in = null;
			if (!socket.isClosed()) {
				in = new BufferedReader(new InputStreamReader(socket
						.getInputStream()));
			} else {
				System.out.println("Socket is closed..");
			}

			String line;
			System.out.println("Reading data ..");
			while ((line = in.readLine()) != null) {
				System.out.println(line);
			}

			out1.close();
			in.close();

		} catch (Exception e) {
			System.out.println("Error sending data to server");
			e.printStackTrace();
			System.out.println("Exception is : " + e);
		}

	}

}
