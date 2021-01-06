public class third_ten_tasks {
    public static void main (String[] args){
        //solution
        System.out.println("solutions(1, 0, -1) -> " + solution(1,0,-1));
        System.out.println("solutions(1, 0, 0) -> " + solution(1,0,0));
        System.out.println("solutions(1, 0, 1) -> " + solution(1,0,1));
        System.out.println();

        //findZip
        System.out.println("findZip(\"all zip files are zipped\") -> " + findZip("all zip files are zipped"));
        System.out.println("findZip(\"all zip files are compressed\") -> "
                + findZip("all zip files are compressed"));
        System.out.println();

        //checkPerfect
        System.out.println("checkPerfect(6) -> " + checkPerfect(6));
        System.out.println("checkPerfect(28) -> " + checkPerfect(28));
        System.out.println("checkPerfect(496) -> " + checkPerfect(496));
        System.out.println("checkPerfect(12) -> " + checkPerfect(12));
        System.out.println("checkPerfect(97) -> " + checkPerfect(97));
        System.out.println();

        //flipEndChars
        System.out.println("flipEndChars(\"Cat, dog, and mouse.\") -> " +
                flipEndChars("Cat, dog, and mouse."));
        System.out.println("flipEndChars(\"ada\") -> " + flipEndChars("ada"));
        System.out.println("flipEndChars(\"Ada\") -> " + flipEndChars("Ada"));
        System.out.println("flipEndChars(\"z\") -> " + flipEndChars("z"));
        System.out.println();

        //isValidHexCode
        System.out.println("isValidHexCode(\"#CD5C5C\") -> " + isValidHexCode("#CD5C5C"));
        System.out.println("isValidHexCode(\"#EAECEE\") -> " + isValidHexCode("#EAECEE"));
        System.out.println("isValidHexCode(\"#eaecee\") -> " + isValidHexCode("#eaecee"));
        System.out.println("isValidHexCode(\"#CD5C58C\") -> " + isValidHexCode("#CD5C58C"));
        System.out.println("isValidHexCode(\"#CD5C5Z\") -> " + isValidHexCode("#CD5C5Z"));
        System.out.println("isValidHexCode(\"#CD5C&C\") -> " + isValidHexCode("#CD5C&C"));
        System.out.println("isValidHexCode(\"CD5C5C\") -> " + isValidHexCode("CD5C5C"));
        System.out.println();

        //same
        int[] test_a = {1, 3, 4, 4, 4};
        int[] test_b = {2, 5, 7};
        int[] test_c = {9, 8, 7, 6};
        int[] test_d = {4, 4, 3, 1};
        int[] test_e = {2};
        int[] test_f = {3, 3, 3, 3, 3};
        System.out.println("same([1, 3, 4, 4, 4], [2, 5, 7]) -> " + same(test_a, test_b));
        System.out.println("same([9, 8, 7, 6], [4, 4, 3, 1]) -> " + same(test_c, test_d));
        System.out.println("same([2], [3, 3, 3, 3, 3]) -> " + same(test_e, test_f));
        System.out.println();

        //isKaprekar
        System.out.println("isKaprekar(0) -> " + isKaprekar(0));
        System.out.println("isKaprekar(3) -> " + isKaprekar(3));
        System.out.println("isKaprekar(45) -> " + isKaprekar(45));
        System.out.println("isKaprekar(297) -> " + isKaprekar(297));
        System.out.println();

        //longestZero
        System.out.println("longestZero(\"01100001011000\") -> " + longestZero("01100001011000"));
        System.out.println("longestZero(\"100100100\") -> " + longestZero("100100100"));
        System.out.println("longestZero(\"11111\") -> " + longestZero("11111"));
        System.out.println();

        //nextPrime
        System.out.println("nextPrime(12) -> " + nextPrime(12));
        System.out.println("nextPrime(24) -> " + nextPrime(29));
        System.out.println("nextPrime(11) -> " + nextPrime(11));
        System.out.println();

        //rightTriangle
        System.out.println("rightTriangle(3, 4, 5) -> " + rightTriangle(3,4,5));
        System.out.println("rightTriangle(145, 105, 100) -> " + rightTriangle(145,105,100));
        System.out.println("rightTriangle(70, 130, 110) -> " + rightTriangle(70,130,110));
        System.out.println();
    }

    //число решений для действительных значений х
    public static int solution (int a, int b, int c){
        double diskr;
        diskr = b * b - 4 * a * c;
        if (Math.sqrt(diskr) > 0){
            return 2;
        }
        else if (Math.sqrt(diskr) == 0){
            return 1;
        }
        else {
            return 0;
        }
    }

    //возвращает позицию второго вхождения " zip " в строку,
    // или -1, если оно не происходит по крайней мере дважды
    public static int findZip (String a){
        if (a.contains("zip")){
            int position_z = a.indexOf("zip"); //индекс z
            String copy = a.substring(position_z + 3); //создает подстроку с указанного индекса
            if (copy.contains("zip")){
                return copy.indexOf("zip") + (a.length() - copy.length());
            }
            else {
                return -1;
            }
        }
        else {
            return -1;
        }
    }

    // проверяет, является ли целое число совершенным числом или нет.
    // Совершенное число - это число, которое можно записать как сумму его множителей,
    // исключая само число.
    public static boolean checkPerfect (int a){
        int summa = 0;
        for (int i = 1; i < a; i++){
            if (a % i == 0){
                summa += i; //суммируем делители
            }
        }
        return summa == a;
    }

    //принимает строку и возвращает новую строку с заменой ее первого и последнего символов
    public static String flipEndChars (String str){
        if (str.length() < 2) {
            return "Incompatible.";
        }
        else if (str.charAt(0) == str.charAt(str.length() - 1)){
            return "Two's a pair.";
        }
        else {
            String copy = "";
            copy += str.charAt(str.length() - 1);
            for (int i = 1; i < str.length() - 1; i++){
                copy += str.charAt(i);
            }
            copy += str.charAt(0);
            return copy;
        }
    }

    //определяет, является ли строка допустимым шестнадцатеричным кодом
    //Шестнадцатеричный код должен начинаться с фунтового ключа # и иметь длину ровно 6 символов.
    //Каждый символ должен быть цифрой от 0-9 или буквенным символом от A-F.
    //Все буквенные символы могут быть прописными или строчными.
    public static boolean isValidHexCode (String str){
        if (str.length() == 7 && str.charAt(0) == '#'){
           str = str.toUpperCase();
           for (int i = 1; i < str.length(); i++) {
               if ( !((str.charAt(i) >= '0' && str.charAt(i) <= '9') ||
                       (str.charAt(i) >= 'A' && str.charAt(i) <= 'F')) )
               {
                   return false;
               }
           }
           return true;
        }
        else {
            return false;
        }
    }

    // возвращает true, если два массива имеют одинаковое количество уникальных элементов,
    // и false в противном случае
    public static boolean same (int[] a, int[] b){
        int count11 = 0; //счетчик оригинальных
        int count22 = 0;
        for (int i = 0; i < a.length; i++){ //пошел от обратного
            int count1 = 0; //счетчик неоригинальных
            for (int j = i + 1; j < a.length; j++){
                if (a[i] == a[j]){
                    count1 += 1; //кол-во повторов определенного элемента
                }
            }
            if (count1 == 0) {count11 += 1;}
        }
        for (int i = 0; i < b.length; i++){
            int count2 = 0;
            for (int j = i + 1; j < b.length; j++){
                if (b[i] == b[j]){
                    count2 += 1;
                }
            }
            if (count2 == 0) {count22 += 1;}
        }
        return count11 == count22;
    }

    //Число Капрекара-это положительное целое число,
    // которое после возведения в квадрат и разбиения на две лексикографические части
    // равно сумме двух полученных новых чисел
    public static boolean isKaprekar (int a) {
        int kvadrat = a * a;
        String str = Integer.toString(kvadrat);
        if (str.length() != 1) {
            double middle = Math.floor(str.length() / 2);
            String str_right = "";
            String str_left = "";
            for (int i = 0; i < (int) middle; i++) {
                str_left += str.charAt(i);
            }
            for (int i = (int) middle; i < str.length(); i++) {
                str_right += str.charAt(i);
            }
            int str_full = Integer.valueOf(str_left) + Integer.valueOf(str_right);
            return str_full == a;
        }
        else if (a == 1 || a == 0) {
            return true;
        }
        else {return false;}
    }

    //возвращает самую длинную последовательность последовательных нулей в двоичной строке
    public static String longestZero (String str){
        int len = 0; //длина последовательности
        int max = 0;
        String sum = "";
        for (int i = 0; i < str.length(); i++){
            if (str.charAt(i) == '0' ) {
                len += 1;
                if (len > max){
                    max = len;
                }
            }
            else {
                len = 0;
            }
        }
        for (int j = 0; j < max; j++){
            sum += "0";
        }
        return sum;
    }

    //Определение, простое число или нет через while
    public static boolean isPrime(int n) {
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

    //Возвращает следующее простое число. Если число простое, возвращает само число
    public static int nextPrime (int a){
        int simple = a;
        if (isPrime(simple) == false) {
            while (isPrime(simple) == false) {
                simple++;
            }
            return simple;
        }
        else {
            return a;
        }
    }

    //определяет, являются ли 3 числа ребрами прямоугольного треугольника
    public static boolean rightTriangle (int x, int y, int z){
        if (x*x + y*y == z*z){
            return true;
        }
        else if (x*x + z*z == y*y){
            return true;
        }
        else if (y*y + z*z == x*x){
            return true;
        }
        else {
            return false;
        }
    }
}
