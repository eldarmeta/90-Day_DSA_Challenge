package extras;

import java.util.Scanner;

public class MonthlyBudgetTracker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ввод дохода
        System.out.print("Введите ваш ежемесячный доход ($): ");
        double income = scanner.nextDouble();

        // Ввод расходов
        System.out.print("Расходы на жильё ($): ");
        double rent = scanner.nextDouble();

        System.out.print("Расходы на еду ($): ");
        double food = scanner.nextDouble();

        System.out.print("Транспортные расходы ($): ");
        double transportation = scanner.nextDouble();

        System.out.print("Расходы на подписки и интернет ($): ");
        double subscriptions = scanner.nextDouble();

        System.out.print("Дополнительные расходы ($): ");
        double others = scanner.nextDouble();

        // Расчёт
        double totalExpenses = rent + food + transportation + subscriptions + others;
        double remaining = income - totalExpenses;

        double suggestedSaving = remaining * 0.50; // 50% откладывать
        double suggestedInvesting = remaining * 0.30; // 30% инвестировать
        double suggestedFun = remaining * 0.20; // 20% тратить на удовольствие

        // Вывод
        System.out.println("\nИтоговый отчёт:");
        System.out.println("Общие расходы: $" + totalExpenses);
        System.out.println("Остаток: $" + remaining);

        if (remaining < 0) {
            System.out.println("⚠️ Внимание! Вы тратите больше, чем зарабатываете!");
        } else {
            System.out.println("Рекомендую:");
            System.out.println("- Отложить (сбережения): $" + suggestedSaving);
            System.out.println("- Инвестировать: $" + suggestedInvesting);
            System.out.println("- Развлечения: $" + suggestedFun);
        }
    }
}
