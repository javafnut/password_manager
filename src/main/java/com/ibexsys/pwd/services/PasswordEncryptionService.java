package com.ibexsys.pwd.services;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Arrays;

/**
 * @author jsc
 *
 */
public class PasswordEncryptionService {
	
	private static final String hashAlgorithm = "PBKDF2WithHmacSHA1";
	private static final String saltAlgorithm = "SHA1PRNG";
	
	
	public static boolean authenticate(String pAttemptedPassword, byte[] pEncryptedPassword,byte[] pSalt)
	               throws NoSuchAlgorithmException, InvalidKeySpecException {

		byte[] lEncryptedAttemptedPassword = getEncryptedPassword(pAttemptedPassword,pSalt);
	    return Arrays.equals(pEncryptedPassword, lEncryptedAttemptedPassword);
	}
	
	public static byte[] getEncryptedPassword(String pPassword, byte[] pSalt)
					throws NoSuchAlgorithmException, InvalidKeySpecException {
		
		// SHA-1 useds 160 made sense here
		 int lDerivedKeyLength = 160;
		 int lIterations = 20000;
		 
		 KeySpec lSpec = new PBEKeySpec(pPassword.toCharArray(), pSalt, lIterations, lDerivedKeyLength);
		 SecretKeyFactory lFactory = SecretKeyFactory.getInstance(hashAlgorithm);
	 
		 return lFactory.generateSecret(lSpec).getEncoded();
    }

	public static byte[] generateSalt()
	              throws NoSuchAlgorithmException {
	
		SecureRandom lRandom = SecureRandom.getInstance(saltAlgorithm);
		byte[] lSalt = new byte[8];
	    lRandom.nextBytes(lSalt);
	    
	    return lSalt;
	}
	
}
