

public class Main {
    public static void main(String[] args) {
        NumberGenerator gerador1 = new NumberGenerator();
        NumberGenerator gerador2 = new NumberGenerator();


        Thread thread1 = new Thread(new GeneratorThread(gerador1));
        Thread thread2 = new Thread(new GeneratorThread(gerador1));
        Thread thread3 = new Thread(new GeneratorThread(gerador2));
        thread1.start();
        thread2.start();
        thread3.start();
        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            System.out.println("Interrompido!");
            e.printStackTrace();
        }
    }
}

