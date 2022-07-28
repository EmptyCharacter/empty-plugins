package dev.empty.scripts.packagename.tasks;

import net.unethicalite.api.widgets.Prayers;

public class doNothing implements ScriptTask{

    @Override
    public boolean validate()
    {
        return true;
    }

    @Override
    public int execute()
    {



        return 1000;
    }
}
