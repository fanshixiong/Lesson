import java.util.*;

public class Delete {
    /**
     * 判断输入串合法性
     * @param s
     * @return
     */
    public static boolean check(String s) {
        if (s.contains(")(")) return false;
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') cnt++;
            if (s.charAt(i) == ')') cnt--;
            if (cnt < 0) return false;
        }
        if(cnt != 0) return false;
        return true;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        if (!check(s)) {
            System.out.println("表达式有误！");
        } else printString(s);
    }

    private static boolean before = false;

    private static void printString(String str) {
        String temp = "";
        for (int i = 0; i < str.length(); i++) {
            if (i == 0) before = false;
            else {
                if ((str.charAt(i - 1) == '*') || (str.charAt(i - 1) == '/')) before = true;
                else before = false;
            }
            if (str.charAt(i) == '(') {
                temp = getString(str.substring(i));
                //System.out.println(temp);
                if (i == 0) str = temp;
                else str = str.substring(0, i) + temp;
            }
        }
        System.out.println(str);
    }

    /**
     * 去括号
     * @param str
     * @return
     */
    private static String getString(String str) {
        String getresult = str;
        String temp = "";
        int i = 0;
        int ll = 0;
        boolean bool = false;
        for (i = 1; i < str.length(); ) {

            if ((str.charAt(i) == '+') || (str.charAt(i) == '-'))  bool = true;

            if (str.charAt(i) == '(') {
                temp = getString(str.substring(i));
                System.out.println(temp);
                ll = temp.length() + str.substring(0, i).length();
                str = str.substring(0, i) + temp;

                if (ll != getresult.length()) {
                    if (i > 1) i--;
                } else {
                    i = str.indexOf(")", i) + 1;
                }
                getresult = str;
                continue;
            }
            if (str.charAt(i) == ')')  break;

            i++;
        }

        getresult = str;

        if (before == true)  return getresult;

        if (bool == false) {
            if ((i + 1) < str.length()) {
                str = str.substring(1);
                temp = str;
                getresult = str.substring(0, i - 1) + temp.substring(i);
            } else if ((i + 1) == str.length()) {
                str = str.substring(1);
                temp = str;
                getresult = str.substring(0, i - 1) + temp.substring(i);
            }
        } else {
            if ((i + 1) < str.length()) {
                if ((str.charAt(i + 1) != '*') && (str.charAt(i + 1) != '/')) {
                    str = str.substring(1);
                    temp = str;
                    getresult = str.substring(0, i - 1) + temp.substring(i);
                }
            } else if ((i + 1) == str.length()) {
                str = str.substring(1);
                temp = str;
                getresult = str.substring(0, i - 1) + temp.substring(i);
            }
        }

        return getresult;
    }
}
