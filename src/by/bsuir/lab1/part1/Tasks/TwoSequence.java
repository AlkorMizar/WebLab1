package by.bsuir.lab1.part1.Tasks;

import by.bsuir.lab1.part1.DigitReader;

public class TwoSequence extends Task{
    private double[] arrayA;
    private double[] arrayB;

    @Override
    public void doTask() {
        super.doTask();
        var result=calculate();
        System.out.println("Ответ:");
        int i = 0;
        for (; i < result.length && result[i]!=-1; i++) {
            System.out.printf("Поместить b%d перед a%d\n",i+1,result[i]+1);
        }
        if (result[result.length-1]==-1){
            System.out.printf("Элементы начиная с b%d помещаются в конец последовательности а\n",i);
        }
    }

    private int[] calculate(){
        int[] result=new int[arrayB.length];
        int j=0;
        for (int i = 0; i < arrayA.length ;i++) {
            while ( j<arrayB.length && arrayA[i]>=arrayB[j]){
                result[j]=i;
                j++;
            }
        }
        while (j<arrayB.length){
            result[j++]=-1;
        }
        return result;
    }

    @Override
    void getArguments() {
        int lenght= DigitReader.readInteger("Введите размер первого массива(<10000):",
                "Должнобыть целым , положительным числом",
                0,10_000);
        arrayA=new double[lenght];
        for (int i = 0; i < lenght; i++) {
            arrayA[i]=DigitReader.readFloat("Введите элемент (по модулю меньший 100000)"+(i+1),
                    "Это должнобыть числом",
                    -100_000,100_000);
        }

        lenght= DigitReader.readInteger("Введите размер второго массива(<10000):",
                "Должнобыть целым , положительным числом",
                0,10_000);
        arrayB=new double[lenght];
        for (int i = 0; i < lenght; i++) {
            arrayB[i]=DigitReader.readFloat("Введите элемент (по модулю меньший 100000)"+(i+1),
                    "Это должнобыть числом",
                    -100_000,100_000);
        }
    }

    @Override
    void getDescription() {
        System.out.println("Задание 8\nДаны две неубывающие последовательности действительных чисел.  \n" +
                "Требуется указать те места, на которые нужно вставлять элементы второй последовательности в первую последовательность так, чтобы новая \n" +
                "последовательность оставалась возрастающей.   ");
    }
}
