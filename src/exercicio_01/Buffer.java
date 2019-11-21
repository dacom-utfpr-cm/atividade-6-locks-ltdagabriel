package exercicio_01;

import java.util.concurrent.locks.ReentrantLock;

public class Buffer {
    final ReentrantLock lock = new ReentrantLock();
    int count = 0;

    public void add() {
        lock.lock();
        count++;

        lock.unlock();
    }

    public void print() {
        System.out.printf("Contador: %d%n", count);
    }

    public void sub() {
        lock.lock();
        count--;

        lock.unlock();
    }

}
