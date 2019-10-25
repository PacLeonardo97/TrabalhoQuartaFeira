package br.com.parg.politicaDeFoco;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Criptografia {
	
	public String Criptografia(String senha) {
		try {
			MessageDigest algorithm = MessageDigest.getInstance("SHA-256");
		     byte messageDigestSenhaAdmin[] = algorithm.digest(senha.getBytes("UTF-8"));
		       
		     StringBuilder hexStringSenhaAdmin = new StringBuilder();
		     for (byte b : messageDigestSenhaAdmin) {
		              hexStringSenhaAdmin.append(String.format("%02X", 0xFF & b));
		     }
		     String senhahex = hexStringSenhaAdmin.toString();
		      
		     return senhahex;
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null; 
	     
	}
}
