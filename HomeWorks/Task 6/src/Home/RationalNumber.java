package Home;

public class RationalNumber {
    private int t, r, c;

    public RationalNumber() { //при создании mew RatNum без указания значений будет данное присваивание
//        this.t = 0;
//        this.r = 1;
        this(0, 1);
         }

    public void setT(int t) {
        this.t = t;
    }

    public void setR(int r) {
        this.r = r;
    }

    public RationalNumber(int t, int r) { //либо присваивание введенных значений
        this.t = t;
        this.r = r;
    }

    public int getT() {
        return t;
    }
    public String show() { //при вызове из Main данного метода выводится строка содержащая это
        return t + "|" + r; //реретурн, потому что при запросе метода возвращает значение
    }

    public Double toDouble() { //при запросе метода преобразует в Дабл и выводит результат деления
        return (double) t / r;
    }

    public int nod(int t, int r) {
        if (t != 0 && r != 0) {
            while (t != 0 & r != 0) {
                if (t > r) t = t % r;
                else r = r % t;
            }
            c = t + r;
            return t + r;
        } else return 0;
    }

    public void optimize() {

        System.out.println(t + "|" + r + " = " + (t /= c) + "|" + (r /= c) + " = " + (double) t / r);
    }
}
