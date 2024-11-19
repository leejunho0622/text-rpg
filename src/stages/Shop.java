package stages;

import java.util.ArrayList;
import java.util.Random;

import interfaces.IOManager;
import items.Item;
import units.Info;

public class Shop implements IOManager {
	private Shop() {
	}

	public static Shop instance = new Shop();

	public static Shop getInstance() {
		return instance;
	}

	private Random ran = new Random();

	private String[] prefix = { "낡은", "평범한", "굉장한" };

	private ArrayList<Item> shop = new ArrayList<Item>();

	private String name;
	private String type;

	private void makeEquipment() {
		for (int i = 0; i < 5; i++) {
			int damageBonus = 0;
			int armorBonus = 0;
			int hpBonus = 0;
			int mpBonus = 0;

			int rType = ran.nextInt(3);
			int status = ran.nextInt(3);
			String prefix = this.prefix[status];
			if (rType == 0) {
				type = "Weapon";
				name = prefix + " 무기";
				damageBonus = (status + 1) * 10;
			} else if (rType == 1) {
				type = "Armor";
				name = prefix + " 갑옷";
				armorBonus = (status + 1) * 5;
				hpBonus = (status + 1) * 150;
			} else if (rType == 2) {
				type = "Artifact";
				name = prefix + " 아티팩트";
				int option = ran.nextInt(4);
				if (option == 0) {
					damageBonus = (status + 1) * 20;
				} else if (option == 1) {
					armorBonus = (status + 1) * 10;
				} else if (option == 2) {
					hpBonus = (status + 1) * 100;
				} else if (option == 3) {
					mpBonus = (status + 1) * 10;
				}
			}
			shop.add(new Item(name, type, damageBonus, armorBonus, hpBonus, mpBonus, (status + 1) * 2000));
		}
	}

	private void printItem(ArrayList<Item> list) {
		String textTitle = String.format("====== SHOP ======\n");
		for (int i = 0; i < list.size(); i++) {
			Item equipment = list.get(i);
			textTitle += String.format("[No.%d]\n[%s][%dG]\n", i + 1, equipment.getName(), equipment.getPrice());
			if (equipment.getDamageBonus() > 0)
				textTitle += String.format("[⚔️:%d]\n", equipment.getDamageBonus());
			if (equipment.getArmorBonus() > 0)
				textTitle += String.format("[🛡️:%d]\n", equipment.getArmorBonus());
			if (equipment.getHpBonus() > 0)
				textTitle += String.format("[HP:+%d]\n", equipment.getHpBonus());
			if (equipment.getMpBonus() > 0)
				textTitle += String.format("[MP:+%d]\n", equipment.getMpBonus());
			if (i < list.size() - 1)
				textTitle += String.format("------------------\n");
		}
		textTitle += String.format("==================\n");
		IOManager.append(textTitle);
	}

	private void buyItem() {
		printItem(shop);
		try {
			String textTitle = String.format("구매할 아이템 번호 입력 >> \n");
			IOManager.append(textTitle);

			String input = reader.readLine();
			int select = Integer.parseInt(input);

			Item item = shop.get(select);

			if (select >= 0 && select < shop.size()) {
				if (Info.money >= item.getPrice()) {
					Info.inventory.add(item);
					Info.money -= item.getPrice();
					textTitle = String.format("구매 성공 !\n");
					IOManager.append(textTitle);
				} else {
					textTitle = String.format("소지금이 부족합니다.\n");
					IOManager.append(textTitle);
				}
			}
		} catch (Exception e) {
		}
	}

	private void sellItem() {
		printItem(Info.inventory);
		try {
			String textTitle = String.format("판매할 아이템 번호 입력 >> \n");
			IOManager.append(textTitle);

			String input = reader.readLine();
			int select = Integer.parseInt(input);

			Item item = Info.inventory.get(select);

			if (select >= 0 && select < Info.inventory.size()) {
				Info.inventory.remove(select);
				Info.money += item.getPrice();
				textTitle = String.format("판매 성공 !\n");
				IOManager.append(textTitle);
			}
		} catch (Exception e) {
		}
	}

	private void printShopMenu() {
		while (true) {
			try {
				String textTitle = String.format("====== SHOP ======\n[구매]\t[판매]\n[나가기]\n");
				IOManager.append(textTitle);

				String input = reader.readLine();

				if (input.equals("구매")) {
					buyItem();
				} else if (input.equals("판매")) {
					sellItem();
				} else if (input.equals("나가기")) {
					break;
				}
			} catch (Exception e) {
			}
		}

	}

	public void start() {
		makeEquipment();
		printShopMenu();
		shop.clear();
	}
}
