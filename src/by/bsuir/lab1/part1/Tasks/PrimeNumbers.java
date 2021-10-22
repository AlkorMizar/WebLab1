package by.bsuir.lab1.part1.Tasks;

import by.bsuir.lab1.part1.DigitReader;

import java.util.ArrayList;

public class PrimeNumbers extends Task {
    private int[] array;
    @Override
    public void doTask() {
        super.doTask();
        System.out.println("Ответ:");
        var result=caculate();
        if (result.size()!=0){
            for (var ind : result) {
                System.out.printf("%d\t",ind);
            }
            System.out.println();
        }else{
            System.out.println("В массиве нет простых чисел");
        }
    }

    private ArrayList<Integer> caculate(){
        ArrayList<Integer> primeNumbersIndexes=new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if (isPrime((array[i]))){
                primeNumbersIndexes.add(i+1);
            }
        }
        return  primeNumbersIndexes;
    }

    private  boolean isPrime(int number){
        boolean result=number!=1;
        if(number!=1 && number!=2 && number!=3 ) {
            result=number % 2 != 0 && number % 3 != 0;
            if (result) {
                for (int i = 6; i < Math.sqrt(number) && result; i += 6) {
                    result = number % (i - 1) != 0 && number % (i + 1) != 0;
                }
            }
        }
        return  result;
    }

    @Override
    void getArguments() {
        int lenght= DigitReader.readInteger("Введите размер массива(<10000):",
                                "Должнобыть целым , положительным числом",
                                        0,10_000);
        array=new int[lenght];
        for (int i = 0; i < lenght; i++) {
            array[i]=DigitReader.readInteger("Введите элемент "+(i+1),
                                             "Это должнобыть числом",
                                             Integer.MIN_VALUE,Integer.MAX_VALUE);
        }
    }

    @Override
    void getDescription() {
        System.out.println("Задание 4\nЗадан целочисленный массив размерности N. Есть ли среди элементов массива простые числа?Если да, то вывести номера этих элементов.");
    }
}
