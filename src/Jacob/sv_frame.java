package Jacob;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

@SuppressWarnings("serial")
public class sv_frame extends JFrame {

	private JPanel wrapper;
	private JPanel arrayWrapper;
	private JPanel buttonWrapper;
	private JPanel[] squarePanels;
	private JButton start;
	private JComboBox<String> selection;
	private JSlider speed;
	private JLabel speedVal;
	private GridBagConstraints c;
	private String[] Sorts = {"Bubble", "Selection", "Insertion", "Gnome", "Merge", "Radix", "Shell", "Bubble(fast)", "Selection(fast)", "Insertion(fast)", "Gnome(fast)"};
	
	public sv_frame(){
		super("Sorting Visualizer");
		
		start = new JButton("Start");
		buttonWrapper = new JPanel();
		arrayWrapper = new JPanel();
		wrapper = new JPanel();
		selection = new JComboBox<String>();
		speed = new JSlider(1, 1000, 20);
		speedVal = new JLabel("Speed: 20 ms");
		c = new GridBagConstraints();
		
		for(String s : Sorts) selection.addItem(s);
		
		arrayWrapper.setLayout(new GridBagLayout());
		wrapper.setLayout(new BorderLayout());

		c.insets = new Insets(0,1,0,1);
		c.anchor = GridBagConstraints.SOUTH;
		
		start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sv_main.startSort((String) selection.getSelectedItem());
		}});
		
		speed.setMinorTickSpacing(10);
		speed.setMajorTickSpacing(100);
		speed.setPaintTicks(true);
		speed.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent arg0) {
				speedVal.setText(("Speed: " + Integer.toString(speed.getValue()) + "ms"));
				validate();
				sv_main.sleep = speed.getValue();
			}
			
		});
		
		buttonWrapper.add(speedVal);
		buttonWrapper.add(speed);
		buttonWrapper.add(start);
		buttonWrapper.add(selection);
		
		wrapper.add(buttonWrapper, BorderLayout.SOUTH);
		wrapper.add(arrayWrapper);
		
		add(wrapper);

		setExtendedState(JFrame.MAXIMIZED_BOTH );
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}
	
	public void preDrawArray(Integer[] squares){
		squarePanels = new JPanel[sv_main.count];
		arrayWrapper.removeAll();
		for(int i = 0; i<sv_main.count; i++){
			squarePanels[i] = new JPanel();
			squarePanels[i].setPreferredSize(new Dimension(sv_main.blockSize, squares[i]*600/(sv_main.count*sv_main.scale)));
			squarePanels[i].setBackground(Color.blue);
			arrayWrapper.add(squarePanels[i], c);
		}
		repaint();
		validate();
	}
	
	public void reDrawArray(Integer[] x){
		reDrawArray(x, -1);
	}
	
	public void reDrawArray(Integer[] x, int y){
		reDrawArray(x, y, -1);
	}
	
	public void reDrawArray(Integer[] x, int y, int z){
		reDrawArray(x, y, z, -1);
	}
	
	public void reDrawArray(Integer[] squares, int working, int comparing, int reading){
		int modifier = 600/(sv_main.count*sv_main.scale);
		arrayWrapper.removeAll();
		for(int i = 0; i<sv_main.count; i++){
			squarePanels[i].setPreferredSize(new Dimension(sv_main.blockSize, squares[i]*modifier));
			if (i == working){
				squarePanels[i].setBackground(Color.green);				
			}else if(i == comparing){
				squarePanels[i].setBackground(Color.red);			
			}else if(i == reading){
				squarePanels[i].setBackground(Color.yellow);			
			}else{
				squarePanels[i].setBackground(Color.blue);
			}
			arrayWrapper.add(squarePanels[i], c);
		}
		repaint();
		validate();
	}
	
}
