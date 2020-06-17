public class Exr {
    public static void main(String[] args) {
        System.out.println("Amount of solutions: " + solutions(1,0,-1));
        System.out.println("Index of zip: " + findZip("all zip files are zipped"));
        System.out.println("Is perfect: " + checkPerfect(97));
        System.out.println("Flipped: " + flipEndChars("Cat, dog, and mouse."));
        System.out.println("Hex code: " + isValidHexCode("#CD5C5C"));
        System.out.println("Same uniqs: " + same(new int[] {2}, new int[] {3,3,3,3,3}));
        System.out.println("Is kaprekar: " + isKaprekar(297));
        System.out.println("Longest zero streak: " + longestZero("01100001011000"));
        System.out.println("Next prime: " + nextPrime(24));
        System.out.println("Is pryamougolniy: " + rightTriangle(145, 105, 100));
    }

    public static int solutions(int a, int b, int c) {
        int D = b*b-4*a*c;
        if (D > 0) return 2;
        else if (D == 0) return 1;
        else return 0;
    }
    public static int findZip(String str) {
        int decoy = 0;
        if (str.contains("zip")) decoy = str.indexOf("zip")+1;
        else return -1;
        str = str.substring(decoy);
        if (str.contains("zip")) return str.indexOf("zip")+decoy;
        else return -1;
    }
    public static boolean checkPerfect(int a) {
        int sum = 0;
        for (int i = 1; i < a; i++) {
            if (a%i == 0) sum+=i;
        }
        return sum==a;
    }
    public static String flipEndChars(String str) {
        if (str.length()<2) return "Incompatible.";
        char[] wp = str.toCharArray();
        char last = str.charAt(str.length()-1);
        if (wp[0] == last) return "Two's a pair.";
        else {wp[wp.length-1] = wp[0]; wp[0] = last;}
        return String.valueOf(wp);
    }
    public static boolean isValidHexCode(String str) {
        String lets = "ABCDEFabcdef";
        if (str.length()!=7 || str.charAt(0)!='#') return false;
        for (char ch : str.substring(1).toCharArray()) {
            if (!Character.isDigit(ch) && !lets.contains(Character.toString(ch))) return false;
        }
        return true;
    }
    public static boolean same(int[] a, int[] b) {
        String as = "", bs = "";
        for (int num : a) {
            String ch = String.valueOf(num);
            if (!as.contains(ch)) as += ch;
        }
        for (int num : b) {
            String ch = String.valueOf(num);
            if (!bs.contains(ch)) bs += ch;
        }
        return as.length()==bs.length();
    }
    public static boolean isKaprekar(int n) {
        char[] wp = String.valueOf(n*n).toCharArray();
        String right = "", left = "";
        for (int i = 0; i < wp.length; i++) {
            if (i%2==0) right += wp[wp.length/2+i/2];
            else left += wp[i/2];
        }
        if (left.length()>0 && right.length()>0) return (n == Integer.parseInt(right) + Integer.parseInt(left));
        else return n == Integer.parseInt(right);
    }
    public static String longestZero(String str) {
        String zeros = "", decoy = ""; int max = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '0') {
                decoy += "0";
            } else {
                if (max < decoy.length()) {
                    max = decoy.length();
                    zeros = decoy;
                }
                decoy = "";
            }
        }
        return zeros;
    }
    public static int nextPrime (int a) {
        if (isPrime(a)) return a;
        while (!isPrime(a)) {
            a++;
        }
        return a;
    }
    public static boolean isPrime(int a) {
        for (int i=2;i<a;i++) {
            if (a%i==0) return false;
        } return true;
    }
    public static boolean rightTriangle(int a, int b, int c) {
        int max = 0, o1 = 0, o2 = 0;
        if (a > b && a > c) {max = a; o1 = b; o2 = c;}
        else if (b > a && b > c) {max = b; o1 = a; o2 = c;}
        else {max = c; o1 = a; o2 = b;}
        return (max*max==o1*o1+o2*o2);
    }
}
