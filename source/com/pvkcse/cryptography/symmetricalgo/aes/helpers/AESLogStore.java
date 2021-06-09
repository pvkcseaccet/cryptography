package com.pvkcse.cryptography.symmetricalgo.aes.helpers;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.pvkcse.cryptography.helpers.CryptoException;
import com.pvkcse.cryptography.helpers.CryptoLogger;

public enum AESLogStore
{

	EXCEPTION_LOGGER(Level.SEVERE, "CRYPTO:: Exception Occured: {0}");

	private Level logLevel;

	private String message;

	AESLogStore(Level logLevel, String message)
	{
		this.logLevel = logLevel;
		this.message = message;
	}

	public void doLog(Logger logger, Throwable ex) throws CryptoException
	{
		if (!(logger instanceof CryptoLogger))
		{
			throw new CryptoException("CRYPTO_LOGGER_ONLY_ALLOWED", "Please use CryptoLogger. You are not supposed to use anyother loggers", ex);
		}
		logger.log(this.logLevel, this.message, ex);
	}

	public Level getLogLevel()
	{
		return logLevel;
	}

	public String getMessage()
	{
		return message;
	}
}
