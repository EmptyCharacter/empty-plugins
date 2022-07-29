package dev.empty.scripts.moobank.tasks;

import net.runelite.api.coords.WorldPoint;

public class KillCows implements ScriptTask
{


    private static final WorldPoint CowPen = new WorldPoint(2470, 4363, 0);


    @Override
    public boolean validate()
    {
        return false;
    }

    @Override
    public int execute()
    {


        return 1000;
    }
}
