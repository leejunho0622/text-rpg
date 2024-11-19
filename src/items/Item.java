package items;

public class Item {
	private String name;
	private String type;
	private int damageBonus;
	private int armorBonus;
	private int hpBonus;
	private int mpBonus;
	private int price;
	private boolean state;
	
	public Item(String name, String type, int damageBonus, int armorBonus, int hpBonus, int mpBonus, int price) {
		this.name = name;
		this.type = type;
		this.damageBonus = damageBonus;
		this.armorBonus = armorBonus;
		this.hpBonus = hpBonus;
		this.mpBonus = mpBonus;
		this.price = price;
		this.state = false;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getType() {
		return this.type;
	}
	
	public int getDamageBonus() {
		return this.damageBonus;
	}
	
	public int getArmorBonus() {
		return this.armorBonus;
	}
	
	public int getHpBonus() {
		return this.hpBonus;
	}
	
	public int getMpBonus() {
		return this.mpBonus;
	}
	
	public int getPrice() {
		return this.price;
	}
}
