package windowsTest;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import stringFunctions.StringFunctions;

import calculatorBase.Calculator;


public class TestWindow implements ActionListener
{

	/**
	 * @param args
	 */
	//number pad buttons 
	JButton oneButton, twoButton, threeButton, fourButton, fiveButton, sixButton, sevenButton, eightButton, nineButton, zeroButton, decimalButton;
	//fraction buttons
	JButton fractionButton, slashButton;
	//display label
	JLabel displayLabel, operationLabel;
	//math pad buttons
	JButton plusButton, minusButton, multiplyButton, divideButton, equalsButton;
	//unit pad buttons
	JButton tsptbspButton, tbsptspButton, tbspcupButton, cuptbspButton, nextButton;
	//convert pad buttons
	JButton convertButton, toButton;
	//clear pad button
	JButton clearButton;
	//conversion options pad
	JButton volvolButton, volweightButton, weightvolButton, metricstdButton, stdmetricButton;
	//multi use buttons
	JButton multiButtonOne, multiButtonTwo, multiButtonThree, multiButtonFour, multiButtonFive, multiButtonSix;
	//standard metric button
	JButton stdmetricSwitch;
	
	//OperationString
	String operationString = "";
	String displayString = "";
	// intialize calculator values
	Calculator calc = new Calculator();
	
	//Flags
	boolean metricFlag = false;
	boolean equalsFlag = false;
	//multiButton label set currently displayed
	int multiButtonSet;
	
	public JPanel createDisplay(String displayText, int X, int Y){
		
		JPanel displayPanel = new JPanel();
		
		displayPanel.setLayout(null);
		displayPanel.setLocation(X,Y);
		displayPanel.setSize(370,90);
		displayPanel.setBackground(Color.white);
		
		operationLabel = new JLabel(displayText);
		operationLabel.setLocation(10, 10);
		operationLabel.setSize(350, 30);
		operationLabel.setHorizontalAlignment(4);
		operationLabel.setForeground(Color.red);
		
		displayLabel = new JLabel(displayText);
		displayLabel.setLocation(10, 50);
		displayLabel.setSize(350, 30);
		displayLabel.setHorizontalAlignment(4);
		displayLabel.setForeground(Color.blue);
		
		displayPanel.add(operationLabel);
		displayPanel.add(displayLabel);
		
		return displayPanel;
		
	}
	
	public JPanel createNumberPad(int X, int Y){
		
		JPanel numberPad = new JPanel();
		
		numberPad.setLayout(null);
		numberPad.setLocation(X,Y);
		numberPad.setSize(175,230);
		
		
		sevenButton = new JButton("7");
		sevenButton.setLocation(10,10);
		sevenButton.setSize(45,45);
		sevenButton.addActionListener(this);
		numberPad.add(sevenButton);
				
		eightButton = new JButton("8");
		eightButton.setLocation(65,10);
		eightButton.setSize(45,45);
		eightButton.addActionListener(this);
		numberPad.add(eightButton);
		
		nineButton = new JButton("9");
		nineButton.setLocation(120,10);
		nineButton.setSize(45,45);
		nineButton.addActionListener(this);
		numberPad.add(nineButton);
		
		fourButton = new JButton("4");
		fourButton.setLocation(10,65);
		fourButton.setSize(45,45);
		fourButton.addActionListener(this);
		numberPad.add(fourButton);
				
		fiveButton = new JButton("5");
		fiveButton.setLocation(65,65);
		fiveButton.setSize(45,45);
		fiveButton.addActionListener(this);
		numberPad.add(fiveButton);
		
		sixButton = new JButton("6");
		sixButton.setLocation(120,65);
		sixButton.setSize(45,45);
		sixButton.addActionListener(this);
		numberPad.add(sixButton);
		
		oneButton = new JButton("1");
		oneButton.setLocation(10,120);
		oneButton.setSize(45,45);
		oneButton.addActionListener(this);
		numberPad.add(oneButton);
				
		twoButton = new JButton("2");
		twoButton.setLocation(65,120);
		twoButton.setSize(45,45);
		twoButton.addActionListener(this);
		numberPad.add(twoButton);
		
		threeButton = new JButton("3");
		threeButton.setLocation(120,120);
		threeButton.setSize(45,45);
		threeButton.addActionListener(this);
		numberPad.add(threeButton);
		
		zeroButton = new JButton("0");
		zeroButton.setLocation(10,175);
		zeroButton.setSize(100,45);
		zeroButton.addActionListener(this);
		numberPad.add(zeroButton);
		
		decimalButton = new JButton(".");
		decimalButton.setLocation(120,175);
		decimalButton.setSize(45,45);
		decimalButton.addActionListener(this);
		numberPad.add(decimalButton);
		
		return numberPad;
	}
	
