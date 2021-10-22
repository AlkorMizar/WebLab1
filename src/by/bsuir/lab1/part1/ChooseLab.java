/*
*
*
*
*/
package by.bsuir.lab1.part1;

import by.bsuir.lab1.part1.Tasks.*;

import java.util.List;

public class ChooseLab {
    static  List<Task> tasks;
    public static void main(String[] args){
        setDefaultTasks();
        do {
            int result=DigitReader.readInteger("Enter number of task(1-"+ tasks.size()+") or zero to exit:",
                    "You can choose from 1 to "+tasks.size(),0,tasks.size());
            if(result==0){
                System.out.println("Bye!");
                return;
            }
            Task task=tasks.get(result-1);
            task.doTask();
        }while (true);
    }

    public static void setDefaultTasks(){
        tasks= List.of(new Equation(),new CartesianSystem(),new FunctionTable(),
                       new PrimeNumbers(),new SubSequence(),new Matrix(),
                       new ShellaSort(),new TwoSequence());
    }
}
