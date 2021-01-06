public class Palindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome("madam"));
    }
    public static String reverseString(String s){ // Метод реверса строки
        String local = "";
        for (int i = 0; i < s.length(); i++){
            local = local + s.charAt(s.length()-1 - i);
        }
        return local;
    }
    public static boolean isPalindrome(String s){ // Метод определения палиндрома
        String local1 = reverseString(s);
        return s.equals(local1);
    }
}