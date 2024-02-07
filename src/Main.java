public class Main {
    public static void main(String[] args) {
        Address stuff = new Address("10201 Mockingbird Lane Apt 6A, Springfield, MO 73561");
        Address stuff2 = new Address("10206 Mockingbird Lane Apt 6A, Springfield, MO 10206");
        System.out.println(stuff);
        System.out.println(PostageCalculator.calculatePostage(stuff,stuff2,2.7,2,4,6));


    }
}