import java.util.Random;

public class Dock implements Runnable {

    private int count = 70_000;

    public int getCount() {
        return count;
    }

    public void operation(int amount) {
        String name = Thread.currentThread().getName();
        if (name.startsWith("+")) {
            count += amount;
        } else {
            count -= amount;
        }
    }


    @Override
    public void run() {
        Random random = new Random();
        for (int i = 0; i < 3; i++) {
            doOperation(10_000);

        }

    }

    private void doOperation(int amount) {
    //private synchronized void doOperation(int amount) {
        String name = Thread.currentThread().getName();
        if (getCount() >= amount) {


            if (name.startsWith("+")) {
                System.out.println(name + " совершает погрузку материала");
            } else {
                System.out.println(name + " совершает разгрузку материала");
            }


            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            operation(amount);
            System.out.println(name + " выполнил операцию. Теперь в порту кг груза: " + getCount());
        } else {
            System.out.println("Груз для разгрузки отсутствует. " + name + " пытается разгрузить: " + getCount());
        }
    }


}
