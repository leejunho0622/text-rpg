package units;

import java.util.ArrayList;

import interfaces.IOManager;

public class Player extends Unit{
	public Player(String name, String job, int hp, int mp, int damage, int def, int crit, boolean party) {
		super(name, job, hp, mp, damage, def, crit, party);
	}
	
	@Override
	public String toString() {
		return String.format("[%s][%s][Lv. %d]\n[HP:%d/%d][MP:%d/%d][%s:%d][%s:%d]", getName(), getJob(), getLevel(), getHp(), getMaxHp(), getMp(), getMaxMp(), "⚔️", getDamage(), "🛡️", getDef());
	}
	
	private int calculateDamage(Monster target, int critRate) {
		int att = getDamage() - target.getDef();
		if (att <= 0)
			att = 1;
		int rate = ran.nextInt(100) + 1;
		if (rate <= getCrit() + critRate)
			att *= 2;
		return att;
	}

	public void skillAttack(Monster target, int damage) {
		String textTitle = String.format("\n%s에게 %d의 데미지!\n", target.getName(), damage);
		IOManager.append(textTitle);
		target.decreaseHp(damage);
		if (target.getHp() <= 0)
			target.setHp(0);
	}

	public void attack(Monster target) {
		int att = calculateDamage(target, 0);
		String textTitle = String.format("\n%s에게 %d의 데미지!\n", target.getName(), att);
		IOManager.append(textTitle);
		target.decreaseHp(att);
		if (target.getHp() <= 0)
			target.setHp(0);
	}

	public void skill(ArrayList<Monster> monsterList) {
		if (getJob().equals("전사")) {
			Monster target = monsterList.get(ran.nextInt(monsterList.size()));
			int att = calculateDamage(target, 0) * 2;
			skillAttack(target, att);
		} else if (getJob().equals("궁수")) {
			for (int i = 0; i < 2; i++) {
				Monster target = monsterList.get(ran.nextInt(monsterList.size()));
				int att = calculateDamage(target, getCrit());
				skillAttack(target, att);
			}

		} else if (getJob().equals("마법사")) {
			for (int i = 0; i < monsterList.size(); i++) {
				Monster target = monsterList.get(ran.nextInt(monsterList.size()));
				int att = calculateDamage(target, 0);
				skillAttack(target, att);
			}
		}

	}
}
