public class Output extends CircuitComponent{
    boolean value;
    public Output(){
       super(1,0); 
    }

    @Override
    protected void computeOutputs(boolean[] newOutValues){
        value = getInput(0);
    }

    public boolean getValue(){
        System.out.println("val: " + value);
        return value;
    }
}
