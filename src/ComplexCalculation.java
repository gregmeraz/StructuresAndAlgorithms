import com.sun.corba.se.spi.orbutil.threadpool.ThreadPool;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class ComplexCalculation {

    public static void main(String[] args) throws InterruptedException {
        ComplexCalculation complexCalculation= new ComplexCalculation();
        System.out.println(complexCalculation.calculateResult(new BigInteger("6"), new BigInteger("6"), new BigInteger("5"), new BigInteger("5")));
    }
    public BigInteger calculateResult(BigInteger base1, BigInteger power1, BigInteger base2, BigInteger power2) throws InterruptedException {
        BigInteger result = new BigInteger("0");
        /*
            Calculate result = ( base1 ^ power1 ) + (base2 ^ power2).
            Where each calculation in (..) is calculated on a different thread
        */

        List<PowerCalculatingThread> powerThreads= new ArrayList<>();
        powerThreads.add(new PowerCalculatingThread(base1, power1));
        powerThreads.add(new PowerCalculatingThread(base2, power2));
       // powerThreads.forEach(Thread::start);
        for(Thread thread:powerThreads){
            thread.start();
            thread.join();
        }

        for(PowerCalculatingThread thread: powerThreads){
            result=result.add(thread.getResult());
        }

        return result;
    }

    private static class PowerCalculatingThread extends Thread {
        private BigInteger result = BigInteger.ONE;
        private BigInteger base;
        private BigInteger power;

        public PowerCalculatingThread(BigInteger base, BigInteger power) {
            this.base = base;
            this.power = power;
        }

        @Override
        public void run() {
            System.out.println("executing thread: "+this.getName());
           this.result=this.base.pow(this.power.intValue());

        }

        public BigInteger getResult() { return result; }
    }
}