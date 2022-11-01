import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker(); //здесь создали объект stepTracker класса StepTracker

        printMenu();
        int userInput = scanner.nextInt();
        int targetSteps = 10000; //целевое количество шагов в день

        while (userInput != 0) {
            if (userInput == 1) { //учет шагов за определенный день
                printMonths();
                //int month = scanner.nextInt();
                int month = 12; // УДАЛИТЬ!!!
                System.out.println("Укажите день");
                int toDay = scanner.nextInt();
                System.out.println("Количество шагов");
                //int stepsInDay = scanner.nextInt();
                int stepsInDay = (int) (Math.random()*20000); // УДАЛИТЬ!!!
                stepTracker.saveSteps(month, toDay, stepsInDay);
            }

            if (userInput == 2) { //печать статистики за выбранный месяц
                printMonths();
                int month = scanner.nextInt();
                stepTracker.calcSteps(month, targetSteps);
            }

            if (userInput == 3) { // дневная цель
                System.out.println("Введите количество шагов, которые будут являться вашей целью");
                targetSteps = scanner.nextInt();
                if (targetSteps < 0) {
                    targetSteps = 10000;
                    System.out.println("Вы ввели не допустимое значение. Дневная цель не может быть меньше 0!");
                }
                System.out.println("Текущая цель " + targetSteps + " шагов в день");
            }

            if (userInput < 0) { // команда вне диапазона <0
                System.out.println("Такой команды нет. Выберите другую команду.");
            }

            if (userInput > 3) { // команда вне диапазона >3
                System.out.println("Такой команды нет. Выберите другую команду.");
            }

            printMenu(); // печатаем меню ещё раз перед завершением предыдущего действия
            userInput = scanner.nextInt(); // повторное считывание данных от пользователя
        }
        System.out.println("Программа завершена");
    }

    private static void printMenu() {
        System.out.println("Вас приветствует программа учета калорий! ");
        System.out.println("Пожалуйста, введите действие, которое Вы хотите выполнить:");
        System.out.println("1 - ввод количества шагов за определенный день;");
        System.out.println("2 - напечатать статистику за определенный месяц;");
        System.out.println("3 - изменить цель по количеству шагов за день;");
        System.out.println("0 - выйти из приложения.");
    }

    private static void printMonths() {
        System.out.println("Укажите месяц 1-ЯНВ, 2-ФЕВ, 3-МАР, 4-АПР, 5-МАЙ, 6-ИЮН, 7-ИЮЛ, 8-АВГ, 9-СЕН, 10-ОКТ, 11-НОЯ, 12-ДЕК");
    }
}