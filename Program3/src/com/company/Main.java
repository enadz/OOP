package com.company;
import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) {

        ArrayList<Employees> employees = new ArrayList<>();

        File file = new File("employees.txt");
        Scanner s;
        String info;
        String[] attributes;
        ArrayList<String> Departments = new ArrayList<>();

        {
            try {
                s = new Scanner(file);

                while (s.hasNextLine()){

                    info= s.nextLine();

                    attributes=info.split(", ", 4);

                    Employees e=new Employees(attributes[0],attributes[1],attributes[2],attributes[3]);
                    employees.add(e);

                    if(Departments.contains(attributes[2])==false) Departments.add(attributes[2]);

                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        ArrayList<Managers> managers = new ArrayList<>();

        File f = new File("managers.txt");
        Scanner x;
        String data;
        String[] attrib;

        {
            try {
                x = new Scanner(f);

                while (x.hasNextLine()){

                    data= x.nextLine();

                    attrib= data.split(", ", 3);

                    Managers m=new Managers(attrib[0],attrib[1],attrib[2]);
                    managers.add(m);



                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }


        ArrayList<Integer> SalInDep = new ArrayList<>();


        for (int j=0; j<Departments.size();j++) {
            int TotalS = 0;
            int TotalB = 0;
            for (int i = 0; i < employees.size(); i++) {
                Employees emp = employees.get(i);
                if ((emp.d).equals(Departments.get(j))) {
                    SalInDep.add(Integer.parseInt(emp.s));
                    TotalS = TotalS + Integer.parseInt(emp.s);
                }
            }

            for (int k = 0; k < managers.size(); k++) {
                Managers man = managers.get(k);
                if ((man.d).equals(Departments.get(j))) {
                    TotalB = Integer.parseInt(man.b) - TotalS;
                    System.out.println("The budget for " + Departments.get(j) + " after salary costs are covered is: " + TotalB);
                }
            }

            FileWriter Top = null;
            try {
                Top = new FileWriter("top10.txt", true);
                PrintWriter printWriter = new PrintWriter(Top);
                printWriter.println("The top 10 salaries for " + Departments.get(j) + " are:");

                if (SalInDep.size() > 9) {
                    for (int i = 0; i < 10; i++) printWriter.println(SalInDep.get((SalInDep.size() - 1) - i));

                } else {
                    for (int i = 0; i < SalInDep.size(); i++)
                        printWriter.println(SalInDep.get((SalInDep.size() - 1) - i));
                }

                printWriter.close();


            } catch (IOException e) {
                e.printStackTrace();
            }

        }


    }
}



/*

Create a program that will read content of a file employees.txt and
save employees to ArrayList, where class Employee should have first name, last name, salary and department as attributes.
After read content of a file managers.txt and save mangers to ArrayList, where
class Manager should have department name, manager name and allocated budget.

Once everything is processed, calculate following:

        Total of salaries for employees for each department and remaining in the budget for each manager.
        Manager budget - (total salaries in that department). Print result to a console.

        Top 10 salaries in each department. Print results in a file per department.
*/