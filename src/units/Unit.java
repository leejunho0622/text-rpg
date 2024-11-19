package units;

import java.util.Random;

import items.Item;

public abstract class Unit{
	public static Random ran = new Random();
	
	private String name;
	private String job;
	
	private int level;
	private int hp;
	private int maxHp;
	private int mp;
	private int maxMp;
	private int damage;
	private int crit;
	private int def;
	private int exp;
	
	private boolean party;
	
	private Item weapon;
	private Item armor;
	private Item artifact;
	
	private int damageBonus;
	private int armorBonus;
	private int hpBonus;
	private int mpBonus;
	
	public Unit(String name, String job, int hp, int mp, int damage, int def, int crit, boolean party) {
		this.name = name;
		this.job = job;
		this.level = 1;
		this.hp = hp;
		this.maxHp = hp;
		this.mp = mp;
		this.maxMp = mp;
		this.damage = damage;
		this.def = def;
		this.exp = 0;
		this.crit = crit;
		this.party = party;
	}

	public Unit(String name, int level, int hp, int damage, int def) {
		this.name = name;
		this.level = level;
		this.hp = hp;
		this.maxHp = hp;
		this.damage = damage;
		this.def = def;
	}
	
	public boolean isParty() {
		return this.party;
	}
	
	public void setParty() {
		this.party = !party;
	}
	
	public void setHp(int hp) {
		this.hp = hp;
	}
	
	public void setExp(int exp) {
		this.exp = exp;
	}
	
	public void decreaseHp(int hp) {
		this.hp -= hp;
	}
	
	public void decreaseMp(int mp) {
		this.mp -= mp;
	}
	
	public void decreaseMaxHp(int maxHp) {
		this.maxHp -= maxHp;
	}
	
	public void decreaseMaxMp(int maxMp) {
		this.maxMp -= maxMp;
	}
	
	public void increaseExp(int exp) {
		this.exp += exp;
	}
	
	public void increaseHp(int hp) {
		this.hp += hp;
	}
	
	public void increaseMp(int mp) {
		this.mp += mp;
	}
	
	public void increaseMaxHp(int maxHp) {
		this.maxHp += maxHp;
	}
	
	public void increaseMaxMp(int maxMp) {
		this.maxMp += maxMp;
	}
	
	public void increaseDamage(int damage) {
		this.damage += damage;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getJob() {
		return this.job;
	}
	
	public int getLevel() {
		return this.level;
	}
	
	public int getExp() {
		return this.exp;
	}
	
	public int getHp() {
		return this.hp + hpBonus;
	}
	
	public int getMp() {
		return this.mp + mpBonus;
	}
	
	public int getMaxHp() {
		return this.maxHp + hpBonus;
	}
	
	public int getMaxMp() {
		return this.maxMp + mpBonus;
	}
	
	public int getDamage() {
		return this.damage + damageBonus;
	}
	
	public int getDef() {
		return this.def + armorBonus;
	}
	
	public int getCrit() {
		return this.crit;
	}
}
