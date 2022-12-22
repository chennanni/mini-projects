import java.security.SecureRandom;

public class CdKeyGenerator {
	
	static final String BASESTRING = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	static SecureRandom rnd = new SecureRandom();
	
	// this method comes from 'maxp' of StackOverFlow
	private static String generateRandomString(int len) {
		StringBuilder sb = new StringBuilder(len);
		for (int i = 0; i < len; i++)
			sb.append(BASESTRING.charAt(rnd.nextInt(BASESTRING.length())));
		return sb.toString();
	}
	
	private static String generateWholeString(String randomString) {
		int x = 3;
		for (int i=0; i<randomString.length(); i++) {
			x += (2 * x) ^ randomString.charAt(i);
		}
		return randomString + (x%10);
	}
	public static String generateKey(int length) {
		// first, generate n-1 String
		// then, generate the last char and put all together
		String key = generateWholeString(generateRandomString(length-1));
		CdKeyDatabase db = CdKeyDatabase.getCdKeyDatabase();
		db.insertNewKey(key);
		return key;
	}
	public static String generateRandomKey(int length) {
		return generateRandomString(length);
	}
}
