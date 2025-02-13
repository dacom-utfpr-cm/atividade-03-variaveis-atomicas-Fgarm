package atvd04;

public class Main {

    public static void main(String[] args) {
        
        int start = 1;
        int end = 10000000;
        int numThreads = 8;
    
        FindCousinMehtodSynced contador_metodo = new FindCousinMehtodSynced();
        FindCousinBlockSynced contador_bloco = new FindCousinBlockSynced();
        FindCousinAtomic contador_atomico = new FindCousinAtomic();
        long tempo_inicial_atomico = System.currentTimeMillis();
        int contagem_atomico = contador_atomico.CountPrimes(start, end, numThreads);
        long tempo_final_atomico = System.currentTimeMillis();
    
        long tempo_inicial_metodo = System.currentTimeMillis();
        int contagem_metodo = contador_metodo.CountPrimes(start, end, numThreads);
        long tempo_final_metodo = System.currentTimeMillis();
    
        long tempo_inicial_bloco = System.currentTimeMillis();
        int contagem_bloco = contador_bloco.CountPrimes(start, end, numThreads);
        long tempo_final_bloco = System.currentTimeMillis();
        
    }

}
