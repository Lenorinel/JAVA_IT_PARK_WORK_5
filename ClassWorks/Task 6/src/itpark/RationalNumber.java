package itpark;

public class RationalNumber {
    int x,y;
    double c;

    public RationalNumber() {
        x = 0;
        y = 1;
       // c =((double)x) / y;
    }
    public RationalNumber (int a, int b) {
        x = a;
        y = b;
        //c = ((double)x)/y;
    }
    public ToDouble(RationalNumber) {
        c = ((double)x)/y;
    }



    void Show () {
        System.out.print("Дробь " + x + "|" + y + " = " + c);
    }
}
