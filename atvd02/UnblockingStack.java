package atvd02;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicReference;

public class UnblockingStack {
    AtomicReference<Deque<Object>> cache = new AtomicReference<Deque<Object>>(new ArrayDeque<Object>());

    public Object pop() throws NoSuchElementException {
        boolean sucesso;
        Object objeto;
        do {
            Deque<Object> oldStack = cache.get();
            Deque<Object> stack2 = new ArrayDeque<Object>(cache.get());
            objeto = stack2.removeFirst();
            sucesso = cache.compareAndSet(oldStack, stack2);
        } while (!sucesso);
        return objeto;
    }

    public void push(Object objeto) throws IllegalStateException {
        boolean sucesso;
        do {
            Deque<Object> oldStack = cache.get();
            Deque<Object> stack2 = new ArrayDeque<Object>(cache.get());
            stack2.addFirst(objeto);
            sucesso = cache.compareAndSet(oldStack, stack2);
        } while (!sucesso);
    }
}
