package com.pvkcse.cryptography.symmetricalgo.aes.resource.enums;

public enum KeySize
{
	BITS_128(128, "AES 128"),
	BITS_192(192, "AES 128"),
	BITS_256(256, "AES 128");

	int size;
	String name;

	KeySize(int size, String name)
	{
		this.size = size;
		this.name = name;
	}

	public int getSize()
	{
		return size;
	}

	public String getName()
	{
		return name;
	}
}
