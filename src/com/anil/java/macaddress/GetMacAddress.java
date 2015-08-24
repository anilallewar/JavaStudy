package com.anil.java.macaddress;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GetMacAddress {

	/**
	 * @param args
	 * @throws SocketException 
	 */
	public static void main(String[] args) throws SocketException {
		GetMacAddress getMac = new GetMacAddress();
		System.out.println("The MAC address on a windows system is: "
				+ getMac.returnMacAddress());
		System.out.println("The M/C hardware number is: "
				+ getMac.getSerialNumber("C:"));
		System.out.println("The Mother board Serial Number is: "
				+ getMac.getMotherboardSerialNumber());
		System.out.println("The current host IP address is: " + getMac.getHostIPAddress());
	}

	/**
	 * Return mac address.
	 *
	 * @return the string
	 */
	public String returnMacAddress() {
		String macAddress = null;
		// Command to get the system information on Windows
		String command = "ipconfig /all";
		// Get the type of OS
		String os = System.getProperty("os.name");
		System.out.println("The operating system is: " + os);

		try {
			Process ps = Runtime.getRuntime().exec(command);
			String line;
			BufferedReader buffIn = new BufferedReader(new InputStreamReader(
					ps.getInputStream()));
			while ((line = buffIn.readLine()) != null) {
				// System.out.println("The current line is: " + line);
				Pattern p = Pattern.compile(".*Physical Address.*: (.*)");
				Matcher m = p.matcher(line);
				// Check the entire line
				if (m.matches()) {
					macAddress = m.group(1);
				}
			}
			buffIn.close();
		} catch (IOException ie) {
			System.out.println("Got IOException while getting MAC address: "
					+ ie.getMessage());
		}

		return macAddress;
	}

	/**
	 * For the Hardware and Network.
	 *
	 * @param drive the drive
	 * @return the serial number
	 */
	public String getSerialNumber(String drive) {
		String result = "";
		try {
			File file = File.createTempFile("realhowto", ".vbs");
			file.deleteOnExit();
			FileWriter fw = new java.io.FileWriter(file);

			String vbs = "Set objFSO = CreateObject(\"Scripting.FileSystemObject\")\n"
					+ "Set colDrives = objFSO.Drives\n"
					+ "Set objDrive = colDrives.item(\""
					+ drive
					+ "\")\n"
					+ "Wscript.Echo objDrive.SerialNumber"; // see note
			fw.write(vbs);
			fw.close();
			Process p = Runtime.getRuntime().exec(
					"cscript //NoLogo " + file.getPath());
			BufferedReader input = new BufferedReader(new InputStreamReader(
					p.getInputStream()));
			String line;
			while ((line = input.readLine()) != null) {
				result += line;
			}
			input.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result.trim();
	}

	/**
	 * Gets the motherboard serial number.
	 *
	 * @return the motherboard serial number
	 */
	public String getMotherboardSerialNumber() {
		String result = "";
		try {
			File file = File.createTempFile("realhowto", ".vbs");
			file.deleteOnExit();
			FileWriter fw = new java.io.FileWriter(file);

			String vbs = "Set objWMIService = GetObject(\"winmgmts:\\\\.\\root\\cimv2\")\n"
					+ "Set colItems = objWMIService.ExecQuery _ \n"
					+ "   (\"Select * from Win32_BaseBoard\") \n"
					+ "For Each objItem in colItems \n"
					+ "    Wscript.Echo objItem.SerialNumber \n"
					+ "    exit for  ' do the first cpu only! \n" + "Next \n";

			fw.write(vbs);
			fw.close();
			Process p = Runtime.getRuntime().exec(
					"cscript //NoLogo " + file.getPath());

			BufferedReader input = new BufferedReader(new InputStreamReader(
					p.getInputStream()));
			String line;
			while ((line = input.readLine()) != null) {
				result += line;
			}
			input.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result.trim();
	}

	/**
	 * Return the IP of the m/c on which process is running
	 * @return
	 * @throws SocketException
	 */
	public String getHostIPAddress() throws SocketException {
		String currentHostIP=null;
		
		Enumeration<NetworkInterface> interfaces = NetworkInterface
				.getNetworkInterfaces();
		while (interfaces.hasMoreElements()) {
			NetworkInterface current = interfaces.nextElement();
			if (!current.isUp() || current.isLoopback() || current.isVirtual()){
				continue;
			}
			Enumeration<InetAddress> addresses = current.getInetAddresses();
			while (addresses.hasMoreElements()) {
				InetAddress current_addr = addresses.nextElement();
				if (current_addr.isLoopbackAddress()){
					continue;
				}else{
					if (current_addr instanceof Inet4Address){
						currentHostIP = current_addr.getHostAddress();
						break;
					}
				}
			}
		}
		
		return currentHostIP;
	}
}
