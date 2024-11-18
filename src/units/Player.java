package units;

import interfaces.IOManager;

public class Player extends Unit{
	public Player(String name, String job, int hp, int mp, int damage, int def, boolean party) {
		super(name, job, hp, mp, damage, def, party);
	}
	
	@Override
	public String toString() {
		return String.format("[%s][%s][Lv. %d]\n[HP:%d/%d][MP:%d/%d][%s:%d][%s:%d]", getName(), getJob(), getLevel(), getHp(), getMaxHp(), getMp(), getMaxMp(), "⚔️", getDamage(), "🛡️", getDef());
	}
	
	public void attack(Monster target) {
		int att = getDamage() - target.getDef();
		String textTitle = String.format("\n%s에게 %d의 데미지!\n\n", target.getName(), att);
		IOManager.append(textTitle);
		target.decreaseHp(att);
		if(target.getHp() <= 0)
			target.setHp(0);
	}
}
