package change_return.app;

public class Item {
	private int tag;
	private String name;
	private double price;
	
	public Item(int tag, String name, double price) {
		this.tag = tag;
		this.name = name;
		this.price = price;
	}
	
	public int getTag() {
		return tag;
	}
	public void setTag(int tag) {
		this.tag = tag;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
}
