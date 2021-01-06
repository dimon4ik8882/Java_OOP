import java.util.ArrayList;
import java.util.*;

public class fourth_java_tasks {
    public static void main (String[] args){
        Bessie(10,7, "hello my name is Bessie and this is my essay");
        System.out.println();

        //Split
        System.out.print("split(\"((()))(())()()(()())\") -> ");
        split("((()))(())()()(()())");
        System.out.println();
        System.out.print("split(\"((()))\") -> ");
        split("((()))");
        System.out.println();
        System.out.print("split(\"((()))(())()()(()())\") -> ");
        split("((()))(())()()(()())");
        System.out.println();
        System.out.println();

        //CamelCase
        System.out.println("toCamelCase(hello_edabit) -> " +  toCamelCase("hello_edabit"));
        System.out.println("toCamelCase(is_modal_open) -> " +  toCamelCase("is_modal_open"));
        System.out.println();

        //snakeCase
        System.out.println("toSnakeCase(helloEdabit) -> " +  toSnakeCase("helloEdabit"));
        System.out.println("toSnakeCase(getColor) -> " +  toSnakeCase("getColor"));
        System.out.println();

        //overTime
        double[] test_a = {16, 18, 30, 1.8};
        System.out.print("overTime([16, 18, 30, 1.8]) -> ");
        System.out.print(overTime(test_a));
        System.out.println("$");
        System.out.println();

        //BMI
        System.out.print("BMI(\"205 pounds\", \"73 inches\") -> ");
        BMI("205 pounds", "73 inches");
        System.out.println();
        System.out.print("BMI(\"55 kilos\", \"1.65 meters\") -> ");
        BMI("55 kilos", "1.65 metres");
        System.out.println();
        System.out.print("BMI(\"154 pounds\", \"2 meters\") -> ");
        BMI("154 pounds", "2 metres");
        System.out.println();
        System.out.println();

        //bugger
        System.out.println("bugger(39) -> " +  bugger(39));
        System.out.println("bugger(999) -> " +  bugger(999));
        System.out.println("bugger(4) -> " +  bugger(4));
        System.out.println();

        //toStarShorthand
        System.out.println("toStarShorthand(\"abbccc\") -> " + toStarShorthand("abbccc"));
        System.out.println("toStarShorthand(\"77777geff\") -> " + toStarShorthand("77777geff"));
        System.out.println("toStarShorthand(\"abc\") -> " + toStarShorthand("abc"));
        System.out.println("toStarShorthand(\"\") -> " + toStarShorthand(""));
        System.out.println();

        //doesRhyme
        System.out.println("doesRhyme(\"Sam I am!\", \"Green eggs and ham.\") -> "
                + doesRhyme("\"Sam I am!", "Green eggs and ham."));
        System.out.println("doesRhyme(\"Sam I am!\", \"Green eggs and HAM.\") -> "
                + doesRhyme("Sam I am!", "Green eggs and HAM."));
        System.out.println("doesRhyme(\"You are off to the races\", \"a splendid day.\") -> "
                + doesRhyme("You are off to the races", "a splendid day."));
        System.out.println();

        //trouble
        System.out.println("trouble(451999277, 41177722899) -> " +  trouble("451999277", "41177722899"));
        System.out.println("trouble(1222345, 12345) -> " +  trouble("1222345", "12345"));
        System.out.println("trouble(666789, 12345667) -> " +  trouble("666789", "12345667"));
        System.out.println();

        //countUniqueBooks
        System.out.println("(\"AZYWABBCATTTA\", 'A') -> " +  countUniqueBooks("AZYWABBCATTTA", 'A'));
        System.out.println("(\"$AA$BBCATT$C$$B$\", '$') -> " +  countUniqueBooks("$AA$BBCATT$C$$B$", '$'));
        System.out.println("(\"ZZABCDEF\", 'Z') -> " +  countUniqueBooks("ZZABCDEF", 'Z'));
        System.out.println();
    }

