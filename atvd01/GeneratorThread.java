import java.util.ArrayList;

public class GeneratorThread implements Runnable{
    NumberGenerator gerador;
    Integer qt_geracao;
    GeneratorThread() {
        this.gerador = new NumberGenerator();
        this.qt_geracao = 3;
    }

    GeneratorThread(NumberGenerator generator) {
        this.gerador = generator;
        this.qt_geracao = 3;
    }

    GeneratorThread(Integer num_geracoes) {
        this.gerador = new NumberGenerator();
        this.qt_geracao = num_geracoes;
    }

    GeneratorThread(NumberGenerator generator, Integer num_geracoes) {
        this.gerador = generator;
        this.qt_geracao = num_geracoes;
    }

    @Override
    public void run() {
        ArrayList<Long> NumGerados = new ArrayList<>(qt_geracao);
        for (int i = 0; i < qt_geracao; i++) {
            NumGerados.add(gerador.next());
        }
        System.out.println(gerador + ": " + NumGerados);
    }

}
