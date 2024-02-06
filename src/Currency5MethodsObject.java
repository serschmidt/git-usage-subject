import java.util.Scanner;

class Currency {
    String name;
    double value;

    Currency() {
        name = "Euro";
        value = 0.92;
    }

    Currency(double value) {
        name = "EURO";
        this.value = value;
    }

    Currency(String name, double value) {
        this.name = name;
        this.value = value;
    }
}


public class Currency5MethodsObject {
    public static void main(String[] args) {
        String[] inOutPut = {"", ""};
        boolean loop = true;
        double[] valueFromTo = {0, 0};

        Currency[] currencies = new Currency[4];

        currencies = initCur(args);

        introWelcome(currencies);

        do {

            inOutPut = getInOutPut(currencies);
            valueFromTo = getRateValue(inOutPut, currencies);

            calcTotal(inOutPut, valueFromTo);

        } while (true);

    }

    public static void calcTotal(String[] inOutPut, double[] valueFromTo) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Задайте сумму " + inOutPut[0] + " которую вы хотите перевести в " + inOutPut[1] + ": ");

        double sum;

        sum = Double.parseDouble(scanner.nextLine());

        double total = sum * valueFromTo[0] / valueFromTo[1];
        total = (double) ((int) (total * 100)) / 100; //Zwei stellen anzeigen.

        System.out.println("Вы получите: \n" + total + inOutPut[1] + "\n\n");
    }

    public static String[] getInOutPut(Currency[] currencies) {
        Scanner scanner = new Scanner(System.in);
        String[] curFtomTo = {"", ""};
        String[] inOutPut = {"", ""};
        double[] valueFromTo = {0, 0};

        for (int i = 0; i < 2; i++) {
            if (i == 0) {
                System.out.println("Выберите исхoдную валюту: ");
            }
            if (i == 1) {
                System.out.println("Выберите цель валюту: ");
            }

            curFtomTo[i] = scanner.nextLine();
            curFtomTo[i] = curFtomTo[i].toUpperCase();

            switch (curFtomTo[i]) {

                case "EXIT":
                    System.out.println("до скорой Встречи. Exit.");
                    System.exit(-1);
                    break;
                case "EURO":
                    inOutPut[i] = currencies[0].name;
                    break;
                case "USD":
                    inOutPut[i] = currencies[1].name;
                    break;
                case "TL":
                    inOutPut[i] = currencies[2].name;
                    break;
                case "RUB":
                    inOutPut[i] = currencies[3].name;
                    break;
                default:
                    System.out.println("неверная Валюта");
                    i = -1;

            }
        }
        System.out.println(curFtomTo[0] + " будут переведины в " + curFtomTo[1]);

        return inOutPut;
    }

    public static double[] getRateValue(String[] inOutPut, Currency[] currencies) {
        double[] valueFromTo = {0, 0};

        for (int i = 0; i < 2; i++) {

            switch (inOutPut[i]) {

                case "EURO":
                    valueFromTo[i] = currencies[0].value;
                    break;
                case "USD":
                    valueFromTo[i] = currencies[1].value;
                    break;
                case "TL":
                    valueFromTo[i] = currencies[2].value;
                    break;
                case "RUB":
                    valueFromTo[i] = currencies[3].value;
                    break;
                default:
                    break;
            }
        }
        return valueFromTo;
    }

    public static Currency[] initCur(String[] arg) {
        //Инициализациа изначальных Валют
        double[] initValue = {1.0, 0.91735, 0.03033, 0.01022};
        double[] curValue = new double[initValue.length];
        String[] curName = {"EURO", "USD", "TL", "RUB"};

        Currency[] c = new Currency[4];

        for (int i = 0; i < 4; i++) {
            c[i] = new Currency(curName[i], initValue[i]);
            System.out.println(c[i].name + " " + c[i].value);
        }
        //проверка, заданы ли валюты в строке Аргументов.
        //После название Валюты идёт её Стоимость в EURO
        for (int i = 0; i < arg.length; i++) {
            int j;
            if (arg[i].equals("EURO:")) {
                j = 0;
                c[j].value = Double.parseDouble(arg[i + 1]);
            } else if (arg[i].equals("USD:")) {
                j = 1;
                c[j].value = Double.parseDouble(arg[i + 1]);
            } else if (arg[i].equals("TL:")) {
                j = 2;
                c[j].value = Double.parseDouble(arg[i + 1]);
            } else if (arg[i].equals("RUB:")) {
                j = 3;
                c[j].value = Double.parseDouble(arg[i + 1]);
            }
            // проверяются только заданные Валюты, остальные игнорируются
        }

        return c;
    }

    public static void introWelcome(Currency[] cN) {
        //Выдаётся Привествие с названиями данных валют.
        System.out.println("Welcome to The Currency Converter! \n" +
                "Willkommen in dem Währungsumrechner! \n" +
                "Добро пожаловать в Конверте Валют! \n\n");
        for (int i = 0; i < 4; i++) {
            System.out.println((i + 1) + ". " + cN[i].name);
        }
        return;
    }


}
