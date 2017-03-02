public abstract class CircuitComponent{ 
    final protected int inputs, outputs;
    private boolean[] inConnected;
    protected boolean[] inValues;
    protected boolean[] outValues;
    private Wire[] wires;

    public CircuitComponent(int inputs, int outputs){
        this.inputs = inputs;
        this.outputs = outputs; 
        init();

    }

    private void init(){
        wires = new Wire[outputs];
        inConnected = new boolean[inputs];
        inValues = new boolean[inputs];
        outValues = new boolean[outputs];
        //System.out.println(inConnected[0]);

    }

    protected boolean getInput(int inputIndex){
        return inValues[inputIndex];
    }

    public void connect(int outputIndex, CircuitComponent receiver, int receiverInputIndex){
        if(wires[outputIndex] != null){
            throw new RuntimeException("Output already exists"); 
        }

        Wire wire = new Wire(receiver, receiverInputIndex);
        wires[outputIndex] = wire;
    }
    public void disconnect(int outputIndex){
        if(wires[outputIndex] == null){
            throw new RuntimeException("Output not connected");
        }
        wires[outputIndex] = null;
    }

    protected void propagateChange(){
        System.out.println("p1");
        boolean[] tempOutValues = new boolean[outValues.length];
        System.out.println("p2");
        computeOutputs(tempOutValues);
        System.out.println("p3");
        for(int i = 0; i < tempOutValues.length; i++){
        System.out.println("p4");
            if(tempOutValues[i] != outValues[i]){
                outValues[i] = tempOutValues[i];
                //System.out.println(wires[i]);
                if(wires[i] != null){ //Checks if component is connected on this output
                    wires[i].getReceiver().propagateChange();
                }
            }
        } 
        System.out.println("p5");


    }
    protected void updateState(){

    }
    protected void propagateStateChange() {

    }

    protected abstract void computeOutputs(boolean[] newOutValues);



    private static class Wire {
        CircuitComponent receiver;
        int receiverInputIndex;

        Wire(CircuitComponent receiver, int receiverInputIndex) {
            this.receiver = receiver;
            this.receiverInputIndex = receiverInputIndex;
        }

        public CircuitComponent getReceiver(){
            return receiver;
        }
    }
    public static void main(String[] args){
        //CircuitComponent test = new CircuitComponent(2,3);
    }
}

