package org.example;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MainController {
    public static void main(String[] args) throws IOException {

        String filePath = "C:\\Users\\Evgeniy\\Desktop\\Cases\\Result.txt";

        Scanner scanner = new Scanner(System.in);
        DataController dataController = new DataController();
        ChangeCostController changeCostController = new ChangeCostController();
        // Берет стоимость из файла CaseCost.txt
        double[] cost = changeCostController.caseCost();

        final double SNAKEBITE_CASE = cost[0];
        final double NIGHTMARES_CASE = cost[1];
        final double FRACTURE_CASE = cost[2];
        final double CLUTCH_CASE = cost[3];
        final double RECOIL_CASE = cost[4];

        int[] countOfCases = dataController.countOfCases();
        ArrayList<Double> caseCosts = dataController.amountToList();

        System.out.println("--------------------------------------------");
        System.out.println("Приветствую! Это калькулятор доходов кейсов");
        System.out.println("Выберите операцию: \n" +
                "1. Изменить цену кейсов | 2. Добавить Кейсы ");
        int result = scanner.nextInt();
        scanner.nextLine();

        if (result == 1) {
            changeCostController.changeCost();
        } else if (result == 2) {

            //--------------------Start--------------------------------
            System.out.println("Введите название кейсов: ");
            while (true) {
                System.out.println("Чтобы закончить напишите 'n'");
                String caseName = scanner.nextLine().trim().toUpperCase();
                switch (caseName) {
                    case "SNAKEBITE":
                        caseCosts.add(SNAKEBITE_CASE);
                        countOfCases[0] += 1;
                        continue;
                    case "NIGHTMARES":
                        caseCosts.add(NIGHTMARES_CASE);
                        countOfCases[1] += 1;
                        continue;
                    case "FRACTURE":
                        caseCosts.add(FRACTURE_CASE);
                        countOfCases[2] += 1;
                        continue;
                    case "CLUTCH":
                        caseCosts.add(CLUTCH_CASE);
                        countOfCases[3] += 1;
                        continue;
                    case "RECOIL":
                        caseCosts.add(RECOIL_CASE);
                        countOfCases[4] += 1;
                        continue;
                    case "N":
                        break;
                    default:
                        System.out.println("Неверное имя кейса. Попробуйте снова.");
                        continue;
                }
                break;
            }

            double resultCost = 0;
            for (int i = 0; i < cost.length; i++) {
                resultCost += countOfCases[i] * cost[i];
            }

            System.out.println(resultCost);

            dataController.writeAmountToFile(resultCost);
            dataController.writeCountToFile(countOfCases);
            dataController.result(resultCost, countOfCases);


            dataController.resultToTerminal(caseCosts, countOfCases);
        }

    }

}