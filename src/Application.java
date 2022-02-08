import java.util.Scanner;

public class Application {
    static Scanner scanner = new Scanner(System.in);
    static String month;

    public static void viewMenu() {
        System.out.println("Выберите пункт меню");
        System.out.println("1 - Ввести количество шагов за определённый день");
        System.out.println("2 - Напечатать статистику за определённый месяц");
        System.out.println("3 - Изменить цель по количеству шагов в день");
        System.out.println("4 - Выйти из приложения");
    }

    public static void main(String[] args) {
        StepTracker stepTracker = new StepTracker();
        while (true) {
            viewMenu();
            int numMenu = scanner.nextInt();
            if (numMenu == 1) {
                while (true) {
                    System.out.println("Про какой месяц речь");
                    month = scanner.next();
                    if (!stepTracker.checkMonth(month)) {
                        System.out.println("Введите месяц правильно");
                    } else {
                        break;
                    }
                }
                System.out.println("За какое число вы хотите ввести данные");
                int numDay = scanner.nextInt();
                System.out.println("Сколько шагов вы прошли за этот день");
                int quantityOfSteps = scanner.nextInt();
                stepTracker.setActivity(month, numDay, quantityOfSteps);

            } else if (numMenu == 2) {
                System.out.println("За какой месяц считать");
                String monthChecked = scanner.next();
                stepTracker.viewActivity(monthChecked);
            } else if (numMenu == 3) {
                System.out.println("Какую ежедневную цель хотите установить");
                int newGoal = -1;
                while (newGoal < 0) {
                    System.out.println("Введите положительное значение");
                    newGoal = scanner.nextInt();
                    stepTracker.setDayGoal(newGoal);
                }
            } else if (numMenu == 4) {
                break;
            }
        }

    }
}