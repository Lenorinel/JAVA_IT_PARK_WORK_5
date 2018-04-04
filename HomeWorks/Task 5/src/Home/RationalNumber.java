package Home;

public class RationalNumber {
    int t, r, c, o;

    public RationalNumber() { //при создании mew RatNum без указания значений будет данное присваивание
        t = 0;
        r = 1;
    }

    public RationalNumber(int z, int v) { //либо присваивание введенных значений
        t = z;
        r = v;
    }

    public String show() { //при вызове из Main данного метода выводится строка содержащая это
        return t + "|" + r; //реретурн, потому что при запросе метода возвращает значение
    }

    public Double toDouble() { //при запросе метода преобразует в Дабл и выводит результат деления
        return (double) t / r;
    }

    public int nod(int a, int b) {
        t = a;
        r = b;
        if(a != 0 && b != 0) {
            while (a != 0 & b != 0) {
                if (a > b) a = a % b;
                else b = b % a;
            }
            c = b + a;
            return b + a;
        } else return 0;
    }
    public void optimize() {

        System.out.println(t + "|" + r + " = " +  (t /= c) + "|" + (r/=c) + " = " + (double)t/r);
   }
}
