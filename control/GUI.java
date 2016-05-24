package control;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.Timer;

import spaceobjects.Bullet;
import spaceobjects.SpaceObject;

public class GUI extends JFrame implements KeyListener, ActionListener
{

	private Controller control;

	public GUI(Controller controller) {
		super("Flappy Invaders");
		
		control = controller;
		setBounds(100, 100, 600, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		displayMenu();
		
		setVisible(true);
		
		Timer timer = new Timer(50, this);
		timer.start();
	}

	public void paint(Graphics g) {
		super.paint(g);
		if(control.isInPlay()) {
			ArrayList<SpaceObject> spaceObjects = control.getObjectList();
			ArrayList<Bullet> bullets = control.getBulletList();
			
			for(SpaceObject o : spaceObjects) {
				g.drawImage(o.getImg(), o.getLocation().getX(), o.getLocation().getY(), this);
			}
			for(Bullet b : bullets) {
				g.drawImage(b.getImg(), b.getLocation().getX(), b.getLocation().getY(), this);
			}
		}
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		if(keyCode == KeyEvent.VK_UP)
			control.onPressUp();
		else if(keyCode == KeyEvent.VK_SPACE)
			control.onPressSpace();
		System.out.println("Boop!");
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(control.isInPlay()) {
			control.step();
		}
	}
	
	public void displayMenu() {
		JFrame frame = this;
		
		JButton btnBmenu = new JButton("Back To Menu");
		btnBmenu.setToolTipText("");
		btnBmenu.setForeground(Color.BLACK);
		btnBmenu.setFont(new Font("Impact", Font.PLAIN, 20));
		btnBmenu.setBackground(Color.RED);
		btnBmenu.setBounds(349, 331, 166, 69);
		btnBmenu.setVisible(false);
		frame.getContentPane().add(btnBmenu);

		JButton btnPlayAgain = new JButton("Play Again?");
		btnPlayAgain.setToolTipText("");
		btnPlayAgain.setForeground(Color.BLACK);
		btnPlayAgain.setFont(new Font("Impact", Font.PLAIN, 20));
		btnPlayAgain.setBackground(Color.GREEN);
		btnPlayAgain.setBounds(75, 331, 166, 69);
		btnPlayAgain.setVisible(false);
		frame.getContentPane().add(btnPlayAgain);

		JButton btnStart = new JButton("Start Game");
		btnStart.setFont(new Font("Impact", Font.PLAIN, 20));
		btnStart.setForeground(Color.BLACK);
		btnStart.setToolTipText("");
		btnStart.setBackground(Color.GREEN);
		btnStart.setBounds(210, 180, 166, 69);
		frame.getContentPane().add(btnStart);

		/*JButton btnRight = new JButton("");
		btnRight.setIcon(new ImageIcon("F:\\arrow_right.png"));
		btnRight.setBounds(514, 369, 68, 43);
		btnRight.setBackground(Color.GREEN);
		frame.getContentPane().add(btnRight);
		btnRight.setVisible(false);

		JButton btnLeft = new JButton("");
		btnLeft.setIcon(new ImageIcon("F:\\arrow_left.png"));
		btnLeft.setBounds(10, 369, 68, 43);
		btnLeft.setBackground(Color.GREEN);
		frame.getContentPane().add(btnLeft);
		btnLeft.setVisible(false);*/

		JButton btnHowPLay = new JButton("How To Play");
		btnHowPLay.setFont(new Font("Impact", Font.PLAIN, 20));
		btnHowPLay.setBackground(new Color(255, 215, 0));
		btnHowPLay.setBounds(210, 260, 164, 68);
		frame.getContentPane().add(btnHowPLay);

		JButton btnBack = new JButton();
		btnBack.setBackground(new Color(255, 0, 0));
		btnBack.setIcon(new ImageIcon("F:\\ic_arrow_back_48px-128 (1).png"));
		btnBack.setBounds(10, 63, 94, 61);
		frame.getContentPane().add(btnBack);
		btnBack.setVisible(false);

		JButton btnExitGame = new JButton("Exit Game");
		btnExitGame.setToolTipText("");
		btnExitGame.setForeground(Color.BLACK);
		btnExitGame.setFont(new Font("Impact", Font.PLAIN, 20));
		btnExitGame.setBackground(Color.RED);
		btnExitGame.setBounds(210, 343, 166, 69);



		JLabel lblGameOver = new JLabel("");
		Image imgG = new ImageIcon(this.getClass().getClassLoader().getResource("game_over.png")).getImage().getScaledInstance(250, -1, 0);
		lblGameOver.setIcon(new ImageIcon(imgG));
		lblGameOver.setBounds(173, 0, 267, 231);
		frame.getContentPane().add(lblGameOver);
		lblGameOver.setVisible(false);

		JLabel lblTitle = new JLabel("");
		Image img = new ImageIcon(this.getClass().getClassLoader().getResource("title.png")).getImage().getScaledInstance(300, -1, 0);
		lblTitle.setIcon(new ImageIcon(img));
		lblTitle.setBounds(150, -6, 313, 190);
		frame.getContentPane().add(lblTitle);

		JTextField txtScore = new JTextField();
		txtScore.setForeground(Color.WHITE);
		txtScore.setFont(new Font("Impact", Font.PLAIN, 25));
		txtScore.setBackground(Color.BLACK);
		txtScore.setText("Score: "); //when method done use getScore method
		txtScore.setBounds(95, 207, 187, 31);
		frame.getContentPane().add(txtScore);
		txtScore.setColumns(10);
		txtScore.setVisible(false);

		JTextField txtEnemyKills= new JTextField();
		txtEnemyKills.setText("Enemies Killed: "); //use stats method
		txtEnemyKills.setForeground(Color.WHITE);
		txtEnemyKills.setFont(new Font("Impact", Font.PLAIN, 25));
		txtEnemyKills.setColumns(10);
		txtEnemyKills.setBackground(Color.BLACK);
		txtEnemyKills.setBounds(95, 237, 187, 31);
		frame.getContentPane().add(txtEnemyKills);
		txtEnemyKills.setVisible(false);

		JTextField txtAcc= new JTextField();
		txtAcc.setText("Accuracy: " + "%"); //use stats method
		txtAcc.setForeground(Color.WHITE);
		txtAcc.setFont(new Font("Impact", Font.PLAIN, 25));
		txtAcc.setColumns(10);
		txtAcc.setBackground(Color.BLACK);
		txtAcc.setBounds(95, 267, 187, 31);
		frame.getContentPane().add(txtAcc);
		txtAcc.setVisible(false);


		JTextField txtTime= new JTextField();
		txtTime.setText("Time Survived: "); //use stats method
		txtTime.setForeground(Color.WHITE);
		txtTime.setFont(new Font("Impact", Font.PLAIN, 25));
		txtTime.setColumns(10);
		txtTime.setBackground(Color.BLACK);
		txtTime.setBounds(95, 297, 187, 31);
		frame.getContentPane().add(txtTime);
		txtTime.setVisible(false);


		JTextPane txtHowTo1 = new JTextPane();
		txtHowTo1.setText("Press UP to jump.\nPress SPACE to fire.\nTry not to die.");
		txtHowTo1.setFont(new Font("Arial", Font.PLAIN, 25));
		txtHowTo1.setBounds(95, 173, 406, 239);
		txtHowTo1.setBackground(new Color(255, 215, 0));
		frame.getContentPane().add(txtHowTo1);
		txtHowTo1.setVisible(false);

		/*JTextPane txtHowTo2 = new JTextPane();
		txtHowTo2.setText("hi this is page 2 of the how too ");
		txtHowTo2.setBounds(95, 173, 406, 239);
		txtHowTo2.setBackground(new Color(255, 215, 0));
		frame.getContentPane().add(txtHowTo2);
		txtHowTo2.setVisible(false);

		btnRight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtHowTo1.setVisible(false);
				txtHowTo2.setVisible(true);
				btnLeft.setVisible(true);
				btnRight.setVisible(false);
			}
		});

		btnLeft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtHowTo1.setVisible(true);
				txtHowTo2.setVisible(false);
				btnLeft.setVisible(false);
				btnRight.setVisible(true);
			}
		});*/

		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtHowTo1.setVisible(false);
				//txtHowTo2.setVisible(false);
				btnBack.setVisible(false);
				//btnLeft.setVisible(false);
				//btnRight.setVisible(false);
				btnHowPLay.setVisible(true);
				btnStart.setVisible(true);
				btnExitGame.setVisible(true);
			}
		});

		btnHowPLay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtHowTo1.setVisible(true);
				btnBack.setVisible(true);
				//btnRight.setVisible(true);
				btnHowPLay.setVisible(false);
				btnStart.setVisible(false);
				btnExitGame.setVisible(false);
			}
		});

		frame.getContentPane().add(btnExitGame);
		btnExitGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});

		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtHowTo1.setVisible(false);
				//txtHowTo2.setVisible(false);
				btnBack.setVisible(false);
				//btnLeft.setVisible(false);
				//btnRight.setVisible(false);
				btnHowPLay.setVisible(false);
				btnStart.setVisible(false);
				btnExitGame.setVisible(false);
				lblTitle.setVisible(false);
				
				control.initField();
				
			/*	//start game for now will go to end screen right away
				btnBmenu.setVisible(true);
				lblGameOver.setVisible(true);
				btnPlayAgain.setVisible(true);
				txtTime.setVisible(true);
				txtAcc.setVisible(true);
				txtScore.setVisible(true);
				txtEnemyKills.setVisible(true);*/
			}
		});



		btnBmenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblTitle.setVisible(true);
				btnHowPLay.setVisible(true);
				btnStart.setVisible(true);
				btnExitGame.setVisible(true);
				btnBmenu.setVisible(false);
				lblGameOver.setVisible(false);
				btnPlayAgain.setVisible(false);
				txtTime.setVisible(false);
				txtAcc.setVisible(false);
				txtScore.setVisible(false);
				txtEnemyKills.setVisible(false);
			}});




		/*JLabel background = new JLabel("");
		Image img1 = new ImageIcon(this.getClass().getResource("backround.jpg")).getImage().getScaledInstance(1000, -1, 0);
		background.setIcon(new ImageIcon(img1));
		background.setBounds(0, -23, 615, 446);
		frame.getContentPane().add(background);	*/
	}


	

}
