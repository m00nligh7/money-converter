import java.util.Scanner;

public class Converter{
    public static void main(String[] args){
        mainProcess();
    }
    public static void mainProcess(){
        Scanner sc = new Scanner(System.in);
        printInformation(1);
        printInformation(2);
        int rubles = sc.nextInt();
        printInformation(3);
        int selectedCurrency = sc.nextInt();
        selectCurrency(selectedCurrency, rubles);
        printInformation(4);
        int selectExit = sc.nextInt();
        exit(selectExit);
        sc.close();
        
    }
    public static void printInformation(int choose){
        switch(choose){
            case 1:
                System.out.println("  __  __                      ___                     _           ");
                System.out.println(" |  \\/  |___ _ _  ___ _  _   / __|___ _ ___ _____ _ _| |_ ___ _ _ ");
                System.out.println(" | |\\/| / _ \\ ' \\/ -_) || | | (__/ _ \\ ' \\ V / -_) '_|  _/ -_) '_|");
                System.out.println(" |_|  |_\\___/_||_\\___|\\_, |  \\___\\___/_||_\\_/\\___|_|  \\__\\___|_|  ");
                System.out.println("                      |__/                                        \n");
                System.out.println("How the program works: ");
                System.out.println("1. User enters the amount (in rubles)");
                System.out.println("2. Selecting the target currency for conversion");
                System.out.println("3. The program calculates the value and outputs it to the console\n");
                break;
            case 2:
                System.out.print("Enter the amount to convert (in rubles): ");
                break;
            case 3:
                System.out.println("\nEnter the number of the currency you want to convert rubles to: ");
                System.out.println("1. Dollars");
                System.out.println("2. Euros");
                System.out.print("Your choice: ");
                break;
            case 4:
                System.out.println("\nDo you want to continue?");
                System.out.println("1. Yes");
                System.out.println("2. No");
                System.out.print("Your choice: ");
                break;
        }
        
    }
    public static void selectCurrency(int select, int currency){
        switch(select){
            case 1:
                RUBToUSD(currency);
                break;
            case 2:
                RUBToEUR(currency);
                break;
            default:
                System.out.println("\nError: Invalid choice");
        }
    }
    public static void RUBToUSD(int number){ 
        float exchangerateUSDtoRUB = 79.35f; // Exchange rate as of 07/25/2025
        String preResult = Float.toString(number / exchangerateUSDtoRUB);
        int dotIndex = preResult.indexOf(".");
        System.out.println("\nRUB to USD conversion: " + preResult.substring(0, dotIndex + 3) + " USD"); 
    } 
    
    // Note: The conversion principle is slightly modified - 
    // we're using the dollar's value in rubles (how many RUB per 1 USD)
    // and then dividing our amount by this USD-to-RUB rate
    // Same logic applies to the RUBtoEUR method

    public static void RUBToEUR(int number){
        float exchangerateEURtoRUB = 93.01f; // Exchange rate as of 07/25/2025
        String preResult = Float.toString(number / exchangerateEURtoRUB);
        int dotIndex = preResult.indexOf(".");
        System.out.println("\nRUB to EUR conversion: " + preResult.substring(0, dotIndex + 3) + " EUR");
    }

    public static void exit(int select){
        switch(select){
            case 1:
                System.out.println("\n");
                mainProcess();
            case 2:
                return;
            default:
                System.out.println("\nError: Invalid choice");
                System.out.println("Continuing...\n");
                mainProcess();
        }
    }

}
