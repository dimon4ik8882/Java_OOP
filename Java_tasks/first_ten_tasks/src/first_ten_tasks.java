import java.io.Serializable;

public class first_ten_tasks {
    public static void main(String[] args) {
        System.out.println("reminder = " + reminder(3,5));
        System.out.println("triArea = " + triArea(2,3));
        System.out.println("Sum of legs = " + animals(2,3,5));
        System.out.println("profitableGamble = " + profitableGamble(0.9,1,2));
        System.out.println("operation " + operation(24,26,2));
        System.out.println("ctoa " + ctoa('A'));
        System.out.println("addUpTo = " + addUpTo(7));
        System.out.println("nextEdge " + nextEdge(8,10));
        int[] cubes  = {1,5,9};
        System.out.println("sumOfCubes " + sumOfCubes(cubes));
        System.out.println("abcmath = " + abcmath(42,5,10));
    }
    public static int reminder (int a, int b){
        if (a % b==0){
           return 0;
        }
        else return a;
    }
    public static int triArea (double base, double height){
        double Square;
        Square = 1.0/2*base*height;
        return (int) Square;
    }
    public static int animals (int ch_legs, int cow_legs, int p_legs){
        int chicken = 2;
        int cows = 4;
        int pigs = 4;
        int sum;
        sum = ch_legs * chicken + cow_legs * cows + p_legs * pigs;
        return sum;
    }
    public static boolean profitableGamble(double prob, double prize, double pay){
        return prob * prize > pay;
    }
    public static Serializable operation(int N, int a, int b){
        String added = "added";
        String subtracted = "subtracted";
        String divided = "divided";
        String multiplied = "multiplied";
        String none = "none";
        if (a + b == N){
            return added;
        }
        else if (a - b == N){
            return subtracted;
        }
        else if (a / b == N){
            return divided;
        }
        else if (a * b == N){
            return multiplied;
        }
        else {
            return none;
        }
    }
    public static int ctoa (char a) {
        return a;
    }
    public static int addUpTo(int a){
        int Sum = 0;
        for (int i = 0; i <= a; i++) {
            Sum += i;
        }
        return Sum;
    }
    public static int nextEdge (int a, int b){
        return (a + b - 1);
    }
    public static int sumOfCubes(int[] a){
        int Sum = 0;
        for (int j : a) {
            Sum += j * j * j;
        }
        return Sum;
    }
    public static boolean abcmath(int a, int b, int c){
        return a * Math.pow(2, b) % c == 0;
    }
}
