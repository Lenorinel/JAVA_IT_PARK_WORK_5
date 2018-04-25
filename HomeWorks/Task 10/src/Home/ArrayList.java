package Home;

public class ArrayList<T> implements List<T>, Stack<T> {
    private final static int INITIAL_SIZE = 10;

    private T data[];
    private int count;

    public ArrayList() {
        this.count = count;
        this.data = (T[])new Object[INITIAL_SIZE];
    }

    @Override
    public T get(int index) {
        if (index < count) {
            return data[index];
        }
        throw new IndexOutOfBoundsException();
    }

    @Override
    public void delete(int index) {
        if(index < count) {
            for(int i = index; i < count - 1;i++) {
                data[i] = data[i + 1];
            }
            count--;
        } else throw new IndexOutOfBoundsException();
    }

    @Override
    public void add(T element) {
        if(count == data.length){
            resize();
        }
        data[count] = element;
        count++;
    }

    @Override
    public boolean contains(T element) {
        for(int i =0; i < count; i++) {
            if(data[i].equals(element)) {
                return  true;
            }
        }return false;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public boolean delete(T element) {
        for (int i = 0; i < count; i++){
            if(data[i].equals(element)){
                delete(i);
                return true;
            }
        } return false;
    }

    private void resize() {
        int newLength = data.length + data.length / 2;
        T newData[] = (T[])new Object[newLength];
        System.arraycopy(data,0,newData,0,count);
        this.data = newData;
    }

    @Override
    public void push(T element) {
        add(element);
    }

    @Override
    public T pop() {
        T element = get(count - 1);
        delete(count - 1);
        return element;
    }
}
