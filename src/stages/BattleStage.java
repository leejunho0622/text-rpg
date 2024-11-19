package stages;

import java.util.ArrayList;

import interfaces.IOManager;
import interfaces.MonsterManager;
import textrpg.TextRPG;
import units.Info;
import units.Monster;
import units.Player;

public class BattleStage extends Stage implements MonsterManager{
	private ArrayList<Monster> monsterList = new ArrayList<Monster>();
	private Guild guild = Guild.getInstance();
	
	@Override
	public void init() {
		TextRPG.currnetStage = "BATTLE";
	}
	
	private void setMonster() {
		int playerLevel = guild.getGuildPlayerByIndex(ran.nextInt(guild.getPartySize())).getLevel();
		for(int i=0; i<guild.getPartySize(); i++) {
			monsterList.add(MonsterManager.makeMonsters(playerLevel));
		}
	}
	
	private void printBattleMain() {
		String textTitle1 = String.format("====== Player ======\n");
		IOManager.append(textTitle1);
		for (int i = 0; i < guild.getPartySize(); i++) {
			IOManager.append(guild.getPartyPlayerByIndex(i).toString()+"\n");
		}
		String textTitle2 = String.format("====== Monster ======\n");
		IOManager.append(textTitle2);
		for (int i = 0; i < monsterList.size(); i++) {
			IOManager.append(monsterList.get(i).toString()+"\n");
		}
	}
	
	private void attackMenu(Player player) {
		while (true) {
			try {
				String textTitle = String.format("[1.공격]\t[2.스킬]\n");
				IOManager.append(textTitle);

				String input = reader.readLine();
				int select = Integer.parseInt(input);
				
				if (select == 1) {
					int ranTarget = ran.nextInt(monsterList.size());
					player.attack(monsterList.get(ranTarget));
					break;
				} else if (select == 2) {
					player.skill(monsterList);
					break;
				}

			} catch (Exception e) {}
		}
	}
	
	private boolean checkHp() {
		int count = 0;
		for(int i=0; i<guild.getPartySize();i++) {
			if(guild.getPartyPlayerByIndex(i).getHp() <= 0)
				count++;
		}
		if(count == guild.getPartySize()) {
			String textTitle = String.format("파티는 전멸하였다.");
			IOManager.append(textTitle);
			return false;
		}
		
		for(int i=0; i<monsterList.size();i++) {
			if(monsterList.get(i).getHp() <= 0) {
				String textTitle = String.format("%s을(를) 처지했다!\n\n", monsterList.get(i).getName());
				IOManager.append(textTitle);
				reward(monsterList.get(i));
				monsterList.remove(i);
			}
		}
		if(monsterList.size() == 0) {
			String textTitle = String.format("몬스터를 전부 처지했다!\n\n");
			IOManager.append(textTitle);
			return false;
		}
		
		return true;
	}
	
	private void reward(Monster target) {
		int exp = 0;
		
		if(target.getName().equals("슬라임")) {
			exp = target.getLevel() * 2;
		}
		
		String textTitle1 = String.format("%d골드를 얻었다!\n", exp * 200);
		IOManager.append(textTitle1);
		String textTitle2 = String.format("파티원들의 경험치가 %d만큼 올랐다!\n\n", exp);
		IOManager.append(textTitle2);
		
		for(int i=0; i<guild.getPartySize(); i++) {
			guild.getPartyPlayerByIndex(i).increaseExp(exp);
			checkExp(guild.getPartyPlayerByIndex(i));
		}
		Info.money += exp * 200;
	}
	
	private void checkExp(Player player) {
		if(player.getExp() >= 10) {
			player.setExp(player.getExp()-10);
			player.levelUp();
		}
	}
	
	@Override
	public void start() {
		setMonster();
		while(checkHp()) {
			printBattleMain();
			for(int i=0; i<guild.getPartySize(); i++) {
				attackMenu(guild.getPartyPlayerByIndex(i));
			}
			System.out.println();
			for(int i=0; i<monsterList.size(); i++) {
				int ranTarget = ran.nextInt(guild.getPartySize());
				monsterList.get(i).attack(guild.getPartyPlayerByIndex(ranTarget));
			}
			System.out.println();
		}
		TextRPG.currnetStage = "LOBBY";
	}
}
