public class second_ten_tasks {
    public static void main (String[] args){
       //Repeat
       System.out.println("repeat(\"mice\", 5) -> " + repeat("mice", 5));
       System.out.println();

       //differenceMaxMin
       int[] test = {1,2,3,88,4,1,3,100};
       System.out.println("differenceMaxMin([1, 2, 3, 88, 4, 1, 3, 100]) -> " + differenceMaxMin(test));
       System.out.println();

       //isAvgWhole
       int[] test1 = {1,3};
       System.out.println("isAvgWhole([1, 2, 3, 4]) -> " + isAvgWhole(test1));
       int[] test2 = {1, 2, 3, 4};
       System.out.println("isAvgWhole([1, 2, 3, 4]) -> " + isAvgWhole(test2));
       System.out.println();

       //cumulativeSum
       int[] test3 = {1, 2, 3};
       System.out.print("cumulativeSum([1, 2, 3]) -> ");
       printArr(cumulativeSum(test3));
       System.out.println();

       //getDecimalPlaces
       System.out.println("getDecimalPlaces(\"20.20\") -> " + getDecimalPlaces("20.20"));
       System.out.println();

       //Fibonacci
       System.out.println("Fibonacci(12) -> " + Fibonacci(12));
       System.out.println();

       //isValid
       System.out.println("isValid(\" 59 02\") -> " + isValid("59 02"));
       System.out.println();

       //isStrangePair
       System.out.println("isStrangePair(\"ratio\", \"orator\") -> " + isStrangePair("ratio", "orator"));
       System.out.println();

       //isPrefix and isSuffix
       System.out.println("isPrefix(\"automation\", \"auto-\") -> " + isPrefix("automation", "auto-"));
       System.out.println("isPrefix(\"retrospect\", \"sub-\") -> " + isPrefix("retrospect", "sub-"));
       System.out.println("isSuffix(\"arachnophobia\", \"-phobia\") -> " + isSuffix("arachnophobia", "-phobia"));
       System.out.println("isSuffix(\"vocation\", \"-logy\") -> " + isSuffix("vocation", "-logy"));
       System.out.println();

       //boxSeq
       System.out.println("boxSeq(0) -> " + boxSeq(0));
       System.out.println("boxSeq(1) -> " + boxSeq(1));
       System.out.println("boxSeq(2) -> " + boxSeq(2));
    }

    public static void printArr(int[] a){
        System.out.print("[");
        for (int i = 0; i < a.length; i++){
            System.out.print(a[i]);
            if (i != a.length-1){
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    //Повторяет символ в строке n раз
    public static String repeat (String a, int n){
        String fin = "";
        for (int i = 0; i < a.length(); i++){
            for (int j = 0; j < n; j++){
                fin += a.charAt(i);
            }
        }
        return fin;
    }
    //Разница между самым большим и самым маленьким числом в массиве
    public static int differenceMaxMin (int[] a){
        int min = a[0];
        int max = a[0];
        for (int i = 0; i < a.length; i++){
            if (a[i] > max){
                max = a[i];
            }
            if (a[i] < min){
                min = a[i];
            }
        }
        return max-min;
    }
    //Принимает массив в качестве аргумента и возвращает true или false
    // в зависимости от того, является ли среднее значение
    // всех элементов массива целым числом или нет.
    public static boolean isAvgWhole (int[] a){
        int sum = 0;
        for (int i = 0; i < a.length; i++){
            sum += a[i];
        }
        return sum % a.length == 0;
    }

    //берет массив целых чисел и возвращает массив,
    //в котором каждое целое число является суммой самого себя + всех предыдущих чисел в массиве
    public static int[] cumulativeSum (int[] a){
        int[] copy;
        copy = a.clone();
        for (int i = 1; i < a.length; i++){
            copy[i] =  copy[i-1] + a[i];
        }
        return copy;
    }

    //Возвращает число десятичных знаков, которое имеет число
    public static int getDecimalPlaces (String a){
        if (a.contains(".")){
           return a.length() - (a.indexOf('.') + 1);
        }
        else {
            return 0;
        }
    }

    //при заданном числе возвращает соответствующее число Фибоначчи
    public static int Fibonacci (int a){
        int first = 0;
        int second = 1;
        for (int i = 0; i < a; i++){
            int sum = first;
            first = second;
            second += sum;
        }
        return second;
    }

    //функция, которая определяет, является ли поданная на вход строка
    //действительным почтовым индексом
    public static boolean isValid (String a){
        int numb = 0;
        String valid = "0123456789";
        for (int i = 0; i < a.length(); i++){
            if (valid.contains(Character.toString(a.charAt(i)))){
                numb++;
            }
        }
        return (a.length() == 5) && (numb == 5);
    }

    //Первая буква 1-й строки = последняя буква 2-й строки
    //Последняя буква 1-й строки = первая буква 2-й строки.
    public static boolean isStrangePair (String a, String b){
        return a.charAt(0) == b.charAt(b.length() - 1) & a.charAt(a.length() - 1) == b.charAt(0);
    }

    //возвращает true, если он начинается с префиксного аргумента
    public static boolean isPrefix (String word, String prefix){
        int count = 0;
        if (prefix.length() < word.length()) {
            for (int i = 0; i < prefix.length(); i++) {
                if (word.charAt(i) == prefix.charAt(i)) {
                    count += 1;
                }
            }
            if (count == prefix.length() - 1) {
                return true;
            } else {
                return false;
            }
        }
        else {
            return false;
        }
    }

    //возвращает true, если он заканчивается аргументом суффикса
    public static boolean isSuffix (String word, String suffix) {
        return word.substring(word.length()-(suffix.length() - 1),
                word.length()-1).equals(suffix.substring(1, suffix.length() - 1));
    } // возвращает часть строки, индекс начала и конца вывода

    //принимает число (шаг) в качестве аргумента
    //и возвращает количество полей на этом шаге последовательности
    public static int boxSeq (int a){
        int sum = 0;
        if (a != 0) {
            for (int i = 1; i <= a; i++) {
                if (i % 2 != 0) {
                    sum += 3;
                } else {
                    sum -= 1;
                }
            }
        }
        else {
            return 0;
        }
        return sum;
    }
}
