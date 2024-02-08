package lesson_16;

public class Currency {
    //    String[] name = {"EURO", "USD", "TL", "RUB"};
    String[] name;
    //    double[] initValue = {1.0, 0.91735, 0.03033, 0.01022};
    double[] value;

    // Конструкт без переданных аргументах
    Currency() {
        this.name = new String[4];
        this.name[0] = "EURO";
        this.name[1] = "USD";
        this.name[2] = "TL";
        this.name[3] = "RUB";

        this.value = new double[4];
        this.value[0] = 1.0;
        this.value[1] = 0.91735;
        this.value[2] = 0.03033;
        this.value[3] = 0.01022;
    }

    // Конструкт с переданнами аргументами
    Currency(String[] args) {
        // вызов конструкта для инициализации изначальных переменных
        this();
        // если ровно 4 аргумента, то ожидаю без проверки,
        // что аргументы это цыфры поочерёдной стоимости Валют.
        if (args.length == 4) {
            for (int i = 0; i < args.length; i++) {
                this.value[i] = Double.parseDouble(args[i]);
            }
        } else {
            //проверка, заданы ли валюты в строке Аргументов.
            //После название Валюты идёт её Стоимость в EURO
            for (int i = 0; i < args.length; i++) {
                if (args[i].equals("EURO:")) {
                    int j = 0;
                    this.value[j] = Double.parseDouble(args[i + 1]);
                } else if (args[i].equals("USD:")) {
                    int j = 1;
                    this.value[j] = Double.parseDouble(args[i + 1]);
                } else if (args[i].equals("TL:")) {
                    int j = 2;
                    this.value[j] = Double.parseDouble(args[i + 1]);
                } else if (args[i].equals("RUB:")) {
                    int j = 3;
                    this.value[j] = Double.parseDouble(args[i + 1]);
                }
                // проверяются только заданные Валюты, остальные игнорируются
            }
        }
    }

    public void printCurrencies(){
        for (int i = 0; i < this.name.length; i++) {
            System.out.println( i + 1 + ": " + this.name[i]);
        }
    }

    public String compareCurrency(String cur){
        String currentCur = "";
        switch (cur) {

            case "EXIT":
                System.out.println("до скорой Встречи. Exit.");
                System.exit(-1);
                break;
            case "EURO":
                currentCur = this.name[0];
            break;
            case "USD":
                currentCur = this.name[1];
            break;
            case "TL":
                currentCur = this.name[2];
            break;
            case "RUB":
                currentCur = this.name[3];
            break;
            default:
                System.out.println("неверная Валюта");
                currentCur = "wrong";
        }
        return currentCur;
    }

    public double getCurrencyRates(String cur, Currency currencies) {
        double curValue=0;

        switch (cur) {

            case "EURO":
                curValue = currencies.value[0];
                break;
            case "USD":
                curValue = currencies.value[1];
                break;
            case "TL":
                curValue = currencies.value[2];
                break;
            case "RUB":
                curValue = currencies.value[3];
                break;
            default:
                break;
        }
        return curValue;
    }

    public double calcTot(double sum, double valueFrom, double valueTo){
        double total = sum * valueFrom / valueTo;
        total = (double) ((int) (total * 100)) / 100; //Zwei stellen anzeigen.
        return total;
    }

}