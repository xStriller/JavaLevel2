import ru.xfriezz.geekbrains.lesson2.MyArrayDataException;
import ru.xfriezz.geekbrains.lesson2.MyArraySizeException;

public class Main {

    public static void main(String[] args) {
        try {
            int sum = strArr(new String[][]{
                    {"1", "dsa", "1", "1"},
                    {"1", "1", "1", "1"},
                    {"1", "1", "1", "1"},
                    {"1", "1", "1", "1"}
            });
            System.out.println(sum);
        } catch (MyArrayDataException | MyArraySizeException e) {
            e.printStackTrace();
        }
    }

    public static int strArr(String[][] a) {
        if (a.length != 4) {
            throw new MyArraySizeException("Ваш массив не верного размера");
        }
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i].length != 4) {
                throw new MyArraySizeException("Ваш массив не верного размера");
            }
            for (int j = 0; j < a[i].length; j++) {
                try {
                    sum += Integer.parseInt(a[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Ячейка [" + i + "][" + j + "]", e);
                }
            }
        }
        return sum;
    }
}
