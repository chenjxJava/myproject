package com.encode;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class EncodeDemo {
	public static void main(String[] args) throws UnsupportedEncodingException {
		String encoding = "iso-8859-1";
		encoding = "UTF-8";

		String str = "品牌/系列名称";
		//str = "\\Jcobo";

		decode(encoding, str);
		//toISO(str);

	}

	private static void toISO(String str) throws UnsupportedEncodingException {
		String s = new String(str.getBytes(), "iso-8859-1");
		String de = new String(s.getBytes("iso-8859-1"), "UTF-8");
	}

	private static void decode(String encoding, String str) {
		try {
			String encode = URLEncoder.encode(str, encoding);
			String decode = URLDecoder.decode(encode, encoding);
			System.out.println(encode + "...." + decode);

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
}

