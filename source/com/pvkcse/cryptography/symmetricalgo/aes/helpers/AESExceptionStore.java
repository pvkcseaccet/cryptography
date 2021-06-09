package com.pvkcse.cryptography.symmetricalgo.aes.helpers;

import java.util.logging.Logger;

import com.pvkcse.cryptography.helpers.CryptoException;

public enum AESExceptionStore
{
	INTERNAL_ERROR_OCCURED("CRYPTO_INTERNAL_ERROR", "Some Internal Error Occured. Please raise an issue in our GitHub Project."),
	KEY_GENERATION_EXCEPTION("CRYPTO_KEY_GENERATION_EXCEPTION", "Exception Occured in Key Generation. Please review your keyspec once.");

	private String errorCode;

	private String errorMessage;

	private static final Logger LOGGER = Logger.getLogger(AESExceptionStore.class.getName());

	AESExceptionStore(String errorCode, String errorMessage)
	{
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}

	public void doThrow(Throwable ex) throws CryptoException
	{
		AESLogStore.EXCEPTION_LOGGER.doLog(LOGGER, ex);
		throw new CryptoException(this.getErrorCode(), this.getErrorMessage(), ex);
	}

	public void doLogAndThrow(Throwable ex, AESLogStore aesLogStore, Logger logger) throws CryptoException
	{
		aesLogStore.doLog(logger, ex);
		throw new CryptoException(this.getErrorCode(), this.getErrorMessage(), ex);
	}

	public void doThrow(Throwable ex, Object placeHolders) throws CryptoException
	{
		AESLogStore.EXCEPTION_LOGGER.doLog(LOGGER, ex);
		throw new CryptoException(this.getErrorCode(), this.getErrorMessage(), ex);
	}

	public void doLogAndThrow(Throwable ex, AESLogStore aesLogStore, Logger logger, Object placeHolders) throws CryptoException
	{
		aesLogStore.doLog(logger, ex);
		throw new CryptoException(this.getErrorCode(), this.getErrorMessage(), ex);
	}

	public String getErrorCode()
	{
		return errorCode;
	}

	public String getErrorMessage()
	{
		return errorMessage;
	}
}
