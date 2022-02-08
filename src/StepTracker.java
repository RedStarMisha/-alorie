import java.util.Arrays;
import java.util.HashMap;

public class StepTracker {
    private HashMap<String, int []> monthSteps = new HashMap<>();
    Converter converter = new Converter();
    private int dayGoal = 1000;
    private int bestSeries;

    StepTracker() {
        for (Months month : Months.values()) {
            monthSteps.put(String.valueOf(month), new int[30] );
        }
    }

    boolean checkMonth(String month) {
        return monthSteps.containsKey(month);
    }

    void setActivity(String monthName, int day, int steps) {
        int [] setActivityOfMonth = monthSteps.get(monthName);
        setActivityOfMonth[day-1]=steps;
    }

    void viewActivity(String month) {
        int stepsOfMonth = 0;
        int activDay = 0;
        System.out.println("Статистика за месяц " + month + " :");
        for (int i = 0; i < monthSteps.get(month).length; i++) {
            System.out.print((i + 1) + " день:" + monthSteps.get(month)[i]);
            System.out.print(i!=(monthSteps.get(month).length-1) ? ", ": "");
            stepsOfMonth += monthSteps.get(month)[i];
            activDay++;
        }
        System.out.println("\nКоличество шагов за месяц - " + stepsOfMonth);
        System.out.println("Среднее количество шагов - " + stepsOfMonth / activDay);
        System.out.println("За месяц поройдено " + converter.convertDistance(stepsOfMonth) + " км");
        System.out.println("За месяц сожжено " + converter.convertEnergy(stepsOfMonth) + " калорий");
        System.out.println("Лучшая серия составила " + findSeries(monthSteps.get(month)) + " дней");
    }

    int findSeries(int[] oneMonth) {
        int localSerisesOfActivity = 0;
        for (int i = 0; i < (oneMonth.length); i++) {
            if (oneMonth[i] >= dayGoal) {
                localSerisesOfActivity++;
            } else {
                if (localSerisesOfActivity > bestSeries) {
                    bestSeries = localSerisesOfActivity;
                }
                localSerisesOfActivity = 0;
            }
        }
        return bestSeries;
    }


    public void setDayGoal(int dayGoal) {
        this.dayGoal = dayGoal;
    }
}







