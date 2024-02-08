import java.util.ArrayList;
public class PackageSimulator {
    private static ArrayList<Package> packages = new ArrayList<Package>();
    private final static String sampleAddress = "1600 Crusty Avenue Apt 10C, Bikini Bottoms, NY ";

    public static void generatePackages(int num)
    {
        for(int i =0;i<num;i++)
        {
            String zip = "";
            String zip2= "";
            while(zip2.equals(zip))
            {
                zip ="";
                zip2="";
                for(int a =0;a<5;a++)
                {
                    int random1 = (int)(Math.random()*10);
                    int random2 = (int)(Math.random()*10);
                    zip+=Integer.toString(random1);
                    zip2+=Integer.toString(random2);
                }
                if(Integer.parseInt(zip)>99950) zip = "99950";
                if(Integer.parseInt(zip2)>99950) zip2 = "99950";
            }
            double weight = Math.random()*69.9+0.1;
            double totalGirth = 131;
            double length =0;
            double width = 0;
            double height = 0;
            while(totalGirth>130)
            {
                int dice = (int)(Math.random()*100)+1;
                if(dice<6)
                {
                    length = Math.random()*129+2;
                    width = Math.random()*129+2;
                    height = Math.random()*129+2;
                }
                else{
                    length = Math.random()*19+2;
                    width = Math.random()*19+2;
                    height = Math.random()*19+2;
                }

                totalGirth = length + width + height;

            }
            Address origin = new Address(sampleAddress+zip);
            Address destination = new Address(sampleAddress+zip2);
            Package sim = new Package(origin,destination,weight, length, width, height);
            packages.add(sim);
        }
        simulationInfo();
    }
    public static double generateTotalCost()
    {
        double total = 0;
        for(Package box : packages)
        {
            total+= PostageCalculator.calculatePostage(box);
        }
        total = (double)(Math.round(total*100))/100;
        return  total;
    }
    public static void simulationInfo()
    {
        System.out.println("Randomly generated package info:");
        for(int i = 0; i<packages.size();i++)
        {
            int order = i+1;
            System.out.println("Package " + order + ": ------------------------------------------------------");
            System.out.println("Origin Address: " + packages.get(i).getOrigin());
            System.out.println("Destination Address: " + packages.get(i).getDestination());
            System.out.println("Weight: " + packages.get(i).getWeight());
            System.out.println("Height: " + packages.get(i).getHeight());
            System.out.println("Length: " + packages.get(i).getLength());
            System.out.println("Width: " + packages.get(i).getWidth());
            System.out.println("Cost: " + PostageCalculator.calculatePostage(packages.get(i)));
        }
        System.out.println("------------------------------------------------------");
        System.out.println("Total Cost of all packages: " + generateTotalCost());
        resetSimulation();
    }public static void resetSimulation()
    {
        packages.clear();
    }

}
