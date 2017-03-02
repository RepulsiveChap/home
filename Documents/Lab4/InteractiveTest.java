import java.awt.GridLayout;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.swing.*;

public class InteractiveTest {
	public static void main(String[] args) {
        System.out.println("1");
		SwingUtilities.invokeLater(() -> {
			JFrame frame = new JFrame("InteractiveTest");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
			
			frame.add(new JLabel("Inputs:"));
        System.out.println("2");
			JPanel panel1 = new JPanel();
			panel1.setLayout(new GridLayout(0, 8));
			frame.add(panel1);
			JButton tickBut = new JButton("Clock Tick"); 
			frame.add(tickBut);
			frame.add(new JLabel("Outputs:"));
			JPanel panel2 = new JPanel();
			panel2.setLayout(new GridLayout(0, 8));
			frame.add(panel2);
        System.out.println("3");
			
			JMenuBar menubar = new JMenuBar();
			JMenu menu = new JMenu("File");
			JMenuItem menuitem = new JMenuItem("Open Circuit...");
			menu.add(menuitem);
			menubar.add(menu);
			frame.setJMenuBar(menubar);
        System.out.println("4");
			
			menuitem.addActionListener(e -> {
				JFileChooser filechooser = new JFileChooser();
				int res = filechooser.showOpenDialog(frame);
				if (res == JFileChooser.APPROVE_OPTION) {
					File fil = filechooser.getSelectedFile();
					ArrayList<String> lines = new ArrayList<>();
					try {
						Scanner scanner = new Scanner(fil);
						while (scanner.hasNextLine()) {
							String line = scanner.nextLine();
							lines.add(line);
						}
						scanner.close();
					} catch (IOException ex) {
						JOptionPane.showMessageDialog(frame, "IO Error: " + ex.getMessage());
					}
					Circuit circuit = new Circuit(lines);
                    System.out.println("5");
					HashMap<String, JLabel> outputLabels = new HashMap<>();

                    System.out.println("6");

					Runnable updateOutputs = () -> {
						for (Map.Entry<String, JLabel> entry : outputLabels.entrySet()) {
                    System.out.println("7");
							String name = entry.getKey();
							boolean val = ((Output)(circuit.getComponent(name))).getValue();
							entry.getValue().setText(name + " : " + (val ? 1 : 0));
						}
					};
					
                    System.out.println("8");
					for (String name : circuit.componentNames()) {
                    System.out.println("9");
						CircuitComponent comp = circuit.getComponent(name);
						if (comp instanceof Input) {
							JButton but = new JButton(name + " : 0");
							panel1.add(but);
							but.addActionListener(ev -> {
								String t = but.getText();
								boolean newval = (t.charAt(t.length() - 1) == '0') ? true : false;
								but.setText(name + " : " + (newval ? 1 : 0));
								((Input)comp).setValue(newval);
								updateOutputs.run();
							});
						} else if (comp instanceof Output) {
							boolean val = ((Output)comp).getValue();
							JLabel lab = new JLabel(name + " : " + (val ? 1 : 0));
							panel2.add(lab);
							outputLabels.put(name, lab);
						}
					}
                    System.out.println("10");
					frame.pack();
					
					menuitem.setEnabled(false);
					
					tickBut.addActionListener(ev -> {
                    System.out.println("12.0");
						circuit.tick();
                    System.out.println("12");
						updateOutputs.run();
					});
                    System.out.println("11");
				}
			});
			
			frame.pack();
			frame.setVisible(true);
		});
	}
}
