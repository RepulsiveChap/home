public class Adder extends CircuitComponent{
    
    public Adder(){
        super(3,2);
    }
    protected void computeOutputs(boolean[] newOutValues){
        int sum = boolToInt(inValues[0]) + boolToInt(inValues[1]) + boolToInt(inValues[2]);
        
        if(sum % 2 == 1){
            outValues[0] = true;
        }
        else{
            outValues[0] = false;
        }
        if(sum >= 2){
            outValues[1] = true;
        }
        else{
            outValues[1] = false;
        }
    }

    protected int boolToInt(boolean a){
        return (a) ? 1 : 0;
    }
}
