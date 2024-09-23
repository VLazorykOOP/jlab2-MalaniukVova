public class task3 {

    // Метод для знаходження найбільшого спільного дільника (НСД) за алгоритмом Евкліда
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // Метод для знаходження найменшого спільного кратного (НСК)
    public static int lcm(int a, int b) {
        return a * (b / gcd(a, b)); // НСК через НСД
    }

    // Метод main для запуску програми
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Будь ласка, введіть 2 цілих числа.");
            return;
        }

        try {
            int num1 = Integer.parseInt(args[0]);
            int num2 = Integer.parseInt(args[1]);

            System.out.println("Введені числа: " + num1 + " і " + num2);
            System.out.println("Найбільший спільний дільник (НСД): " + gcd(num1, num2));
            System.out.println("Найменше спільне кратне (НСК): " + lcm(num1, num2));
        } catch (NumberFormatException e) {
            System.out.println("Будь ласка, введіть правильні цілі числа.");
        }
    }
}
