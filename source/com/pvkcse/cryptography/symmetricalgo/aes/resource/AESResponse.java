package com.pvkcse.cryptography.symmetricalgo.aes.resource;

import com.pvkcse.cryptography.symmetricalgo.aes.resource.enums.AESMode;
import com.pvkcse.cryptography.symmetricalgo.aes.resource.enums.Encoder;
import com.pvkcse.cryptography.symmetricalgo.aes.resource.enums.Padding;

public class AESResponse
{
	private String key;

	private String plaintText;

	private AESMode aesMode;

	private Padding padding;

	private Encoder encoder;

	private String cipher;

	private AESResponse()
	{

	}

	public String getKey()
	{
		return key;
	}

	public String getPlaintText()
	{
		return plaintText;
	}

	public AESMode getAesMode()
	{
		return aesMode;
	}

	public Padding getPadding()
	{
		return padding;
	}

	public Encoder getEncoder()
	{
		return encoder;
	}

	public String getCipher()
	{
		return cipher;
	}

	public static final class Builder
	{
		private String key;
		private String plaintText;
		private AESMode aesMode;
		private Padding padding;
		private Encoder encoder;
		private String cipher;

		private Builder()
		{
		}

		public static AESResponse.Builder anAESResponse()
		{
			return new AESResponse.Builder();
		}

		public AESResponse.Builder withKey(String key)
		{
			this.key = key;
			return this;
		}

		public AESResponse.Builder withPlaintText(String plaintText)
		{
			this.plaintText = plaintText;
			return this;
		}

		public AESResponse.Builder withCipher(String cipher)
		{
			this.cipher = cipher;
			return this;
		}

		public AESResponse.Builder withAesMode(AESMode aesMode)
		{
			this.aesMode = aesMode;
			return this;
		}

		public AESResponse.Builder withPadding(Padding padding)
		{
			this.padding = padding;
			return this;
		}

		public AESResponse.Builder withEncoder(Encoder encoder)
		{
			this.encoder = encoder;
			return this;
		}

		public AESResponse build()
		{
			AESResponse aesResponse = new AESResponse();
			aesResponse.padding = this.padding;
			aesResponse.key = this.key;
			aesResponse.encoder = this.encoder;
			aesResponse.plaintText = this.plaintText;
			aesResponse.aesMode = this.aesMode;
			aesResponse.cipher = this.cipher;
			return aesResponse;
		}
	}
}