	public JPanel createFractionPad(int X, int Y){
		
		JPanel fractionPad = new JPanel();
		
		fractionPad.setLayout(null);
		fractionPad.setLocation(X,Y);
		fractionPad.setSize(175,65);
		
		fractionButton = new JButton("Fraction");
		fractionButton.setLocation(10,10);
		fractionButton.setSize(100,45);
		fractionButton.addActionListener(this);
		fractionPad.add(fractionButton);
		
		slashButton = new JButton("/");
		slashButton.setLocation(120,10);
		slashButton.setSize(45,45);
		slashButton.addActionListener(this);
		fractionPad.add(slashButton);
		
		return fractionPad;
	}
	
	public JPanel createMathPad(int X, int Y){
		
		JPanel mathPad = new JPanel();
		
		mathPad.setLayout(null);
		mathPad.setLocation(X,Y);
		mathPad.setSize(65,285);
		
		char ch = '\u00F7';
		
		divideButton = new JButton(Character.toString(ch));
		divideButton.setLocation(10,10);
		divideButton.setSize(45,45);
		divideButton.addActionListener(this);
		mathPad.add(divideButton);
		
		multiplyButton = new JButton("*");
		multiplyButton.setLocation(10,65);
		multiplyButton.setSize(45,45);
		multiplyButton.addActionListener(this);
		mathPad.add(multiplyButton);
		
		minusButton = new JButton("-");
		minusButton.setLocation(10,120);
		minusButton.setSize(45,45);
		minusButton.addActionListener(this);
		mathPad.add(minusButton);
		
		plusButton = new JButton("+");
		plusButton.setLocation(10,175);
		plusButton.setSize(45,45);
		plusButton.addActionListener(this);
		mathPad.add(plusButton);
		
		equalsButton = new JButton("=");
		equalsButton.setLocation(10,230);
		equalsButton.setSize(45,45);
		equalsButton.addActionListener(this);
		mathPad.add(equalsButton);
		
		return mathPad;
	}
		
	public JPanel createMultiButtonPad(int X, int Y){
		
		JPanel multiBtnPad = new JPanel();
		
		multiBtnPad.setLayout(null);
		multiBtnPad.setLocation(X,Y);
		multiBtnPad.setSize(150,340);
		
		multiButtonSet = 1;
		
		multiButtonOne = new JButton("Vol - Vol");
		multiButtonOne.setLocation(10,10);
		multiButtonOne.setSize(130,45);
		multiButtonOne.addActionListener(this);
		multiBtnPad.add(multiButtonOne);
		
		multiButtonTwo = new JButton("Weight - Weight");
		multiButtonTwo.setLocation(10,65);
		multiButtonTwo.setSize(130,45);
		multiButtonTwo.addActionListener(this);
		multiBtnPad.add(multiButtonTwo);
		
		multiButtonThree = new JButton("Vol - Weight");
		multiButtonThree.setLocation(10,120);
		multiButtonThree.setSize(130,45);
		multiButtonThree.addActionListener(this);
		multiBtnPad.add(multiButtonThree);
		
		multiButtonFour = new JButton("Weight - Vol");
		multiButtonFour.setLocation(10,175);
		multiButtonFour.setSize(130,45);
		multiButtonFour.addActionListener(this);
		multiBtnPad.add(multiButtonFour);
		
		multiButtonFive = new JButton("Std - Metric");
		multiButtonFive.setLocation(10,230);
		multiButtonFive.setSize(130,45);
		multiButtonFive.addActionListener(this);
		multiBtnPad.add(multiButtonFive);
		
		multiButtonSix = new JButton("Metric - Std");
		multiButtonSix.setLocation(10,285);
		multiButtonSix.setSize(130,45);
		multiButtonSix.addActionListener(this);
		multiBtnPad.add(multiButtonSix);
		
		return multiBtnPad;
	}
	
