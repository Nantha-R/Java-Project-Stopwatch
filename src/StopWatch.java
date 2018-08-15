public class StopWatch extends Thread {

    public Actions actions;

    StopWatch(){}

    StopWatch(Actions actions)
    {
        this.actions = actions;
    }

    public void run()
    {

        while(actions.isRunFlag())
        {
            try
            {
                Thread.sleep(998);
            }
            catch (Exception e)
            {
                e.printStackTrace();
                System.exit(1);
            }
            actions.incrementTime();
        }

    }
}
