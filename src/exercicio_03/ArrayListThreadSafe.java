package exercicio_03;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ArrayListThreadSafe {
    ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    Lock leitura = lock.readLock();
    Lock escrita = lock.writeLock();

    ArrayList<Object> list = new ArrayList<>();

    public void put(Object obj) {
        escrita.lock();
        try {
            list.add(obj);
        } finally {
            escrita.unlock();
        }
    }

    public Object get(int index) {
        leitura.lock();
        try {
            System.out.println(list.size());
            return list.get(list.size()-1);
        } finally {
            leitura.unlock();
        }
    }

}
