package atvd04;

public class Main {

    public static void main(String[] args) {
        
        int start = 1;
        int end = 1000000;
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
        
        long tempo_atomico = tempo_final_atomico - tempo_inicial_atomico;
        long tempo_metodo = tempo_final_metodo - tempo_inicial_metodo;
        long tempo_bloco = tempo_final_bloco - tempo_inicial_bloco;
        System.out.println("Atomico: Foram achados "+ contagem_atomico +" em "+ tempo_atomico + " milisegundos");
        System.out.println("Metodo: Foram achados "+ contagem_metodo +" em "+ tempo_metodo + " milisegundos");
        System.out.println("Bloco: Foram achados "+ contagem_bloco +" em "+ tempo_bloco + " milisegundos");
    }

}
