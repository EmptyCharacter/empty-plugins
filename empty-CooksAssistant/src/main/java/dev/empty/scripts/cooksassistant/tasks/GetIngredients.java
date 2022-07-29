package dev.empty.scripts.cooksassistant.tasks;

import net.runelite.api.Item;
import net.runelite.api.ItemID;
import net.runelite.api.Player;
import net.runelite.api.TileObject;
import net.runelite.api.coords.WorldPoint;
import net.unethicalite.api.entities.Players;
import net.unethicalite.api.entities.TileObjects;
import net.unethicalite.api.items.Bank;
import net.unethicalite.api.items.Inventory;
import net.unethicalite.api.movement.Movement;
import net.unethicalite.api.movement.Reachable;

public class GetIngredients implements ScriptTask
{

	private static final WorldPoint LumbyBank = new WorldPoint(3208, 3221, 2);
	private static final WorldPoint CowPatch = new WorldPoint(3254, 3270, 0);


	@Override
	public boolean validate()
	{
		return true;
	}

	@Override
	public int execute()
	{
		Player local = Players.getLocal();

//		!SHOULD START AT LUMBY BANK ANYWAYS ---- WALKS TO AND OPENS BANK
// 		----------------------------------------------------------------------------------------------

		if (!Bank.isOpen())
		{
			if (Movement.isWalking())
			{
				return 1000;
			}
			TileObject booth = TileObjects.getFirstAt(LumbyBank, x -> x.hasAction("Bank", "Collect"));
			if (booth == null || booth.distanceTo(local) > 20 || !Reachable.isInteractable(booth))
			{
				Movement.walkTo(LumbyBank);
				return 1000;
			}
			booth.interact("Bank");
		}
//		----------------------------------------------------------------------------------------------



//		WITHDRAWS ITEMS
//		----------------------------------------------------------------------------------------------
		Item bucket = Inventory.getFirst(ItemID.BUCKET);
		if (bucket == null)
		{
			Bank.withdraw(ItemID.BUCKET, 1, Bank.WithdrawMode.ITEM);
			return 1000;
		}

		Item pot = Inventory.getFirst(ItemID.POT);
		if (pot == null)
		{
			Bank.withdraw(ItemID.POT, 1, Bank.WithdrawMode.ITEM);
			return 1000;
		}
//		----------------------------------------------------------------------------------------------

		Movement.walkTo(CowPatch);




		return 1000;
	}
}
