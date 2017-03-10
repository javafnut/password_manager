package com.ibexsys.pwd.services;

import com.ibexsys.pwd.model.PasswordCriteria;

import java.util.Random;


/**
 *  Package: com.jsc.pwd.generator
 *  Class: PasswordGeneratorImpl
 *
 *  Description: PasswordGenerator Implementation
 *  
 *
 *  @author jsc
 *  Date: Oct 13, 2012
 */

public class PasswordGeneratorService{
	
	private Random randomGen = null;
	
	public StringBuffer getCharSet(PasswordCriteria criteria){
		
		StringBuffer charSet = new StringBuffer();
		
		if (criteria.isAlphaLowerChars())
			charSet.append(PasswordCriteria.ALPHA_CHARS_LOWER_CASE);
		
		if (criteria.isAlphaUpperChars())
			charSet.append(PasswordCriteria.ALPHA_CHARS_UPPER_CASE);
		
		if (criteria.isNumericChars())
			charSet.append(PasswordCriteria.NUMERIC_CHARS);
		
	    if (criteria.isOtherChars())
	    	charSet.append(PasswordCriteria.OTHER_CHARS);
		
		return charSet;
				
	}
	
	
	public String generatePassword(PasswordCriteria criteria) {
		// TODO Auto-generated method stub

		if (randomGen == null){
			randomGen = new Random();
		}
		
		
	    StringBuffer password = new StringBuffer();
	    StringBuffer charResource = getCharSet(criteria);
	    int charResourceLen = charResource.length();
	    
	    for (int i = 0; i < criteria.getPwdLen(); i++){
	    	int ndx = randomGen.nextInt(charResourceLen);
	    	
	    	password.append(charResource.charAt(ndx));
	    }
    
    	
        return password.toString();
	}
	
	
	/* Use Default Criteria */
	public String generatePassword(){
		
		PasswordCriteria criteria = new PasswordCriteria();
		
		return generatePassword(criteria).toString();
		
	}
	
	

}
