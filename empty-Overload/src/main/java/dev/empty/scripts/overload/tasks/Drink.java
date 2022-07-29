package dev.empty.scripts.overload.tasks;

import net.runelite.api.Item;
import net.runelite.api.Skill;
import net.unethicalite.api.game.Skills;
import net.unethicalite.api.items.Inventory;

public class Drink implements ScriptTask
{

    @Override
    public boolean validate()
    {
        return true;
    }

    @Override
    public int execute()
    {
        if (Skills.getLevel(Skill.ATTACK) == Skills.getBoostedLevel(Skill.ATTACK))
        {
            Item overloadPotion = Inventory.getFirst(x -> x.hasAction("Drink")
                    && (x.getName().contains("Overload") || x.getName().contains("Overload")));
            if (overloadPotion != null)
            {
                overloadPotion.interact("Drink");
                return 7000;
            }
        }


        return 1000;
    }
}
