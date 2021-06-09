package com.pvkcse.cryptography.symmetricalgo.aes.action;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

import com.pvkcse.cryptography.symmetricalgo.aes.resource.KeySpec;

public class KeyGenerator
{
	public static SecretKey doGetAESKey(KeySpec spec) throws NoSuchAlgorithmException, InvalidKeySpecException
	{
		return spec.canGenerateKeyFromPassword() ? Util.generateKeyFromPassword(spec) : Util.generateKey(spec);
	}

	private static final class Util
	{

		private static SecretKey generateKey(KeySpec spec) throws NoSuchAlgorithmException
		{
			javax.crypto.KeyGenerator keyGenerator = javax.crypto.KeyGenerator.getInstance(Constants.KeyGenerator.ALGORITHM);
			keyGenerator.init(spec.getKeySize().getSize());
			return keyGenerator.generateKey();
		}

		private static SecretKey generateKeyFromPassword(KeySpec spec) throws NoSuchAlgorithmException, InvalidKeySpecException
		{
			SecretKeyFactory factory = SecretKeyFactory.getInstance(Constants.KeyGenerator.PBKDF2_WITH_HMACSHA256);
			java.security.spec.KeySpec pbeSpec = new PBEKeySpec(spec.getPassword().toCharArray(), spec.getSalt().getBytes(), Constants.KeyGenerator.ITERATION_COUNT, Constants.KeyGenerator.KEY_LENGTH_DEFAULT);
			return new SecretKeySpec(factory.generateSecret(pbeSpec).getEncoded(), Constants.KeyGenerator.ALGORITHM);
		}
	}

}
