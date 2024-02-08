package lesson_16;

import java.util.Scanner;

public class CurrencyConverterCLI {
    public static void main(String[] args) {
        String[] inOutPut = {"", ""};
        double[] valueFromTo = {0, 0};

        Currency currencies = (args.length > 0) ? new Currency(args) : new Currency();

        // Почему не работает? в чтом разница с выше?
//        if (args.length > 0) {
//            Currency currencies = new Currency(args);
//        } else {
//            Currency currencies = new Currency();
//        }

        introWelcome(currencies);

        do {

            inOutPut = getInOutPut(currencies);
            valueFromTo = getRateValue(inOutPut, currencies);

            calcTotal(inOutPut, valueFromTo, currencies);

        } while (true);

    }


    public static void calcTotal(String[] inOutPut, double[] valueFromTo, Currency currency) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Задайте сумму " + inOutPut[0] + " которую вы хотите перевести в " + inOutPut[1] + ": ");

        double sum;

        sum = Double.parseDouble(scanner.nextLine());

        double total = currency.calcTot(sum, valueFromTo[0], valueFromTo[1]);
        System.out.println("Вы получите: \n" + total + inOutPut[1] + "\n\n");
    }

    public static String[] getInOutPut(Currency currencies) {
        Scanner scanner = new Scanner(System.in);
        String[] curFtomTo = {"", ""};
        String[] inOutPut = {"", ""};

        for (int i = 0; i < 2; i++) {
            if (i == 0) {
                System.out.println("Выберите исхoдную валюту: ");
            }
            if (i == 1) {
                System.out.println("Выберите конечную валюту: ");
            }

            curFtomTo[i] = scanner.nextLine();
            curFtomTo[i] = curFtomTo[i].toUpperCase();

            inOutPut[i] = currencies.compareCurrency(curFtomTo[i]);
            if (inOutPut[i].equals("wrong")) {
                i = -1;
            }
        }

        System.out.println(curFtomTo[0] + " будут переведины в " + curFtomTo[1]);

        return inOutPut;
    }

    public static double[] getRateValue(String[] inOutPut, Currency currencies) {
        double[] valueFromTo = {0, 0};

        for (int i = 0; i < 2; i++) {
            valueFromTo[i] = currencies.getCurrencyRates(inOutPut[i], currencies);
        }
        return valueFromTo;
    }


    public static void introWelcome(Currency cN) {
        //Выдаётся Привествие с названиями данных валют.
        System.out.println("Welcome to The lesson_16.Currency Converter! \n" +
                "Willkommen in dem Währungsumrechner! \n" +
                "Добро пожаловать в Конверте Валют! \n\n");

        cN.printCurrencies();

        System.out.println("введите EXIT, чтобы завершить программу");
    }
}
