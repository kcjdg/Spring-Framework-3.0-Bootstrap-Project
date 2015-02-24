package com.ph.sinonet.spring.util;

import org.jasypt.encryption.pbe.PBEStringEncryptor;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

import com.google.common.base.CharMatcher;


/**
 * See : http://security.stackexchange.com/questions/10049/explaining-security-vs-performace-to-a-non-tech-superior
 * 
 * @author sinonet
 *
 */

public class HibernatePBEStringEncryptor implements PBEStringEncryptor {

	private StandardPBEStringEncryptor standardPBEStringEncryptor;

	private final static String PREFIX = "ENCRYPT+(";
	private final static String SUFFIX = ")";

	
	public HibernatePBEStringEncryptor() {
//		Security.addProvider(new BouncyCastleProvider());
		standardPBEStringEncryptor = new StandardPBEStringEncryptor();
		standardPBEStringEncryptor.setAlgorithm("PBEWithSHA1AndDESede");
		standardPBEStringEncryptor.setPassword("s1n0N3tPH!lL1Pp3n*s");
		standardPBEStringEncryptor.setKeyObtentionIterations(10000);
	}

	public String encrypt(String message) {
		String hashValue = HashingUtil.sha1(message);
		String encryptMessage = standardPBEStringEncryptor.encrypt(hashValue);
		String finalMsg = PREFIX + encryptMessage + SUFFIX;
		return finalMsg;
	}

	public String decrypt(String encryptedMessage) {
	String finalMsg = CharMatcher.anyOf(PREFIX+SUFFIX).trimFrom(encryptedMessage);
		return standardPBEStringEncryptor.decrypt(finalMsg);
	}	

	public void setPassword(String password) {
		standardPBEStringEncryptor.setPassword(password);
	}

	
//	public static void getSecurityProviders() {
//		for (Provider provider : Security.getProviders()) {
//			System.out.println("Provider: " + provider.getName());
//			for (Provider.Service service : provider.getServices()) {
//				System.out.println("Algorithm: " + service.getAlgorithm());
//			}
//		}
//	}

	
	public static void main(String[] args) {
		HibernatePBEStringEncryptor encryptor = new HibernatePBEStringEncryptor();
		String en = encryptor.encrypt("123123");
		System.out.println(en);
		System.out.println(encryptor.decrypt(en));
	}
	
	
	
}
