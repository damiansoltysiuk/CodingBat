public class String2 {
    /*Given a string, return a string where for every char in the original, there are two chars.
    doubleChar("The") → "TThhee"
    doubleChar("AAbb") → "AAAAbbbb"
    doubleChar("Hi-There") → "HHii--TThheerree"*/
    public String doubleChar(String str) {
        String result = "";
        for(int i = 0; i < str.length(); i++) {
            result = result + str.charAt(i) + str.charAt(i);
        }
        return result;
    }

    /*Return the number of times that the string "hi" appears anywhere in the given string.
    countHi("abc hi ho") → 1
    countHi("ABChi hi") → 2
    countHi("hihi") → 2*/
    public int countHi(String str) {
        int counter = 0;
        for(int i = 0; i < str.length() - 1; i++) {
            if(str.substring(i, i + 2).equals("hi")) {
                counter++;
            }
        }
        return counter;
    }

    /*Return true if the string "cat" and "dog" appear the same number of times in the given string.
    catDog("catdog") → true
    catDog("catcat") → false
    catDog("1cat1cadodog") → true*/
    public boolean catDog(String str) {
        int counterCat = 0;
        int counterDog = 0;
        for(int i = 0; i < str.length() - 2; i++) {
            if(str.substring(i, i + 3).equals("cat")) counterCat++;
            if(str.substring(i, i + 3).equals("dog") )counterDog++;
        }
        return counterCat == counterDog;
    }

    /*Return the number of times that the string "code" appears anywhere in the given string, except we'll accept any
    letter for the 'd', so "cope" and "cooe" count.
    countCode("aaacodebbb") → 1
    countCode("codexxcode") → 2
    countCode("cozexxcope") → 2*/
    public int countCode(String str) {
        int counter = 0;
        for(int i = 0; i < str.length() - 3; i++) {
            if(str.substring(i, i + 2).equals("co") &&
                    str.charAt(i + 3) == 'e') counter++;
        }
        return counter;
    }

    /*Given two strings, return true if either of the strings appears at the very end of the other string, ignoring
    upper/lower case differences (in other words, the computation should not be "case sensitive"). Note:
    str.toLowerCase() returns the lowercase version of a string.
    endOther("Hiabc", "abc") → true
    endOther("AbC", "HiaBc") → true
    endOther("abc", "abXabc") → true*/
    public boolean endOther(String a, String b) {
        a = a.toLowerCase();
        b = b.toLowerCase();
        if(a.length() >= b.length()) {
            return a.substring(a.length() - b.length()).equals(b);
        }
        return b.substring(b.length() - a.length()).equals(a);
    }

    /*Return true if the given string contains an appearance of "xyz" where the xyz is not directly preceeded by a
    period (.). So "xxyz" counts but "x.xyz" does not.
    xyzThere("abcxyz") → true
    xyzThere("abc.xyz") → false
    xyzThere("xyz.abc") → true*/
    public boolean xyzThere(String str) {
        for(int i = 0; i < str.length() - 2; i++) {
            if(str.substring(i, i + 3).equals("xyz")) return true;
            if(str.charAt(i) == '.') i++;
        }
        return false;
    }

    /*Return true if the given string contains a "bob" string, but where the middle 'o' char can be any char.
    bobThere("abcbob") → true
    bobThere("b9b") → true
    bobThere("bac") → false*/
    public boolean bobThere(String str) {
        for(int i = 1; i < str.length() - 1; i++) {
            if(str.charAt(i - 1) == 'b' && str.charAt(i + 1) == 'b') return true;
        }
        return false;
    }

    /*We'll say that a String is xy-balanced if for all the 'x' chars in the string, there exists a 'y' char somewhere
    later in the string. So "xxy" is balanced, but "xyx" is not. One 'y' can balance multiple 'x's. Return true if
    the given string is xy-balanced.
    xyBalance("aaxbby") → true
    xyBalance("aaxbb") → false
    xyBalance("yaaxbb") → false*/
    public boolean xyBalance(String str) {
        return (str.lastIndexOf('y') >= str.lastIndexOf('x'));
    }

    /*Given two strings, a and b, create a bigger string made of the first char of a, the first char of b, the second
    char of a, the second char of b, and so on. Any leftover chars go at the end of the result.
    mixString("abc", "xyz") → "axbycz"
    mixString("Hi", "There") → "HTihere"
    mixString("xxxx", "There") → "xTxhxexre"*/
    public String mixString(String a, String b) {
        String result = "";
        for(int i = 0; i < Math.max(a.length(), b.length()); i++) {
            if(i < Math.min(a.length(), b.length())) {
                result = result + a.charAt(i) + b.charAt(i);
            } else if(i < b.length()) {
                result = result + b.charAt(i);
            } else {
                result = result + a.charAt(i);
            }
        }
        return result;
    }

    /*Given a string and an int n, return a string made of n repetitions of the last n characters of the string.
    You may assume that n is between 0 and the length of the string, inclusive.
    repeatEnd("Hello", 3) → "llollollo"
    repeatEnd("Hello", 2) → "lolo"
    repeatEnd("Hello", 1) → "o"*/
    public String repeatEnd(String str, int n) {
        String result = "";
        for(int i = 0; i < n; i++) {
            result += str.substring(str.length() - n, str.length());
        }
        return result;
    }

    /*Given a string and an int n, return a string made of the first n characters of the string, followed by the
    first n-1 characters of the string, and so on. You may assume that n is between 0 and the length of the string,
    inclusive (i.e. n >= 0 and n <= str.length()).
    repeatFront("Chocolate", 4) → "ChocChoChC"
    repeatFront("Chocolate", 3) → "ChoChC"
    repeatFront("Ice Cream", 2) → "IcI"*/
    public String repeatFront(String str, int n) {
        String result = "";
        for(int i = 0; i < n; i++) {
            result += str.substring(0, n - i);
        }
        return result;
    }

    /*Given two strings, word and a separator sep, return a big string made of count occurrences of the word, separated
    by the separator string.
    repeatSeparator("Word", "X", 3) → "WordXWordXWord"
    repeatSeparator("This", "And", 2) → "ThisAndThis"
    repeatSeparator("This", "And", 1) → "This"*/
    public String repeatSeparator(String word, String sep, int count) {
        String result = "";
        for(int i = 0; i < count; i++) {
            if(i == 0) result = word;
            else result += sep.concat(word);
        }
        return result;
    }

    /*Given a string, consider the prefix string made of the first N chars of the string. Does that prefix string
    appear somewhere else in the string? Assume that the string is not empty and that N is in the range 1..str.length().
    prefixAgain("abXYabc", 1) → true
    prefixAgain("abXYabc", 2) → true
    prefixAgain("abXYabc", 3) → false*/
    public boolean prefixAgain(String str, int n) {
        String buffer = str.substring(0, n);
        for(int i = 1; i <= str.length() - n; i++) {
            if(buffer.equals(str.substring(i, i + n))) return true;
        }
        return false;
    }

    /*Given a string, does "xyz" appear in the middle of the string? To define middle, we'll say that the number of
    chars to the left and right of the "xyz" must differ by at most one. This problem is harder than it looks.
    xyzMiddle("AAxyzBB") → true
    xyzMiddle("AxyzBB") → true
    xyzMiddle("AxyzBBB") → false*/
    public boolean xyzMiddle(String str) {
        int size = str.length();

        if (size < 3) return false;

        if (size % 2 == 0) {
            if(str.substring(size / 2 - 2, size / 2 + 1).equals("xyz") ||
                    str.substring(size / 2 - 1, size / 2 + 2).equals("xyz")) return true;
        }

        if (size % 2 != 0) {
            if(str.substring(size / 2 - 1, size / 2 + 2).equals("xyz")) return true;
        }
        return false;
    }

    /*A sandwich is two pieces of bread with something in between. Return the string that is between the first and last
    appearance of "bread" in the given string, or return the empty string "" if there are not two pieces of bread.
    getSandwich("breadjambread") → "jam"
    getSandwich("xxbreadjambreadyy") → "jam"
    getSandwich("xxbreadyy") → ""*/
    public String getSandwich(String str) {
        int counter = 0;
        int size = str.length();
        String sandwich = "";

        if(size <= 10) return "";

        int start = 0;
        int stop = 0;
        for(int i = 0; i < size - 4; i++) {
            String buffer = str.substring(i, i + 5);
            if(str.substring(i, i + 5).equals("bread") && counter == 0) {
                start = i + 5;
                i = start;
                counter++;
            } else  if(str.substring(i, i + 5).equals("bread") && counter == 1) {
                stop = i;
            }
        }
        if(start != 0 && stop != 0 && start != stop)
            return str.substring(start, stop);
        return str.substring(start, stop);
    }

    /*Returns true if for every '*' (star) in the string, if there are chars both immediately before and after the star,
    they are the same.
    sameStarChar("xy*yzz") → true
    sameStarChar("xy*zzz") → false
    sameStarChar("*xa*az") → true*/
    public boolean sameStarChar(String str) {
        for (int i=1; i<str.length()-1; i++) {
            if (str.charAt(i) == '*') {
                if (str.charAt(i-1) != str.charAt(i+1)) return false;
            }
        }
        return true;
    }

    /*Given a string, compute a new string by moving the first char to come after the next two chars, so "abc" yields
    "bca". Repeat this process for each subsequent group of 3 chars, so "abcdef" yields "bcaefd". Ignore any group of
    fewer than 3 chars at the end.
    oneTwo("abc") → "bca"
    oneTwo("tca") → "cat"
    oneTwo("tcagdo") → "catdog"*/
    public String oneTwo(String str) {
        int change = str.length() / 3;
        String buff = "";
        for(int i = 0; i < change; i++) {
            buff += str.substring(3 * i + 1, 3 * i + 3).concat(str.substring(3 * i, 3 * i + 1));
        }
        return buff;
    }

    /*Look for patterns like "zip" and "zap" in the string -- length-3, starting with 'z' and ending with 'p'. Return
    a string where for all such words, the middle letter is gone, so "zipXzap" yields "zpXzp".
    zipZap("zipXzap") → "zpXzp"
    zipZap("zopzop") → "zpzp"
    zipZap("zzzopzop") → "zzzpzp"*/
    public String zipZap(String str) {
        if(str.length() <= 2) return str;
        String buffer = "";
        for(int i = 1; i <= str.length() - 2; i++) {
            if(str.charAt(i - 1) == 'z' && str.charAt(i + 1) == 'p') {
                buffer = buffer.concat
                        (str.substring(i - 1, i).
                                concat(str.substring(i + 1, i + 2)));
                i += 2;
            } else if (str.length() - i < 3) {
                buffer = buffer.concat(str.substring(str.length() - 3));
                i += 3;
            } else {
                buffer = buffer.concat(str.substring(i - 1, i));
            }
        }
        return buffer;
    }

    /*Return a version of the given string, where for every star (*) in the string the star and the chars immediately
    to its left and right are gone. So "ab*cd" yields "ad" and "ab**cd" also yields "ad".
    starOut("ab*cd") → "ad"
    starOut("ab**cd") → "ad"
    starOut("sm*eilly") → "silly"*/
    public String starOut(String str) {
        int index = str.indexOf('*');

        while(index >= 0) {
            int prev = prevChecked(str, index);
            int next = nextChecked(str, index);
            str = str.substring(0, prev).concat(str.substring(next));
            index = str.indexOf('*');
        }
        return str;
    }

    private int prevChecked(String str, int n) {
        return n > 0 ? n - 1 : 0;
    }

    private int nextChecked(String str, int n) {
        while(str.charAt(n) == '*' && n != str.length() - 1) {
            n++;
        }
        return n + 1;
    }

    /*Given a string and a non-empty word string, return a version of the original String where all chars have been
    replaced by pluses ("+"), except for appearances of the word string which are preserved unchanged.
    plusOut("12xy34", "xy") → "++xy++"
    plusOut("12xy34", "1") → "1+++++"
    plusOut("12xy34xyabcxy", "xy") → "++xy++xy+++xy"*/
    public String plusOut(String str, String word) {
        String result = "";
        int i = 0 ;
        while(i < str.length() ) {
            if (str.substring(i).startsWith(word)) {
                result = result + word;
                i = i + word.length();
            } else {
                result = result + "+" ;
                i++;
            }
        }
        return result ;
    }

    /*Given a string and a non-empty word string, return a string made of each char just before and just after every
    appearance of the word in the string. Ignore cases where there is no char before or after the word, and a char may
    be included twice if it is between two words.
    wordEnds("abcXY123XYijk", "XY") → "c13i"
    wordEnds("XY123XY", "XY") → "13"
    wordEnds("XY1XY", "XY") → "11"*/
    public String wordEnds(String str, String word) {
        int wordL = word.length();
        String result = "";
        int index = str.indexOf(word);
        while(index >= 0) {
            if(index > 0) {
                result += str.charAt(index - 1);
            }
            if(index < str.length() - wordL) {
                result += str.charAt(index + wordL);
            }
            index = str.indexOf(word, index + 1);
        }
        return result;
    }
}
