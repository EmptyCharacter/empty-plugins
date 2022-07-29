package dev.empty.scripts.rockcake.tasks;

import net.runelite.api.Item;
import net.unethicalite.api.items.Inventory;

public class Eat implements ScriptTask
{

    @Override
    public boolean validate()
    {
        return true;
    }

    @Override
    public int execute()
    {

        Item overloadPotion = Inventory.getFirst(x -> x.hasAction("Guzzele")
                && (x.getName().contains("Dwarven rock cake") || x.getName().contains("Dwarven rock cake")));
        if (overloadPotion != null)
        {
            overloadPotion.interact("Guzzle");
            return 1000;
        }


        return 1000;
    }
}
