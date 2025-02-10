import java.util.concurrent.atomic.AtomicLong;

public class NumberGenerator {

    private AtomicLong sequenceNumber = new AtomicLong(0);

    public Long next() {
        long prev, next;
        do {
            prev = sequenceNumber.get();
            next = this.sequenceNumber.get() + 1;
        } while (!sequenceNumber.compareAndSet(prev, next));
        return next;
    }
    

}
