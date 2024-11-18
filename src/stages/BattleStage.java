package stages;

import java.io.IOException;
import java.util.ArrayList;

import interfaces.IOManager;
import interfaces.MonsterManager;
import textrpg.TextRPG;
import units.Monster;

public class BattleStage extends Stage implements MonsterManager{
	private ArrayList<Monster> monsterList = new ArrayList<Monster>();
	
	@Override
	public void init() {
		TextRPG.currnetStage = "BATTLE";
	}
	
	private void setMonster() {
		int playerLevel = Guild.getGuildPlayerByIndex(0).getLevel();
		for(int i=0; i<Guild.getPartySize(); i++) {
			monsterList.add(MonsterManager.makeMonsters(playerLevel));
		}
	}
	
	private void printBattleMain() {
		String textTitle1 = String.format("====== Player ======\n");
		IOManager.append(textTitle1);
		for (int i = 0; i < Guild.getPartySize(); i++) {
			IOManager.append(Guild.getGuildPartyByIndex(i).toString()+"\n");
		}
		String textTitle2 = String.format("====== Monster ======\n");
		IOManager.append(textTitle2);
		for (int i = 0; i < monsterList.size(); i++) {
			IOManager.append(monsterList.get(i).toString()+"\n");
		}
	}
	
	@Override
	public void start() {
		setMonster();
		printBattleMain();
		try {
			String input = reader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
