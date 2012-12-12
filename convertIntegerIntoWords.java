
public class convertIntegerIntoWords {

    String[] belowTens = {"", " One", " Two", " Three", " Four", " Five",
        " Six", " Seven", " Eight", " Nine", " Ten", " Eleven", " Twelve",
        " Thirteen", " Fourteen", " Fifteen", " Sixteen", " Seventeen",
        " Eighteen", " Nineteen"};
    String[] tens = {"", "Ten", " Twenty", " Thirty", " Forty", " Fifty",
        " Sixty", " Seventy", " Eighty", " Ninety"};
    String[] aboveTens = {"", " Hundred", " Thousand", " Lakh", " Crore", "Hundred Crore"};

    public String IntegerIntoWords(int num) {
        String Str = "", ltr = "";
        int len = 0, q = 0, r = 0;
        while (num > 0) {
            len = numberCount(num);
            //Take the length of the number and do letter conversion
            switch (len) {
                case 9:
                case 8:
                    q = num / 10000000;
                    r = num % 10000000;
                    ltr = twoDigits(q);
                    Str = Str + ltr + aboveTens[4];
                    num = r;
                    break;
                case 7:
                case 6:
                    q = num / 100000;
                    r = num % 100000;
                    ltr = twoDigits(q);
                    Str = Str + ltr + aboveTens[3];
                    num = r;
                    break;

                case 5:
                case 4:

                    q = num / 1000;
                    r = num % 1000;
                    ltr = twoDigits(q);
                    Str = Str + ltr + aboveTens[2];
                    num = r;
                    break;
                case 3:
                    if (len == 3) {
                        r = num;
                    }
                    ltr = threeDigits(r);
                    Str = Str + ltr;
                    num = 0;
                    break;
                case 2:

                    ltr = twoDigits(num);
                    Str = Str + ltr;
                    num = 0;
                    break;
                case 1:
                    Str = Str + belowTens[num];
                    num = 0;
                    break;
                default:
                    num = 0;
            }
            if (num == 0) {
                System.out.println(Str);
            }
        }
        return Str;
    }

    int numberCount(int num) {
        int cnt = 0, r = 0;
        while (num > 0) {
            r = num % 10;
            cnt++;
            num = num / 10;
        }
        return cnt;
    }
//Method for Conversion of two digits

    String twoDigits(int numq) {
        int numr, nq;
        String ltr = "";
        nq = numq / 10;
        numr = numq % 10;

        if (numq > 19) {
            ltr = ltr + tens[nq] + belowTens[numr];
        } else {
            ltr = ltr + belowTens[numq];
        }
        return ltr;
    }
//Method for Conversion of three digits

    String threeDigits(int numq) {
        int numr, nq;
        String ltr = "";
        nq = numq / 100;
        numr = numq % 100;
        if (numr == 0) {
            ltr = ltr + belowTens[nq] + aboveTens[1];
        } else {
            ltr = ltr + belowTens[nq] + aboveTens[1] + " and" + twoDigits(numr);
        }
        return ltr;
    }

    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("" + (new convertIntegerIntoWords().IntegerIntoWords(987654321)));
    }
}
