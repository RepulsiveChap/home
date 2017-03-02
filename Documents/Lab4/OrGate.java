public class OrGate extends LogicGate{
    public OrGate(){
        super(2);

    }    
    protected boolean compute(){
        for(int i = 0; i < inValues.length; i++){
            if(getInput(i)) {
                return true;
            }
        }
        return false;
    }
}
