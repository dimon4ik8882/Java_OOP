import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;


public class sixth_ten_tasks {
    public static void main (String[] args){
        //bell
        System.out.println("bell(1) -> " +  bell(1));
        System.out.println("bell(2) -> " +  bell(2));
        System.out.println("bell(3) -> " +  bell(3));
        System.out.println();

        //translateWord
        System.out.println("translateWord(\"flag\") -> " +  translateWord("flag"));
        System.out.println("translateWord(\"Apple\") -> " +  translateWord("Apple"));
        System.out.println("translateWord(\"button\") -> " +  translateWord("button"));
        System.out.println("translateWord(\"\") -> " +  translateWord(""));
        System.out.println("translateSentence(\"I like to eat honey waffles.\") -> " +
                translateSentence("I like to eat honey waffles."));
        System.out.println("translateSentence(\"Do you think it is going to rain today?\") -> " +
                translateSentence("Do you think it is going to rain today?"));
        System.out.println();

        //validColor
        System.out.println("validColor(\"rgb(0,0,0)\") -> " +  validColor("rgb(0,0,0)"));
        System.out.println("validColor(\"rgb(0, ,0)\") -> " +  validColor("rgb(0, ,0)"));
        System.out.println("validColor(\"rgb(255,256,255)\") -> " +  validColor("rgb(255,256,255)"));
        System.out.println("validColor(\"rgba(0,0,0,0.123456789)\") -> " +  validColor("rgba(0,0,0,0.123456789)"));
        System.out.println();

        //stripUrlParams
        System.out.println("stripUrlParams(\"https://edabit.com?a=1&b=2&a=2\") -> " +
                stripURLParam("https://edabit.com?a=1&b=2&a=2"));
        System.out.println("stripUrlParams(\"https://edabit.com?a=1&b=2&a=2\", [\"b\"]) -> " +
                stripURLParam("https://edabit.com?a=1&b=2&a=2","b"));
        System.out.println();

        //getHashTags
        System.out.println("getHashTags(\"How the Avocado Became the Fruit of the Global Trade\") -> " +
                getHashTags("How the Avocado Became the Fruit of the Global Trade"));
        System.out.println("getHashTags(\"Why You Will Probably Pay More for Your Christmas Tree This Year\") -> " +
                getHashTags("Why You Will Probably Pay More for Your Christmas Tree This Year"));
        System.out.println("getHashTags(\"Hey Parents, Surprise, Fruit Juice Is Not Fruit\") -> " +
                getHashTags("Hey Parents, Surprise, Fruit Juice Is Not Fruit"));
        System.out.println("getHashTags(\"Visualizing Science\") -> " +
                getHashTags("Visualizing Science"));
        System.out.println();

        //ulam
        System.out.println("ulam(4) -> " +  ulam(4));
        System.out.println("ulam(9) -> " +  ulam(9));
        System.out.println("ulam(206) -> " +  ulam(206));
        System.out.println();

        //longestNonrepeatingSubstring
        System.out.println("longestNonrepeatingSubstring(\"abcabcbb\") -> " +  longestNonrepeatingSubstring("abcabcbb"));
        System.out.println("longestNonrepeatingSubstring(\"aaaaaa\") -> " +  longestNonrepeatingSubstring("aaaaaa"));
        System.out.println("longestNonrepeatingSubstring(\"abcde\") -> " +  longestNonrepeatingSubstring("abcde"));
        System.out.println("longestNonrepeatingSubstring(\"abcda\") -> " +  longestNonrepeatingSubstring("abcda"));
        System.out.println();

        //convertToRoman
        System.out.println("convertToRoman(2) -> " +  convertToRoman(2));
        System.out.println("convertToRoman(12) -> " +  convertToRoman(12));
        System.out.println("convertToRoman(16) -> " +  convertToRoman(16));
        System.out.println();

        //formula
        System.out.println("formula(\"6 * 4 = 24\") -> " +  formula("6 * 4 = 24"));
        System.out.println("formula(\"18 / 17 = 2\") -> " +  formula("8 / 17 = 2"));
        System.out.println("formula(\"16 * 10 = 160 = 14 + 120\") -> " +  formula("16 * 10 = 160 = 14 + 120"));
        System.out.println();

        //palindromedescendant
        System.out.println("palindromedescendant(11211230) -> " +  palindrome("11211230"));
        System.out.println("palindromedescendant(13001120) -> " +  palindrome("13001120"));
        System.out.println("palindromedescendant(23336014) -> " +  palindrome("23336014"));
        System.out.println("palindromedescendant(11) -> " +  palindrome("11"));

    }
    //Число Белла - это количество способов,
    // которыми массив из n элементов может быть разбит на непустые подмножества.
    // Создайте функцию, которая принимает число n и возвращает соответствующее число Белла.
    public static int bell(int num) {
        int[][] bell = new int[num+1][num+1];
        bell[0][0] = 1;

        for (int i = 1; i <= num; i++) {
            bell[i][0] = bell[i-1][i-1];

            for (int j=1; j<=i; j++) {
                bell[i][j] = bell[i - 1][j - 1] + bell[i][j - 1];
            }
        }
        return bell[num][0];
    }

