package com.example.kira;

import java.util.Random;

public class ExprGenerator {
    public int lvl=1, score=0;
    private int result=0;
    private String signs[]={"+","-","*"};
    public String getExpr(){
        switch (lvl){
            case 1:return lvl_1();
            case 2:return lvl_2();
            case 3:return lvl_3();
            default: return lvl_4();
        }
    }

    private String lvl_1(){
        Random random = new Random();
        int first=random.nextInt(10);
        int second=random.nextInt(10);
        String sign=signs[random.nextInt(3)];
        result=calculate(first,sign,second);
        return first+sign+second;
    }
    private String lvl_2(){
        Random random = new Random();
        int first=random.nextInt(10);
        int second=random.nextInt(10);
        int third=random.nextInt(10);
        String sign1=signs[random.nextInt(3)];
        String sign2=signs[random.nextInt(3)];
        int r;
        if(sign2.equals("*")){
            r=calculate(second,sign2,third);
            result=calculate(first,sign1,r);
        }
        else{
            r=calculate(first,sign1,second);
            result=calculate(r,sign2,third);
        }
        return first+sign1+second+sign2+third;
    }
    private String lvl_3(){
        Random random = new Random();
        int first=random.nextInt(30);
        int second=random.nextInt(30);
        String sign=signs[random.nextInt(3)];
        result=calculate(first,sign,second);
        return first+sign+second;
    }

    private String lvl_4(){
        Random random = new Random();
        int first=random.nextInt(30);
        int second=random.nextInt(30);
        int third=random.nextInt(30);
        String sign1=signs[random.nextInt(3)];
        String sign2=signs[random.nextInt(3)];
        int r;
        if(sign2.equals("*")){
            r=calculate(second,sign2,third);
            result=calculate(first,sign1,r);
        }
        else{
            r=calculate(first,sign1,second);
            result=calculate(r,sign2,third);
        }
        return first+sign1+second+sign2+third;
    }

    private int calculate(int first,String sign, int second){
        switch(sign){
            case "+":return result=first+second;
            case "-":return result=first-second;
            default:return result=first*second;
        }
    }

    public boolean check(int answer){
        boolean flag;
        if(answer==result){
            score+=lvl;
            switch (score){
                case 10:lvl=2;break;
                case 30:lvl=3;break;
                case 60:lvl=4;
            }
            flag=true;
        }
        else flag=false;
        return flag;
    }
}
