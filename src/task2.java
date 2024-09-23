import java.util.Scanner;

public class task2 {
    private double edge; // Довжина ребра куба

    // Конструктор
    public task2(double edge) {
        this.edge = edge;
        System.out.println("Конструктор: Створено куб з ребром = " + edge);
    }

    // Метод для обчислення сумарної площі граней куба
    public double getSurfaceArea() {
        double surfaceArea = 6 * Math.pow(edge, 2);
        System.out.println("Обчисленна площі: Площа граней = " + surfaceArea);
        return surfaceArea;
    }

    // Метод для обчислення об'єму куба
    public double getVolume() {
        double volume = Math.pow(edge, 3);
        System.out.println("Обчислення об'єму: Об'єм куба = " + volume);
        return volume;
    }

    // Метод для обчислення довжини великої діагоналі куба
    public double getDiagonal() {
        double diagonal = edge * Math.sqrt(3);
        System.out.println("Обчислення діагоналі: Довжина діагоналі = " + diagonal);
        return diagonal;
    }

    // Метод main для запуску програми
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Створення об'єкту Scanner для зчитування вводу з клавіатури

        // Введення довжини ребра куба користувачем
        System.out.print("Введіть довжину ребра куба: ");
        double edge = scanner.nextDouble();

        // Створення об'єкту куба з введеним значенням ребра
        task2 cube = new task2(edge);

        // Виведення результатів обчислень
        System.out.println("Сумарна площа граней: " + cube.getSurfaceArea());
        System.out.println("Об'єм куба: " + cube.getVolume());
        System.out.println("Довжина великої діагоналі: " + cube.getDiagonal());
    }
}
