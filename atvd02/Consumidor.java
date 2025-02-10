package atvd02;


import java.util.NoSuchElementException;
import java.util.Random;

public class Consumidor implements Runnable{
    private UnblockingStack pilha;
    private static Random rand = new Random();
    Consumidor(UnblockingStack stack) {
        pilha = stack;
    }
    
    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                int espera = rand.nextInt(10, 100);
                Thread.sleep(espera * 100);
                try {
                    System.out.println("Resolvi consumir, saiu o objeto" + pilha.pop().toString());
                }
                catch (NoSuchElementException e) {
                    System.out.println("Resolvi consumir, estava vazio :|");
                }
                
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
    }
}
