public class DFlipFlop extends StatefulComponent{
    private boolean state;
    public DFlipFlop(){
        super(1,1);
    }
    public void updateState(){
        state = getInput(0);
    }
    protected void computeOutputs(boolean[] newOutputs){
        outValues[0] = state;                
    }
    
}
