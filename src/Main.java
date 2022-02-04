import java.util.Scanner;

public class Main {
    static Scanner scanner=new Scanner(System.in);
    static String month;

    public static void viewMenu() {
        System.out.println("Выберите пункт меню");
        System.out.println("1 - Ввести количество шагов за определённый день");
        System.out.println("2 - Напечатать статистику за определённый месяц");
        System.out.println("3 - Изменить цель по количеству шагов в день");
        System.out.println("4 - Выйти из приложения");
    }

    public static void main(String[] args) {
        StepTracker stepTracker=new StepTracker();
        viewMenu();
        while (true) {
            int numMenu=scanner.nextInt();
            if (numMenu==1) {
                System.out.println("Про какой месяц речь");
                month = scanner.next();
                System.out.println("За какое число вы хотите ввести данные");
                int numDay = scanner.nextInt();
                System.out.println("Сколько шагов вы прошли за этот день");
                int quantityOfSteps = scanner.nextInt();
                stepTracker.writeActivity(month, numDay,quantityOfSteps);

            } else if (numMenu==2) {
                System.out.println("За какой день считать");
                int numCheckedDay = scanner.nextInt();
                stepTracker.readActivity(month, numCheckedDay);
            } else if (numMenu==3) {

            } else if (numMenu==4) {
                break;
            }
        }

    }
}
    /*
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите год:");
        int year = scanner.nextInt();

        if (isLeapYear(year)) {
            System.out.println("Год високосный, день программиста отмечаем 12.09." + year);

        } else {
            System.out.println("Год не високосный, день программиста отмечаем 13.09." + year);
        }

    }


    public static boolean isLeapYear(int year) {
        return (year % 100 != 0 && year % 4 == 0 || year % 400 == 0);
    }

}
*/