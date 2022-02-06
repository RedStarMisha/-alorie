import java.util.Arrays;
import java.util.HashMap;

public class StepTracker {
    private HashMap <String, Integer []> monthSteps = new HashMap<>();
    Converter converter = new Converter();
    int dayGoal = 10000;
    int bestSeries;
    StepTracker () {
        for (Months month:Months.values()) {
            monthSteps.put(String.valueOf(month), new Integer[30]);
        }
    }

    void viewActivity (String month) {
        int stepsOfMonth=0;
        int activDay=0;
        System.out.println("Статистика за месяц "+month+" :");
        for (int i=0;i<monthSteps.get(month).length;i++) {
            System.out.print((i+1) +" день:"+monthSteps.get(month)[i]);
            if (monthSteps.get(month)[i]!=null) {
                stepsOfMonth+=monthSteps.get(month)[i];
                activDay++;
            }
            if (i>0) {

            }
        }
        System.out.println("Количество шагов за месяц - "+stepsOfMonth);
        System.out.println("Среднее количество шагов - "+ stepsOfMonth/activDay );
        System.out.println("За месяц поройдено "+converter.convertDistance(stepsOfMonth)+" км");
        System.out.println("За месяц сожжено "+converter.convertEnergy(stepsOfMonth)+" калорий");
    }

    void writeActivity (String monthName, int day, int steps) {
                monthSteps.get(monthName)[day-1]=steps;
    }

    boolean checkMonth (String month) {
        return monthSteps.containsKey(month);
    }
    
    /*void viewActivity (String monthName, int numCheckedDay) {
        Integer[] selectedMonth = monthSteps.get(monthName);
        System.out.println("Количество пройденных шагов по дням :");
        for (int i=0;i<selectedMonth.length;i++) {
            System.out.print((i+1)+" день: "+selectedMonth[i]);
        }*/



        //System.out.println(monthName + " за " + numCheckedDay + " число прошел " + monthSteps.get(monthName)[numCheckedDay] + " шагов");
    }







