package Home;

public interface Stack<T> extends Collection<T>{
    void push(T element); //положить в конец
    T pop(); //забрать с конца
}
