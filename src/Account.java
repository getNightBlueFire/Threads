public class Account implements Runnable {
    private int balance = 50;

    public int getBalance() {
        return balance;
    }

    public void withdraw(int amount) {
        balance -= amount;
    }

    public void run() {
        for (int x = 0; x < 5; x++) {
            makeWithdrawal(10);
            if (getBalance() < 0) {
                System.out.println("денег на счету нет!");
            }
        }
    }
    private void makeWithdrawal(int amount) {
    //private synchronized void makeWithdrawal(int amount) {
        if (getBalance() >= amount) {
            System.out.println(Thread.currentThread().getName()
                    + " снял со счета деньги");
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            withdraw(amount);
            System.out.println(Thread.currentThread().getName()
                    + " выполнил операцию. На счету осталось "
                    + getBalance());
        } else {
            System.out.println("сумма не достаточно на аккаутне "
                    + Thread.currentThread().getName()
                    + " для снятия денег: " + getBalance());
        }
    }
}
