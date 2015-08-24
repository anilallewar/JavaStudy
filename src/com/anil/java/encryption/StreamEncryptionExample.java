/**
 * 
 */
package com.anil.java.encryption;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class StreamEncryptionExample {

	SecretKeySpec skeySpec = null;

	Cipher cipher = null;

	public void encrypt() {
		try {

			/* Instantiate the cipher */
			cipher = Cipher.getInstance("RC4");

			/* Initialize the cipher in ENCRYPT mode with key for encryption */
			cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
			/* call doEncrypt with text and cipher */
			String returnedCihperText = doEncrypt("ABC1", cipher);
			System.out.println("Cipher Text:" + returnedCihperText);
			cipher.init(Cipher.DECRYPT_MODE, skeySpec);
			System.out.println("Original Text: " + decrypt(returnedCihperText, cipher));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private String doEncrypt(String strencryptText, Cipher cipher)
			throws BadPaddingException, IllegalBlockSizeException, SQLException {
		String strreturnEncryptedText = "";
		byte[] encrypted = new byte[1];
		encrypted = cipher.doFinal(strencryptText.getBytes());
		BASE64Encoder base64_encoder = new BASE64Encoder();
		strreturnEncryptedText = base64_encoder.encodeBuffer(encrypted);
		return strreturnEncryptedText;
	}

	public String decrypt(String tobedecrypted, Cipher cipher)
			throws BadPaddingException, IllegalBlockSizeException,
			SQLException, IOException, NoSuchAlgorithmException,
			NoSuchPaddingException, InvalidKeyException {
		String retrieved_data = null;

		/* Use of BASE64 decoder for decoding of obfuscated String */
		BASE64Decoder base64_decoded = new BASE64Decoder();
		byte[] data_byteform1 = base64_decoded.decodeBuffer(tobedecrypted);
		
		/* Decrypt the encrypted data */
		byte[] original_bytes = cipher.doFinal(data_byteform1);
		
		/* Construct the original String */
		retrieved_data = new String(original_bytes);
		return retrieved_data;
	}

	public SecretKeySpec createKey() {
		try {
			/*
			 * The class KeyGenerator provided the functionality of
			 * symmetric-key keygenerator
			 */
			KeyGenerator kgen = KeyGenerator.getInstance("RC4");

			/*
			 * Initialize the key generator with the keysize. The key size is an
			 * algorithm specific metric specified in number of bits
			 */
			kgen.init(128); //16 bits

			/* Generate the SecretKey */
			SecretKey skey = kgen.generateKey();
			
			/* Get the key in the encoded format */
			byte[] raw = skey.getEncoded();

			/* Construct an algorithm specific secret key from byte array */
			skeySpec = new SecretKeySpec(raw, "RC4");
		} catch (NoSuchAlgorithmException nsae) {
			System.out.println(nsae);
		}
		return skeySpec;
	}

	public static void main(String[] args){
		StreamEncryptionExample example = new StreamEncryptionExample();
		example.createKey();
		example.encrypt();
	}
}
