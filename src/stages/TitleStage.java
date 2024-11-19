package stages;

import java.io.IOException;

import interfaces.IOManager;
import textrpg.TextRPG;
import units.Player;

public class TitleStage extends Stage{
	private Guild guild = Guild.getInstance();
	
	@Override
	public void init() {
		TextRPG.currnetStage = "TITLE";
	}
	
	public Player setUser() {
		try {
			String textTitle = String.format("====== TEXT RPG ======\n======= 직업 선택 =======\n[전사]\t[궁수]\t[마법사]\n");
			IOManager.append(textTitle);
			
			String input = reader.readLine();
			
			if(input.equals("전사")) {
				return new Player("플레이어", "전사", 1300, 100, 100, 100, 5, true);
			}
			else if(input.equals("궁수")) {
				return new Player("플레이어", "궁수", 1150, 250, 130, 70, 20, true);
			}
			else if(input.equals("마법사")) {
				return new Player("플레이어", "마법사", 1000, 400, 170, 30, 10, true);
			}
			
		} catch (IOException e) {}
		return setUser();
	}
	
	@Override
	public void start() {
		while (true) {
			try {
			String textTitle = String.format("=== TEXT RPG ===\n[시작]\t[종료]\n");
			IOManager.append(textTitle);
			
			String input = reader.readLine();
			
			if (input.equals("시작")) {
				TextRPG.currnetStage = "LOBBY";
				break;
			}else if(input.equals("종료")) {
				TextRPG.playGame = false;
				break;
			}
			
			}catch (Exception e) {}
		}
		guild.addGuildPlayer(setUser());
		guild.updateParty();
	}
}