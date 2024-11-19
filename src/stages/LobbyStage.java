package stages;

import interfaces.IOManager;
import textrpg.TextRPG;

public class LobbyStage extends Stage {
	@Override
	public void init() {
		TextRPG.currnetStage = "LOBBY";
	}

	@Override
	public void start() {
		while (true) {
			try {
				String textTitle = String.format("====== TEXT RPG ======\n[전투]\t[정보]\t[장비]\n[상점]\t[길드]\n");
				IOManager.append(textTitle);

				String input = reader.readLine();

				if (input.equals("전투")) {
					TextRPG.currnetStage = "BATTLE";
					break;
				} else if (input.equals("정보")) {
					TextRPG.currnetStage = "ANY";
					AnyStage.type = "INFO";
					break;
				} else if (input.equals("장비")) {
					TextRPG.currnetStage = "ANY";
					AnyStage.type = "EQUIP";
					break;
				} else if (input.equals("상점")) {
					TextRPG.currnetStage = "ANY";
					AnyStage.type = "SHOP";
					break;
				} else if (input.equals("길드")) {
					TextRPG.currnetStage = "ANY";
					AnyStage.type = "GUILD";
					break;
				}

			} catch (Exception e) {
			}
		}
	}
}