public class Address {
    private String house;
    private String street;
    private String apNum;
    private String city;
    private String state;
    private int[] zip;

    public Address(String h, String s, String a, String c, String state, int z)
    {
        house = h;
        street = s;
        apNum = a;
        city = c;
        this.state = state;
        zip = new int[5];
        String zString = Integer.toString(z);
        for(int i = 0;i<zString.length();i++)
        {
            zip[i] = Integer.parseInt(zString.substring(i,i+1));
        }
    }
    public Address(Address a)
    {
        house = a.getHouse();
        street = a.getStreet();
        apNum = a.getApNum();
        city = a.getCity();
        state = a.getState();
        zip = a.getZip();
    }

    public Address(String a)
    {
        String[] address = a.split(" ");
        int which = 1;
        for(int z=0;z<address.length;z++)
        {
            String words = address[z];
            if(which ==1){ house = words; which++;}
            else if(which == 2){ street = words + " " + address[z+1]; which++;}
            else if(which ==3)
            {
               if(words.contains(","))
               {
                   apNum = words.substring(0, words.length()-1);
                   which++;
               }
            }
            else if(which == 4)
            {
                if(words.contains(","))
                {
                    city = words.substring(0, words.length()-1);
                    which++;
                }
            }
            else if(which == 5)
            {
                state = words;
                which++;
            }
            else{
                zip = new int[5];
                for(int i = 0;i<words.length();i++)
                {
                    zip[i] = Integer.parseInt(words.substring(i,i+1));
                }
                break;
            }

        }
    }

    public String getHouse() {
        return house;
    }

    public String getStreet() {
        return street;
    }

    public String getApNum() {
        return apNum;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public int[] getZip() {
        return zip;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setApNum(String apNum) {
        this.apNum = apNum;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setZip(int[] zip) {
        this.zip = zip;
    }

    public String toString()
    {
        String zipCode ="";
        for(int value : zip)
        {
            zipCode+=Integer.toString(value);
        }
        return house + " " + street + " Apt " + apNum + ", " + city + ", " + state + " " + zipCode;
    }
}
