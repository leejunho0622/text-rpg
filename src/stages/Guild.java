package stages;

import java.util.ArrayList;
import units.Player;

public class Guild extends Stage{
	public static ArrayList<Player> guildList = new ArrayList<Player>();
	public static ArrayList<Player> partyList = new ArrayList<Player>();
	
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
	
	@Override
	public void start() {
		init();
	}
	
}
