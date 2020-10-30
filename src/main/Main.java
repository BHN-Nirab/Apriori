package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Main {

    public static ArrayList<ArrayList<String>> transection;
    public static int minSup_Count;
    public static HashSet<String> itemset;
    public static ArrayList<Integer> supportCountTable;

    public static void inputTransection()
    {
        transection = new ArrayList<>();

        File file = new File("src/resources/input.txt");
        try {
            Scanner sc = new Scanner(file);

            while (sc.hasNext())
            {
                String itemsLine = sc.nextLine().split("=")[1];
                String items[] = itemsLine.split(",");

                ArrayList<String> itemList = new ArrayList<>();

                for (String item : items) {
                    itemList.add(item);
                }

                transection.add(itemList);
            }

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void inputMinSupCount()
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter minimum support count: ");
        minSup_Count = sc.nextInt();
    }

    public static void initializeItemSet()
    {
        itemset  = new HashSet<>();

        for (ArrayList<String> items : transection) {
            for (String item : items) {
                itemset.add(item);
            }
        }

    }

    public static void initializeSupportCount()
    {
        supportCountTable = new ArrayList<>();

        Object[] itemsetString = itemset.toArray();

        for(int i=0; i<itemsetString.length; i++)
        {
            int supportCount = 0;

            for (ArrayList<String> items : transection) {
                for (String item : items) {
                    if(item.equals(itemsetString[i]))
                        supportCount++;
                }
            }
            supportCountTable.add(supportCount);
        }
    }






    public static void main(String[] args) {
        inputTransection();
        inputMinSupCount();
        initializeItemSet();
        initializeSupportCount();



    }
}
