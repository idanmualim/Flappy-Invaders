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

public class GUI extends JFrame implements ActionListener, KeyListener
{

	private Controller control;
	private boolean upJustPressed;

	public GUI(Controller controller) {
		super("Flappy Invaders");
		
		control = controller;
		
		setBounds(100, 100, 600, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		getContentPane().setBackground(Color.BLACK);
		
		addKeyListener(this);
		
		displayMenu();
		setVisible(true);
		
		Timer timer = new Timer(17, this);
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
		if(e.getKeyCode() == KeyEvent.VK_UP && !upJustPressed) {
			control.onPressUp();
			upJustPressed = true;
		}
		else if(e.getKeyCode() == KeyEvent.VK_SPACE)
			control.onPressSpace();
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		if(arg0.getKeyCode() == KeyEvent.VK_UP)
			upJustPressed = false;
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
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

		JButton btnStart = new JButton("Start Game");
		btnStart.setFont(new Font("Impact", Font.PLAIN, 20));
		btnStart.setForeground(Color.BLACK);
		btnStart.setToolTipText("");
		btnStart.setBackground(Color.GREEN);
		btnStart.setBounds(210, 180, 166, 69);
		frame.getContentPane().add(btnStart);

		JButton btnHowPLay = new JButton("How To Play");
		btnHowPLay.setFont(new Font("Impact", Font.PLAIN, 20));
		btnHowPLay.setBackground(new Color(255, 215, 0));
		btnHowPLay.setBounds(210, 260, 164, 68);
		frame.getContentPane().add(btnHowPLay);

		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Impact", Font.PLAIN, 20));
		btnBack.setBackground(new Color(255, 0, 0));
		btnBack.setBounds(10, 63, 94, 61);
		frame.getContentPane().add(btnBack);
		btnBack.setVisible(false);

		JButton btnExitGame = new JButton("Exit Game");
		btnExitGame.setToolTipText("");
		btnExitGame.setForeground(Color.BLACK);
		btnExitGame.setFont(new Font("Impact", Font.PLAIN, 20));
		btnExitGame.setBackground(Color.RED);
		btnExitGame.setBounds(210, 343, 166, 69);
		

		JLabel lblTitle = new JLabel("");
		Image img = new ImageIcon(this.getClass().getClassLoader().getResource("title.png")).getImage().getScaledInstance(300, -1, 0);
		lblTitle.setIcon(new ImageIcon(img));
		lblTitle.setBounds(150, -6, 313, 190);
		frame.getContentPane().add(lblTitle);

		


		JTextPane txtHowTo1 = new JTextPane();
		txtHowTo1.setText("Press UP to jump.\nPress SPACE to fire.\nTry not to die.");
		txtHowTo1.setFont(new Font("Arial", Font.PLAIN, 25));
		txtHowTo1.setBounds(95, 173, 406, 239);
		txtHowTo1.setBackground(new Color(255, 215, 0));
		frame.getContentPane().add(txtHowTo1);
		txtHowTo1.setVisible(false);

		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtHowTo1.setVisible(false);
				btnBack.setVisible(false);
				btnHowPLay.setVisible(true);
				btnStart.setVisible(true);
				btnExitGame.setVisible(true);
			}
		});

		btnHowPLay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtHowTo1.setVisible(true);
				btnBack.setVisible(true);
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
				btnBack.setVisible(false);
				btnHowPLay.setVisible(false);
				btnStart.setVisible(false);
				btnExitGame.setVisible(false);
				lblTitle.setVisible(false);
				
				control.initField();
				
			}
		});



		




		/*JLabel background = new JLabel("");
		Image img1 = new ImageIcon(this.getClass().getResource("backround.jpg")).getImage().getScaledInstance(1000, -1, 0);
		background.setIcon(new ImageIcon(img1));
		background.setBounds(0, -23, 615, 446);
		frame.getContentPane().add(background);	*/
	}
	
	public void displayGameOver(int score, int killed, int accuracy, double time) {
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
		
		
		JLabel lblGameOver = new JLabel("");
		Image imgG = new ImageIcon(this.getClass().getClassLoader().getResource("game_over.png")).getImage().getScaledInstance(250, -1, 0);
		lblGameOver.setIcon(new ImageIcon(imgG));
		lblGameOver.setBounds(173, 0, 267, 231);
		frame.getContentPane().add(lblGameOver);
		lblGameOver.setVisible(false);
		
		JTextField txtScore = new JTextField();
		txtScore.setForeground(Color.WHITE);
		txtScore.setFont(new Font("Impact", Font.PLAIN, 25));
		txtScore.setBackground(Color.BLACK);
		txtScore.setText("Score: " + score);
		txtScore.setBounds(95, 207, 187, 31);
		frame.getContentPane().add(txtScore);
		txtScore.setColumns(10);
		txtScore.setVisible(false);

		JTextField txtEnemyKills= new JTextField();
		txtEnemyKills.setText("Enemies Killed: " + killed); //use stats method
		txtEnemyKills.setForeground(Color.WHITE);
		txtEnemyKills.setFont(new Font("Impact", Font.PLAIN, 25));
		txtEnemyKills.setColumns(10);
		txtEnemyKills.setBackground(Color.BLACK);
		txtEnemyKills.setBounds(95, 237, 187, 31);
		frame.getContentPane().add(txtEnemyKills);
		txtEnemyKills.setVisible(false);

		JTextField txtAcc= new JTextField();
		txtAcc.setText("Accuracy: " + accuracy + "%"); //use stats method
		txtAcc.setForeground(Color.WHITE);
		txtAcc.setFont(new Font("Impact", Font.PLAIN, 25));
		txtAcc.setColumns(10);
		txtAcc.setBackground(Color.BLACK);
		txtAcc.setBounds(95, 267, 187, 31);
		frame.getContentPane().add(txtAcc);
		txtAcc.setVisible(false);


		JTextField txtTime= new JTextField();
		txtTime.setText(time + " seconds"); //use stats method
		txtTime.setForeground(Color.WHITE);
		txtTime.setFont(new Font("Impact", Font.PLAIN, 25));
		txtTime.setColumns(10);
		txtTime.setBackground(Color.BLACK);
		txtTime.setBounds(95, 297, 187, 31);
		frame.getContentPane().add(txtTime);
		txtTime.setVisible(false);
		
		btnBmenu.setVisible(true);
		btnPlayAgain.setVisible(true);
		lblGameOver.setVisible(true);
		txtTime.setVisible(true);
		txtAcc.setVisible(true);
		txtScore.setVisible(true);
		txtEnemyKills.setVisible(true);
		btnPlayAgain.requestFocusInWindow();
		
		btnBmenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnBmenu.setVisible(false);
				lblGameOver.setVisible(false);
				btnPlayAgain.setVisible(false);
				txtTime.setVisible(false);
				txtAcc.setVisible(false);
				txtScore.setVisible(false);
				txtEnemyKills.setVisible(false);
				control.getGUI().displayMenu();
				
			}});
		
		btnPlayAgain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnBmenu.setVisible(false);
				lblGameOver.setVisible(false);
				btnPlayAgain.setVisible(false);
				txtTime.setVisible(false);
				txtAcc.setVisible(false);
				txtScore.setVisible(false);
				txtEnemyKills.setVisible(false);
				control.initField();
			}
		});
	}


}
