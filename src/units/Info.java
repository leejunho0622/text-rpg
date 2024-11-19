package units;

import interfaces.IOManager;
import stages.Guild;
import textrpg.TextRPG;

public class Info implements IOManager{
	private Info() {}
	
	public static Info instance = new Info();
	public static int money;
	
	private Guild guild = Guild.getInstance();
	
	public static Info getInstance() {
		return instance;
	}
	
	private void printInfo() {
		String info = "";
		info += String.format("\n======= 파티원 ======\n");
		info += String.format("[소지금 : %d]\n", money);
		for(int i=0; i<guild.getPartySize(); i++) {
			Player user = guild.getPartyPlayerByIndex(i);
			info += String.format("[No. %d]\n[이름 : %s] [직업 : %s]\n", i+1, user.getName(), user.getJob());
			info += String.format("[Level : %d] [EXP : %d]\n",user.getLevel(), user.getExp());
			info += String.format("[HP : %d/%d] [MP : %d/%d]\n", user.getHp(), user.getMaxHp(), user.getMp(), user.getMaxMp());
			info += String.format("[⚔️ : %d] [🛡️ : %d] [💥 : %d]\n", user.getDamage(), user.getDef(), user.getCrit());
		}
		info += String.format("===================\n\n");
		IOManager.append(info);
	}
	
	public void start() {
		printInfo();
		TextRPG.currnetStage = "LOBBY";
	}
}
