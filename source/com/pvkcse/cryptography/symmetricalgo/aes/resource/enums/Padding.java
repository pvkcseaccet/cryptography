package com.pvkcse.cryptography.symmetricalgo.aes.resource.enums;

public enum Padding
{
	PKCS5("PKCS5"),
	PKCS7("PKCS7"),
	NOPADDING("NOPADDING");

	private String name;

	Padding(String name)
	{
		this.name = name;
	}

	public String getName()
	{
		return name;
	}
}
