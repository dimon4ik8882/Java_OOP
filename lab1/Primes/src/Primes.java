public class Primes { // Класс простых чисел
    public static void main(String[] args) {
        int x;
        for (x = 0; x <= 100; x++){
           if (isPrime(x) == true){
               System.out.println(x);
            }
        }
    }
    public static boolean isPrime(int n) { // Определение, простое число или нет через while
        int i = 1;
        while (i < n - 1 & n % (i + 1) != 0){
            i++;
        }
        if ((i + 1) == n){
            return true;
        }
        else {
            return false;
        }
    }
    
}
