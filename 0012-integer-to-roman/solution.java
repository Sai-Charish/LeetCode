class Solution {
    public String intToRoman(int num) {
        HashMap<Integer,String> Sym = new HashMap<>();
        int temp = num;
        int digit;
        int pow = 1;
        Sym.put(1,"I");
        Sym.put(4,"IV");
        Sym.put(5,"V");
        Sym.put(9,"IX");
        Sym.put(10,"X");
        Sym.put(40,"XL");
        Sym.put(50,"L");
        Sym.put(90,"XC");
        Sym.put(100,"C");
        Sym.put(400,"CD");
        Sym.put(500,"D");
        Sym.put(900,"CM");
        Sym.put(1000,"M");
        
        String str = "";
        String app = "";


        while(temp !=0)
        {
            digit = temp % 10;
            if(digit == 1 || digit == 4 || digit == 5 || digit == 9)
            {
                app = Sym.get(digit*pow);
                str = app + str;
            }
            else if(digit >= 2 && digit <= 4 || digit >= 6 && digit <= 8)
            {
                if(digit >= 2 && digit <= 4)
                {
                    app = Sym.get(1*pow);
                    str = app.repeat(digit) + str;

                }
                else if(digit >= 6 && digit <= 8)
                {
                    app = Sym.get(5*pow);
                    digit = digit - 5;
                    app += (Sym.get(1*pow)).repeat(digit);
                    str = app + str;
                }
                
            }
            temp/=10;
            pow*=10;
        }

        return str;


    }
}
