package com.pvkcse.cryptography.symmetricalgo.aes.action;

import java.math.BigInteger;
import java.security.Key;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class AESEncryption
{
	private static final String KEY_CHARSET = "1234567890qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM";

	public static void main(String[] args) throws Exception
	{
		//		System.out.println(generateKey());
		String key = "iHVcF9dYjCGVYZBImuDieEtWB3wk2dsDWtvxij9jf9c";
		Long data = Long.MAX_VALUE;
		String cipher = encrypt(new byte[] {data.byteValue()}, baseConvertBack(key));
		System.out.println(cipher);
	}

	public static String encrypt(byte[] data, byte[] keyVal) throws Exception
	{
		Key key = new SecretKeySpec(keyVal, "AES");
		Cipher c = Cipher.getInstance("AES");

		//Encryption
		c.init(Cipher.ENCRYPT_MODE, key);
		byte[] encVal = c.doFinal(data);

		return baseConvert(encVal);
	}

	public static String generateKey() throws Exception
	{
		KeyGenerator keyGen = KeyGenerator.getInstance("AES");
		keyGen.init(256); // for example
		SecretKey secretKey = keyGen.generateKey();

		byte[] bytes = secretKey.getEncoded();

		return Base64.getEncoder().withoutPadding().encodeToString(secretKey.getEncoded());
	}

	public static String baseConvert(byte[] bytes)
	{
		BigInteger number = new BigInteger(1, bytes);
		BigInteger quotient;
		BigInteger remainder;
		StringBuilder result = new StringBuilder();
		BigInteger base = BigInteger.valueOf(KEY_CHARSET.length());
		do
		{
			remainder = number.remainder(base);
			quotient = number.divide(base);
			result.append(KEY_CHARSET.charAt(remainder.intValue()));
			number = number.divide(base);
		}
		while (!BigInteger.ZERO.equals(quotient));
		return result.reverse().toString();
	}

	public static byte[] baseConvertBack(String encodedValue)
	{
		BigInteger number = BigInteger.ZERO;
		final BigInteger base = BigInteger.valueOf(KEY_CHARSET.length());
		int power = 0;
		for (int i = encodedValue.length() - 1; i >= 0; i--)
		{
			char c = encodedValue.charAt(i);
			number = number.add(base.pow(power).multiply(new BigInteger(String.valueOf(KEY_CHARSET.indexOf(c)))));
			power++;
		}
		byte[] resultwithsignbit = number.toByteArray();
		byte[] finalresult = new byte[resultwithsignbit.length - 1];
		for (int i = 1; i < resultwithsignbit.length; i++)
		{
			finalresult[i - 1] = resultwithsignbit[i];
		}
		return finalresult;
	}

}
