
public class Actions extends Thread {

    public Contents contents;
    public boolean runFlag;

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
            this.start();
        }
    }

    public void run()
    {

        while(isRunFlag())
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
            incrementTime();
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
