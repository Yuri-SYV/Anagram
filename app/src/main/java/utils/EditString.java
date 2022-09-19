package utils;

public class EditString {

    public final static String editString(String string, String ignore) {

            StringBuilder builder = new StringBuilder();
            String[] strArray = string.split(" ");

            for (int n = 0; n < strArray.length; n++) {
                char[] s = strArray[n].toCharArray();
                String revStr = new String(reverse(s, ignore));
                builder.append(revStr);
                if (n < strArray.length - 1) {
                    builder.append(" ");
                }
            }
            String result = builder.toString();
            return result;
        }

        public static char[] reverse(char[] s, String ignore) {

            char[] temp = new char[s.length];           // creating character array
            int x = 0;
            for (int i = 0; i < s.length; i++) {
                if (ignore.indexOf(s[i]) < 0) {
                    temp[x] = s[i];
                    x++;
                }
            }

            rev(temp, 0, x);                          // reversing the character array

            char[] anagram = new char[s.length];
            x = 0;
            for (int i = 0; i < s.length; i++) {        // creating reverse word
                if (ignore.indexOf(s[i]) < 0) {
                    anagram[i] = temp[x];
                    x++;
                } else {
                    anagram[i] = s[i];
                }
            }
            return anagram;
        }

        public final static void rev(char s[], int l, int r) {        // reversal array
            for (int i = l; i < r / 2; i++) {
                char temp = s[i];
                s[i] = s[r - 1 - i];
                s[r - 1 - i] = temp;
            }
        }
    }

