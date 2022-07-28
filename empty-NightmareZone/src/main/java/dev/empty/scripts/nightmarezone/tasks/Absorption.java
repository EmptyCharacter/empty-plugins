package dev.empty.scripts.nightmarezone.tasks;

import net.runelite.api.*;
import net.unethicalite.api.entities.Players;
import net.unethicalite.api.entities.TileObjects;
import net.unethicalite.api.game.Combat;
import net.unethicalite.api.game.Skills;
import net.unethicalite.api.items.Bank;
import net.unethicalite.api.items.Inventory;
import net.unethicalite.api.movement.Movement;
import net.unethicalite.api.movement.Reachable;
import net.runelite.api.coords.WorldPoint;
import net.unethicalite.api.widgets.Prayers;

public class Absorption implements ScriptTask
{
	private static final WorldPoint BANK_TILE = new WorldPoint(3268, 3167, 0);

	@Override
	public boolean validate()
	{
		return true;
	}

	@Override
	public int execute()
	{
		Prayers.toggleQuickPrayer(true);
		try {
			Thread.sleep(700);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Prayers.toggleQuickPrayer(false);


		if(Skills.getLevel(Skill.ATTACK) == Skills.getBoostedLevel(Skill.ATTACK))
		{
			Item overloadPotion = Inventory.getFirst(x -> x.hasAction("Drink")
					&& (x.getName().contains("Overload") || x.getName().contains("Overload")));
			if (overloadPotion != null)
			{
				overloadPotion.interact("Drink");
				return 7000;
			}
		}



		return 35_000;
	}
}
