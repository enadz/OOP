package com.company;
import java.io.*;
import java.util.*;
import java.util.Map;
import java.util.Map.Entry;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("employees.txt");
        Scanner s = null;

        ArrayList<String> departments = new ArrayList<>();

        try {
            s = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        String dep="";
        int counter = 0;
        String d = "";
        ArrayList<String> info = new ArrayList<>();


        while (s.hasNextLine()) {

            dep = s.nextLine();
            info.add(dep);
            for (int i = 0, n = dep.length(); i < n; i++) {
                char c = dep.charAt(i);
                if (c == ',') counter++;
                if (counter == 3);
                else if (counter == 2) d = d + c;
                else;

            }
            counter = 0;
        }

            String[] data = d.split(", ");

            for(int i=0; i<data.length; i++) {
                if (departments.contains(data[i]));
                else departments.add(data[i]);
            }

            departments.remove(0);

            //I couldn't be bothered retracing the loop. Removed the unnecessary empty element this way
            //Yes, I'm aware this could've been more efficient. But it works

            System.out.println(departments);
            //note to self info still has the entire rows stored

        Map map = new TreeMap<String, List<Employees>>();

        String[] items;
        int depnum=departments.size();

        for(int j=0; j<depnum; j++) {

            ArrayList<Employees> employees = new ArrayList<>();

            for(int i=0; i<info.size(); i++){

                items=info.get(i).split(", ",4);

                Employees e=new Employees(items[0],items[1]);

                if (departments.get(j).matches(items[2])) employees.add(e);

            }

            map.put(departments.get(j), employees);

        }

        //System.out.println(info);

       //System.out.println(info.size());

       //System.out.println(map);



            FileWriter m = null;
            try {
                m = new FileWriter("marketing.txt");
            } catch (IOException e) {
                e.printStackTrace();
            }
            PrintWriter printWriterM = new PrintWriter(m);
        for (int i=0; i<((ArrayList)map.get("Marketing")).size();i++){
            printWriterM.print(((Employees)(((ArrayList)map.get("Marketing")).get(i))).name);
            printWriterM.println();}
            printWriterM.close();

        FileWriter p = null;
        try {
            p = new FileWriter("production.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        PrintWriter printWriterP = new PrintWriter(p);



        for (int i=0; i<((ArrayList)map.get("Production")).size();i++){
        printWriterP.print(((Employees)(((ArrayList)map.get("Production")).get(i))).name);
        printWriterP.println();}
        printWriterP.close();

    }

}


/*
Create a program that will read content of a file employees.txt and
put employees in a Map company that will keep information on department as key
and will have list of Employees (class should have first name and last name) as a value.
Finally create as many files as there are keys in Map and save employees to corresponding file.
*/