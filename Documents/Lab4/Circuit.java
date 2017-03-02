import java.util.*;
public class Circuit{

    private Map <String, CircuitComponent> components = new HashMap<>();
    

    public Circuit(){ //Creates an exmpty circuit

    }
    public Circuit(List<String> lines){

        for(String line : lines){
            String[] values = line.split(" ");
            String name = values[0];
            String type = values[1];

            if(type.equals("AND")){
               components.put(name, new AndGate());
            }
            if(type.equals("OR")){
               components.put(name, new OrGate());
            }
            if(type.equals("XOR")){
               components.put(name, new XorGate());
            }
            if(type.equals("NOT")){
               components.put(name, new NotGate());
            }
            if(type.equals("ADDER")){
               components.put(name, new Adder());
            }
            if(type.equals("INPUT")){
               components.put(name, new Input(false));
            }
            if(type.equals("OUTPUT")){
               components.put(name, new Output());
            }
            if(type.equals("ZERO")){
               components.put(name, new Constant(false));
            }
            if(type.equals("ONE")){
               components.put(name, new Constant(true));
            }
            if(type.equals("FORK")){
               components.put(name, new Fork(2));
            }
            if(type.equals("DFLIPFLOP")){
               components.put(name, new DFlipFlop());
            }
            if(type.equals("JKFLIPFLOP")){
               components.put(name, new JKFlipFlop());
            }


            //CircuitComponent(name, type);


        }
        for(String line : lines){
            String[] values = line.split(" ");
            String name = values[0];
            String type = values[1];


            int numWires = (values.length - 2) / 3;
            System.out.println("NUMWIRES: " +numWires);
            for(int i = 2; i < (numWires+2); i=i+3){
                int utIndex = Integer.parseInt(values[i]);
                CircuitComponent reciever = getComponent(values[i+1]);
                int inIndex = Integer.parseInt(values[i+2]);
                getComponent(name).connect(utIndex, reciever, inIndex);
                System.out.println("KÖÖÖR");
            }
        }
    }

    public void addComponent(String name, CircuitComponent component){
        if(components.containsKey(name)){
            throw new RuntimeException();
        }
        else{
            components.put(name, component);
        }
    }
    public CircuitComponent getComponent(String name){
        return components.get(name);
    }
    public Set<String> componentNames(){
        return components.keySet();
    }
    public void tick(){

        //Collection<CircuitComponent> temp = components.values();

        System.out.println("C1");
        for (String key : components.keySet()){
            CircuitComponent comp = getComponent(key);
            comp.updateState();
        }
        System.out.println("C2");

        for (String key : components.keySet()){
            System.out.println("C2.0");
            CircuitComponent comp = getComponent(key);
            System.out.println("C2.1");
            comp.propagateChange();
            System.out.println("C2.2");
        }
        System.out.println("C3");
        // terator it = components.entrySet().iterator();
        //Object[] temp = new Object[component.size()];
        //Object[] temp = components.values().toArray();

        //while(it.hasNext()){
        //Map.Entry pair = (Map.Entery)it.next();
        //CircuitComponent comp = pair.getValue();
        //comp.updateState();
        //comp.propagateChange();
        //}
        //CircuitComponent.propagateChange();

    }

}
