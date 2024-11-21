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
	
	private void printEquipMenu() {
		String textTitle = String.format("[1. 착용][2. 해제]");
		IOManager.append(textTitle);
		try {
			String input = reader.readLine();
			int select = Integer.parseInt(input);
			
			if(select == 1) {
				equip();
			}else if(select == 2) {
				disEquip();
			}
		} catch (Exception e) {}
		
	}
	
	private void equip() {
		guild.printPartyPlayerList();
		int select = 0;
		try {
			String input = reader.readLine();
			select = Integer.parseInt(input)-1;
		} catch (Exception e) {}
		Player player = guild.getPartyPlayerByIndex(select);
		
		list.printItem(Info.inventory);
		String textTitle = String.format("적용할 아이템 선택 >> \n");
		IOManager.append(textTitle);
		
		Item selectItem = null;
		try {
			String input = reader.readLine();
			select = Integer.parseInt(input)-1;
			if (select >= 0 && select < Info.inventory.size()) {
				selectItem = Info.inventory.get(select);
			}
			Item weaponSlot = player.equipmentSlots[0];
			Item armorSlot = player.equipmentSlots[1];
			Item artifactSlot = player.equipmentSlots[2];
			
			if (selectItem.getType().equals("Weapon") && weaponSlot == null) {
				weaponSlot = selectItem;
			} else if (selectItem.getType().equals("Armor") && armorSlot == null) {
				armorSlot = selectItem;
			} else if (selectItem.getType().equals("Artifact") && artifactSlot == null) {
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
	
	private void disEquip() {
		guild.printPartyPlayerList();
		int select = 0;
		try {
			String input = reader.readLine();
			select = Integer.parseInt(input)-1;
		} catch (Exception e) {}
		Player player = guild.getPartyPlayerByIndex(select);
		Info.printPlayerEquipment(player);
		try {
			String textTitle = String.format("슬롯 입력 >> \n");
			IOManager.append(textTitle);
			String input = reader.readLine();
			select = Integer.parseInt(input)-1;
			if(select >= 0 && select < player.equipmentSlots.length) {
				Item temp = player.equipmentSlots[select];
				Info.inventory.add(temp);
				temp = null;
				textTitle = String.format("장비 해제 성공! >> \n");
				IOManager.append(textTitle);
			}
				
		} catch (Exception e) {}
	}
	
	private void equipManager() {
		printEquipMenu();
		equip();
		TextRPG.currnetStage = "LOBBY";
	}
	
	public void start() {
		equipManager();
	}
}
