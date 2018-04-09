package itpark;

public class RationalNumber {
    int x,y;

    public RationalNumber() { //Если создается объект без значений переменных
        x = 0;
        y = 1;
       // c =((double)x) / y;
    }
    public RationalNumber (int a, int b) { //если при создании объекта, задаются значения переменных
        x = a;
        y = b;
        //c = ((double)x)/y;
    }
    public ToDouble() {

        c = ((double)x)/y;
    }



    void Show () {
        System.out.print("Дробь " + x + "|" + y + " = " + c);
    }
}
