package app.cd_key_generator;

import java.util.HashMap;

public class CdKeyDatabase {
	
	private static CdKeyDatabase dbInstance;
	private int globalUniqueId;
	private HashMap<String, CdKey> dbMap;
	
	private CdKeyDatabase() {
		this.globalUniqueId = 0;
		this.dbMap = new HashMap<String, CdKey>();
	}
	
	public static CdKeyDatabase getCdKeyDatabase() {
		if (dbInstance == null) {
			dbInstance = new CdKeyDatabase();
		}
		return dbInstance;
	}
	
	public boolean insertNewKey(String key) {
		if (!dbMap.containsKey(key)) {
			CdKey newKey = new CdKey(globalUniqueId++, key, true);
			dbMap.put(key, newKey);
			return true;
		} else {
			return false;
		}
	}
	
	public boolean validateIsKeyActive(String key) {
		if (dbMap.containsKey(key) && dbMap.get(key).isActive()){
			return true;
		} else {
			return false;
		}
	}
	
	public boolean activateKey(String key) {
		if (dbMap.containsKey(key)) {
			dbMap.get(key).setActive(true);
			return true;
		} else {
			return false;
		}
	}
	
	public boolean deActivateKey(String key) {
		if (dbMap.containsKey(key)) {
			dbMap.get(key).setActive(false);
			return true;
		} else {
			return false;
		}
	}
}