    // получает слово на английском и возвращает это слово, переведенное на латинский язык
    public static String translateWord(String a) {
        String ext = "";
        String firststring = "";
        String secondstring = "";
        char[] A = a.toCharArray();
        char[] glassnie = {
                'A',
                'E',
                'I',
                'O',
                'U',
                'Y',
                'a',
                'e',
                'i',
                'o',
                'u',
                'y'
        };
        int pos = -1;
        if (a.length() > 0) {
            if (pos == -1) { // от сюда до 1171 строки поиск первой гласной буквы в слове
                for (int i = 0; i < A.length; i++) {
                    for (int b = 0; b < glassnie.length; b++) {
                        if (A[i] == glassnie[b]) {
                            pos = i;
                        }
                    }
                    if (pos != -1) {
                        break;
                    }
                }

            }
            firststring = a.substring(0, pos); // разбиение слова на 2 от начала до гласной и от гласной до конца
            secondstring = a.substring(pos, a.length()); // 2 часть слова
            pos = -1;
            for (int b = 0; b < glassnie.length; b++) { // соединение слова если первая буква согласная
                if (A[0] != glassnie[b]) {
                    ext = secondstring + firststring + "ay";
                    break;
                }
            }
            for (int n = 0; n < glassnie.length; n++) { // соединение слова если первая буква гласная
                if (A[0] == glassnie[n]) {
                    ext = a + "yay";
                    break;
                }
            }
        } else {
            ext = " ";
        }
        return ext;
    }

    //берет английское предложение и возвращает это предложение, переведенное на латинский язык
    public static String translateSentence(String n){
        String ext = "";
        String[] h = n.split(" "); // разбиение предложения на слова
        for (int i=0;i<h.length;i++){ // применяем функцию перевода слова
            ext += translateWord(h[i]) + " ";
        }
        return ext;
    }

    //принимает строку (например, " rgb(0, 0, 0)") и возвращает true, если ее формат правильный,
    // в противном случае возвращает false.
    public static boolean validColor(String a) {
        boolean q = false;
        String format = "";
        String str = "";
        String[] colorIndex = {};
        int r = -3;
        int b = -3;
        int g = -3;
        double A = -3;
        char[] n = a.toCharArray();
        if (a.indexOf('(') == 3) { // определение формата
            for (int i = 0; i <= 2; i++) {
                format = format + n[i];
            }
        } else {
            for (int i = 0; i <= 3; i++) {
                format = format + n[i];
            }
        }
        format = format.toLowerCase(); // нижний регистр названию
        if (format.equals("rgb")) {
            str = a.substring(a.indexOf('(')+1,a.indexOf(')')); // определение только цифр
            str = str.replace(" ","");
            colorIndex = str.split(","); // разбиение цифр
            if(colorIndex[0] == "" || colorIndex[1] == "" || colorIndex[2] == ""){
                q = false;
            }else {
                r = Integer.parseInt(colorIndex[0]);  // распределение цифр
                if (colorIndex[1] == "1" & colorIndex[1] == "2" & colorIndex[1] == "3" & colorIndex[1] == "4"
                & colorIndex[1] == "5" & colorIndex[1] == "6" & colorIndex[1] == "7" & colorIndex[1] == "8"
                & colorIndex[1] == "9" & colorIndex[1] == "10") {
                    g = Integer.parseInt(colorIndex[1]);
                }
                else {
                    return false;
                }
                //g = Integer.parseInt(colorIndex[1]);
                b = Integer.parseInt(colorIndex[2]);
            }
            if ((r < 226 && g < 226 && b < 226) && (r > -1 && g > -1 && b > -1)) { // проверка на валидность
                q = true;
            }
        }
        if (format.equals("rgba")){
            str = a.substring(a.indexOf('(')+1,a.indexOf(')')); // определение только цифр
            str = str.replace(" ","");
            colorIndex = str.split(","); // разбиение цифр

            if(colorIndex[0] == "" || colorIndex[1] == "" || colorIndex[2] == "" || colorIndex[3] ==""){
                q = false;
            }else{
                r = Integer.parseInt(colorIndex[0]); // распределение цифр
                g = Integer.parseInt(colorIndex[1]);
                b = Integer.parseInt(colorIndex[2]);
                A = Double.parseDouble(colorIndex[3]);
            }
            if ((r < 226 && g < 226 && b < 226 && A <= 1.0) && (r > -1 && g > -1 && b > -1 && A >=0.0)) {
                q = true; // проверка на валидность
            }
        }
        return q;
    }