    public static void Bessie(int a, int b, String c) {
        char[] str = c.toCharArray();
        char[] str1;
        ArrayList<char[]> list1 = new ArrayList<>();
        Queue<Character> str2 = new LinkedList<>();
        int j = 0;
        for (int i = 0; i < c.length(); i++) {

            if (str[i] == ' ' || i == c.length() - 1) {
                if (i == c.length() - 1) {
                    str2.offer(str[i]);
                }
                str1 = new char[str2.size()];
                int razmer = str2.size();
                for (int k = 0; k < razmer; k++) {
                    str1[k] = str2.element();
                    str2.remove();
                }
                list1.add(str1);
                j = 0;
            }
            if (str[i] != ' ')
                str2.offer(str[i]);
            j++;
        }
        int dl = 0;
        for (int i = 0; i < a; i++) {
            System.out.print(list1.get(i));
            dl = list1.get(i).length;
            for (j = i + 1; j < a; j++) {
                if (b - dl > 0) {
                    dl += list1.get(j).length;
                    if (b - dl >= 0) {
                        System.out.print(" " + String.valueOf(list1.get(j)));
                        i++;
                    }
                }
            }
            System.out.println();
        }
    }

    //группирует строку в кластер скобок. Каждый кластер должен быть сбалансирован.
    public static void split(String a) {
        char[] str = a.toCharArray();
        Queue<Character> open = new LinkedList<>();
        Queue<Character> close = new LinkedList<>();
        Queue<Character> vse = new LinkedList<>();
        for (int i = 0; i < a.length(); i++) {
            if (str[i] == '(')
                open.offer(str[i]);
            if (str[i] == ')')
                close.offer(str[i]);
            if (str[i] == '(' || str[i] == ')')
                vse.offer(str[i]);
            if (open.size() == close.size()) {
                int razmer = vse.size();
                System.out.print(" '' ");
                for (int j = 0; j < razmer; j++) {
                    System.out.print(vse.element());
                    if (vse.element() == '(')
                        open.remove();
                    if (vse.element() == ')')
                        close.remove();
                    vse.remove();
                }
                System.out.print(" '', ");
            }
        }
    }

    //CamelCase — стиль написания составных слов, при котором несколько слов пишутся слитно без пробелов,
    // при этом каждое слово внутри фразы пишется с прописной буквы.
    // Стиль получил название CamelCase, поскольку прописные буквы внутри слова напоминают горбы верблюда
    public static String toCamelCase(String a) {
        char[] str = a.toCharArray();
        Queue<Character> str1 = new LinkedList<>();
        for (int i = 0; i < str.length; i++) {
            if (str[i] == '_') {
                str[i + 1] = (char) (str[i + 1] - 32);
            } else
                str1.offer(str[i]);
        }
        str = new char[str1.size()];
        int razmer = str1.size();
        for (int i = 0; i < razmer; i++) {
            str[i] = str1.element();
            str1.remove();
        }
        return String.valueOf(str);
    }

    //Snake case — стиль написания составных слов, при котором несколько слов разделяются
    // символом подчеркивания (_), и не имеют пробелов в записи, причём каждое слово обычно пишется
    // с маленькой буквы — «foo_bar», «hello_world» и т. д.
    public static String toSnakeCase(String a) {
        char[] str = a.toCharArray();
        Queue<Character> str1 = new LinkedList<>();
        for (int i = 0; i < str.length; i++) {
            if (str[i] >= 65 && str[i] <= 90) {
                str1.offer('_');
                str1.offer((char) (str[i] + 32));
            } else
                str1.offer(str[i]);
        }
        str = new char[str1.size()];
        int razmer = str1.size();
        for (int i = 0; i < razmer; i++) {
            str[i] = str1.element();
            str1.remove();
        }
        return String.valueOf(str);
    }

    //вычисляет сверхурочную работу и оплату, связанную с сверхурочной работой.
    public static double overTime(double[] a) {
        double sum = 0;
        if (a[0] < 17) {
            if (a[1] <= 17)
                sum = (a[1] - a[0]) * a[2];
            if (a[1] > 17)
                sum = (17 - a[0]) * a[2] + (a[1] - 17) * a[3] * a[2];
        }
        if (a[0] >= 17) {
            sum = (a[1] - a[0]) * a[2] * a[3];
        }
        return sum;
    }

