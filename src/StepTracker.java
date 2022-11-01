public class StepTracker {

    int[][] monthToData;
    Converter converter = new Converter();

    public StepTracker() {
        monthToData = new int[12][30];
    }
    void saveSteps(int month, int day, int stepsInDay) {
        monthToData[month-1][day-1] = stepsInDay;

    }
    void calcSteps(int month, int targetSteps) {
        int sumSteps = 0;
        int maxSerial = 0;
        int middleCalcSerial = 0; //промежуточная переменная количества последовательных дней
        int maxStepsInMonth = 0;
        for (int i = 0; i < monthToData[month-1].length; i++) {
            sumSteps = sumSteps + monthToData[month-1][i];
            System.out.print((i+1) + " день:" + monthToData[month-1][i] + ", ");

            if (monthToData[month-1][i] >= targetSteps) {
                middleCalcSerial++;
                if (middleCalcSerial > maxSerial) {
                    maxSerial = middleCalcSerial;
                }
            }else {
                middleCalcSerial = 0;
            }
            if (monthToData[month-1][i] > maxStepsInMonth) {
                maxStepsInMonth = monthToData[month-1][i];
            }
        }
        System.out.println(" ");
        System.out.println("Количество пройденых шагов за " + month + " -й месяц:" + sumSteps);
        System.out.println("Наибольшее количество пройденых шагов в " + month + " -ом месяце:" + maxStepsInMonth);
        System.out.println("Среднее количество шагов за " + month + " -й месяц:" + (sumSteps/monthToData[month-1].length));
        converter.distanceInMonth(sumSteps, month);
        converter.energInMonth(sumSteps, month);
        System.out.println("Самая продолжительная серия в " + month + " -м месяце:" + maxSerial + " дней");
    }
}