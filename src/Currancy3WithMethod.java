import java.util.Scanner;

public class Currancy3WithMethod {

    // static double curValue;

    public static void main(String[] args) {
// ---------------------------------------------------- // Initialisiere Werte der Währung basierend auf EURO
        double[] curValue = {1.0, 0.91735, 0.03033, 0.01022};    // Ввод Валюты к базе ЕВРО
        String[] curName = {"EURO", "USD", "TL", "RUB"};

        if (args.length == curName.length) {                         // Ersetze Werte der Währung durch die Eingebe der Kommandozeile, falls vorhanden.
            for (int i = 0; i < curValue.length; i++) {
                curValue[i] = Double.parseDouble(args[i]);
            }
        }
// ----------------------------------------------------

        String[] currancy = {"", ""}; //     currancy[0] -> From;  currancy[1] -> In ;

        double[] cur = new double[2];
        double total = 0;


        String[] hilsSatz = {"исходную", "цель"};
        Scanner scanner = new Scanner(System.in);


        introWelcome(curName);                  //Приветствие и Список Валют

        mainCycle:
        do {
            for (int j = 0; j < 2; j++) {

//                System.out.println("Geben sie die "+ hilsSatz[j] + "  ein: ");  // Währung eingeben [0] für
                System.out.println("выберите " + hilsSatz[j] + " Валюту: ");
                currancy[j] = scanner.nextLine();                   // [0] für Eingangswährung
                currancy[j] = currancy[j].toUpperCase();            // [1] für Zielwährung

                if (currancy[j].equals("EXIT")){
                    System.out.println("Good Bye!");
                    break mainCycle;
                }

                cur[j] = getRateValue(currancy[j], curValue);

            }

//            System.out.println(currancy[0] + " werden in " + currancy[1] + " umgewandelt ");
            System.out.println(currancy[0] + " будут переведины в " + currancy[1]);


//            System.out.println("Geben sie die Summe der umzuwandelnde Währenug ein: ");
            System.out.println("Задайте сумму " + currancy[0] + " которую вы хотите перевести в " + currancy[1] + ": ");

            double sum;

            sum = Double.parseDouble(scanner.nextLine());

            total = sum * cur[0] / cur[1];
            total = (double) ((int) (total * 100)) / 100; //Zwei stellen anzeigen.

//            System.out.println("Sie erhalten folgenden Betrag: \n" + total + currancy[1] + "\n\n");
            System.out.println("Вы получите: \n" + total + currancy[1] + "\n\n");
        } while (true);
    }

    public static void introWelcome(String[] cN) {
        System.out.println("Welcome to The Currency Converter \n Willkommen in Dem Währungsumrechner! \n Добро пожаловать в Конверте Валют! \n\n");
        for (int i = 0; i < cN.length; i++) {
            System.out.println((i + 1) + ". " + cN[i]);
        }
        return;
    }

    public static double getRateValue(String currancy, double[] rates) {
        double value = 0.0;
        switch (currancy) {

            case "EXIT":
                System.out.println("exit");
                break;
//                System.exit(-1);
            case "EURO":
                value = rates[0]; // Wechselkurs EURO zu EURO
                break;
            case "USD":
                value = rates[1]; // Wechselkurs USD zu EURO
                break;
            case "TL":
                value = rates[2]; // Wechselkurs TL zu EURO
                break;
            case "RUB":
                value = rates[3]; // Wechselkurs RUB zu EURO
                break;
            default:
                System.out.println("неверная Валюта");
//                System.exit(-1);
        }
        return value;
    }

}
