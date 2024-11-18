package stages;

import java.util.ArrayList;
import units.Player;

public class Guild extends Stage{
	private static ArrayList<Player> guildList = new ArrayList<Player>();
	private static ArrayList<Player> partyList = new ArrayList<Player>();
	
	@Override
	public void init() {
		partyList.clear();
		if(!guildList.isEmpty()) {
			for(int i=0; i<guildList.size(); i++) {
				if(guildList.get(i).isParty())
					partyList.add(guildList.get(i));
			}
		}
	}
	
	public static void addGuildPlayer(Player player) {
		guildList.add(player);
	}
	
	@Override
	public void start() {
		init();
	}
	
}
