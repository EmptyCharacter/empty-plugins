package dev.empty.scripts.packagename.tasks;


public class TaskOne implements ScriptTask
{

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
