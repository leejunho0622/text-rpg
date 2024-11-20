package stages;

import menu.Equip;
import menu.Guild;
import menu.Shop;
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
		if (type.equals("INFO")) {
			Info info = Info.getInstance();
			info.start();
		} else if (type.equals("EQUIP")) {
			Equip equip = Equip.getInstance();
			equip.start();
		} else if (type.equals("SHOP")) {
			Shop shop = Shop.getInstance();
			shop.start();
		} else if (type.equals("GUILD")) {
			Guild guild = Guild.getInstance();
			guild.start();
		}
	}
}
