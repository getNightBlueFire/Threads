public class TestDock {
    public static void main(String[] args) {
        Dock dock = new Dock();


        Thread thread1 = new Thread(dock);
        Thread thread2 = new Thread(dock);
        Thread thread3 = new Thread(dock);
        Thread thread4 = new Thread(dock);
        Thread thread5 = new Thread(dock);
        thread1.setName("-t1");
        thread2.setName("-t2");
        thread3.setName("-t3");
        thread4.setName("-t4");
        thread5.setName("+t5");

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();


    }
}
