package com.pvkcse.cryptography.symmetricalgo.aes.resource.enums;

public enum Encoder
{

	BASE64("BASE64"),
	BASE62("BASE62"),
	HEX("HEX");

	private String name;

	Encoder(String name)
	{
		this.name = name;
	}

	public String getName()
	{
		return name;
	}
}
