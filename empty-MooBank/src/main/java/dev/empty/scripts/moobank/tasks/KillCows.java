package dev.empty.scripts.moobank.tasks;

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

public class KillCows implements ScriptTask
{


	private static final WorldPoint CowPen = new WorldPoint(2470, 4363, 0);


	@Override
	public boolean validate() { return false; }

	@Override
	public int execute()
	{



		return 1000;
	}
}
