package stages;

import java.util.ArrayList;

import interfaces.IOManager;
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
	
	public static void updateParty() {
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
	
	public static int getPartySize() {
		return partyList.size();
	}
	
	public static Player getGuildPlayerByIndex(int index) {
		return guildList.get(index);
	}
	
	public static Player getPartyPlayerByIndex(int index) {
		return partyList.get(index);
	}
	
	private void printGuildMain() {
		String textTitle = String.format("====== Guild ====== [소지금 : %G]\n[길드원 영입]\t[길드원 추방]\n[파티 설정]\t[파티 추방]");
		IOManager.append(textTitle);
	}
	
	@Override
	public void start() {
		init();
		printGuildMain();
	}
	
}
