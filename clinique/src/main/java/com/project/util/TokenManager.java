package com.project.util;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

public class TokenManager {

			
    public static String generateToken(String id) throws NoSuchAlgorithmException, UnsupportedEncodingException
    {
        int numero= new Random().hashCode();
        return Cryptage.SHA1(numero+id+"  "+System.currentTimeMillis());
    }
	
	
}
