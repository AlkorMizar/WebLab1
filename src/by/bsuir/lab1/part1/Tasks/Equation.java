package by.bsuir.lab1.part1.Tasks;

import by.bsuir.lab1.part1.DigitReader;

public class Equation extends Task {
    private double x;
    private double y;

    @Override
    public void doTask() {
        super.doTask();
        System.out.printf("Answer is %f",caculate());
    }

    private  double caculate(){
        double result=x;

        double upPartEquation=Math.sin(x+y);
        upPartEquation*=upPartEquation;
        upPartEquation+=1;

        double downPartEquation=2*x;
        downPartEquation/=(1 + x * x * y * y);
        downPartEquation=Math.abs(x-downPartEquation);
        downPartEquation+=2;

        result+=upPartEquation/downPartEquation;
        return result;
    }

    public   void getDescription(){
        System.out.println("Задание 1\nВычислить значение выражения по формуле (все переменные принимают действительные значения).");
    }

    public void getArguments() {
        x= DigitReader.readFloat("Введите x(от -100 000 до 100 000):","X должны быть числом от -100 000 до 100 000",
                -100_000,100_000);
        y= DigitReader.readFloat("Введите y(от -100 000 до 100 000):","Y должны быть числом от -100 000 до 100 000",
                -100_000,100_000);
    }
}
