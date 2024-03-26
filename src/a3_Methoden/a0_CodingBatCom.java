package a3_Methoden;

import java.util.ArrayList;
import java.util.Arrays;

public class a0_CodingBatCom {
    //                                           https://codingbat.com/java/Recursion-1
    public static void main(String[] args) {
    }
    public int factorial(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return n * factorial(--n);
    }
    public int bunnyEars(int bunnies) {
        if (bunnies == 0) return 0;

        return 2 + bunnyEars(bunnies-1);
    }
    public int fibonacci(int n) {
        if (n < 2) return n;

        return fibonacci(n -1) + fibonacci(n -2);
    }
    public int bunnyEars2(int bunnies) {
        if (bunnies == 0) return 0;

        if (bunnies % 2 == 1) return 2 + bunnyEars2(bunnies-1);
        else return 3 + bunnyEars2(bunnies-1);
    }
    public int count7(int n) {
        if ( n<10 ) return n == 7 ? 1 : 0;

        return (n % 10 == 7 ? 1 : 0) + count7(n / 10);
    }
    public int count8(int n) {
        if (n < 10) return n == 8 ? 1 : 0;

        if (n % 100 == 88) return 2 + count8(n / 10);

        return (n % 10 == 8 ? 1 : 0) + count8(n / 10);
    }
    public int powerN(int base, int n) {
        if (n == 1) return base;

        return powerN(base, --n) * base;
    }
    public int countX(String str) {
        if (str.isEmpty()) return 0;
        if (str.length() == 1) return str.charAt(0) == 'x' ? 1 : 0;

        return (str.charAt(str.length() -1) == 'x' ? 1 : 0) + countX(str.substring(0, str.length()-1));
    }
    public int countHi(String str) {
        if (str.length() < 2) return 0;

        if (str.startsWith("hi")) return 1 + countHi(str.substring(2));

        return countHi(str.substring(1));
    }
    public String changeXY(String str) {
        if (str.isEmpty()) return str;

        return str.charAt(0) == 'x' ? "y"+changeXY(str.substring(1)) :
                str.charAt(0) + changeXY(str.substring(1));
    }
    public String changePi(String str) {
        if (str.length() < 2) return str;

        if (str.startsWith("pi")) return "3.14" + changePi(str.substring(2));

        return str.charAt(0) + changePi(str.substring(1));
    }
    public String noX(String str) {
        if (str.isEmpty()) return str;

        return str.charAt(0) == 'x' ? noX(str.substring(1)) :
                str.charAt(0) + noX(str.substring(1));
    }
    public boolean array6(int[] nums, int index) {
        if (nums.length == 0 || index >= nums.length) return false;
        else if (nums[index] == 6) return true;

        return array6(nums, ++index);
    }
    public int array11(int[] nums, int index) {
        if (nums.length == 0 || index >= nums.length) return 0;

        return (nums[index] == 11 ? 1 : 0) + array11(nums, ++index);
    }
    public boolean array220(int[] nums, int index) {
        if (nums.length == 0 || index >= nums.length) return false;

        for (int i = index; i < nums.length; i++) {
            if (nums[index]*10 == nums[i]) return true;
        }

        return array220(nums, ++index);
    }
    public String allStar(String str) {
        if (str.length() <= 1) return str;

        return str.charAt(0) + "*" + allStar(str.substring(1));
    }
    public String pairStar(String str) {
        if (str.length() <= 1) return str;

        return str.charAt(0) +
                (str.charAt(0) == str.charAt(1) ? "*" : "") +
                pairStar(str.substring(1));
    }
    public String endX(String str) {
        if (str.isEmpty()) return str;

        return str.charAt(0) == 'x' ?
                endX(str.substring(1)) + "x" :
                str.charAt(0) +  endX(str.substring(1));
    }
    public int countPairs(String str) {
        if (str.length() <= 2) return 0;

        return (str.charAt(0) == str.charAt(2) ? 1 : 0) + countPairs(str.substring(1));
    }
    public int countAbc(String str) {
        if (str.length() < 3) return 0;

        return (str.startsWith("abc") || str.startsWith("aba") ? 1 : 0)
                + countAbc(str.substring(1));
    }
    public int count11(String str) {
        if (str.length() < 2) return 0;

        return str.startsWith("11") ? 1 + count11(str.substring(2)) : count11(str.substring(1));
    }
    public String stringClean(String str) {
        if (str.length() < 2) return str;

        return (str.charAt(0) == str.charAt(1) ? "" : str.charAt(0))
                + stringClean(str.substring(1));
    }
    public int countHi2(String str) {
        if (str.length() < 2) return 0;

        if (str.startsWith("xhi")) return countHi2(str.substring(3));

        if (str.charAt(0) == 'x') return countHi2(str.substring(1));

        return str.startsWith("hi") ?
                1 + countHi2(str.substring(2)) :
                countHi2(str.substring(1));
    }
    public String parenBit(String str) {
        if (str.length() < 2) return "";

        if (str.charAt(0) == '(') {
            if (str.charAt(str.length() -1) == ')') return str;
            else return parenBit(str.substring(0, str.length()-1));
        }
        return parenBit(str.substring(1));
    }
    public boolean nestParen(String str) {
        if (str.length() % 2 == 1) return false;

        if (!str.isEmpty()) {
            if (str.charAt(0) == '(' && str.charAt(str.length()-1) == ')') {
                return nestParen(str.substring(1, str.length()-1));  // ohne "return" ????
            }
            else return false;
        }
        return true;
    }
    public int strCount(String str, String sub) {
        if (str.length() < sub.length()) return 0;

        return str.startsWith(sub) ?
                1 + strCount(str.substring(sub.length()), sub) :
                strCount(str.substring(1), sub);
    }
    public boolean strCopies(String str, String sub, int n) {
        if (str.length() < sub.length()) return false;

        if (str.startsWith(sub)) n--;
        if (n <= 0) return true;
        return strCopies(str.substring(1), sub, n);
    }
    public int strDist(String str, String sub) {
        if (str.length() < sub.length()) return 0;
        if (str.startsWith(sub)) {
            if (!str.endsWith(sub)) return strDist(str.substring(0, str.length() -1), sub);
        } else return strDist(str.substring(1), sub);

        return str.length();
    }


    // -------------------------- Rekursion 2
    public boolean groupSum(int start, int[] nums, int target) {
        if (start >= nums.length) return target == 0;

        if (groupSum(start+1, nums, target-nums[start])) return true;

        if (groupSum(start+1, nums, target)) return true;

        return false;
    }

    public boolean groupSum6(int start, int[] nums, int target) {
        if (start >= nums.length) return (target == 0);

        if (nums[start] == 6) {
            return groupSum6(start + 1, nums, target - 6);
        }

        return groupSum6(start + 1, nums, target) || groupSum6(start + 1, nums, target - nums[start]);
    }

    public boolean groupNoAdj(int start, int[] nums, int target) {
        if (start >= nums.length) return (target == 0);

        return groupNoAdj(start + 2, nums, target - nums[start]) ||
                groupNoAdj(start + 1, nums, target);
    }
    public boolean groupSum5(int start, int[] nums, int target) {
        if (start >= nums.length) return (target == 0);

        if (nums[start] % 5 == 0) {
            if (start < nums.length - 1 && nums[start + 1] == 1) {
                return groupSum5(start + 2, nums, target - nums[start]);
            }
            return groupSum5(start + 1, nums, target - nums[start]);
        }
        return groupSum5(start + 1, nums, target - nums[start]) ||
                groupSum5(start + 1, nums, target);
    }











}
