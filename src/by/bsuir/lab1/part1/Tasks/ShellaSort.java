package by.bsuir.lab1.part1.Tasks;

import by.bsuir.lab1.part1.DigitReader;

import java.util.Arrays;

public class ShellaSort extends  Task {

    private double[] array;

    @Override
    public void doTask() {
        super.doTask();
        System.out.println("Ответ:"+Arrays.toString(calculate()));
    }

    private double[] calculate(){
        var resultArray= Arrays.copyOf(array,array.length);
        int i=0;
        while (i<array.length-1){
            if (resultArray[i]>resultArray[i+1]){
                swap(resultArray,i,i+1);
                i-=i==0?0:1;
            }else {
                i++;
            }
        }
        return  resultArray;
    }

    private void swap(double[] array,int first,int second){
        double temp=array[first];
        array[first]=array[second];
        array[second]=temp;
    }

    @Override
    void getArguments() {
        int lenght= DigitReader.readInteger("Введите размер массива(<10000):",
                "Должнобыть целым , положительным числом",
                0,10_000);
        array=new double[lenght];
        for (int i = 0; i < lenght; i++) {
            array[i]=DigitReader.readFloat("Введите элемент "+(i+1)+" (по модулю меньший 100000)",
                    "Это должнобыть числом",
                    -100_000,100_000);
        }
    }

    @Override
    void getDescription() {
        System.out.println("Задание 7\nДаны действительные числа a1, a2, …, an. Получить следующую квадратную матрицу порядка n.  ");
    }
}
