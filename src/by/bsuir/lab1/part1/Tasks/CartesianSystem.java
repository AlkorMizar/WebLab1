package by.bsuir.lab1.part1.Tasks;

import by.bsuir.lab1.part1.DigitReader;

public class CartesianSystem extends Task{

    float x,y;
    float x4,y4;
    float[][] coordinates;

    public CartesianSystem(){
        coordinates=new float[][]{{4,0},{6,0,},
                                   {6,-3},{-6,-3},
                                   {-6,0},{-4,0},
                                   {-4,5},{4,5}};
    }

    @Override
    public void doTask() {
        super.doTask();
        System.out.println("Ответ:"+ calculate());
    }

    private  boolean calculate(){
        x4=x==0?1:0;
        y4=y==0?1:0;
        int collision = 0;
        for (int i = 0; i < coordinates.length; i++) {
            if(isIntersect(i,(i+1)%coordinates.length)){
                collision++;
            };
        }
        return  collision%2==1;
    }

    private boolean isIntersect(int i,int j){
        boolean result=false;
        float coeftX1=coordinates[i][1]-coordinates[j][1];//y1-y2
        float coefY1=coordinates[i][0]-coordinates[j][0];//x1-x2
        float freeCoef1=coordinates[i][0]*coordinates[j][1]-coordinates[i][1]*coordinates[j][0];//x1y2-x2y2
        float coefX2=y-y4;
        float coefY2=x-x4;
        float freeCoef2=x*y4-x4*y;
        float a=coeftX1*coefY2-coefX2*coefY1;
        float b=coeftX1*freeCoef2-coefX2*freeCoef1;
        if(a!=0){
            float intersectY=b/a;
            float intersectX=(coefY2*intersectY-freeCoef2)/coefX2;
            float directionX=x-intersectX,
                directionY=y-intersectY;
            result=directionX*coefY2>=0 &&
                   directionY*coefX2>=0;
            boolean betwenY1Y2=(coordinates[i][1]-intersectY)*(coordinates[j][1]-intersectY)<=0;
            boolean betwenX1X2=(coordinates[i][0]-intersectX)*(coordinates[j][0]-intersectX)<=0;
            result&=betwenX1X2&&betwenY1Y2;
        }
        return result;
    }

    @Override
    void getArguments() {
        x=(float) DigitReader.readFloat("Введите x:","X должны быть числом",
                -100_000,100_000);
        y=(float) DigitReader.readFloat("Введите y:","Y должны быть числом",
                -100_000,100_000);
    }

    @Override
    void getDescription() {
        System.out.println("Задание 2\nДля данной области составить программу, которая печатает true, если точка с координатами (х, \n" +
                "у) принадлежит закрашенной области, и false — в противном случае.");
    }
}
