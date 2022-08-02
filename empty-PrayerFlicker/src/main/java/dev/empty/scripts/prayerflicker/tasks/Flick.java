package dev.empty.scripts.prayerflicker.tasks;

import net.unethicalite.api.widgets.Prayers;

public class Flick implements ScriptTask
{

    @Override
    public boolean validate()
    {
        return true;
    }

    @Override
    public int execute()
    {
        Prayers.toggleQuickPrayer(true);
        try
        {
            Thread.sleep(800);
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        Prayers.toggleQuickPrayer(false);


        return 48_000;
    }
}
