package Stopwatch;

public class Timer implements Runnable{
    /**
     * When an object implementing interface {@code Runnable} is used
     * to create a thread, starting the thread causes the object's
     * {@code run} method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method {@code run} is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */

    StopWatchController stopWatchController;
    public volatile boolean flag = true;
    public Timer(StopWatchController stopWatchController) {
        this.stopWatchController = stopWatchController;
    }

    @Override
    public void run() {
        int hr=0;
        int min = 0;
        int sec = 0;
        try {
            while(flag){

                    Thread.sleep(1000);
                    sec++;
                    if (sec == 60) {
                        min++;
                        sec = 0;
                    }
                    if (min == 60) {
                        hr++;
                        min = 0;
                    }
                    stopWatchController.setTimer(hr, min, sec);

            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void stop0(){
        flag = false;

    }
}
