package w9;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

public class ConverterUI extends JFrame {

	
	// attributes for graphical components
	private JButton convertButton = new JButton("Convert");
	private JButton clearButton = new JButton("Clear");
	private UnitConverter unitconverter;
	private JTextField input;
	private JTextField result;
	private JComboBox unit1ComboBox;
	private JComboBox unit2ComboBox;
	private JLabel equal = new JLabel(" = ");
	Container top = new Container();
	Container bottom = new Container();
	Container type = new Container();
	ButtonGroup group = new ButtonGroup();
	private JRadioButton left = new JRadioButton("Left -> Right");
	private JRadioButton right = new JRadioButton("Right -> Left");
	
	ButtonGroup typeGroup = new ButtonGroup();
	private JRadioButton length = new JRadioButton("Length");
	private JRadioButton weight = new JRadioButton("Weight");
	private JRadioButton currency = new JRadioButton("Currency");
	private JRadioButton time = new JRadioButton("Time");
	


	public ConverterUI( UnitConverter uc ){
		
		this.unitconverter = uc;

		this.setTitle("Length Converter");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		initComponent();
	}
	
	
	/*
	 * initialize components in the windows
	 */
	public void initComponent(){
		
		this.setLayout(new GridLayout( 3 , 0 ));

		top.setLayout(new FlowLayout());
		bottom.setLayout(new FlowLayout());
		type.setLayout(new FlowLayout());
		
		this.add(top);
		this.add(bottom);
		this.add(type);

		input = new JTextField(7);
		result = new JTextField(7);
		result.setEditable(false);

		Unit[] lengths = unitconverter.getLengths();
		
		
		unit1ComboBox = new JComboBox<Unit>(lengths);
		unit2ComboBox = new JComboBox<Unit>(lengths);

		top.add(input);
		top.add(unit1ComboBox);
		top.add(equal);
		top.add(result);
		top.add(unit2ComboBox);
		top.add(convertButton);
		top.add(clearButton);

		clearButton.addActionListener( new ClearButtonListener() );

		ConvertButtonListener listener = new ConvertButtonListener();
		convertButton.addActionListener( listener );
		input.addActionListener( listener );
		result.addActionListener( listener );

		input.addKeyListener(new KeyEvent());
		result.addKeyListener(new KeyEvent());	

		group.add(left);
		group.add(right);
		left.setSelected(true);
		left.addActionListener( new RadioButtonListener() );
		right.addActionListener( new RadioButtonListener() );


		bottom.add(left);
		bottom.add(right);
		
		
		typeGroup.add(length);
		typeGroup.add(weight);
		typeGroup.add(time);
		typeGroup.add(currency);
		
		length.setSelected(true);
		
		type.add(length);
		type.add(weight);
		type.add(time);
		type.add(currency);
		
		time.addActionListener(new TypeButton());
		currency.addActionListener(new TypeButton());
		length.addActionListener(new TypeButton());
		weight.addActionListener(new TypeButton());
		
		
		
		this.setSize(750,125);
		this.setResizable(false);
		this.setVisible(true);
	}
	
		
	class TypeButton implements ActionListener{
		
		public void actionPerformed(ActionEvent e){
			
			Unit[] lengths = unitconverter.getLengths();
			Unit[] weights = unitconverter.getWeights();
			Unit[] currencys = unitconverter.getCurrency();
			Unit[] times = unitconverter.getTime();
			
			if (length.isSelected()){
				
				unit1ComboBox.setModel(new javax.swing.DefaultComboBoxModel(lengths));
				unit2ComboBox.setModel(new javax.swing.DefaultComboBoxModel(lengths));
				
				
			} else if (weight.isSelected()){
				
				unit1ComboBox.setModel(new javax.swing.DefaultComboBoxModel(weights));
				unit2ComboBox.setModel(new javax.swing.DefaultComboBoxModel(weights));
				
			} else if (currency.isSelected()){
				
				unit1ComboBox.setModel(new javax.swing.DefaultComboBoxModel(currencys));
				unit2ComboBox.setModel(new javax.swing.DefaultComboBoxModel(currencys));
				
			} else if (time.isSelected()){
				
				unit1ComboBox.setModel(new javax.swing.DefaultComboBoxModel(times));
				unit2ComboBox.setModel(new javax.swing.DefaultComboBoxModel(times));
				
			}
			
		
			
		}
		
	}
	
	/*
	 * Action listener for radio button
	 */
	class RadioButtonListener implements ActionListener{

		public void actionPerformed(ActionEvent e){
			
			if (left.isSelected()){

				input.setEditable(true);
				result.setEditable(false);
			} else {

				input.setEditable(false);
				result.setEditable(true);
			}
		}
	}

	
	class KeyEvent implements KeyListener{

		@Override
		public void keyTyped(java.awt.event.KeyEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void keyPressed(java.awt.event.KeyEvent e) {
			// TODO Auto-generated method stub


		}

		@Override
		public void keyReleased(java.awt.event.KeyEvent e) {
			// TODO Auto-generated method stub

			convert();
		}
	}
	
	/*
	 * Action listener for clear button
	 * Clear all text in JTextField
	 */
	class ClearButtonListener implements ActionListener{

		public void actionPerformed(ActionEvent e){
			
			input.setText("");
			result.setText("");
		}
	}

	/*
	 * Action listener for convert button
	 * convert the value
	 */
	class ConvertButtonListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {

			convert();
		}

	}
	
	/*
	 * convert input amount to selected unit
	 */
	public void convert(){
		
		String s;
		Unit unit1 , unit2 ;

		if (left.isSelected()){
			
			s = input.getText().trim();

			unit1 = (Unit) unit1ComboBox.getSelectedItem();
			unit2 = (Unit) unit2ComboBox.getSelectedItem();
		} else {
			
			s = result.getText().trim();

			unit1 = (Unit) unit2ComboBox.getSelectedItem();
			unit2 = (Unit) unit1ComboBox.getSelectedItem();
		}


		if ( s.length() > 0 ){
			try {
				
				double value = Double.valueOf( s );
				double temp = unitconverter.convert( value , unit1 , unit2 );
				DecimalFormat df = new DecimalFormat("#.################");

				if (left.isSelected()) result.setText( df.format(temp) );
				else if (right.isSelected()) input.setText( df.format(temp) );

			} catch ( NumberFormatException error ){
				System.out.println("not number");
			}
		}
	}

	
}
