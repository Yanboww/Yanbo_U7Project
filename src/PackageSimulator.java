import java.util.ArrayList;
public class PackageSimulator {
    private static ArrayList<Package> packages;

    public static void generatePackages(int num)
    {
        for(int i =0;i<num;i++)
        {
            int zip = (int)(Math.random()*89999)+10000;
            int order = i+1;
            System.out.println("Package " + order + ": ----------------------------");

        }
    }

    public static void resetSimulation()
    {
        packages.clear();
    }

}
