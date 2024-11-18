package stages;

import interfaces.IOManager;
import textrpg.TextRPG;

public class TitleStage extends Stage{
	@Override
	public void init() {
		TextRPG.currnetStage = "TITLE";
	}

	@Override
	public void start() {
		while (true) {
			try {
			String textTitle = String.format("=== TEXT RPG ===\n[1. 시작]\t[2. 종료]\n");
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
	}
}