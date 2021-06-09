package com.pvkcse.cryptography.symmetricalgo.aes.action;

public class Constants
{
	public static final class KeyGenerator
	{
		public static final String ALGORITHM = "AES";
		public static final String PBKDF2_WITH_HMACSHA256 = "PBKDF2WithHmacSHA256";
		public static final Integer ITERATION_COUNT = 65536;
		public static final Integer KEY_LENGTH_DEFAULT = 256;
	}
}
