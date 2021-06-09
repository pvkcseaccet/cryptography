package com.pvkcse.cryptography.symmetricalgo.aes.resource.enums;

public enum AESMode
{

	CTR("CTR", "Counter Mode"),
	CBC("CBC", "Cipher Block Chaining Mode"),
	ECB("ECB", "Electronic Cook Book Mode"),
	CFB("CFB", "Cipher FeedBack Mode"),
	OFB("OFB", "Output FeedBack Mode"),
	GCM("GCM", "Gallois/Counter Mode");

	private String name;

	private String formattedName;

	AESMode(String name, String formattedName)
	{
		this.name = name;
		this.formattedName = formattedName;
	}

	public String getName()
	{
		return name;
	}

	public String getFormattedName()
	{
		return formattedName;
	}

}