	public JPanel createstdmetricPad(int X, int Y){
		
		JPanel stdmetricPad = new JPanel();
		
		stdmetricPad.setLayout(null);
		stdmetricPad.setLocation(X,Y);
		stdmetricPad.setSize(120,65);
		
		stdmetricSwitch = new JButton("Metric");
		stdmetricSwitch.setLocation(10,10);
		stdmetricSwitch.setSize(100,45);
		stdmetricSwitch.addActionListener(this);
		stdmetricPad.add(stdmetricSwitch);
		
		return stdmetricPad;
		
	}
	
	public JPanel createClearPad(int X, int Y){
		
		JPanel clearPad = new JPanel();
		
		clearPad.setLayout(null);
		clearPad.setLocation(X,Y);
		clearPad.setSize(120,65);
		
		clearButton = new JButton("Clear");
		clearButton.setLocation(10,10);
		clearButton.setSize(100,45);
		clearButton.addActionListener(this);
		clearPad.add(clearButton);
		
		return clearPad;
		
	}
	
	public void changeMultiButtonLabels(int set){
		if (set == 1){
			multiButtonOne.setText("Vol - Vol");
			multiButtonTwo.setText("Weight - Weight");
			multiButtonThree.setText("Vol - Weight");
			multiButtonThree.setVisible(true);
			multiButtonFour.setText("Weight - Vol");
			multiButtonFour.setVisible(true);
			multiButtonFive.setText("Std - Metric");
			multiButtonFive.setVisible(true);
			multiButtonSix.setText("Metric - Std");
			multiButtonSix.setVisible(true);
			multiButtonSet = 1;
		}
		else if (set == 2){
			if (metricFlag == false){
				multiButtonOne.setText("tsp - Tbsp");
				multiButtonTwo.setText("Tbsp - tsp");
				multiButtonThree.setText("Tbsp - Cup");
				multiButtonThree.setVisible(true);
				multiButtonFour.setText("Cup - Tbsp");
				multiButtonFour.setVisible(true);
				multiButtonFive.setText("Liquids");
				multiButtonFive.setVisible(true);
				multiButtonSix.setText("");
				multiButtonSix.setVisible(false);
				multiButtonSet = 2;
			}
			else if (metricFlag == true){
				multiButtonOne.setText("mL - L");
				multiButtonTwo.setText("L - mL");
				multiButtonThree.setText("");
				multiButtonThree.setVisible(false);
				multiButtonFour.setText("");
				multiButtonFour.setVisible(false);
				multiButtonFive.setText("");
				multiButtonFive.setVisible(false);
				multiButtonSix.setText("");
				multiButtonSix.setVisible(false);
				multiButtonSet = 2;
			}
		}
		else if (set == 3){
			if (metricFlag == false){
				multiButtonOne.setText("fl oz - Cup");
				multiButtonTwo.setText("Cup - fl oz");
				multiButtonThree.setText("Cup - Pt");
				multiButtonThree.setVisible(true);
				multiButtonFour.setText("Pt - Cup");
				multiButtonFour.setVisible(true);
				multiButtonFive.setText("Pt - Qt");
				multiButtonFive.setVisible(true);
				multiButtonSix.setText("Qt - Pt");
				multiButtonSix.setVisible(true);
				multiButtonSet = 3;
			}
			else if (metricFlag == true){
				multiButtonOne.setText("mL - L");
				multiButtonTwo.setText("L - mL");
				multiButtonThree.setText("");
				multiButtonThree.setVisible(false);
				multiButtonFour.setText("");
				multiButtonFour.setVisible(false);
				multiButtonFive.setText("");
				multiButtonFive.setVisible(false);
				multiButtonSix.setText("");
				multiButtonSix.setVisible(false);
				multiButtonSet = 3;
			}
			
		}
		else if (set == 4){
			multiButtonOne.setText("Flour");
			multiButtonTwo.setText("Sugar");
			multiButtonThree.setText("Baking Soda");
			multiButtonFour.setText("Baking Powder");
			multiButtonFive.setText("Salt");
			multiButtonSix.setText("");
			multiButtonSix.setVisible(false);
			multiButtonSet = 4;
		}
		else if (set == 5){
			if (metricFlag == false){
				multiButtonOne.setText("cup - oz");
				multiButtonTwo.setText("Tbsp - oz");
				multiButtonThree.setText("tsp - oz");
				multiButtonThree.setVisible(true);
				multiButtonFour.setText("");
				multiButtonFour.setVisible(false);
				multiButtonFive.setText("");
				multiButtonFive.setVisible(false);
				multiButtonSix.setText("");
				multiButtonSix.setVisible(false);
				multiButtonSet = 5;
			}
			else if (metricFlag == true){
				multiButtonOne.setText("ml - g");
				multiButtonTwo.setText("l - g");
				multiButtonThree.setText("l - kg");
				multiButtonThree.setVisible(true);
				multiButtonFour.setText("");
				multiButtonFour.setVisible(false);
				multiButtonFive.setText("");
				multiButtonFive.setVisible(false);
				multiButtonSix.setText("");
				multiButtonSix.setVisible(false);
				multiButtonSet = 5;
			}
		}
		else if (set == 6){
			if (metricFlag == false){
				multiButtonOne.setText("oz - cup");
				multiButtonTwo.setText("oz - Tbsp");
				multiButtonThree.setText("oz - tsp");
				multiButtonThree.setVisible(true);
				multiButtonFour.setText("");
				multiButtonFour.setVisible(false);
				multiButtonFive.setText("");
				multiButtonFive.setVisible(false);
				multiButtonSix.setText("");
				multiButtonSix.setVisible(false);
				multiButtonSet = 6;
			}
			else if (metricFlag == true){
				multiButtonOne.setText("g - ml");
				multiButtonTwo.setText("g - l");
				multiButtonThree.setText("kg - l");
				multiButtonThree.setVisible(true);
				multiButtonFour.setText("");
				multiButtonFour.setVisible(false);
				multiButtonFive.setText("");
				multiButtonFive.setVisible(false);
				multiButtonSix.setText("");
				multiButtonSix.setVisible(false);
				multiButtonSet = 6;
			}
		}
		else if (set == 7){
			if (metricFlag == false){
				multiButtonOne.setText("oz - lbs");
				multiButtonTwo.setText("lbs - oz");
				multiButtonThree.setText("");
				multiButtonThree.setVisible(false);
				multiButtonFour.setText("");
				multiButtonFour.setVisible(false);
				multiButtonFive.setText("");
				multiButtonFive.setVisible(false);
				multiButtonSix.setText("");
				multiButtonSix.setVisible(false);
				multiButtonSet = 7;
			}
			else if (metricFlag == true){
				multiButtonOne.setText("g - kg");
				multiButtonTwo.setText("kg - g");
				multiButtonThree.setText("mg - g");
				multiButtonThree.setVisible(true);
				multiButtonFour.setText("g - mg");
				multiButtonFour.setVisible(true);
				multiButtonFive.setText("");
				multiButtonFive.setVisible(false);
				multiButtonSix.setText("");
				multiButtonSix.setVisible(false);
				multiButtonSet = 7;
			}
		}
		else if (set == 8){
			multiButtonOne.setText("Flour");
			multiButtonTwo.setText("Sugar");
			multiButtonThree.setText("Baking Soda");
			multiButtonFour.setText("Baking Powder");
			multiButtonFive.setText("Salt");
			multiButtonSix.setText("");
			multiButtonSix.setVisible(false);
			multiButtonSet = 8;
		}
		else if (set == 9){
			multiButtonOne.setText("F - C");
			multiButtonTwo.setText("tsp - mL");
			multiButtonThree.setText("Tbsp -  mL");
			multiButtonFour.setText("Cup - mL");
			multiButtonFive.setText("oz - g");
			multiButtonSix.setText("");
			multiButtonSix.setVisible(false);
			multiButtonSet = 9;
		}
		else if (set == 10){
			multiButtonOne.setText("C - F");
			multiButtonTwo.setText("mL - tsp");
			multiButtonThree.setText("mL - Tbsp");
			multiButtonFour.setText("mL - Cup");
			multiButtonFive.setText("g - oz");
			multiButtonSix.setText("");
			multiButtonSix.setVisible(false);
			multiButtonSet = 10;
		}
	}
	
