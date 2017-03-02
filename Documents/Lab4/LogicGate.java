public abstract class LogicGate extends CircuitComponent{
    public LogicGate(int inputs){
        super(inputs, 1);
    }
    protected abstract boolean compute();

    @Override
    protected void computeOutputs(boolean[] newOutValues){
        newOutValues[0] = compute();
    }
}
