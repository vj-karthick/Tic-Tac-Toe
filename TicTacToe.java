    package tictactoe;

	import java.awt.*;
	import java.awt.event.*;
	import java.util.*;
	import javax.swing.*;

	public class TicTacToe implements ActionListener{

	int temp;
	Random random = new Random(); 
	JFrame frame = new JFrame(); 
	JPanel title_panel = new JPanel();
	JPanel next_panel = new JPanel();
	JPanel button_panel = new JPanel(); 
	JLabel textfield = new JLabel(); 
	JLabel s = new JLabel();
	JButton[] buttons = new JButton[9];   
	boolean player1_turn;

	TicTacToe()
	{
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(800,800);
	frame.getContentPane().setBackground(new Color(50,50,50));
	frame.setLayout(new BorderLayout());
	frame.setTitle("TIC TAC TOE - KARTHICK.M");
	frame.setVisible(true);
    frame.setLocationRelativeTo(null);
	textfield.setBackground(new Color(25,25,25)); 
	textfield.setForeground(new Color(25,255,0)); 
	textfield.setFont(new Font("Verdana", Font.BOLD,75));
	textfield.setHorizontalAlignment(JLabel.CENTER);
	textfield.setText("Tic-Tac-Toe"); 
	textfield.setOpaque(true);
	
	
	s.setBackground(Color.DARK_GRAY); 
	s.setForeground(Color.yellow); 
	s.setFont(new Font("Verdana", Font.PLAIN,50));
	s.setHorizontalAlignment(JLabel.CENTER);
	s.setText("Wait for the Prompt.."); 
	s.setOpaque(true);
	
	
	title_panel.setLayout(new BorderLayout()); 
	title_panel.setBounds(0,0,800,100);
	
	next_panel.setLayout(new BorderLayout()); 
	next_panel.setBounds(60,80,700,200);

	button_panel.setLayout(new GridLayout(3,3)); 
	button_panel.setBackground(new Color(150,150,150));
	button_panel.setBounds(80,80,400,300);

	for(int i=0;i<9;i++) 
	{
	buttons[i] = new JButton();
	button_panel.add(buttons[i]);
	buttons[i].setFont(new Font("MVBoli", Font.BOLD,120)); 
	buttons[i].setFocusable(false);
	buttons[i].addActionListener(this);
	}

	title_panel.add(textfield);
	next_panel.add(s);


	frame.add(title_panel, BorderLayout.NORTH); 
	frame.add(next_panel, BorderLayout.SOUTH); 

	
	frame.add(button_panel);

	firstTurn();
	}

	@Override
	
	public void actionPerformed(ActionEvent e) 
	{
	for(int i=0;i<9;i++) 
	{
	    if(e.getSource()==buttons[i]) 
	    {
	       if(player1_turn) 
	       {
	           if(buttons[i].getText()=="")
	           {
	               buttons[i].setForeground(new Color(255,0,0));
                   buttons[i].setText("X");
	               player1_turn=false;
	               textfield.setText("O turn");

	               check();
	           }
	       }
	       else 
	       {
	           if(buttons[i].getText()=="") 
	           {
	               buttons[i].setForeground(new Color(0,0,255));
	               buttons[i].setText("O");
	               player1_turn=true;
                   textfield.setText("X turn");
	               check();
	           }
            }
	}
	}
	}

	public void firstTurn() 
	{
	try 
	{
	Thread.sleep(2000);
	} 
	catch (InterruptedException e) 
	{ // TODO Auto-generated catch block 
		e.printStackTrace();
	}
	
	if(random.nextInt(2)==0) 
	{
	player1_turn=true;
	textfield.setText("X turn");
	}

	else 
	{
	player1_turn=false;
	textfield.setText("O turn");
	}
	}

	public void check() {

	//check X win conditions

	if((buttons[0].getText()=="X") && (buttons[1].getText()=="X") && (buttons[2].getText()=="X")) 
	{
		temp=1;
		xWins(0,1,2);
     }
	
	
	if( (buttons[3].getText()=="X") && (buttons[4].getText()=="X") && (buttons[5].getText()=="X")) 
	{
		temp=1;
	xWins(3,4,5);

	}

	if( (buttons[6].getText()=="X") && (buttons[7].getText()=="X") && (buttons[8].getText()=="X") ) 
	{
		temp=1;
	xWins(6,7,8);
	
	}

	if( (buttons[0].getText()=="X") && (buttons[3].getText()=="X") && (buttons[6].getText()=="X") ) 
	{
		temp=1;
	xWins(0,3,6);
	
	}
	if( (buttons[1].getText()=="X") && (buttons[4].getText()=="X") && (buttons[7].getText()=="X") ) 
	{
		temp=1;
	xWins(1,4,7);
	
	}

	if( (buttons[2].getText()=="X") && (buttons[5].getText()=="X") && (buttons[8].getText()=="X") ) {

	temp=1;
	xWins(2,5,8);
	
	}

	if( (buttons[0].getText()=="X") && (buttons[4].getText()=="X") && (buttons[8].getText()=="X") )
	{
		temp=1;
		xWins(0,4,8);
		
	}
	
	if( (buttons[2].getText()=="X") && (buttons[4].getText()=="X") && (buttons[6].getText()=="X"))
	{
	temp=1;
	xWins(2,4,6);
	
	}

	//check O win conditions

	if( (buttons[0].getText()=="O") && (buttons[1].getText()=="O") && (buttons[2].getText()=="O") ) 
	{
	temp=1;
	oWins(0,1,2);
	
	}

	if( (buttons[3].getText()=="O") && (buttons[4].getText()=="O") && (buttons[5].getText()=="O") )
	{
		temp=1;
	oWins(3,4,5);
	}
	
	if( (buttons[6].getText()=="O") && (buttons[7].getText()=="O") && (buttons[8].getText()=="O") ) 
	{
	temp=1;
	oWins(6,7,8);
	
	}

	if( (buttons[0].getText()=="O") && (buttons[3].getText()=="O") && (buttons[6].getText()=="O") ) {
		temp=1;
	oWins(0,3,6);

	}

	if( (buttons[1].getText()=="O") && (buttons[4].getText()=="O") && (buttons[7].getText()=="O"))
	{ 
		temp=1;
		oWins(1,4,7);
	}
	if( (buttons[2].getText()=="O") && (buttons[5].getText()=="O") && (buttons[8].getText()=="O") ) 
	{
		temp=1;
	oWins(2,5,8);

	}

	if( (buttons[0].getText()=="O") && (buttons[4].getText()=="O") && (buttons[8].getText()=="O") ) {
		temp=1;
	oWins(0,4,8);

	}


	if( (buttons[2].getText()=="O") && (buttons[4].getText()=="O") && (buttons[6].getText()=="O") ) {
		temp=1;
		oWins(2,4,6);
	}
	
	boolean draw = true;
    for (int i = 0; i < 9; i++) { 
        if (buttons[i].getText().equals("")) {
            draw = false;
            break;
        }
    }

	if(draw && temp!=1)
	{
		tie();
	}
	}
	public void xWins(int a, int b, int c) 
	{ 
	buttons[a].setBackground(Color.GREEN); 
	buttons[b].setBackground(Color.GREEN); 
	buttons[c].setBackground(Color.GREEN);

	for(int i=0;i<9;i++)
	{
	buttons[i].setEnabled(false);
	} 
	textfield.setText("X wins");
	}

	public void oWins(int a, int b, int c) 
	{ 
    buttons[a].setBackground(Color.GREEN); 
	buttons[b].setBackground(Color.GREEN); 
	buttons[c].setBackground(Color.GREEN);

	for(int i=0;i<9;i++) 
	{

	buttons[i].setEnabled(false);

	} 
	textfield.setText("O wins");
	}
	public void tie() 
	{ 

	for(int i=0;i<9;i++) 
	{
    buttons[i].setBackground(Color.RED);
	buttons[i].setEnabled(false);

	} 
	textfield.setText("IT'S AN TIE");

	}
	
	
}
