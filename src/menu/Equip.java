package menu;

import interfaces.IOManager;
import items.Item;
import textrpg.TextRPG;
import units.Info;
import units.Player;

public class Equip implements IOManager{
	private Equip() {}
	public static Equip instance = new Equip();
	public static Equip getInstance() {
		return instance;
	}
	
	private Guild guild = Guild.getInstance();
	private Shop list = Shop.getInstance();
	
	private Player printEquipMenu() {
		guild.printPartyPlayerList();
		try {
			String input = reader.readLine();
			int select = Integer.parseInt(input)-1;
			return guild.getPartyPlayerByIndex(select);
		} catch (Exception e) {}
		return null;
	}
	
	private void equip(Player player) {
		list.printItem(Info.inventory);
		String textTitle = String.format("적용할 아이템 선택 >> \n");
		IOManager.append(textTitle);
		
		Item selectItem = null;
		try {
			String input = reader.readLine();
			int select = Integer.parseInt(input)-1;
			if (select >= 0 && select < Info.inventory.size()) {
				selectItem = Info.inventory.get(select);
			}
			Item weaponSlot = player.equipmentSlots[0];
			Item armorSlot = player.equipmentSlots[1];
			Item artifactSlot = player.equipmentSlots[2];
			
			if (selectItem.getType().equals("Weapon") && weaponSlot == null) {
				weaponSlot = selectItem;
			}
			else if (selectItem.getType().equals("Armor") && armorSlot == null) {
				armorSlot = selectItem;
			}
			else if (selectItem.getType().equals("Artifact") && artifactSlot == null) {
				artifactSlot = selectItem;
			} else {
				textTitle = String.format("이미 장비를 장착중입니다.\n");
				IOManager.append(textTitle);
			}
			player.setItem(selectItem);
			Info.inventory.remove(selectItem);
			
			textTitle = String.format("장비장착 성공!\n");
			IOManager.append(textTitle);
		} catch (Exception e) {}
	}
	
	private void equipManager() {
		Player user = printEquipMenu();
		equip(user);
		TextRPG.currnetStage = "LOBBY";
	}
	
	public void start() {
		equipManager();
	}
}
