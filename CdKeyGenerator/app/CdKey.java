package app.cd_key_generator;

public class CdKey {
	private int id;
	private String key;
	private boolean isActive;
	
	public CdKey(int id, String key, boolean isActive) {
		this.id = id;
		this.key = key;
		this.isActive = isActive;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
}
