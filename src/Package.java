public class Package {
    private Address origin;
    private Address destination;
    private double weight;
    private double length;
    private double width;
    private double height;

    public Package(Address o, Address d, double w, double l, double width, double h)
    {
        if(w<0.1 || l<2 || width<2 || h<2){System.out.println("Incompatible package"); return;}
        origin = o;
        destination = d;
        weight = w;
        length = l;
        this.width = width;
        height = h;
    }

    public Address getOrigin() {
        return origin;
    }

    public Address getDestination() {
        return destination;
    }

    public double getWeight() {
        return weight;
    }

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }
}
