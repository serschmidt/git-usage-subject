public class Currancy5MethodsObject {
    public static void main(String[] args) {
        String[] = curname = {"EURO", "USD", "TL", "RUB"};

        introWelcome(curName);


    }

    public static void introWelcome(String[] cN) {
        //Выдаётся Привествие с названиями данных валют.
        System.out.println("Welcome to The Currency Converter! \n" +
                "Willkommen in dem Währungsumrechner! \n" +
                "Добро пожаловать в Конверте Валют! \n\n");
        for (int i = 0; i < cN.length; i++) {
            System.out.println((i + 1) + ". " + cN[i]);
        }
        return;
    }



}
