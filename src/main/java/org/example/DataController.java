package org.example;

import java.io.*;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class DataController {
    String filePath = "C:\\Users\\Evgeniy\\Desktop\\Cases\\Result.txt";
    String dataPath = "C:\\Users\\Evgeniy\\Desktop\\Cases\\Data\\AllCases.txt";
    String caseCount = "C:\\Users\\Evgeniy\\Desktop\\Cases\\Data\\CaseCount.txt";





    void resultToTerminal(ArrayList<Double> doubleArray, int[] intArray) {
        double result = 0;

        for (int i = 0; i < doubleArray.size(); i++) {
            result += doubleArray.get(i);
        }

        System.out.println("---------------------------------------");
        System.out.println("Count of Cases:");
        System.out.println("SNAKEBITE: " + intArray[0]);
        System.out.println("NIGHTMARES: " + intArray[1]);
        System.out.println("FRACTURE: " + intArray[2]);
        System.out.println("CLUTCH: " + intArray[3]);
        System.out.println("RECOIL: " + intArray[4]);
        System.out.println("---------------------------------------");
        System.out.println("Cost of All Cases: " + result);
        System.out.println("---------------------------------------");
    }


    void result (double result, int[] intArray) throws IOException {

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath));
        bufferedWriter.write("---------------------------------------");
        bufferedWriter.newLine();
        bufferedWriter.write("Count of Cases: ");
        bufferedWriter.newLine();
        bufferedWriter.write("SNAKEBITE: " + intArray[0]);
        bufferedWriter.newLine();
        bufferedWriter.write("NIGHTMARES: " + intArray[1]);
        bufferedWriter.newLine();
        bufferedWriter.write("FRACTURE: " + intArray[2]);
        bufferedWriter.newLine();
        bufferedWriter.write("CLUTCH: " + intArray[3]);
        bufferedWriter.newLine();
        bufferedWriter.write("RECOIL: " + intArray[4]);
        bufferedWriter.newLine();

        bufferedWriter.write("---------------------------------------");
        bufferedWriter.newLine();


        bufferedWriter.write("Cost of All Cases: " + result +"₴");
        bufferedWriter.newLine();
        bufferedWriter.write("---------------------------------------");
        bufferedWriter.close();
    }


    // ------------Операция с Файлом AllCases----------------------------------
    public ArrayList<Double> amountToList () throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(dataPath));
        ArrayList<Double> result = new ArrayList<Double>();

        String line;
        NumberFormat format = NumberFormat.getInstance(Locale.US);

        while((line = reader.readLine()) != null){
            double number = Double.parseDouble(line.trim());
            result.add(number);
        }
        reader.close();

        return result;
    }

    public void writeAmountToFile(double result) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(dataPath));


        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();
    }


    // ------------Операция с Файлом CaseCount----------------------------------

    public void writeCountToFile(int[] arrayList) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(caseCount));

        for (int number : arrayList){
            bufferedWriter.write(String.valueOf(number));
            bufferedWriter.newLine();
        }
        bufferedWriter.close();
    }

    public int[] countOfCases () throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(caseCount));
        int[] result = new int[5];

        String line;
        NumberFormat format = NumberFormat.getInstance(Locale.US);
        int index = 0;

        while((line = reader.readLine()) != null && index < 5){
            int number = Integer.parseInt(line.trim());
            result[index] = number;
            index++;
        }
        reader.close();

        return result;
    }
}