    //Создайте функцию, которая будет принимать вес и рост (в килограммах, фунтах, метрах или дюймах)
    //и возвращать ИМТ и связанную с ним категорию. Округлите ИМТ до ближайшей десятой.
    public static void BMI(String a, String b) {
        char[] str = a.toCharArray();
        char[] str1 = b.toCharArray();
        double ves = 1, rost = 1;
        Queue<Character> str2 = new LinkedList<>();
        Queue<Character> str3 = new LinkedList<>();
        for (int i = 0; i < str.length; i++) {
            if ((str[i] >= '0' && str[i] <= '9') || str[i] == '.')
                str2.offer(str[i]);
            if (str[i] == 'p') {
                ves /= 2.2;
                break;
            }
            if (str[i] == 'k')
                break;
        }
        for (int i = 0; i < str1.length; i++) {
            if ((str1[i] >= '0' && str1[i] <= '9') || str1[i] == '.')
                str3.offer(str1[i]);
            if (str1[i] == 'i') {
                rost /= 39.37;
                break;
            }
            if (str1[i] == 'm')
                break;
        }
        int razmer = str2.size(), sum = 0;
        boolean tochka = false;
        for (int i = 0; i < razmer; i++) {
            if (str2.element() != '.') {
                sum *= 10;
                sum += (str2.element() - 48);
            } else {
                tochka = true;
            }
            str2.remove();
        }
        ves *= sum;
        if (tochka)
            ves /= 100;
        sum = 0;
        razmer = str3.size();
        tochka = false;
        for (int i = 0; i < razmer; i++) {
            if (str3.element() != '.') {
                sum *= 10;
                sum += (str3.element() - 48);
            } else {
                tochka = true;
            }
            str3.remove();
        }
        rost *= sum;
        if (tochka)
            rost /= 100;
        double sum1 = ves / (rost * rost);
        String formattedDouble = String.format("%.1f", sum1);
        if (sum1 >= 25)
            System.out.print(formattedDouble + " Overweight");
        else if (sum1 < 18.5)
            System.out.print(formattedDouble + " Underweight");
        else
            System.out.print(formattedDouble + " Normal weight");
    }

    //Создайте функцию, которая принимает число и возвращает его мультипликативное постоянство,
    // которое представляет собой количество раз, которое вы должны умножать цифры в num,
    // пока не достигнете одной цифры.
    public static int bugger(int a) {
        char[] chars = ("" + a).toCharArray();
        int sum = a, i = 0, sum1 = 1;
        while (sum > 9) {
            for (int j = 0; j < chars.length; j++) {
                sum1 *= (chars[j] - 48);
            }
            i++;
            sum = sum1;
            sum1 = 1;
            chars = ("" + sum).toCharArray();
        }
        return i;
    }

    //Напишите функцию, которая преобразует строку в звездную стенографию.
    // Если символ повторяется n раз, преобразуйте его в символ*n.
    public static String toStarShorthand(String a) {
        char[] str = a.toCharArray();
        if (a.length() > 0) {
            char b = str[0];
            int sum = 1;
            Queue<Character> str1 = new LinkedList<>();
            for (int i = 1; i < str.length; i++) {
                if (b == str[i]) {
                    sum++;
                } else if (sum == 1) {
                    str1.offer(b);
                } else if (sum > 1) {
                    str1.offer(b);
                    str1.offer('*');
                    str1.offer((char) (sum + 48));
                    sum = 1;
                }
                if (i + 1 == str.length) {
                    str1.offer(b);
                    str1.offer('*');
                    str1.offer((char) (sum + 48));
                    sum = 1;
                }
                b = str[i];
            }
            str = new char[str1.size()];
            int razmer = str1.size();
            for (int i = 0; i < razmer; i++) {
                str[i] = str1.element();
                str1.remove();
            }
            return String.valueOf(str);
        }
        else {return  "";}
    }