    //я принимает URL (строку), удаляет дублирующиеся параметры запроса и параметры,
    // указанные во втором аргументе (который будет необязательным массивом)
    public static String stripURLParam(String str, String ... param){
        URL url = null;
        try
        {
            url = new URL(str);
        }
        catch(MalformedURLException e)
        {
            System.err.println("MalformedURLException: " + e.getMessage());
        }
        String query = url.getQuery();
        //System.out.println(query);
        String[] arguments = query.split("&");
        ArrayList<String> results = new ArrayList<String>();
        boolean isDetected = false;
        for(int i = 0; i < arguments.length - 1; i++){
            for(int j = 1; j < arguments.length; j++){
                if(arguments[i].split("=")[0].equals(arguments[j].split("=")[0]) && i != j){
                    //System.out.println(arguments[i] + " - " + arguments[j]);
                    isDetected = true;
                    break;
                }
            }
            for(int k = 0; k < param.length; k++){
                if(arguments[i].split("=")[0].equals(param[k]))
                    isDetected = true;
            }
            if(!isDetected){
                results.add(arguments[i]);
            }
            else{
                isDetected = false;
            }
        }
        results.add(arguments[arguments.length - 1]);
        String resultUrl = str.substring(0, str.indexOf("?")) + "?";
        for(int i = 0; i < results.size() - 1; i++){
            resultUrl += results.get(i) + "&";
        }
        resultUrl += results.get(results.size() - 1);
        return resultUrl;
    }

    //извлекает три самых длинных слова из заголовка газеты и преобразует их в хэштеги.
    // Если несколько слов одинаковой длины, найдите слово, которое встречается первым.
    static String getHashTags(String line){
        String result = "";
        int k = 0;

        //убираем все запятые из строки
        while(line.indexOf(',') != -1){
            line = line.substring(0, line.indexOf(',')) + line.substring(line.indexOf(',') + 1);
        }

        //все заглавные буквы превращаем в строчные
        line = line.toLowerCase();

        //запишем каждое слово как элемент массива
        String[] masLine = line.split(" ");

        //проверяем, если в заголовке меньше 3х слов
        if(masLine.length < 3){
            if(masLine.length < 2){
                return line;
            }
            //если 2, то вернуть в порядке убывания (касается длины слов)
            if(masLine[0].length() < masLine[1].length())
                return "#" + masLine[1] + " #" + masLine[0];
            else
                return "#" + masLine[0] + " #" + masLine[1];
        }

        //ищем 3 слова с наибольшей длиной
        for(int i = 0; i < 3; i++){
            //line при каждой попытке найти слово должен содержать первое слово
            line = masLine[0];
            //начинаем со 2 слова, тк у нас первое уже записано в line
            //line используется для поиска длины слова и в конечном счете для записи результата
            //k нужно для того, чтобы найти самое длинное слово и исключить его в повторных проверках
            for(int j = 1; j < masLine.length; j++){
                if(masLine[j].length() > line.length()){
                    line = masLine[j];
                    k = j;
                }
            }
            //исключаем полученное слово из проверки в дальнейшем
            masLine[k] = "";
            //записываем полученное слово
            result += "#" + line + " ";
        }

        return result;
    }

    //последовательность Улама
    public static int ulam(int n)
    {
        int count, cur = 4, i = 3;
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        while(i <= n){
            count = 0;
            for(int j = 0; j < arr.size()-1; j++){
                for(int k = j; k < arr.size(); k++){
                    if(arr.get(j) + arr.get(k) == cur && j != k)
                        count++;
                }
            }
            if(count == 1){
                arr.add(cur);
                i++;
            }
            cur++;
        }
        return arr.get(n-1);
    }

