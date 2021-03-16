package concurrency;

public class Deadlock {
    private static boolean initialized = false;
    /*Thread t = new Thread(new Runnable() {
        @Override
        public void run() {
            initialized = true;
        }
    });*/

    static {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                initialized = true;
            }
        });
        t.start(); //Keep only this line in static block
        //move below try-catch block to main method before SOP to resolve deadlock
        try {
            t.join();
        } catch (InterruptedException e) {
            throw new AssertionError(e);
        }
    }

    public static void main(String[] args) {
        /*try {
            t.join();
        } catch (InterruptedException e) {
            throw new AssertionError(e);
        }*/
        System.out.println(initialized);
    }
}
