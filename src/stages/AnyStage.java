package stages;

import textrpg.TextRPG;
import units.Info;

public class AnyStage extends Stage{
	public static String type;
	
	
			
	@Override
	public void init() {
		TextRPG.currnetStage = "ANY";
	}

	@Override
	public void start() {
		if(type.equals("INFO")) {
			Info info = Info.getInstance();
			info.start();
		}
		else if(type.equals("SHOP")) {}
		else if(type.equals("GUILD")) {
			Guild guild = Guild.getInstance();
			guild.start();
		}
	}
}
