package app.cd_key_generator;

public class App {
	public static void main(String args[]) {
		int UN_ENCRYPTED_KEY_LENGTH = 12;
		int ENCRYPTED_KEY_LENGTH = 24;
		
		// Generate good cd key 1
		String goodCdKey_1 = CdKeyGenerator.generateKey(UN_ENCRYPTED_KEY_LENGTH);
		System.out.println("key 1, generate key: " + goodCdKey_1);
		// Encryption
		String encryptedGoodCdKey_1 = CdKeyEncriptor.encrypt(goodCdKey_1);
		System.out.println("key 1, encryption -> cd key: " + encryptedGoodCdKey_1);
		// Description
		String decriptedGoodCdKey_1 = CdKeyEncriptor.decrypt(encryptedGoodCdKey_1);
		// Validation
		boolean isValidCdKey_1 = CdKeyValidator.validateKey(decriptedGoodCdKey_1);
		System.out.println("key 1, validation: " + isValidCdKey_1);

		System.out.println("*********************************************");
		
		// Generate random cd key 2
		String randomCdKey_2 = CdKeyGenerator.generateRandomKey(ENCRYPTED_KEY_LENGTH);
		System.out.println("key 2, generate random cd key: " + randomCdKey_2);
		// Validation
		boolean isValidCdKey_2 = CdKeyValidator.validateKey(randomCdKey_2);
		System.out.println("key 2, validation: " + isValidCdKey_2);
	}
}
