package exercicio_03;

import java.util.Random;

public class Main {
    /**
     * Faça uma classe ArrayListThreadSafe usando ReadWriteLock.
     * Teste usando threads que realizam leitura e escrita para essa estrutura
     *
     * @autor: Gabriel Choptian
     */
    public static void main(String[] args) {
        ArrayListThreadSafe t = new ArrayListThreadSafe();
        // Escritor
        Thread th = new Thread(() -> {
            int value = 1;

                try {
                    while (value > 0) {
                        t.put(value);
                        value = new Random().nextInt(50);
                        Thread.sleep(100);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    System.out.println("Escritor parado por numero aleatorio 0");
                }
        });
        th.start();

        //Leitor
        new Thread(() -> {
            while (th.isAlive()) {
                try {
                    System.out.println(" ---> " + (Integer) t.get(0));
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

}
