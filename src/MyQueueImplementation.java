import java.util.Collection;
import java.util.LinkedList;

public class MyQueueImplementation extends LinkedList<String> {

    public String peek() {
       return this.getLast();
    }

    public String poll(){
        String popped=this.peek();
        super.removeLast();
        return popped;
    }

    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String remove() {
        throw new UnsupportedOperationException();
    }

    @Override
    public String remove(int index) {
        throw new UnsupportedOperationException("a Queue does not support random access deletion");
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean add(String s) {
         super.addFirst(s);
         return true;
    }

    @Override
    public void add(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(Collection<? extends String> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void addFirst(String s) {
        throw new UnsupportedOperationException();
    }

}
