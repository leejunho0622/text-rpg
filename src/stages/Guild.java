package stages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import interfaces.IOManager;
import textrpg.TextRPG;
import units.Info;
import units.Player;

public class Guild implements IOManager{
	private Guild() {}
	private static Guild instance = new Guild();
	public static Guild getInstance() {
		return instance;
	}
	
	private Random ran = new Random();
	
	private static ArrayList<Player> guildList = new ArrayList<Player>();
	private static ArrayList<Player> partyList = new ArrayList<Player>();
	
	public void updateParty() {
		partyList.clear();
		if(!guildList.isEmpty()) {
			for(int i=0; i<guildList.size(); i++) {
				if(guildList.get(i).isParty())
					partyList.add(guildList.get(i));
			}
		}
	}
	
	public void addGuildPlayer(Player player) {
		guildList.add(player);
	}
	
	public int getPartySize() {
		return partyList.size();
	}
	
	public int getGuildSize() {
		return guildList.size();
	}
	
	public Player getGuildPlayerByIndex(int index) {
		return guildList.get(index);
	}
	
	public Player getPartyPlayerByIndex(int index) {
		return partyList.get(index);
	}
	
	private void printGuildMain() {
		while(true) {
			try {
				String textTitle = String.format("====== Guild ====== [소지금 : %dG]\n[1. 길드원 영입]\t[2. 길드원 추방]\n[3. 파티 설정]\t[4. 파티 추방]\n[5. 프로필 확인]\t[0. 나가기]", Info.money);
				IOManager.append(textTitle);
				
				String input = reader.readLine();
				int select = Integer.parseInt(input);
				
				if (select == 1) {
					joinGuildPlayer();
				} else if (select == 2) {
					deleteGuildPlayer();
				} else if (select == 3) {
					setParty();
				} else if (select == 4) {
					deletePartyPlayer();
				} else if (select == 5) {
					checkGuildPlayer();
				} else if (select == 0) {
					TextRPG.currnetStage = "LOBBY";
					break;
				}
				
			}catch (Exception e) {}
		}
	}
	
	private Player pickPlayer() {
		String[] firstName = {"김","이","박","최","정","조","윤"};
		String[] lastName = {"서준","지호","주원","현우","민재","민성","서윤","서연","지우","민서","채원","수아","예린"};
		String name = firstName[ran.nextInt(firstName.length)] + lastName[ran.nextInt(lastName.length)];
		
		int pick = ran.nextInt(3);
		String job = "";
		
		if (pick == 0) {
			job = "전사";
		} else if (pick == 1) {
			job = "궁수";
		} else if (pick == 2) {
			job = "마법사";
		}
		
		int hp = ran.nextInt(3)+1;
		int mp = ran.nextInt(5)+1;
		int damage = ran.nextInt(5)+1;
		int def = ran.nextInt(5)+1;
		int crit = ran.nextInt(6)+5;
		
		return new Player(name, job, 1000 + hp*100, 50 + mp*10, 50 + damage*10, 50 + def*10, crit, false);
	}
	
	private void joinGuildPlayer() {
		if(Info.money < 5000) {
			String textTitle = String.format("소지금이 부족합니다.\n");
			IOManager.append(textTitle);
			return;
		}
		addGuildPlayer(pickPlayer());
	}

	private void deleteGuildPlayer() {
		String textTitle = String.format("===== Guild =====\n");
		for(int i=0; i<getGuildSize(); i++) {
			Player user = getGuildPlayerByIndex(i);
			textTitle += String.format("[No. %d][%s:%s][Lv.%d]\n", i+1, user.getName(), user.getJob(), user.getLevel());
			IOManager.append(textTitle);
		}
		textTitle += String.format("==================\n");
		textTitle += String.format("길드원 번호 입력 >>\n");
		IOManager.append(textTitle);
		
		try {
			String input = reader.readLine();
			int select = Integer.parseInt(input)-1;
			if(select >=1 && select <= getGuildSize())
		} catch (IOException e) {}
		
		
	}

	private void setParty() {
		
	}

	private void deletePartyPlayer() {
		
	}
	
	private void checkGuildPlayer() {
		
	}
	
	public void start() {
		updateParty();
		printGuildMain();
	}
	
}
