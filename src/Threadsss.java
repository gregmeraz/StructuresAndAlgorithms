import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Threadsss {

    private static int MAX_PASSWORD=9999;

    public static void main(String[] args) throws InterruptedException {
        Random random= new Random();
        Vault vault= new Vault(random.nextInt(MAX_PASSWORD));
        List<Thread> threads= new ArrayList<>();
        threads.add(new Thief1(vault));
        threads.add(new Thief2(vault));
        threads.add(new PoliceThread());

        threads.forEach(Thread::start);
    }

    private static class Vault{
        private int password;

        public Vault(int password){
            this.password=password;
        }
        public boolean isCorrectPassword(int guessedPassword){
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return this.password==guessedPassword;
        }
    }

    private abstract static class Thief extends Thread{
        protected Vault vault;
        public Thief(Vault vault){
            this.vault=vault;
            this.setPriority(Thread.MAX_PRIORITY);
        }

        @Override
        public synchronized void start() {
            System.out.println("Starting thread: "+this.getName());
            super.start();
        }
    }

    private static class Thief1 extends Thief{

        public Thief1(Vault vault) {
            super(vault);
        }

        @Override
        public void run() {
            for(int guess=0; guess<MAX_PASSWORD; guess++){
                if(vault.isCorrectPassword(guess)){
                    System.out.println("Thief 1 got you azz, fam");
                    System.exit(0);
                }
            }
        }
    }
    private static class Thief2 extends Thief {
        public Thief2(Vault vault) {
            super(vault);
        }

        @Override
        public void run() {
            for(int guess=MAX_PASSWORD; guess>=0; guess--){
                if(vault.isCorrectPassword(guess)){
                    System.out.println("Thief 2 got you azz, fam");
                    System.exit(0);
                }
            }
        }
    }

    private static class PoliceThread extends Thread{
        @Override
        public void run() {
            for (int i=10; i>0; i--){
                System.out.println(i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Police got you first");
            System.exit(0);
        }
    }

}