	public JPanel createContentPane(){
		
		JPanel totalGUI = new JPanel();
		totalGUI.setLayout(null);
		totalGUI.setBackground(Color.DARK_GRAY);
		
		//Display Panel
		JPanel displayPanel = new JPanel();
		
		displayPanel.setLayout(null);
		displayPanel.setLocation(0,0);
		displayPanel.setSize(175,65);
		displayPanel = createDisplay(operationString,10,10);
		
		totalGUI.add(displayPanel);
		
		//Number Pad
		JPanel numberPanel = new JPanel();
		
		numberPanel.setLayout(null);
		numberPanel.setLocation(0,0);
		numberPanel.setSize(175,230);
		numberPanel = createNumberPad(10, 120);
		
		totalGUI.add(numberPanel);
		
		//Fraction Pad
		JPanel fractionPanel = new JPanel();
		
		fractionPanel.setLayout(null);
		fractionPanel.setLocation(0,65);
		fractionPanel.setSize(175,65);
		fractionPanel = createFractionPad(10, 340);
		
		totalGUI.add(fractionPanel);
		
		//Math Pad
		JPanel mathPanel = new JPanel();
		
		mathPanel.setLayout(null);
		mathPanel.setLocation(0,65);
		mathPanel.setSize(175,275);
		mathPanel = createMathPad(175, 120);
		
		totalGUI.add(mathPanel);
		
		//standard metric pad
		JPanel stdmetricPanel = new JPanel();
		
		stdmetricPanel.setLayout(null);
		stdmetricPanel.setLocation(0,65);
		stdmetricPanel.setSize(175,275);
		stdmetricPanel = createstdmetricPad(10, 395);
		
		totalGUI.add(stdmetricPanel);
		
		//Menu Options Pad
		JPanel multiButtonPanel = new JPanel();
		
		multiButtonPanel.setLayout(null);
		multiButtonPanel.setLocation(0,65);
		multiButtonPanel.setSize(175,275);
		multiButtonPanel = createMultiButtonPad(230, 120);
		
		totalGUI.add(multiButtonPanel);
		
		//Clear Pad
		JPanel clearPanel = new JPanel();
		
		clearPanel.setLayout(null);
		clearPanel.setLocation(0,65);
		clearPanel.setSize(175,275);
		clearPanel = createClearPad(120, 395);
		
		totalGUI.add(clearPanel);
		
		//return completed window
		return totalGUI;
	}
	
