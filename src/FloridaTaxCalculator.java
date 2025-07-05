import java.util.Scanner;

public class FloridaTaxCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ввод годового дохода
        System.out.print("Введите ваш годовой доход ($): ");
        double income = scanner.nextDouble();

        // Расчёт налогов
        double federalTax = calculateFederalTax(income);
        double socialSecurityTax = calculateSocialSecurityTax(income);
        double medicareTax = calculateMedicareTax(income);

        // Во Флориде — state income tax = 0
        double floridaTax = 0;

        // Итог
        double totalTax = federalTax + socialSecurityTax + medicareTax;
        double netIncome = income - totalTax;

        // Вывод
        System.out.println("Федеральный налог: $" + federalTax);
        System.out.println("Social Security налог: $" + socialSecurityTax);
        System.out.println("Medicare налог: $" + medicareTax);
        System.out.println("State tax (Florida): $" + floridaTax);
        System.out.println("Общий налог: $" + totalTax);
        System.out.println("Чистый доход после налогов: $" + netIncome);
    }

    // Примерная федеральная налоговая таблица 2025 (упрощённая для single)
    public static double calculateFederalTax(double income) {
        double tax = 0;

        if (income <= 11000) { // 10%
            tax = income * 0.10;
        } else if (income <= 44725) { // 12%
            tax = 1100 + (income - 11000) * 0.12;
        } else if (income <= 95375) { // 22%
            tax = 5147 + (income - 44725) * 0.22;
        } else if (income <= 182100) { // 24%
            tax = 16290 + (income - 95375) * 0.24;
        } else {
            tax = 37104 + (income - 182100) * 0.32; // приближённо, дальше можно добавить другие уровни
        }

        return tax;
    }

    public static double calculateSocialSecurityTax(double income) {
        double maxSocialSecurity = 168600; // лимит на 2024-2025 год
        if (income > maxSocialSecurity) {
            return maxSocialSecurity * 0.062; // 6.2% до лимита
        } else {
            return income * 0.062;
        }
    }

    public static double calculateMedicareTax(double income) {
        return income * 0.0145; // Medicare = 1.45% на весь доход
    }
}
