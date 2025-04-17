package org.example;

import java.io.*;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class ChangeCostController {
    String caseCost = "C:\\Users\\Evgeniy\\Desktop\\Cases\\Data\\CaseCost.txt";


     public double[] changeCost() throws IOException {
         double[] result = new double[5];
         Scanner sc = new Scanner(System.in);
         BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(caseCost));

         System.out.print("Цена за SNAKEBITE: ");
         result[0] = sc.nextDouble();
         System.out.print("Цена за NIGHTMARES: ");
         result[1] = sc.nextDouble();
         System.out.print("Цена за FRACTURE: ");
         result[2] = sc.nextDouble();
         System.out.print("Цена за CLUTCH: ");
         result[3] = sc.nextDouble();
         System.out.print("Цена за RECOIL: ");
         result[4] = sc.nextDouble();

         for(double cost : result){
             bufferedWriter.write(String.valueOf(cost));
             bufferedWriter.newLine();
         }

         System.out.println("Цены успешно изменены!");
         bufferedWriter.close();
         return result;
     }

    public double[] caseCost() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(caseCost));
        double[] result = new double[5];

        String line;
        NumberFormat format = NumberFormat.getInstance(Locale.US);
        int index = 0;

        while((line = reader.readLine()) != null && index < 5){
            double number = Double.parseDouble(line.trim());
            result[index] = number;
            index++;
        }
        reader.close();

        return result;
    }
}
