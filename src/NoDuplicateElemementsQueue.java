import java.util.ArrayDeque;

public class NoDuplicateElemementsQueue extends ArrayDeque<String> {
    @Override
    public boolean add(String s) {
        if(!this.contains(s)){
            return super.add(s);
        }
        else{
            System.out.println("element already exists on the Queue");
            return false;
        }
    }

    @Override
    public void addFirst(String s) {
        throw new UnsupportedOperationException();
    }
}
