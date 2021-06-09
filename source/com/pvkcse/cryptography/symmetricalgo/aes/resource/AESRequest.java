package com.pvkcse.cryptography.symmetricalgo.aes.resource;

import com.pvkcse.cryptography.symmetricalgo.aes.resource.enums.AESMode;
import com.pvkcse.cryptography.symmetricalgo.aes.resource.enums.Encoder;
import com.pvkcse.cryptography.symmetricalgo.aes.resource.enums.Padding;

public class AESRequest
{
	private String key;

	private String plaintText;

	private AESMode aesMode;

	private Padding padding;

	private Encoder encoder;

	private AESRequest()
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

	public static final class Builder
	{
		private String key;
		private String plaintText;
		private AESMode aesMode;
		private Padding padding;
		private Encoder encoder;

		private Builder()
		{
		}

		public static Builder anAESRequest()
		{
			return new Builder();
		}

		public Builder withKey(String key)
		{
			this.key = key;
			return this;
		}

		public Builder withPlaintText(String plaintText)
		{
			this.plaintText = plaintText;
			return this;
		}

		public Builder withAesMode(AESMode aesMode)
		{
			this.aesMode = aesMode;
			return this;
		}

		public Builder withPadding(Padding padding)
		{
			this.padding = padding;
			return this;
		}

		public Builder withEncoder(Encoder encoder)
		{
			this.encoder = encoder;
			return this;
		}

		public AESRequest build()
		{
			AESRequest aESRequest = new AESRequest();
			aESRequest.padding = this.padding;
			aESRequest.key = this.key;
			aESRequest.encoder = this.encoder;
			aESRequest.plaintText = this.plaintText;
			aESRequest.aesMode = this.aesMode;
			return aESRequest;
		}
	}
}
