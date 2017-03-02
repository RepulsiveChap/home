public class Input extends CircuitComponent{
    private boolean value;
    public Input(boolean value){
       super(0,1); 
    }

    @Override
    protected void computeOutputs(boolean[] newOutValues){
        System.out.println("INPUT VALUE: " + value);
       newOutValues[0] = value; 
    }

    public void setValue(boolean value){
        this.value = value;
    }
}
