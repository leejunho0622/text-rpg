package units;

import items.Item;

public abstract class Unit{
	private String name;
	private String job;
	
	private int level;
	private int hp;
	private int maxHp;
	private int mp;
	private int maxMp;
	private int damage;
	private int def;
	private int exp;
	
	private boolean party;
	
	private Item weapon;
	private Item armor;
	private Item artifact;
	
	private int damageBouns;
	private int armorBouns;
	private int hpBouns;
	private int mpBouns;
	
	public Unit(String name, String job, int level, int hp, int mp, int damage, int def, int exp) {
		this.name = name;
		this.job = job;
		this.level = level;
		this.hp = hp;
		this.maxHp = hp;
		this.mp = mp;
		this.maxMp = mp;
		this.damage = damage;
		this.def = def;
		this.exp = exp;
	}

	public Unit(String name, String job, int level, int hp, int damage, int def) {
		this.name = name;
		this.job = job;
		this.level = level;
		this.hp = hp;
		this.maxHp = hp;
		this.damage = damage;
		this.def = def;
	}
}
