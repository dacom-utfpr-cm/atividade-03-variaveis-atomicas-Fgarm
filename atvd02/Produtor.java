package atvd02;

import java.util.Random;

public class Produtor implements Runnable{
    private UnblockingStack pilha;
    private static Random rand = new Random();
    Produtor(UnblockingStack stack) {
        pilha = stack;
    }
    
    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                int espera = rand.nextInt(10, 100);
                Thread.sleep(espera * 10);
                try {
                    pilha.push(espera);
                }
                catch (Exception e) {
                    System.out.println("Não foi possível colocar o elemento devido a" + e);
                }
                
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
    }
}
