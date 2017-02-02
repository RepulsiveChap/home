import java.lang.Math;
class RatNum {
    public int numerator;
    public int denominator;
    public static void main(String[] args) throws Exception {

        //Converts the first two arguments (Strings) to ints
        //int m = Integer.parseInt(args[0]);
        //int n = Integer.parseInt(args[1]);
        //int sgdresult = sgd(m, n);
        //Used for debugging and testing part 1
        //System.out.println(sgdresult);

        RatNum r = parse("2");
        System.out.println(r.toString());
        r = parse("13/32");
        System.out.println(r.toString());
        r = parse("-2");
        System.out.println(r.toString());
        r = parse("0/23");
        System.out.println(r.toString());
        r = parse("-23/23");
        System.out.println(r.toString());
        //r = parse("23/0");
        //System.out.println(r.toString());
        //r = parse("23/-0");
        //System.out.println(r.toString());
        r = parse("23/-12");
        System.out.println(r.toString());
    }

    public static int sgd(int m, int n){
        //Exception if any of the given arguments is equal to 0
        if (m == 0 || n == 0){
            throw new IllegalArgumentException("The integer 0 is not allowed");
        }

        int r;

        //Euklides algorithm
        while (true) {
            //Takes the modulo of the given arguments absolute value
            r = Math.abs(m)%Math.abs(n);
            //If the result of the modulo is equal to 0, the algorithm is done
            if (r == 0) {
                return n;
            }
            else {
                m = n;
                n = r;
            }
        }
    }
    public RatNum (){
        numerator = 0;
        denominator = 1;

    }
    public RatNum (int a){
        numerator = a;
        denominator = 1;
    }
    public RatNum (int numerator, int denominator){
        //If the denominator is negative, we make the numerator negative instead
        if (denominator < 0) {
            numerator = numerator * -1;
            denominator = denominator * -1;
        }
        //If the numerator is 0, the denominator should always be 1
        if(numerator == 0) {
            this.numerator = 0;
            this.denominator = 1;
        }
        //If none of the exceptions occurs, we divide the given arguments by sgd
        else{
            //If the denominator is 0, an exception is thrown
            if(denominator == 0){
                throw new NumberFormatException("Denominator = 0");
            }
            int r = sgd(numerator, denominator);
            this.numerator = numerator/r;
            this.denominator = denominator/r;
        }
    }

    public RatNum (RatNum rat){
        denominator = rat.getDenominator();
        numerator = rat.getNumerator();

    }
    public RatNum (String s){
        RatNum r = parse(s);
        RatNum r2 = new RatNum(r.getNumerator(), r.getDenominator());
    }
    public int getNumerator(){
        return numerator;
    }
    public int getDenominator(){
        return denominator;
    }
    public String toString(){
        return (numerator + "/" + denominator );
    }
    public double toDouble(){
        return (numerator/(1.0* denominator));
    }

    public static RatNum parse(String s) {
        RatNum r;

        s = s.trim();
        String[] a = s.split("/");

        if(a.length == 1){
            r = new RatNum(Integer.parseInt(a[0]));
        }
        else if(a.length == 2){
            r = new RatNum(Integer.parseInt(a[0]), Integer.parseInt(a[1]));
        }
        else{
            throw new NumberFormatException();
        }
        
        return r;
    }
    
    public Object clone(){
        return new RatNum(this.getNumerator(), this.getDenominator());
    }
    public boolean equals(RatNum a) {
        return a.toDouble() == this.toDouble(); 
    }

    public boolean lessThan(RatNum a){
        return (a.toDouble() < this.toDouble());
    }
    public RatNum add(RatNum a){
        int numa = a.getNumerator();
        int dena = a.getDenominator();
        int tempnum = this.numerator * dena; // a1 * b2
        int tempden = this.denominator * dena;  // a2 * b2
        numa = this.denominator * numa; // a2 * b1 
        dena = this.denominator * dena; // a2 * b2

        return new RatNum((numa + tempnum), (dena + tempden));
    }
    public RatNum sub(RatNum a){
        int numa = a.getNumerator();
        int dena = a.getDenominator();
        int tempnum = this.numerator * dena; // a1 * b2
        int tempden = this.denominator * dena;  // a2 * b2
        numa = this.denominator * numa; // a2 * b1 
        dena = this.denominator * dena; // a2 * b2

        return new RatNum((numa - tempnum), (dena - tempden));
    }
    public RatNum mul(RatNum a){
        return new RatNum((a.getNumerator() * this.getNumerator()), (a.getDenominator() *  this.getDenominator()));
    }
    public RatNum div(RatNum a){
        return new RatNum((a.getDenominator() * this.getNumerator()), (a.getNumerator() * this.getDenominator()));
    }

}
