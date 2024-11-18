package interfaces;

import java.util.Random;
import units.Monster;

public interface MonsterManager {
	public Random ran = new Random();

	public static Monster makeMonsters(int level) {
		String packageName = "units.";
		String[] classNames = { "Slime" };
		String[] names = { "슬라임" };

		int rIdx = ran.nextInt(classNames.length);
		int hp = 0, damage = 0, def = 0;

		if (rIdx == 0) {
			hp = 800 + 100 * (level - 1);
			damage = 20 + 5 * (level - 1);
			def = 5 + 2 * (level - 1);
		}

		try {
			Class<?> clazz = Class.forName(packageName + classNames[rIdx]);

			Class<?>[] argsTypes = new Class<?>[] { String.class, int.class, int.class, int.class, int.class };
			Object obj = clazz.getConstructor(argsTypes).newInstance(names[rIdx], level, hp, damage, def);

			if (obj instanceof Monster) {
				return (Monster) obj;
			}

		} catch (Exception e) {}
		return null;
	}
	
}