package com.company;

public class Lowest implements Runnable {

    Employees emp;
    static int minS=Integer.MAX_VALUE;

    Lowest(Employees e) {

        emp=e;

    }

    public void run() {

        try{

            Sync.testing();
            Integer income = Integer.parseInt(emp.s);
            if(minS>income) minS=income;

            ZelimGlobalneVarijable.getInstance().min.add(minS);

        }catch(Exception E){E.printStackTrace();}


    }


}
