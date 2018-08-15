
public class Actions{

    private Contents contents;
    private volatile boolean runFlag;
    private StopWatch stopWatch;

    Actions(){}

    Actions(Contents contents)
    {
        this.contents = contents;
    }

    public boolean isRunFlag() {
        return runFlag;
    }

    public void setRunFlag(boolean runFlag) {
        this.runFlag = runFlag;
    }

    public void startStopwatch()
    {
        if(! isRunFlag())
        {
            setRunFlag(true);
            stopWatch = new StopWatch(this);
            stopWatch.start();
        }
    }

    public void stopStopwatch()
    {
        if(isRunFlag())
        {
            try
            {
                setRunFlag(false);
                stopWatch.join();
            }
            catch (Exception e)
            {
                e.printStackTrace();
                System.exit(1);
            }
        }
    }

    public void incrementTime()
    {
        int seconds = contents.getSeconds() + 1;

        if(seconds == 60)
        {
            contents.setSeconds(0);
            int minutes = contents.getMinutes() + 1;
            if(minutes == 60)
            {
                contents.setMinutes(0);
                int hours = contents.getHours() + 1;
                if(hours == 24)
                {
                    contents.setHours(0);
                }
                else
                {
                    contents.setHours(hours);
                }
            }
            else
            {
                contents.setMinutes(minutes);
            }
        }
        else
        {
            contents.setSeconds(seconds);
        }
    }
}
