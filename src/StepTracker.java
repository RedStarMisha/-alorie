import java.util.HashMap;

public class StepTracker {
    private HashMap <String, Integer []> monthSteps = new HashMap<>();


    void writeActivity (String monthName, int day, int steps) {
        if (monthSteps.containsKey(monthName)) {
            Integer [] month = monthSteps.get(monthName);
            month [day] = steps;
        } else {
            monthSteps.put(monthName, new Integer[30]);
            Integer [] month = monthSteps.get(monthName);
            month [day] = steps;
        }
        //System.out.println(monthName+" за "+day+" прошел "+monthSteps.get(monthName)[day]+" шагов");
    }
    void readActivity (String monthName, int numCheckedDay) {
        System.out.println(monthName+" за "+numCheckedDay+" число прошел "+monthSteps.get(monthName)[numCheckedDay]+" шагов");
    }
}
