package stages;

import java.io.IOException;

import interfaces.IOManager;
import textrpg.TextRPG;
import units.Player;

public class LobbyStage extends Stage{
	@Override
	public void init() {
		TextRPG.currnetStage = "LOBBY";
	}

	public Player setUser() {
		try {
			String textTitle = String.format("====== TEXT RPG ======\n====== 직업 선택 ======\n[전사]\t[궁수]\t[마법사]\n");
			IOManager.append(textTitle);
			
			String input = reader.readLine();
			
			if(input.equals("전사")) {
				return new Player("플레이어", "전사", 1300, 100, 100, 100);
			}
			else if(input.equals("궁수")) {
				return new Player("플레이어", "궁수", 1150, 250, 130, 70);
			}
			else if(input.equals("마법사")) {
				return new Player("플레이어", "마법사", 1000, 400, 170, 30);
			}
			
		} catch (IOException e) {}
		return setUser();
	}
	
	@Override
	public void start() {
		Guild.guildList.add(setUser());
		while(true) {
			try {
				String textTitle = String.format("====== TEXT RPG ======\n[전투]\t[정보]\t[상점]\n[길드]\n");
				IOManager.append(textTitle);
				
				String input = reader.readLine();
				
				if (input.equals("전투")) {
					TextRPG.currnetStage = "BATTLE";
					break;
				}else if(input.equals("정보")) {
					TextRPG.currnetStage = "ANY";
					AnyStage.type = "INFO";
					break;
				}else if(input.equals("상점")) {
					TextRPG.currnetStage = "ANY";
					AnyStage.type = "SHOP";
					break;
				}
				
			}catch (Exception e) {}
		}
	}
}