package by.bsuir.lab1.part1;

import java.util.Scanner;

public class DigitReader {
    public static int readInteger(String descriptionOfInt, String errorDescription, int from, int to){
        var scanner = new Scanner(System.in);
        int result=from;
        System.out.println(descriptionOfInt);
        do{
            if (scanner.hasNextInt()){
                result=scanner.nextInt();
                if((result>=from) && (result<=to)){
                    break;
                }
            }else {
                scanner.next();
            }
            System.out.println(errorDescription);
        }while(true);
        return result;
    }

    public static float readFloat(String descriptionOfInt, String errorDescription, float from, float to){
        var scanner = new Scanner(System.in);
        float result=from;
        System.out.println(descriptionOfInt);
        do{
            if (scanner.hasNextFloat()){
                result=scanner.nextFloat();
                if((result>=from) && (result<=to)){
                    break;
                }
            }else {
                scanner.next();
            }
            System.out.println(errorDescription);
        }while(true);
        return result;
    }
}
