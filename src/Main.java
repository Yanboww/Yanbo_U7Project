import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
       String answer = "";
       Scanner s = new Scanner(System.in);
       while(!answer.contains("4"))
       {
           System.out.println("\n------------------------------------------------------");
           System.out.println("What would you like to do?");
           System.out.println("1. Calculate Cost of One Package");
           System.out.println("2. Simulate Packages");
           System.out.println("3. How Packages are Calculated");
           System.out.println("4. Exit");
           System.out.print("Input: ");
           answer = s.nextLine();
           parseAnswer(answer, s);
       }


    }
    public static void parseAnswer(String answer, Scanner s)
    {
        if(answer.contains("1")) choiceOne(s);
        else if(answer.contains("2")) choiceTwo(s);
        else if(answer.contains("3")) choiceThree();
        else if(!answer.contains("4")) System.out.println("Invalid option");
    }
    public static void choiceOne(Scanner s)
    {
        try{
            System.out.println("------------------------------------------------------");
            System.out.print("Enter zip code of the origin of the package: ");
            int origin = Integer.parseInt(s.nextLine());
            System.out.print("Enter zip code of the destination of the package: ");
            int destination = Integer.parseInt(s.nextLine());
            if(origin>99950 || origin<1 || destination>99950 || destination<1){System.out.println("Invalid zip code"); return;}
            System.out.print("Enter weight of the package: ");
            double weight = Double.parseDouble(s.nextLine());
            System.out.print("Enter height of the package: ");
            double height = Double.parseDouble(s.nextLine());
            System.out.print("Enter length of the package: ");
            double length = Double.parseDouble(s.nextLine());
            System.out.print("Enter width of the package: ");
            double width = Double.parseDouble(s.nextLine());
            if(width<0.1 || length<2 || weight<2 || height<2){System.out.println("Incompatible package"); return;}
            System.out.println("Cost: " + PostageCalculator.calculatePostage(origin,destination,weight,height,length,width));
        }
        catch (NumberFormatException e)
        {
            System.out.println("Invalid input");
        }
    }
    public static void choiceTwo(Scanner s)
    {
        try{
            System.out.println("------------------------------------------------------");
            System.out.print("How many packages would you like to simulate? ");
            int repetition = Integer.parseInt(s.nextLine());
            PackageSimulator.generatePackages(repetition);
        }
        catch (NumberFormatException e)
        {
            System.out.println("Invalid input");
        }
    }
    public static void choiceThree()
    {
        System.out.println("------------------------------------------------------");
        System.out.println("++++Package Cost Formula++++");
        System.out.println("Base Cost: $3.75");
        System.out.println("$0.50 per pound ($0.05 per 0.1 lbs)");
        System.out.println("$0.01 per difference in origin and destination county codes\n");
        System.out.println("++++Account for large and heavy packages++++");
        System.out.println("Any packages over 36 inches in combined measurements(length + width + height)");
        System.out.println("will incur addition charges at $0.1 per inch\n");
        System.out.println("Any packages over 40 lbs will incur $0.1 instead of $0.05 per 0.1 lbs for the");
        System.out.println("lbs that exceed the 40 lbs limit\n");
        System.out.println("++++FAQ++++");
        System.out.println("Weight limit: 70 lbs");
        System.out.println("Total combined measurement limit: 130 inches");
        System.out.println("Operable Countries : USA(zip code range: 00001 - 99950)");
    }

}