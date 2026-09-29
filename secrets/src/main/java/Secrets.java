public class Secrets {

    public static int shiftBack(int value, int amount) {
        return value >>> amount;
    }

    public static int setBits(int value, int mask) {
        return value | mask;
    }

    public static int flipBits(int value, int mask) {
        return value ^ mask;
    }

    public static int clearBits(int value, int mask) {
        return value & ~mask;
    }

    public static void main(String[] args) {
        System.out.println("shiftBack(8, 2) = " + shiftBack(8, 2));
        System.out.println("setBits(5, 3) = " + setBits(5, 3));
        System.out.println("flipBits(5, 11) = " + flipBits(5, 11));
        System.out.println("clearBits(5, 11) = " + clearBits(5, 11));
    }
}