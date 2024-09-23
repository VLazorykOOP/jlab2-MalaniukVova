import java.util.Scanner;

public class task1 {
    private long wholePart; // Ціла частина
    private short fractionalPart; // Дробова частина

    // Конструктор
    public task1(long wholePart, short fractionalPart) {
        this.wholePart = wholePart;
        this.fractionalPart = fractionalPart;
    }

    // Гетери для отримання значень
    public long getWholePart() {
        return wholePart;
    }

    public short getFractionalPart() {
        return fractionalPart;
    }

    // Метод для додавання двох дробів
    public task1 add(task1 other) {
        long newWholePart = this.wholePart + other.getWholePart();
        short newFractionalPart = (short) (this.fractionalPart + other.getFractionalPart());

        if (newFractionalPart >= 100) {
            newWholePart += 1;
            newFractionalPart -= 100;
        }

        return new task1(newWholePart, newFractionalPart);
    }

    // Метод для віднімання двох дробів
    public task1 subtract(task1 other) {
        long newWholePart = this.wholePart - other.getWholePart();
        short newFractionalPart = (short) (this.fractionalPart - other.getFractionalPart());

        if (newFractionalPart < 0) {
            newWholePart -= 1;
            newFractionalPart += 100;
        }

        return new task1(newWholePart, newFractionalPart);
    }

    // Метод для множення двох дробів
    public task1 multiply(task1 other) {
        double thisValue = this.toDouble();
        double otherValue = other.toDouble();
        double result = thisValue * otherValue;

        return fromDouble(result);
    }

    // Метод для порівняння дробів
    public int compareTo(task1 other) {
        return Double.compare(this.toDouble(), other.toDouble());
    }

    // Перетворення дробу у тип double для зручності
    public double toDouble() {
        return this.wholePart + this.fractionalPart / 100.0;
    }

    // Статичний метод для створення дробу з типу double
    public static task1 fromDouble(double value) {
        long wholePart = (long) value;
        short fractionalPart = (short) ((value - wholePart) * 100);
        return new task1(wholePart, fractionalPart);
    }

    @Override
    public String toString() {
        return wholePart + "." + String.format("%02d", fractionalPart);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Введення першого дробу
        System.out.print("Введіть цілу частину першого дробу: ");
        long wholePart1 = scanner.nextLong();
        System.out.print("Введіть дробову частину першого дробу (0-99): ");
        short fractionalPart1 = scanner.nextShort();

        task1 f1 = new task1(wholePart1, fractionalPart1);

        // Введення другого дробу
        System.out.print("Введіть цілу частину другого дробу: ");
        long wholePart2 = scanner.nextLong();
        System.out.print("Введіть дробову частину другого дробу (0-99): ");
        short fractionalPart2 = scanner.nextShort();

        task1 f2 = new task1(wholePart2, fractionalPart2);

        // Виконання операцій
        System.out.println("Додавання: " + f1.add(f2));
        System.out.println("Віднімання: " + f1.subtract(f2));
        System.out.println("Множення: " + f1.multiply(f2));
        System.out.println("Порівняння: " + (f1.compareTo(f2) == 0 ? "Дроби рівні" : f1.compareTo(f2) > 0 ? "Перший дріб більший" : "Другий дріб більший"));
    }
}
