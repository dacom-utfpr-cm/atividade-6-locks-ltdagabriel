package exercicio_01;

import java.util.Scanner;

/**
 * Faça um programa usando Lock para simular a atualização de um contador que é acessado por múltiplas threads.
 * O contador pode diminuir e aumentar.
 *
 * @author: Gabriel Choptian
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Buffer buffer = new Buffer();
        Scanner str = new Scanner(System.in);
        while (true){
            new Thread(()-> buffer.add()).start();
            new Thread(()-> buffer.add()).start();
            new Thread(()-> buffer.sub()).start();
            new Thread(()-> buffer.sub()).start();
            new Thread(()-> buffer.print()).start();
            Thread.sleep(200);
        }

    }
}
