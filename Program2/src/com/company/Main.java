package com.company;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
public class Main {


    public static void main(String[] args) {

        ArrayList<Employees> employees = new ArrayList<>();

        File file = new File("employees.txt");
        Scanner s;
        String info;
        String[] attributes;

        {
            try {
                s = new Scanner(file);

                while (s.hasNextLine()) {

                    info = s.nextLine();

                    attributes = info.split(", ", 4);

                    Employees e = new Employees(attributes[0], attributes[1], attributes[2], attributes[3]);

                    employees.add(e);
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        for (int i = 0; i < employees.size(); i++) {

            Employees x = employees.get(i);

            Thread t1 = new Thread(new Highest(x));
            Thread t2 = new Thread(new Lowest(x));

            t1.start();
            t2.start();

            try {
                t1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            try {
                t2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            FileWriter op = null;
            try {
                op = new FileWriter("output.txt");
                PrintWriter printWriter = new PrintWriter(op);

                printWriter.println("The highest salary is:");
                printWriter.println(ZelimGlobalneVarijable.getInstance().max.get(ZelimGlobalneVarijable.getInstance().max.size() - 1));
                printWriter.println("The smallest salary is:");
                printWriter.println(ZelimGlobalneVarijable.getInstance().min.get(ZelimGlobalneVarijable.getInstance().min.size() - 1));
                printWriter.close();


            } catch (IOException e) {
                e.printStackTrace();
            }


        }

    }
}
