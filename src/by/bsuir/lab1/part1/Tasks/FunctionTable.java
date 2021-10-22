package by.bsuir.lab1.part1.Tasks;

import by.bsuir.lab1.part1.DigitReader;

public class FunctionTable extends  Task {

    private float a;
    private float b;
    private float h;

    public void doTask(){
        super.doTask();
        calculate();
    }

    @Override
    void getArguments() {
        a= DigitReader.readFloat("Введите a(от -100 000 до 100 000):","a должны быть числом",
                -100_000,100_000);
        b= DigitReader.readFloat("Введите b(от а до 100 000):","b должны быть числом",
                a,100_000);
        h= DigitReader.readFloat("Введите h(от -100 000 до 100 000):","h должны быть числом",
                -100_000,100_000);
    }

    @Override
    void getDescription() {
        System.out.println("Задание 3\nСоставить таблицу значений функции(tg) на заданной области(от a до b) с заданным шагом(h)");
    }

    private void  calculate(){
        WriteLine();
        System.out.printf("|%10s|%10s|\n","x","F(x)");
        WriteLine();
        for (float i=a;i<=b;i+=h){
            System.out.printf("|%10.5s|%10.5s|\n",i,Math.tan(i));
            WriteLine();
        }
    }

    private  void WriteLine(){

        for (int i=0;i<23;i++){
            if(i==0 || i==11 || i==22){
                System.out.print("|");
            }else {
                System.out.print("-");
            }
        }
        System.out.println();
    }
}
