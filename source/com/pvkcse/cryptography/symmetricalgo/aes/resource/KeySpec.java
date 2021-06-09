package com.pvkcse.cryptography.symmetricalgo.aes.resource;

import com.pvkcse.cryptography.symmetricalgo.aes.resource.enums.KeySize;

public class KeySpec
{
	private KeySize keySize;

	private boolean canGenerateKeyFromPassword;

	private String password;

	public static final class Builder
	{
		private KeySize keySize;
		private boolean canGenerateKeyFromPassword;
		private String password;

		private Builder()
		{
		}

		public static Builder aKeySpec()
		{
			return new Builder();
		}

		public Builder withKeySize(KeySize keySize)
		{
			this.keySize = keySize;
			return this;
		}

		public Builder withCanGenerateKeyFromPassword(boolean canGenerateKeyFromPassword)
		{
			this.canGenerateKeyFromPassword = canGenerateKeyFromPassword;
			return this;
		}

		public Builder withPassword(String password)
		{
			this.password = password;
			return this;
		}

		public KeySpec build()
		{
			KeySpec keySpec = new KeySpec();
			keySpec.canGenerateKeyFromPassword = this.canGenerateKeyFromPassword;
			keySpec.keySize = this.keySize;
			keySpec.password = this.password;
			return keySpec;
		}
	}
}
