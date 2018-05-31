package com.geethikafile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PrintApplication {

    public static void main(String[] args) {

        String csvFile = "C:\\Users\\Gattika\\Desktop\\FirstName_LastName.csv";
        String line = "";
        String cvsSplitBy = ",";
        int count=0;
        int cost1,cost2,cost3,cost4,cost5;
        float TotalCost=0;

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {
            	
                // use comma as separator
                String[] path = line.split(cvsSplitBy);
                if (count !=0) {
                	Integer [] value = new Integer[path.length];
                    
                	value[0]=Integer.parseInt(path[0]);
                	//Integer [] value = new Integer[path.length];
                	value[1]=Integer.parseInt(path[1]);
                	//System.out.println(value[0]);
                System.out.println("\n"+"Total Pages are "+value[0]);
                if(path[2].contains("true")&& value[1]!=0) {
                System.out.println("No.of Double sided color pages ="+value[1]);
                cost1 =value[1]*20;
                TotalCost = TotalCost+cost1;
                System.out.println("Cost of the job is "+cost1+ "c");
                System.out.println("No.of double sided black&white pages ="+(value[0]-value[1]));
                cost5 = (value[0]-value[1])*10;
                TotalCost=TotalCost+cost5;
                System.out.println("Cost of the job is "+cost5+ "c");
                }
                if(path[2].contains("true")&&value[1]==0) {
                System.out.println("No.of Double sided black&white pages ="+value[0]);
                cost2 = value[0]*10;
                TotalCost=TotalCost+cost2;
                System.out.println("Cost of the job is "+cost2+ "c");
                }
                if(path[2].contains("false")) {
                	System.out.println("No.of Single sided color pages ="+value[1]);
                	cost3= value[1]*25;
                	TotalCost=TotalCost+cost3;
                	System.out.println("Cost of the job is "+cost3+ "c");
                }
                if(path[2].contains("false")) {
                	System.out.println("No.of Single sided black&white pages ="+(value[0]-value[1]));
                	cost4 = (value[0]-value[1])*15;
                	TotalCost=TotalCost+cost4;
                	System.out.println("Cost of the job is "+cost4+ "c");
                	
                }
                
                
                }
                
                count++;
               
            } 
            System.out.println("\n"+"Total Cost of all the jobs = $"+TotalCost/100);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}