    //возвращает самую длинную неповторяющуюся подстроку для строкового ввода.
    public static String longestNonrepeatingSubstring(String str){
        String longestStr = "";
        String tempStr = "";
        for(int i = 0; i < str.length(); i++){
            if (tempStr.indexOf(str.charAt(i)) == -1){
                tempStr += str.charAt(i);
            }
            else{
                if (longestStr.length() < tempStr.length()){
                    longestStr = tempStr;
                    tempStr = "";
                }
            }
        }
        if (tempStr.length() > longestStr.length()){
            longestStr = tempStr;
        }
        return longestStr;
    }

    //принимает арабское число и преобразует его в римское число
    public static String convertToRoman(int num){
        String roman = "";
        int a = 0, k = 0;
        while(num != 0){
            a = num % 10;
            if(k == 0)
                roman = units(a) + roman;
            else if (k == 1)
                roman = tens(a) + roman;
            else if(k == 2)
                roman = hundreds(a) + roman;
            else if(k == 3)
                roman = thousends(a) + roman;
            num /= 10;
            k++;
        }
        return roman;
    }

    public static String units(int a){
        switch(a){
            case 1:
                return "I";
            case 2:
                return "II";
            case 3:
                return "III";
            case 4:
                return "IV";
            case 5:
                return "V";
            case 6:
                return "VI";
            case 7:
                return "VII";
            case 8:
                return "VIII";
            case 9:
                return "IX";
            default:
                return "";
        }
    }

    public static String tens(int a){
        switch(a){
            case 1:
                return "X";
            case 2:
                return "XX";
            case 3:
                return "XXX";
            case 4:
                return "XL";
            case 5:
                return "L";
            case 6:
                return "LX";
            case 7:
                return "LXX";
            case 8:
                return "LXXX";
            case 9:
                return "XC";
            default:
                return "";
        }
    }

    public static String hundreds(int a){
        switch(a){
            case 1:
                return "C";
            case 2:
                return "CC";
            case 3:
                return "CCC";
            case 4:
                return "CD";
            case 5:
                return "D";
            case 6:
                return "DC";
            case 7:
                return "DCC";
            case 8:
                return "DCCC";
            case 9:
                return "CM";
            default:
                return "";
        }
    }

    public static String thousends(int a){
        switch(a){
            case 1:
                return "M";
            case 2:
                return "MM";
            case 3:
                return "MMM";
            default:
                return "";
        }
    }

    //принимает строку и возвращает true или false в зависимости от того, является ли формула правильной или нет
    public static boolean formula(String a) {
        boolean res = false;
        int equalsPos = a.indexOf("=");
        if ((equalsPos > -1) && (a.lastIndexOf("=") == equalsPos)) {
            int mathAns = Integer.parseInt(a.substring(equalsPos+1).trim());
            String mathExpress = a.substring(0, equalsPos);
            if ((a.contains("+")) && (a.indexOf("+") < equalsPos)) {
                String[] mathVars = mathExpress.trim().split(" \\+ ");
                if (Integer.parseInt(mathVars[0]) + Integer.parseInt(mathVars[1]) == mathAns)
                    res = true;
            }
            else if ((a.contains("*")) && (a.indexOf("*") < equalsPos)) {
                String[] mathVars = mathExpress.trim().split(" \\* ");
                if (Integer.parseInt(mathVars[0]) * Integer.parseInt(mathVars[1]) == mathAns)
                    res = true;
            }
            else if ((a.contains("/")) && (a.indexOf("/") < equalsPos)) {
                String[] mathVars = mathExpress.trim().split(" \\/ ");
                if (Integer.parseInt(mathVars[0]) / Integer.parseInt(mathVars[1]) == mathAns)
                    res = true;
            }
            else if ((a.contains("-")) && (a.indexOf("-") < equalsPos)) {
                String[] mathVars = mathExpress.trim().split(" \\- ");
                if (Integer.parseInt(mathVars[0]) - Integer.parseInt(mathVars[1]) == mathAns)
                    res = true;
            }
        }
        return res;
    }

    //возвращает значение true, если само число является палиндромом или любой из его потомков вплоть до 2 цифр
    // (однозначное число - тривиально палиндром).
    public static boolean palindrome(String num){
        while(num.length() > 1){
            //System.out.println(num);
            if(isPal(num))
                return true;
            String buf = "";
            for(int i = 0; i < num.length() - 1; i += 2){
                buf += "" +  (Character.getNumericValue(num.charAt(i)) + Character.getNumericValue(num.charAt(i+1)));
            }
            num = buf;
        }
        return false;
    }
    public static boolean isPal(String str){
        return str.equals(new StringBuilder(str).reverse().toString());
    }

}
