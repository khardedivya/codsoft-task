import java.util.Scanner;

public class CurrencyConverter {

    // Method to simulate fetching exchange rates
    public static double getExchangeRate(String baseCurrency, String targetCurrency) {
        // Simulated exchange rates for the sake of the example
        double rate = 1.0;
        switch (baseCurrency.toUpperCase()) {
            case "USD":
                if (targetCurrency.equalsIgnoreCase("INR")) {
                    rate = 82.0; // 1 USD = 82 INR
                } else if (targetCurrency.equalsIgnoreCase("EUR")) {
                    rate = 0.93; // 1 USD = 0.93 EUR
                }
                break;
            case "INR":
                if (targetCurrency.equalsIgnoreCase("USD")) {
                    rate = 0.012; // 1 INR = 0.012 USD
                } else if (targetCurrency.equalsIgnoreCase("EUR")) {
                    rate = 0.011; // 1 INR = 0.011 EUR
                }
                break;
            case "EUR":
                if (targetCurrency.equalsIgnoreCase("USD")) {
                    rate = 1.07; // 1 EUR = 1.07 USD
                } else if (targetCurrency.equalsIgnoreCase("INR")) {
                    rate = 88.0; // 1 EUR = 88 INR
                }
                break;
            default:
                System.out.println("Unsupported currency.");
                break;
        }
        return rate;
    }

    // Main method for currency conversion
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Available currencies
        String[] currencies = {"USD", "INR", "EUR"};

        // Select base currency
        System.out.print("Select your base currency (USD, INR, EUR): ");
        String baseCurrency = scanner.next().toUpperCase();

        // Validate base currency
        if (!isValidCurrency(baseCurrency, currencies)) {
            System.out.println("Invalid base currency.");
            return;
        }

        // Select target currency
        System.out.print("Select your target currency (USD, INR, EUR): ");
        String targetCurrency = scanner.next().toUpperCase();

        // Validate target currency
        if (!isValidCurrency(targetCurrency, currencies)) {
            System.out.println("Invalid target currency.");
            return;
        }

        // Check if base and target currencies are the same
        if (baseCurrency.equals(targetCurrency)) {
            System.out.println("Base and target currencies cannot be the same.");
            return;
        }

        // Input amount for conversion
        System.out.print("Enter the amount to convert: ");
        double amount = scanner.nextDouble();

        // Validate amount
        if (amount <= 0) {
            System.out.println("Amount must be greater than zero.");
            return;
        }

        // Fetch exchange rate
        double exchangeRate = getExchangeRate(baseCurrency, targetCurrency);

        // Convert the amount
        double convertedAmount = amount * exchangeRate;

        // Display the result
        System.out.printf("%.2f %s is equal to %.2f %s\n", amount, baseCurrency, convertedAmount, targetCurrency);

        scanner.close();
    }

    // Helper method to validate the currency input
    private static boolean isValidCurrency(String currency, String[] validCurrencies) {
        for (String validCurrency : validCurrencies) {
            if (validCurrency.equalsIgnoreCase(currency)) {
                return true;
            }
        }
        return false;
    }
}
