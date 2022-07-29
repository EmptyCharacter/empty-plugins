package dev.empty.scripts.dragons.tasks;

import net.runelite.api.Item;
import net.runelite.api.ItemID;
import net.runelite.api.Player;
import net.runelite.api.TileObject;
import net.runelite.api.coords.WorldArea;
import net.runelite.api.coords.WorldPoint;
import net.unethicalite.api.entities.Players;
import net.unethicalite.api.entities.TileObjects;
import net.unethicalite.api.items.Bank;
import net.unethicalite.api.items.Inventory;
import net.unethicalite.api.movement.Movement;
import net.unethicalite.api.movement.Reachable;

public class BankLoot implements ScriptTask
{
    private static final WorldPoint BANK_TILE = new WorldPoint(3268, 3167, 0);
    private static final WorldPoint ZanarisBank = new WorldPoint(2380, 4460, 0);
    private static final WorldPoint ChickenShrine = new WorldPoint(2453, 4476, 0);
    private static final WorldArea ChickenShrineArea = new WorldArea(2453, 4476, 1, 1, 0);
    private static final WorldPoint DragonPortal = new WorldPoint(2460, 4352, 0);


    @Override
    public boolean validate()
    {
        return Inventory.isFull() || Inventory.contains(ItemID.RAW_CHICKEN) && Inventory.contains(ItemID.RANGING_POTION4);
    }

    @Override
    public int execute()
    {
        Player local = Players.getLocal();
//		TileObject portal = TileObjects.getNear
//		if (portal == null || portal.distanceTo(local) > 20 || !Reachable.isInteractable(portal))
//		{
//			Movement.walkTo(DragonPortal);
//		}
//		portal.interact("Use");


//		WALKS TO AND OPENS BANK
// 		----------------------------------------------------------------------------------------------

        if (!Bank.isOpen() && !Inventory.contains(ItemID.RAW_CHICKEN) && !Inventory.contains(ItemID.RANGING_POTION4))
        {
            if (Movement.isWalking())
            {
                return 1000;
            }
            TileObject booth = TileObjects.getFirstAt(ZanarisBank, x -> x.hasAction("Use", "Collect"));
            if (booth == null || booth.distanceTo(local) > 20 || !Reachable.isInteractable(booth))
            {
                Movement.walkTo(ZanarisBank);
                return 1000;
            }
            booth.interact("Use");
        }
//		----------------------------------------------------------------------------------------------


//		DEPOSITS, WITHDRAWS, WALKS TO SHRINE
//		----------------------------------------------------------------------------------------------
        if (Inventory.isFull() && !Inventory.contains(ItemID.RAW_CHICKEN) && !Inventory.contains(ItemID.RANGING_POTION4))
        {
            Bank.depositInventory();
        }

        Item rangePot = Inventory.getFirst(ItemID.RANGING_POTION4);
        if (rangePot == null)
        {
            Bank.withdraw(ItemID.RANGING_POTION4, 1, Bank.WithdrawMode.ITEM);
        }

        Item rawChicken = Inventory.getFirst(ItemID.RAW_CHICKEN);
        if (rawChicken == null)
        {
            Bank.withdraw(ItemID.RAW_CHICKEN, 1, Bank.WithdrawMode.ITEM);
        }
//		----------------------------------------------------------------------------------------------

//		Walks to shrine
//		----------------------------------------------------------------------------------------------

        if (!ChickenShrineArea.contains(local))
        {
            Movement.walkTo(ChickenShrine);
            return 1000;
        }

//		----------------------------------------------------------------------------------------------


        return 1000;
    }
}
