package com.pvkcse.cryptography.symmetricalgo.aes.action;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

import com.pvkcse.cryptography.helpers.CryptoException;
import com.pvkcse.cryptography.symmetricalgo.aes.helpers.AESExceptionStore;
import com.pvkcse.cryptography.symmetricalgo.aes.resource.KeySpec;

public class KeyGenerator
{
	public static SecretKey doGetAESKey(KeySpec spec) throws CryptoException
	{
		try
		{
			return spec.canGenerateKeyFromPassword() ? Util.generateKeyFromPassword(spec) : Util.generateKey(spec);
		}
		catch(NoSuchAlgorithmException | InvalidKeySpecException algoEx)
		{
			AESExceptionStore.KEY_GENERATION_EXCEPTION.doThrow(algoEx);
		}
		catch(Exception ex)
		{
			AESExceptionStore.INTERNAL_ERROR_OCCURED.doThrow(ex);
		}

		return null;
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
