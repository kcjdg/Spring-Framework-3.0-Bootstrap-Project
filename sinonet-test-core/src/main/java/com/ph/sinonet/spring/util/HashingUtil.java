package com.ph.sinonet.spring.util;

import java.nio.charset.Charset;

import com.google.common.base.Charsets;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;

public class HashingUtil {
	
	private static Charset UTF8 = Charsets.UTF_8;
	
	public static String sha256(String message){
		return Hashing.sha256().hashString(message, UTF8).toString();
	}
	
	public static String md5(String message){
		return Hashing.md5().hashString(message, UTF8).toString();
	}
	
	public static String sha1(String message){
		return Hashing.sha1().hashString(message, UTF8).toString();
	}
	
	
}