	private static void createAndShowGUI() {

        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("Chef Calculator");

        //Create and set up the content pane.
        TestWindow demo = new TestWindow();
        frame.setContentPane(demo.createContentPane());

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 500);
        frame.setVisible(true);
    }

	public void actionPerformed(ActionEvent e){
		
		if (e.getSource() == oneButton){
			if (equalsFlag){
				displayString = "";
				equalsFlag = false;
			}
			displayString = displayString+"1";
			displayLabel.setText(displayString);
		}
		else if (e.getSource() == twoButton){
			if (equalsFlag){
				displayString = "";
				equalsFlag = false;
			}
			displayString = displayString+"2";
			displayLabel.setText(displayString);
		}
		else if (e.getSource() == threeButton){
			if (equalsFlag){
				displayString = "";
				equalsFlag = false;
			}
			displayString = displayString+"3";
			displayLabel.setText(displayString);
		}
		else if (e.getSource() == fourButton){
			if (equalsFlag){
				displayString = "";
				equalsFlag = false;
			}
			displayString = displayString+"4";
			displayLabel.setText(displayString);
		}
		else if (e.getSource() == fiveButton){
			if (equalsFlag){
				displayString = "";
				equalsFlag = false;
			}
			displayString = displayString+"5";
			displayLabel.setText(displayString);
		}
		else if (e.getSource() == sixButton){
			if (equalsFlag){
				displayString = "";
				equalsFlag = false;
			}
			displayString = displayString+"6";
			displayLabel.setText(displayString);
		}
		else if (e.getSource() == sevenButton){
			if (equalsFlag){
				displayString = "";
				equalsFlag = false;
			}
			displayString = displayString+"7";
			displayLabel.setText(displayString);
		}
		else if (e.getSource() == eightButton){
			if (equalsFlag){
				displayString = "";
				equalsFlag = false;
			}
			displayString = displayString+"8";
			displayLabel.setText(displayString);
		}
		else if (e.getSource() == nineButton){
			if (equalsFlag){
				displayString = "";
				equalsFlag = false;
			}
			displayString = displayString+"9";
			displayLabel.setText(displayString);
		}
		else if (e.getSource() == zeroButton){
			if (equalsFlag){
				displayString = "";
				equalsFlag = false;
			}
			displayString = displayString+"0";
			displayLabel.setText(displayString);
		}
		else if (e.getSource() == decimalButton){
			if (equalsFlag){
				displayString = "";
				equalsFlag = false;
			}
			if (displayString == ""){
				displayString = "0";
			}
			if (!StringFunctions.hasDecimal(displayString)){
				displayString = displayString+".";
			}	
			displayLabel.setText(displayString);
		}
		else if (e.getSource() == divideButton){
			calc.addOperation(displayString);
			calc.addOperation("div");
			operationString = calc.getOperationString();
			displayString = "";
			operationLabel.setText(operationString);
			displayLabel.setText(displayString);
		}
		else if (e.getSource() == multiplyButton){
			calc.addOperation(displayString);
			calc.addOperation("mul");
			operationString = calc.getOperationString();
			displayString = "";
			operationLabel.setText(operationString);
			displayLabel.setText(displayString);
		}
		else if (e.getSource() == minusButton){
			calc.addOperation(displayString);
			calc.addOperation("sub");
			operationString = calc.getOperationString();
			displayString = "";
			operationLabel.setText(operationString);
			displayLabel.setText(displayString);
		}
		else if (e.getSource() == plusButton){
			calc.addOperation(displayString);
			calc.addOperation("add");
			operationString = calc.getOperationString();
			displayString = "";
			operationLabel.setText(operationString);
			displayLabel.setText(displayString);
		}
		else if (e.getSource() == clearButton){
			operationString = "";
			displayLabel.setText(operationString);
			
			changeMultiButtonLabels(1);
		}
		else if (e.getSource() == fractionButton){
			operationString = operationString+" ";
			displayLabel.setText(operationString);
		}
		else if (e.getSource() == slashButton){
			operationString = operationString+"/";
			displayLabel.setText(operationString);
		}		
		else if (e.getSource() == multiButtonOne){
			if (multiButtonSet == 1){
				changeMultiButtonLabels(2);
			}
			else if (multiButtonSet == 2){
				changeMultiButtonLabels(1);
			}
			else if (multiButtonSet == 4){
				changeMultiButtonLabels(5);
			}
			else if (multiButtonSet == 5){
				changeMultiButtonLabels(1);
			}
			else if (multiButtonSet == 6){
				changeMultiButtonLabels(1);
			}
			else if (multiButtonSet == 7){
				changeMultiButtonLabels(1);
			}
			else if (multiButtonSet == 8){
				changeMultiButtonLabels(6);
			}
		}
		else if (e.getSource() == multiButtonTwo){
			if (multiButtonSet == 1){
				changeMultiButtonLabels(7);
			}
			else if (multiButtonSet == 7){
				changeMultiButtonLabels(1);
			}
		}
		else if (e.getSource() == multiButtonThree){
			if (multiButtonSet == 1){
				changeMultiButtonLabels(4);
			}
		}
		else if (e.getSource() == multiButtonFour){
			if (multiButtonSet == 1){
				changeMultiButtonLabels(8);
			}
		}
		else if (e.getSource() == multiButtonFive){
			if (multiButtonSet == 1){
				changeMultiButtonLabels(9);
			}
			else if (multiButtonSet == 2){
				changeMultiButtonLabels(3);
			}
		}
		else if (e.getSource() == multiButtonSix){
			if (multiButtonSet == 1){
				changeMultiButtonLabels(10);
			}
		}
		else if (e.getSource() == stdmetricSwitch){
			if (metricFlag == false){
				stdmetricSwitch.setText("Standard");
				metricFlag = true;
				changeMultiButtonLabels(multiButtonSet);
			}
			else if (metricFlag == true){
				stdmetricSwitch.setText("Metric");
				metricFlag = false;
				changeMultiButtonLabels(multiButtonSet);
			}
		}
		else if (e.getSource() == equalsButton){
			calc.addOperation(displayString);
			calc.processStack();
			displayString = calc.getResultString();
			displayLabel.setText(displayString);
			operationString = "";
			operationLabel.setText(operationString);
			changeMultiButtonLabels(1);
			equalsFlag = true;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });

	}

}
