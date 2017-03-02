public class XorGate extends LogicGate{
    public XorGate(){
        super(2);

    }    
    protected boolean compute(){
        boolean result = false;
        for(int i = 0; i < inValues.length; i++){
            if(getInput(i)) {
                result = !result;
            }
        }
        return result;
    }
}
