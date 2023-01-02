public class NumberInWords {
    private String setTwoDigits(String number) {

        String[] oneToNine={"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        String[] elevenToNinteen={"eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "ninteen"};
        String[] twoDigitWithZero={"ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninty"};

        String ansString="";

        if(number.charAt(0)=='0' && number.charAt(1)=='0') {
            return ansString;
        }

        else if(number.charAt(0)=='0') {
            ansString += oneToNine[number.charAt(1)-'0'];
        }

        else if(number.charAt(0)=='1') {
            if(number.charAt(1)=='0') ansString+="ten";
            else ansString += elevenToNinteen[number.charAt(1)-'0'-1];
        }

        else {
            ansString += twoDigitWithZero[number.charAt(0)-'0'-1] + " " + oneToNine[number.charAt(1)-'0'];
        }

        return ansString;
    }

    public String numberToSpelling(String number) {

        String[] oneToNine={"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        String[] elevenToNinteen={"eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "ninteen"};
        String[] twoDigitWithZero={"ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninty"};
        String[] thousandToCrore={"crore", "lakh", "thousand"};

        String ansString="";
        String returningText="";

        if(number.length()%2==0) {
            number = '0' + number;
        }

        int idx=0;
        if(number.length()==7 || number.length()==6) idx=1;
        else if(number.length()==5 || number.length()==4) idx=2;
        
        for(int i=number.length(); i>3; i-=2) {
            returningText = setTwoDigits("" + number.charAt(number.length()-i) + number.charAt(number.length()-i+1));

            if(!returningText.equals("")) {
                ansString += returningText + " " + thousandToCrore[idx] + " ";
            }

            if(idx<2) idx++;
        }
        
        if(number.length()>=3 && number.charAt(number.length()-3) != '0')
        ansString += oneToNine[number.charAt(number.length()-3)-'0'] + " hundred ";

        if( !ansString.isEmpty() && (number.length()>=1) && (number.charAt(number.length()-1)!='0' || number.charAt(number.length()-2)!='0') ) {
            ansString += "and ";
        }

        ansString += (number.length()>=2)? setTwoDigits("" + number.charAt(number.length()-2) + number.charAt(number.length()-1))
            : setTwoDigits("0" + number.charAt(number.length()-1));

        return ansString;

    }
    
    public static void main(String args[]) {
        Conversion c=new Conversion();

        System.out.println("3782183\t\t" + c.numberToSpelling("3782183"));
        System.out.println("7723\t\t" + c.numberToSpelling("7723"));
        System.out.println("53330\t\t" + c.numberToSpelling("53330"));
        System.out.println("1000\t\t" + c.numberToSpelling("1000"));
        System.out.println("100\t\t" + c.numberToSpelling("100"));
        System.out.println("1111\t\t" + c.numberToSpelling("1111"));
        System.out.println("100001\t\t" + c.numberToSpelling("100001"));
        System.out.println("100271\t\t" + c.numberToSpelling("100271"));
        System.out.println("11\t\t" + c.numberToSpelling("11"));
        System.out.println("90921\t\t" + c.numberToSpelling("90921"));
        System.out.println("1891111\t\t"  + c.numberToSpelling("1891111"));
    }
}