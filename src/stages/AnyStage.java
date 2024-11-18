package stages;

import textrpg.TextRPG;

public class AnyStage extends Stage{
	public static String type;
	
	@Override
	public void init() {
		TextRPG.currnetStage = "ANY";
	}

	@Override
	public void start() {
		if(type.equals("INFO")) {}
		else if(type.equals("SHOP")) {}
		else if(type.equals("GUILD")) {
			
		}
	}
}
