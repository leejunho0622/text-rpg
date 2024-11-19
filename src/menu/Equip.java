package menu;

import interfaces.IOManager;
import units.Info;
import units.Player;

public class Equip implements IOManager{
	private Guild guild = Guild.getInstance();
	private Shop list = Shop.getInstance();
	
	private Player printEquipMenu() {
		guild.printPartyPlayerList();
		String textTitle = String.format("장비를 착용할 파티원 번호 입력 >> \n");
		IOManager.append(textTitle);
		try {
			String input = reader.readLine();
			int select = Integer.parseInt(input);
			return guild.getPartyPlayerByIndex(select);
		} catch (Exception e) {}
		return null;
	}
	
	private void equipMenu(Player player) {
		list.printItem(Info.inventory);
		String textTitle = String.format("적용할 아이템 선택 >> \n");
		IOManager.append(textTitle);
		
		try {
			String input = reader.readLine();
			int select = Integer.parseInt(input);
			if (select >= 0 && select < Info.inventory.size()) {
				Info.inventory.get(select);
			}
		} catch (Exception e) {}
	}
	
	
	public void start() {
		equipMenu(printEquipMenu());
	}
}
