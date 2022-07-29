package dev.empty.scripts.packagename.tasks;


public class TaskTwo implements ScriptTask
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
