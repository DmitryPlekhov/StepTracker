public class Converter {
    static double oneSteplenght = 0.00075; // длина одного шага в километрах
    static double oneStepEnerg = 0.05; // калорий за один шаг

    public Converter(){
    }
    void distanceInMonth(int sumSteps, int month) { //пройденная дистанция за месяц
        double distance = sumSteps * oneSteplenght;
        System.out.println("За " + month + "-й месяц Вы прошли " + distance + " км.");
    }

    void energInMonth(int sumSteps, int month){ //количество каллорий за месяц
        double energ = sumSteps * oneStepEnerg;
        System.out.println("За " + month + "-й месяц Вы потратили " + energ + " ккал.");
    }
}
