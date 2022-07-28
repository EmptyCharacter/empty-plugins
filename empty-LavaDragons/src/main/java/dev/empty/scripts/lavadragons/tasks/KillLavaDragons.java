package dev.empty.scripts.lavadragons.tasks;

import net.runelite.api.*;
import net.unethicalite.api.entities.Players;
import net.unethicalite.api.entities.TileItems;
import net.unethicalite.api.entities.TileObjects;
import net.unethicalite.api.game.Combat;
import net.unethicalite.api.items.Bank;
import net.unethicalite.api.items.Inventory;
import net.unethicalite.api.movement.Movement;
import net.unethicalite.api.movement.Reachable;
import net.runelite.api.coords.WorldPoint;

public class KillLavaDragons implements ScriptTask
{
	private static final WorldPoint SafeSpot = new WorldPoint(2470, 4363, 0);



	@Override
	public boolean validate()
	{
		return true;
	}

	@Override
	public int execute()
	{
		Player local = Players.getLocal();
		NPC mob = Combat.getAttackableNPC("Black dragon");


		if (!Inventory.isFull())
		{
			TileItem loot = TileItems.getNearest("Dragon bones", "Black dragonhide");
			if (loot != null)
			{
				if (!Reachable.isInteractable(loot.getTile()))
				{
					Movement.walkTo(loot.getTile().getWorldLocation());
					return -4;
				}

				loot.pickup();
				return -3;
			}
			Movement.walkTo(SafeSpot);
		}




		return 1000;
	}
}
