package textrpg;

import java.util.HashMap;

import interfaces.IOManager;
import stages.Stage;
import stages.TitleStage;
import stages.LobbyStage;
import stages.BattleStage;
import stages.AnyStage;

public class TextRPG implements IOManager{
	private TextRPG() {}
	private static TextRPG instance = new TextRPG();
	public static TextRPG getInstacne() {
		return instance;
	}
	
	private HashMap<String, Stage> stageList = new HashMap<String, Stage>();
	
	public static boolean playGame = true;
	public static String currnetStage = "";
	public static String beforeStage = "";
	
	private void init() {
		stageList.put("TITLE", new TitleStage());
		stageList.put("LOBBY", new LobbyStage());
		stageList.put("BATTLE", new BattleStage());
		stageList.put("ANY", new AnyStage());
		currnetStage = "TITLE";
	}
	
	private void changeStage() {
		String stageInfo = String.format("[ %s → %s ]\n", beforeStage, currnetStage);
		IOManager.append(stageInfo);
		Stage stage = stageList.get(currnetStage);
		beforeStage = currnetStage;
		stage.start();
	}
	
	public void run() {
		init();
		while(playGame) {
			changeStage();
		}
	}
}