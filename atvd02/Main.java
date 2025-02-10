package atvd02;

public class Main {
    public static void main(String[] args) {
        UnblockingStack pilha = new UnblockingStack();
        pilha.push(1);
        Thread thread1 = new Thread(new Produtor(pilha));
        Thread thread2 = new Thread(new Consumidor(pilha));
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
