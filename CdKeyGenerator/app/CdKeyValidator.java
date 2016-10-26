package app.cd_key_generator;

public class CdKeyValidator {
	public static boolean validateKey(String key) {
		CdKeyDatabase db = CdKeyDatabase.getCdKeyDatabase();
		if (db.validateIsKeyActive(key)) {
			String partOfKey = key.substring(0, key.length()-1);
			int x = 3;
			for (int i=0; i<partOfKey.length(); i++) {
				x += (2 * x) ^ partOfKey.charAt(i);
			}
			if (x%10 == key.charAt(key.length()-1)-'0') {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
}
