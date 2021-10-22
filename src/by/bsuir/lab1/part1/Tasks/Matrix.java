package by.bsuir.lab1.part1.Tasks;

import by.bsuir.lab1.part1.DigitReader;

import java.util.Arrays;

public class Matrix extends Task {
    double array[];

    public void doTask() {
        super.doTask();
        System.out.println("Ответ:");
        var matrix=calculate();
        for (int i = 0; i < array.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }

    private double[][] calculate(){
        var resultMatrix=new double[array.length][array.length];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                resultMatrix[i][j]=array[(j+i)%array.length];
            }
        }
        return resultMatrix;
    }

    @Override
    void getArguments() {
        int lenght= DigitReader.readInteger("Введите размер массива(<10000):",
                "Должнобыть целым , положительным числом",
                0,10_000);
        array=new double[lenght];
        for (int i = 0; i < lenght; i++) {
            array[i]=DigitReader.readFloat("Введите элемент (по модулю меньший 100000)"+(i+1),
                    "Это должнобыть числом",
                    -100_000,100_000);
        }
    }

    @Override
    void getDescription() {
        System.out.println("Задание 6\nДаны действительные числа a1, a2, …, an. Получить следующую квадратную матрицу порядка n.  ");
    }
}
