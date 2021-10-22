package by.bsuir.lab1.part1.Tasks;

import by.bsuir.lab1.part1.DigitReader;

public class SubSequence extends Task {
    private  int[] array;

    @Override
    public void doTask() {
        super.doTask();
        System.out.println("Ответ:"+calculate());
    }

    private  int calculate(){
        int lenght = array.length;                     //размер исходной последовательности
        double d[]=new double[lenght+1];
        d[0]=Double.NEGATIVE_INFINITY;
        for (int i = 1; i < lenght+1; i++) {
            d[i]=Double.POSITIVE_INFINITY;
        }
        int max=-1;
        for (int i = 0; i < lenght; i++) {
            int j = binarySearch(d, array[i]);
            if(array[i] != d[j]){
                d[j]=array[i];
                max=Math.max(j,max);
            }
        }
        return lenght-max;
    }

    private int binarySearch(double[] d, int number){
        int l=0;
        int r=d.length;
        int i=(r+l)/2;
        while ( i==0 || d[i-1]>=number || d[i]<=number){
            if(d[i]<number){
                l=i+1;
            }else {//d[i]>=number
                r=i-1;
            }
            i=(r+l)/2;
        }
        return  i;
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
        System.out.println("Задание 5\nДана целочисленная таблица А[n]. Найти наименьшее число K элементов, которые можно \n" +
                "выкинуть из данной последовательности, так чтобы осталась возрастающая подпоследовательность.  .");
    }
}
