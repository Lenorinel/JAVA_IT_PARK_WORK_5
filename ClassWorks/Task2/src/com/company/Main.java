import java.util.ArrayList;
import java.util.Arrays;
class Task2 {

    public static void main(String[] args) {
        // write your code here
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(5);
        list.add(6);
        list.add(1);
        list.add(2);
        list.add(2);
        list.remove(2);
    }
}

//int[] intArray = { 1, 2, 3, 4, 5 };
//int[] removed = ArrayUtils.removeElement(intArray, 3);//create a new array
//System.out.println(Arrays.toString(removed));