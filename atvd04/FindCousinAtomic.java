package atvd04;

import java.util.concurrent.atomic.AtomicInteger;

public class FindCousinAtomic {
    private AtomicInteger counter;

    public FindCousinAtomic() {
        counter.set(0);
    }

    

    public Integer CountPrimes(Integer start, Integer end, Integer num_threads) {
        Thread[] threads = new Thread[num_threads];
        for (int i = 0; i < num_threads; i++) {
            final int threadId = i;
            final int comeco = start;
            final int fim = end;
            threads[i] = new Thread(() -> find(comeco, fim, threadId));
            threads[i].start();
        }
        for (Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                System.out.println("Thread interrompida!");
            }
        }
        return counter.get();
    }

    private void Sum() {
        counter.incrementAndGet();
    }

    private void find(Integer start, Integer end, Integer offset) {
        for (int number = start + offset; number <= end; number += offset) {
            boolean prime = true;
            if (number < 2) continue;
            for (int i = 2; i <= Math.sqrt(number); i++) {
                if (number % i == 0) prime = false;
            }
            if(prime) Sum();
        }
    }
}
