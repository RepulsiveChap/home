public class AndGate extends LogicGate{
    public AndGate(){
        super(2);

    }    
    protected boolean compute(){

        System.out.println("lengh" +inValues.length);
        for(int i = 0; i < inValues.length; i++){
            if(!getInput(i)) {
                System.out.println("and gate returning false");
                return false;
            }
        }
        System.out.println("and gate returning true");
        return true;
    }
}
