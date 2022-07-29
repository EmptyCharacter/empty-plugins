package dev.empty.scripts.dragons.tasks;

import net.runelite.api.ItemID;
import net.runelite.api.NPC;
import net.runelite.api.Player;
import net.runelite.api.TileItem;
import net.runelite.api.coords.WorldArea;
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

public class KillDragons implements ScriptTask
{

    @Inject
    private ItemManager itemManager;

    private List<TileItem> notOurItems = new ArrayList<>();

    private static final WorldPoint SafeSpot = new WorldPoint(2470, 4363, 0);
    private static final WorldArea SafeSpotArea = new WorldArea(2470, 4363, 1, 1, 0);
    private boolean test = false;

    @Override
    public boolean validate()
    {
        return !Inventory.isFull() && !Inventory.contains(ItemID.RAW_CHICKEN);
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


        if (SafeSpotArea.contains(local))
        {
            Combat.setAttackStyle(Combat.AttackStyle.FOURTH);
            mob.interact("Attack");
            try
            {
                Thread.sleep(1000);
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            Combat.setAttackStyle(Combat.AttackStyle.SECOND);

        }

        return 1000;
    }
}