    //Создайте функцию, которая возвращает true, если две строки рифмуются, и false в противном случае.
    // Для целей этого упражнения две строки рифмуются, если последнее слово из каждого предложения содержит
    // одни и те же гласные.
    public static String doesRhyme(String a, String b) {
        char[] str = a.toCharArray();
        char[] str1 = b.toCharArray();
        Queue<Character> str2 = new LinkedList<>();
        Queue<Character> str3 = new LinkedList<>();
        for (int i = str.length - 1; i >= 0; i--) {
            if (str[i] == 'a' || str[i] == 'e' || str[i] == 'i' || str[i] == 'o'
                    || str[i] == 'u' || str[i] == 'y') {
                str2.offer(str[i]);
            }
            if (str[i] == 'A' || str[i] == 'E' || str[i] == 'I' || str[i] == 'O'
                    || str[i] == 'U' || str[i] == 'Y') {
                str2.offer((char) (str[i] + 32));
            }
            if (str[i] == ' ') {
                break;
            }
        }
        for (int i = str1.length - 1; i >= 0; i--) {
            if (str1[i] == 'a' || str1[i] == 'e' || str1[i] == 'i' || str1[i] == 'o'
                    || str1[i] == 'u' || str1[i] == 'y')
                {str3.offer(str1[i]);}

            if (str1[i] == 'A' || str1[i] == 'E' || str1[i] == 'I' || str1[i] == 'O'
                    || str1[i] == 'U' || str1[i] == 'Y')
                {str3.offer((char) (str1[i] + 32));}

            if (str1[i] == ' ') {break;}
        }
        str = new char[str2.size()];
        for (int i = 0; i < str.length; i++) {
            str[i] = str2.element();
            str2.remove();
        }
        str1 = new char[str3.size()];
        for (int i = 0; i < str1.length; i++) {
            str1[i] = str3.element();
            str3.remove();
        }
        if (str.length != str1.length)
            return "false";
        else {
            for (int i = 0; i < str1.length; i++) {
                for (int j = 0; j < str.length; j++) {
                    if (str[i] == str1[j]) {
                        str[i] = '1';
                        str1[j] = '1';
                    }
                }
            }
            for (int i = 0; i < str1.length; i++) {
                if (str1[i] != str[i]) {
                    return "false";
                }
            }
            return "true";
        }
    }

    //Создайте функцию, которая принимает два целых числа и возвращает true, если число повторяется три раза подряд
    // в любом месте в num1 и то же самое число повторяется два раза подряд в num2.
    public static Boolean trouble(String a, String b) {
        char[] str = ("" + a).toCharArray();
        char[] str1 = ("" + b).toCharArray();
        int[] sum = new int[10];
        for (int i = 0; i < str.length - 2; i++) {
            if (str[i] == str[i + 1] && str[i] == str[i + 2]) {
                sum[str[i] - 48] = 3;
            }
        }
        for (int i = 0; i < str1.length - 1; i++) {
            if (str1[i] == str1[i + 1]) {
                if (sum[str1[i] - 48] == 3) {
                    return true;
                }
            }
        }
        return false;
    }

    //Предположим, что пара одинаковых символов служит концами книги для всех символов между ними.
    // Напишите функцию, которая возвращает общее количество уникальных символов (книг, так сказать)
    // между всеми парами концов книги.
    public static int countUniqueBooks(String s, char c) {
        String cc = "";
        String q = "";
        cc += c;
        char[] s1 = (s).toCharArray();
        String vr = "";
        boolean open = false;
        String ww = "";
        for (char w : s1) {
            ww += w;
            if ((ww.equals(cc)) & open) {
                open = false;
                if (vr.length() > 0) {
                    q += vr;
                }
                vr = "";
                ww = "";
                continue;
            }
            if ((ww.equals(cc)) & !open) {
                open = true;
                ww = "";
                continue;
            }
            if (open) {
                vr += w;
            }
            ww = "";
        }
        return q.replaceAll("(.)(?=.*?\\1)", "").length();
    }
}
