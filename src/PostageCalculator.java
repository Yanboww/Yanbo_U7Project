public class PostageCalculator {
    static final double baseCost = 3.75;

    public static double calculatePostage(int zip1, int zip2, double weight, double h, double l, double w)
    {
        double total = baseCost;
        total += weight/0.1 * 0.05;
        if(weight>40) total+= (weight-40)/0.1*0.05;
        double totalInches = h+l+w;
        if(totalInches>36) total+= totalInches*0.1;
        zip1  = zip1/100; zip2 = zip2/100;
        total+= (double)Math.abs(zip1-zip2)/100;
        total = (double)Math.round(total*100)/100;
        return total;
    }

    public static double calculatePostage(Address o, Address d, double weight, double h, double l, double w )
    {
        String[] zipString = {"",""};
        int[] zipCode1 = o.getZip();
        int[] zipCode2 = d.getZip();
        for(int i = 0;i<5;i++)
        {
            zipString[0]+=Integer.toString(zipCode1[i]);
            zipString[1]+=Integer.toString(zipCode2[i]);
        }
        int zip1 = Integer.parseInt(zipString[0]);
        int zip2 = Integer.parseInt(zipString[1]);
        double total = baseCost;
        total += weight/0.1 * 0.05;
        if(weight>40) total+= (weight-40)/0.1*0.05;
        double totalInches = h+l+w;
        if(totalInches>36) total+= totalInches*0.1;
        zip1  = zip1/100; zip2 = zip2/100;
        total+= (double)Math.abs(zip1-zip2)/100;
        total = (double)Math.round(total*100)/100;
        return total;
    }

    public static double calculatePostage(Package p)
    {
        Address o = p.getOrigin();
        Address d= p.getDestination();
        double weight = p.getWeight();
        double h = p.getHeight();
        double l = p.getLength();
        double w = p.getWidth();
        String[] zipString = {"",""};
        int[] zipCode1 = o.getZip();
        int[] zipCode2 = d.getZip();
        for(int i = 0;i<5;i++)
        {
            zipString[0]+=Integer.toString(zipCode1[i]);
            zipString[1]+=Integer.toString(zipCode2[i]);
        }
        int zip1 = Integer.parseInt(zipString[0]);
        int zip2 = Integer.parseInt(zipString[1]);
        double total = baseCost;
        total += weight/0.1 * 0.05;
        if(weight>40) total+= (weight-40)/0.1*0.05;
        double totalInches = h+l+w;
        if(totalInches>36) total+= totalInches*0.1;
        zip1  = zip1/100; zip2 = zip2/100;
        total+= (double)Math.abs(zip1-zip2)/100;
        total = (double)Math.round(total*100)/100;
        return total;
    }
}
