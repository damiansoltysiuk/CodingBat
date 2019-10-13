public class String3 {
    /*Given a string, count the number of words ending in 'y' or 'z' -- so the 'y' in "heavy" and the 'z' in "fez"
    count, but not the 'y' in "yellow" (not case sensitive). We'll say that a y or z is at the end of a word if there
    is not an alphabetic letter immediately following it. (Note: Character.isLetter(char) tests if a char is an
    alphabetic letter.)
    countYZ("fez day") → 2
    countYZ("day fez") → 2
    countYZ("day fyyyz") → 2*/
    public int countYZ(String str) {
        str = str.toLowerCase();
        int count = 0;
        char[] chars = str.toCharArray();
        for(int i = 1; i < chars.length; i++) {
            if(!Character.isLetter(chars[i]) &&
                    (chars[i - 1] == 'y' || chars[i - 1] == 'z')) count++;
        }
        if(chars[chars.length - 1] == 'y' || chars[chars.length - 1] == 'z') count++;
        return count;
    }

    /*Given two strings, base and remove, return a version of the base string where all instances of the remove string
    have been removed (not case sensitive). You may assume that the remove string is length 1 or more. Remove only
    non-overlapping instances, so with "xxx" removing "xx" leaves "x".
    withoutString("Hello there", "llo") → "He there"
    withoutString("Hello there", "e") → "Hllo thr"
    withoutString("Hello there", "x") → "Hello there"*/
    public String withoutString(String base, String remove) {
        String result = "";
        int i = 0;
        while(i < base.length()){
            if(base.substring(i).toLowerCase().startsWith(remove.toLowerCase())) {
                i += remove.length();
            } else {
                result += base.charAt(i);
                i++;
            }
        }
        return result;
    }

    /*Given a string, return true if the number of appearances of "is" anywhere in the string is equal to the number of
    appearances of "not" anywhere in the string (case sensitive).
    equalIsNot("This is not") → false
    equalIsNot("This is notnot") → true
    equalIsNot("noisxxnotyynotxisi") → true*/
    public boolean equalIsNot(String str) {
        int counterIs = (str.length() - str.replace("is","").length()) / 2;
        int counterNot = (str.length() - str.replace("not","").length()) / 3;
        return counterIs == counterNot;
    }

    /*We'll say that a lowercase 'g' in a string is "happy" if there is another 'g' immediately to its left or right.
    Return true if all the g's in the given string are happy.
    gHappy("xxggxx") → true
    gHappy("xxgxx") → false
    gHappy("xxggyygxx") → false*/
    public boolean gHappy(String str) {
        int size = str.length();
        if (str.indexOf('g') < 0) return true;
        if (size < 2) return false;
        if (str.charAt(size - 1) == 'g' && str.charAt(size - 2) != 'g') return false;
        int i = 1;
        while (i < str.length()) {
            if (str.charAt(i) == 'g') {
                if (str.charAt(i - 1) != 'g' && str.charAt(i + 1) != 'g') {
                    return false;
                }
            }
            i++;
        }
        return true;
    }

    /*We'll say that a "triple" in a string is a char appearing three times in a row. Return the number of triples in
    the given string. The triples may overlap.
    countTriple("abcXXXabc") → 1
    countTriple("xxxabyyyycd") → 3
    countTriple("a") → 0*/
    public int countTriple(String str) {
        int counter = 0;
        int i = 0;
        while(i <= str.length() - 3) {
            if(str.charAt(i) == str.charAt(i + 1) && str.charAt(i) == str.charAt(i + 2)) {
                counter++;
            }
            i++;
        }
        return counter;
    }

    /*Given a string, return the sum of the digits 0-9 that appear in the string, ignoring all other characters.
    Return 0 if there are no digits in the string. (Note: Character.isDigit(char) tests if a char is one of the chars
    '0', '1', .. '9'. Integer.parseInt(string) converts a string to an int.)
    sumDigits("aa1bc2d3") → 6
    sumDigits("aa11b33") → 8
    sumDigits("Chocolate") → 0*/
    public int sumDigits(String str) {
        int sum = 0;
        int i = 0;
        while(i < str.length()) {
            char ch = str.charAt(i);
            if(Character.isDigit(ch)) {
                sum += Character.getNumericValue(ch);
            }
            i++;
        }
        return sum;
    }

    /*Given a string, return the longest substring that appears at both the beginning and end of the string without
    overlapping. For example, sameEnds("abXab") is "ab".
    sameEnds("abXYab") → "ab"
    sameEnds("xx") → "x"
    sameEnds("xxx") → "x"*/
    public String sameEnds(String string) {
        int limit = string.length() / 2;
        int count = 0;
        for(int i = 1; i <=limit; i++) {
            String word = string.substring(0, i);
            if(string.endsWith(word)) count = i;
        }
        return string.substring(0, count);
    }

    /*Given a string, look for a mirror image (backwards) string at both the beginning and end of the given string. In
    other words, zero or more characters at the very begining of the given string, and at the very end of the string in
    reverse order (possibly overlapping). For example, the string "abXYZba" has the mirror end "ab".
    mirrorEnds("abXYZba") → "ab"
    mirrorEnds("abca") → "a"
    mirrorEnds("aba") → "aba"*/
    public String mirrorEnds(String string) {
        char[] chars = string.toCharArray();
        int limit = chars.length - 1;
        int count = 0;
        for(int i = 0; i <= limit; i++) {
            if(chars[i] == chars[limit - i]) count++;
            else break;
        }
        return string.substring(0, count);
    }

    /*Given a string, return the length of the largest "block" in the string. A block is a run of adjacent chars that
    are the same.
    maxBlock("hoopla") → 2
    maxBlock("abbCCCddBBBxx") → 3
    maxBlock("") → 0*/
    public int maxBlock(String str) {
        int size = str.length();
        if(size < 2) return size;
        int counter = 0;
        int max = 0;
        int i = 1;
        char ch = str.charAt(0);
        while(i < size){
            if(str.charAt(i - 1) == str.charAt(i)) {
                counter++;
            } else {
                counter = 0;
            }
            max = Math.max(max, counter);
            i++;
        }
        return max + 1;
    }

    /*Given a string, return the sum of the numbers appearing in the string, ignoring all other characters. A number is
    a series of 1 or more digit chars in a row. (Note: Character.isDigit(char) tests if a char is one of the chars
    '0', '1', .. '9'. Integer.parseInt(string) converts a string to an int.)
    sumNumbers("abc123xyz") → 123
    sumNumbers("aa11b33") → 44
    sumNumbers("7 11") → 18*/
    public int sumNumbers(String str) {
        int sum = 0;
        for (int i = 0; i <= str.length() - 1; i++) {
            char ch = str.charAt(i);
            if(Character.isDigit(str.charAt(i))){
                int start = i;
                int stop = start;
                while (i < str.length() - 1 && Character.isDigit(str.charAt(i + 1))){
                    i++;
                    stop = i;
                }
                int num = Integer.parseInt(str.substring(start, stop + 1));
                sum += num;
            }
        }
        return sum;
    }

    /*Given a string, return a string where every appearance of the lowercase word "is" has been replaced with "is not".
    The word "is" should not be immediately preceeded or followed by a letter -- so for example the "is" in "this" does
    not count. (Note: Character.isLetter(char) tests if a char is a letter.)
    notReplace("is test") → "is not test"
    notReplace("is-is") → "is not-is not"
    notReplace("This is right") → "This is not right"*/
    public String notReplace(String str) {
        str = " " + str + " ";
        String result = "";
        int i = 1;
        while(i < str.length() - 1) {
            if (str.substring(i, i + 2).equals("is") && (!Character.isLetter(str.charAt(i - 1)) && !Character.isLetter(str.charAt(i + 2)))) {
                result += "is not";
                i++;
            } else {
                result += str.charAt(i);
            }
            i++;
        }
        return result;
    }
}
