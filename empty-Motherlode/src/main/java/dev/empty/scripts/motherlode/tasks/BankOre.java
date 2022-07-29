package dev.empty.scripts.motherlode.tasks;

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

public class BankOre implements ScriptTask
{
    private static final WorldPoint MotherlodeChest = new WorldPoint(3760, 5666, 0);

    @Override
    public boolean validate()
    {
        return Inventory.isFull();
    }

    @Override
    public int execute()
    {
        Player local = Players.getLocal();
        if (!Bank.isOpen())
        {
            if (Movement.isWalking())
            {
                return 1000;
            }

            TileObject booth = TileObjects.getFirstAt(MotherlodeChest, x -> x.hasAction("Bank", "Collect"));
            if (booth == null || booth.distanceTo(local) > 20 || !Reachable.isInteractable(booth))
            {
                Movement.walkTo(MotherlodeChest);
                return 1000;
            }

            booth.interact("Bank");
            return 3000;
        }

        Item hammer = Inventory.getFirst(ItemID.HAMMER);
        if (Inventory.isFull())
        {
            Bank.depositInventory();
            return 1000;
        }

        if (hammer == null)
        {
            Bank.withdraw(ItemID.HAMMER, 1, Bank.WithdrawMode.ITEM);
            return 1000;
        }

        return 1000;
    }
}
