package dev.empty.scripts.prayerflicker.tasks;

public class doNothing implements ScriptTask
{

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
