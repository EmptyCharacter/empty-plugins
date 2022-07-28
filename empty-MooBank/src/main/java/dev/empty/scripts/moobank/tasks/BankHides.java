package dev.empty.scripts.moobank.tasks;

import net.unethicalite.api.entities.Players;
import net.unethicalite.api.entities.TileObjects;
import net.unethicalite.api.items.Bank;
import net.unethicalite.api.items.Inventory;
import net.unethicalite.api.movement.Movement;
import net.unethicalite.api.movement.Reachable;
import net.runelite.api.Item;
import net.runelite.api.ItemID;
import net.runelite.api.Player;
import net.runelite.api.TileObject;
import net.runelite.api.coords.WorldPoint;

public class BankHides implements ScriptTask
{
	private static final WorldPoint AlKharidBank = new WorldPoint(3268, 3167, 0);
	private static final WorldPoint TollGate = new WorldPoint(3268, 3277, 0);


	@Override
	public boolean validate()
	{
		return true;
	}

	@Override
	public int execute()
	{

		Player local = Players.getLocal();

		TileObject booth = TileObjects.getFirstAt(TollGate, x -> x.hasAction("Open", "Pay-toll(10gp)"));
		if (booth == null || booth.distanceTo(local) > 20 || !Reachable.isInteractable(booth))
		{
			Movement.walkTo(TollGate);
			return 1000;
		}

		booth.interact("Pay-toll(10gp)");




		return 1000;
	}
}
