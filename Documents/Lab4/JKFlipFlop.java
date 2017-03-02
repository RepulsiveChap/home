public class JKFlipFlop extends StatefulComponent{
    private boolean state;
    public JKFlipFlop(){
        super(2,2);
    }
    protected void computeOutputs(boolean[] newOutputs){
        outValues[0] = state;
        outValues[1] = !state;
    }
    public void updateState(){
        if(getInput(0) && !getInput(1)){
            state = true;
        }
        if(!getInput(0) && getInput(1)){
            state = false;
        }
        if(getInput(0) && getInput(1)){
            state = !state;
        }
    }
}
