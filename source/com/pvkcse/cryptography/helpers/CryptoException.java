package com.pvkcse.cryptography.helpers;

public class CryptoException extends Exception
{
	private String errorCode;

	private String errorMessage;

	public CryptoException()
	{

	}

	public CryptoException(String errorCode, Throwable ex)
	{
		super(ex);
		this.errorCode = errorCode;
	}

	public CryptoException(String errorCode, String errorMessage, Throwable ex)
	{
		super(ex);
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
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
