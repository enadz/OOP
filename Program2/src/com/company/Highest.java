package com.company;

public class Highest implements Runnable{

    final Employees emp;
    static int maxS=0;

    Highest(Employees e) {

        emp=e;

    }


    public void run() {

        try{
            Thread.sleep(300);
            int income = Integer.parseInt(emp.s);
            if(maxS<income) maxS=income;

            ZelimGlobalneVarijable.getInstance().max.add(maxS);
            Sync.testing();

        }catch(Exception E){E.printStackTrace();}


    }




}
