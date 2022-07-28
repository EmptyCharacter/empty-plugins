package dev.empty.scripts.lavadragons.tasks;

import net.runelite.api.*;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.game.ItemManager;
import net.unethicalite.api.entities.Players;
import net.unethicalite.api.entities.TileItems;
import net.unethicalite.api.game.Combat;
import net.unethicalite.api.items.Inventory;
import net.unethicalite.api.movement.Movement;
import net.unethicalite.api.movement.Reachable;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

public class BankLavaLoot implements ScriptTask
{

	@Inject
	private ItemManager itemManager;

	private List<TileItem> notOurItems = new ArrayList<>();

	private static final WorldPoint SafeSpot = new WorldPoint(2470, 4363, 0);


	@Override
	public boolean validate() { return !Inventory.isFull() && !Inventory.contains(ItemID.RAW_CHICKEN); }

	@Override
	public int execute()
	{
		Player local = Players.getLocal();
		NPC mob = Combat.getAttackableNPC("Black dragon");

//			mob.interact("Attack");
//			Movement.walkTo(SafeSpot);


//		Loots then walks back to SAFESPOT
//		----------------------------------------------------------------------------------------------
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
//		----------------------------------------------------------------------------------------------


//		if(local.isAnimating() == )
//		{
//			NPC mob = Combat.getAttackableNPC("Black dragon");
//			mob.interact("Attack");
//			Movement.walkTo(SafeSpot);
//		}






		return 1000;
	}
}
