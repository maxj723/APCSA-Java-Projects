package quiz;

import javax.swing.JFrame;
import javax.swing.ButtonGroup;
import java.awt.Container;
import java.awt.GridLayout;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Game extends JFrame implements ActionListener {

	JTextArea label;
	JRadioButton Buttons[] = new JRadioButton[5];
	JButton btnNext, btnResult;
	ButtonGroup bg;
	int count = 0;
	static int current = 0;
	int x = 1;
	int y = 1;
	int now = 0;
	int m[] = new int[10];
	int[] houses = new int[4];
	int griff = 0;
	int raven = 0;
	int slyth = 0;
	int huff = 0;
	String house = "";

	JPanel titleNamePanel, startButtonPanel, mainTextPanel, choiceButtonPanel, playerPanel, menuPanel, shopPanel,
			exitPanel, moneyPanel, sneakerPanel, broomPanel, robePanel, wandPanel;
	JLabel titleNameLabel, hpLabel, hpLabelNumber, enemyHpLabel, enemyHpLabelNumber, moneyLabel, moneyLabelNumber,
			itemLabel, priceLabel, blankLabel, sneakerLabel, sneakerDescLabel, sneakerPriceLabel, broomLabel, broomDescLabel, broomPriceLabel, robeLabel, robeDescLabel,
			robePriceLabel, wandLabel, wandDescLabel, wandPriceLabel, successLabel, houseLabel, enemyHouseLabel;
	Font titleFont = new Font("Times New Roman", Font.PLAIN, 90);
	Font normalFont = new Font("Times New Roman", Font.PLAIN, 30);
	Font smallFont = new Font("Times New Roman", Font.PLAIN, 15);
	JButton startButton, choice1, choice2, choice3, choice4, playAgainButton, shopButton, sneakerButton, broomButton,
			robeButton, wandButton, exitButton;
	JTextArea mainTextArea;

	Wizard player1, enemy;
	Attack enemyAttack;
	String player1Text = "Choose an attack", enemyText = "";
	boolean youWon, gameActive;
	Item sneaker, broom, robe, wand;

	Game(String s) {
		super(s);
		label = new JTextArea();
		add(label);
		bg = new ButtonGroup();
		for (int i = 0; i < 5; i++) {
			Buttons[i] = new JRadioButton();
			add(Buttons[i]);
			bg.add(Buttons[i]);
			Buttons[i].setFont(new Font("Arial", Font.PLAIN, 15));

		}

		btnNext = new JButton("Next");
		btnResult = new JButton("Result");
		// btnShop = new JButton("Shop");
		btnResult.setVisible(false);
		btnResult.addActionListener(this);
		btnNext.addActionListener(this);
		add(btnNext);
		add(btnResult);
		setData();

		label.setBounds(30, 40, 600, 20);
		label.setLineWrap(true);
		Buttons[0].setBounds(50, 80, 1000, 20);
		Buttons[1].setBounds(50, 110, 1000, 20);
		Buttons[2].setBounds(50, 140, 1000, 20);
		Buttons[3].setBounds(50, 170, 1000, 20);
		btnNext.setBounds(100, 240, 100, 30);
		btnResult.setBounds(270, 240, 100, 30);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setLocation(250, 100);
		setVisible(true);
		setSize(1000, 800);
		Font f = Buttons[0].getFont();

		f = f.deriveFont(10);
		Buttons[0].setFont(f);
		Buttons[1].setFont(f);
		Buttons[2].setFont(f);
		Buttons[3].setFont(f);
		label.setFont(f);

	}

	public void setData() {
		Buttons[4].setSelected(true);
		if (current == 0) {
			label.setText("After you have died, what would you most like people to do when they hear your name?");
			Buttons[0].setText("Think with admiration of your achievements");
			Buttons[1].setText("Ask for more stories about your adventures");
			Buttons[2].setText(
					"I don't care what people think when I die; it's what they think when I'm alive that counts");
			Buttons[3].setText("Miss you, but smile");
		}
		if (current == 1) {
			label.setText("Which of the following would you most hate people to call you?");
			Buttons[0].setText("Ignorant");
			Buttons[1].setText("Cowardly");
			Buttons[2].setText("Ordinary");
			Buttons[3].setText("Selfish");
		}
		if (current == 2) {
			label.setText("What would you rather invent a potion that would give you");
			Buttons[0].setText("Wisdom?");
			Buttons[1].setText("Glory?");
			Buttons[2].setText("Power?");
			Buttons[3].setText("Love?");
		}
		if (current == 3) {
			label.setText("How would you like to be known to history?");
			Buttons[0].setText("The Wise");
			Buttons[1].setText("The Bold");
			Buttons[2].setText("The Great");
			Buttons[3].setText("The Good");
		}
		if (current == 4) {
			label.setText("You enter an enchanted garden. What do you look at first?");
			Buttons[0].setText("The silver leafed tree bearing golden apples");
			Buttons[1].setText("The statue of an old wizard with a strangely twinkling eye");
			Buttons[2].setText("The bubbling pool, in the depths of which something luminous is swirling?");
			Buttons[3].setText("The fat red toadstools that appear to be talking to each other");
		}
		if (current == 5) {
			label.setText("What kind of instrument most pleases your ear?");
			Buttons[0].setText("The piano");
			Buttons[1].setText("The drum");
			Buttons[2].setText("The violin");
			Buttons[3].setText("The trumpet");
		}
		if (current == 6) {
			label.setText("Four boxes are placed before you. Which would you try and open");
			Buttons[0].setText(
					"The ornate golden casket, standing on clawed feet, whose inscription warns that both secret knowledge and unbearable temptation lie within.");
			Buttons[1].setText(
					"The small pewter box, unassuming and plain, with a scratched message upon it that reads \" open only for the worthy.\"");
			Buttons[2].setText(
					"The gleaming jet black box with a silver lock and key, marked with a mysterious rune that you know to be the mark of Merlin.");
			Buttons[3].setText(
					"The small tortoiseshell box, embellished with gold, inside which some small creature seems to be squeaking.");
		}
		if (current == 7) {
			label.setText("Four goblets are placed before you. Which would you choose to drink?");
			Buttons[0].setText(
					"The foaming, frothing, silvery liquid that sparkles as though containing ground diamonds.");
			Buttons[1].setText(
					"The golden liquid so bright that it hurts the eye, and which makes sunspots dance all around the room.");
			Buttons[2].setText(
					"The mysterious black liquid that gleams like ink, and gives off fumes that make you see strange visions.");
			Buttons[3].setText(
					"The smooth, thick, richly purple drink that gives off a delicious smell of chocolate and plums.");
		}

		label.setBounds(30, 40, 600, 20);
		for (int i = 0, j = 0; i <= 90; i += 30, j++) {
			Buttons[j].setBounds(50, 80 + i, 1000, 20);
		}
	}

	public void checkAns() {
		if (current == 0) {
			if (Buttons[0].isSelected()) {
				raven++;
			}
			if (Buttons[1].isSelected()) {
				griff++;
			}
			if (Buttons[2].isSelected()) {
				slyth++;
			}
			if (Buttons[3].isSelected()) {
				huff++;
			}
		}
		if (current == 1) {
			if (Buttons[0].isSelected()) {
				raven++;
			}
			if (Buttons[1].isSelected()) {
				griff++;
			}
			if (Buttons[2].isSelected()) {
				slyth++;
			}
			if (Buttons[3].isSelected()) {
				huff++;
			}
		}
		if (current == 2) {
			if (Buttons[0].isSelected()) {
				raven++;
			}
			if (Buttons[1].isSelected()) {
				griff++;
			}
			if (Buttons[2].isSelected()) {
				slyth++;
			}
			if (Buttons[3].isSelected()) {
				huff++;
			}
		}
		if (current == 3) {
			if (Buttons[0].isSelected()) {
				raven++;
			}
			if (Buttons[1].isSelected()) {
				griff++;
			}
			if (Buttons[2].isSelected()) {
				slyth++;
			}
			if (Buttons[3].isSelected()) {
				huff++;
			}
		}
		if (current == 4) {
			if (Buttons[0].isSelected()) {
				raven++;
			}
			if (Buttons[1].isSelected()) {
				griff++;
			}
			if (Buttons[2].isSelected()) {
				slyth++;
			}
			if (Buttons[3].isSelected()) {
				huff++;
			}
			if (current == 5) {
				if (Buttons[0].isSelected()) {
					raven++;
				}
				if (Buttons[1].isSelected()) {
					griff++;
				}
				if (Buttons[2].isSelected()) {
					slyth++;
				}
				if (Buttons[3].isSelected()) {
					huff++;
				}
				if (current == 6) {
					if (Buttons[0].isSelected()) {
						raven++;
					}
					if (Buttons[1].isSelected()) {
						griff++;
					}
					if (Buttons[2].isSelected()) {
						slyth++;
					}
					if (Buttons[3].isSelected()) {
						huff++;
					}
					if (current == 7) {
						if (Buttons[0].isSelected()) {
							raven++;
						}
						if (Buttons[1].isSelected()) {
							griff++;
						}
						if (Buttons[2].isSelected()) {
							slyth++;
						}
						if (Buttons[3].isSelected()) {
							huff++;
						}
					}
				}
			}
		}
	}

	public void calcResult() {
		if (raven > griff && raven > slyth && raven > huff) {
			house = "Ravenclaw";
		} else if (griff > raven && griff > slyth && griff > huff) {
			house = "Gryffindor";
		} else if (slyth > raven && slyth > griff && slyth > huff) {
			house = "Slytherin";
		} else if (huff > raven && huff > griff && huff > slyth) {
			house = "Hufflepuff";
		}
		player1 = new Wizard(house);

		sneaker = new Item("Sneakers", 200);
		broom = new Item("Broom", 600);
		robe = new Item("Robe", 800);
		wand = new Item("Wand", 1000);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNext) {
			checkAns();
			current++;
			setData();

			if (current == 7) {
				calcResult();
				btnNext.setEnabled(false);
				btnResult.setVisible(true);
				btnResult.setText("Result");
			}
		}

		if (e.getSource() == btnResult) {
			createTitleScreen();
		}

		if (e.getSource() == startButton) {
			createGameScreen();
		}

		if (e.getSource() == choice1) {
			move(player1.getAttacks().get(0));
		}

		if (e.getSource() == choice2) {
			move(player1.getAttacks().get(1));
		}

		if (e.getSource() == choice3) {
			move(player1.getAttacks().get(2));
		}

		if (e.getSource() == choice4) {
			move(player1.getAttacks().get(3));
		}

		if (e.getSource() == playAgainButton) {
			reset();
			//createGameScreen();
		}

		if (e.getSource() == shopButton) {
			playerPanel.setVisible(false);
			createShop();
		}

		if (e.getSource() == sneakerButton) {
			if (player1.buy(sneaker)) {
				moneyLabelNumber.setText("" + player1.getMoney());
				successLabel.setText("Success");
			} else {
				successLabel.setText("Poor");
			}

		}

		if (e.getSource() == broomButton) {
			if (player1.buy(broom)) {
				moneyLabelNumber.setText("" + player1.getMoney());
				successLabel.setText("Success");
			} else {
				successLabel.setText("Poor");
			}
		}

		if (e.getSource() == robeButton) {
			if (player1.buy(robe)) {
				moneyLabelNumber.setText("" + player1.getMoney());
				successLabel.setText("Success");
			} else {
				successLabel.setText("Poor");
			}
		}

		if (e.getSource() == wandButton) {
			if (player1.buy(wand)) {
				moneyLabelNumber.setText("" + player1.getMoney());
				successLabel.setText("Success");
			} else {
				successLabel.setText("Poor");
			}
		}

		if (e.getSource() == exitButton) {
			shopPanel.setVisible(false);
			exitPanel.setVisible(false);
			moneyPanel.setVisible(false);
			createGameScreen();

		}
	}

	public void createTitleScreen() {
		JOptionPane.showMessageDialog(this, "Your House is " + house + "\nClose this message to Fight!");
		current++;
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.black);
		setLayout(null);
		setVisible(true);
		setTitle("Fight");
		label.setVisible(false);
		for (JRadioButton button : Buttons) {
			button.setVisible(false);
		}
		btnNext.setVisible(false);
		btnResult.setVisible(false);
		titleNamePanel = new JPanel();
		titleNamePanel.setBounds(100, 100, 600, 150);
		titleNamePanel.setBackground(Color.black);
		titleNameLabel = new JLabel("Fight");
		titleNameLabel.setForeground(Color.white);
		titleNameLabel.setFont(titleFont);

		startButtonPanel = new JPanel();
		startButtonPanel.setBounds(300, 400, 200, 100);
		startButtonPanel.setBackground(Color.black);

		startButton = new JButton("START");
		startButton.setBackground(Color.black);
		// startButton.setForeground(Color.white);
		startButton.addActionListener(this);
		startButton.setFont(normalFont);

		titleNamePanel.add(titleNameLabel);
		startButtonPanel.add(startButton);

		add(titleNamePanel);
		add(startButtonPanel);

	}

	public void createGameScreen() {

		enemy = new Wizard();
		titleNamePanel.setVisible(false);
		startButtonPanel.setVisible(false);

		mainTextPanel = new JPanel();
		mainTextPanel.setBounds(100, 100, 600, 250);
		mainTextPanel.setBackground(Color.black);

		mainTextArea = new JTextArea("Choose an attack");
		mainTextArea.setBounds(100, 100, 500, 250);
		mainTextArea.setBackground(Color.gray);
		mainTextArea.setForeground(Color.white);
		mainTextArea.setFont(normalFont);
		mainTextArea.setLineWrap(true);
		mainTextPanel.add(mainTextArea);

		choiceButtonPanel = new JPanel();
		choiceButtonPanel.setBounds(100, 350, 600, 140);
		choiceButtonPanel.setBackground(Color.gray);
		choiceButtonPanel.setLayout(new GridLayout(2, 2));

		choice1 = new JButton("Choice 1");
		choice1.setFont(normalFont);
		choice1.setBackground(Color.BLACK);
		choice1.setForeground(Color.GRAY);
//		choice1.setOpaque(true);
//		choice1.setBorderPainted(false);
		choice1.addActionListener(this);
		choiceButtonPanel.add(choice1);
		choice2 = new JButton("Choice 2");
		choice2.setFont(normalFont);
		choice2.setBackground(Color.BLACK);
		choice2.setForeground(Color.GRAY);
//		choice2.setOpaque(true);
//		choice2.setBorderPainted(false);
		choice2.addActionListener(this);
		choiceButtonPanel.add(choice2);
		choice3 = new JButton("Choice 3");
		choice3.setFont(normalFont);
		choice3.setBackground(Color.BLACK);
		choice3.setForeground(Color.GRAY);
//		choice3.setOpaque(true);
//		choice3.setBorderPainted(false);
		choice3.addActionListener(this);
		choiceButtonPanel.add(choice3);
		choice4 = new JButton("Choice 4");
		choice4.setFont(normalFont);
		choice4.setBackground(Color.BLACK);
		choice4.setForeground(Color.GRAY);
//		choice4.setOpaque(true);
//		choice4.setBorderPainted(false);
		choice4.addActionListener(this);
		choiceButtonPanel.add(choice4);

		playerPanel = new JPanel();
		playerPanel.setBounds(100, 15, 600, 60);
		playerPanel.setBackground(Color.gray);
		playerPanel.setLayout(new GridLayout(2, 4));
		hpLabel = new JLabel("Your HP:", SwingConstants.CENTER);
		hpLabel.setFont(normalFont);
		hpLabel.setForeground(Color.white);
		playerPanel.add(hpLabel);
		hpLabelNumber = new JLabel("", SwingConstants.CENTER);
		hpLabelNumber.setFont(normalFont);
		hpLabelNumber.setForeground(Color.white);
		playerPanel.add(hpLabelNumber);
		enemyHpLabel = new JLabel("Enemy HP: ", SwingConstants.CENTER);
		enemyHpLabel.setFont(normalFont);
		enemyHpLabel.setForeground(Color.white);
		playerPanel.add(enemyHpLabel);
		enemyHpLabelNumber = new JLabel("100", SwingConstants.CENTER);
		enemyHpLabelNumber.setFont(normalFont);
		enemyHpLabelNumber.setForeground(Color.white);
		playerPanel.add(enemyHpLabelNumber);
		
		houseLabel = new JLabel("", SwingConstants.CENTER);
		houseLabel.setFont(smallFont);
		houseLabel.setForeground(Color.white);
		playerPanel.add(houseLabel);
		blankLabel = new JLabel();
		blankLabel.setFont(smallFont);
		blankLabel.setForeground(Color.white);
		playerPanel.add(blankLabel);
		enemyHouseLabel = new JLabel("", SwingConstants.CENTER);
		enemyHouseLabel.setFont(smallFont);
		enemyHouseLabel.setForeground(Color.white);
		playerPanel.add(enemyHouseLabel);
		

		menuPanel = new JPanel();
		menuPanel.setBounds(100, 350, 600, 70);
		menuPanel.setBackground(Color.gray);
		menuPanel.setLayout(new GridLayout(1, 2));
		menuPanel.setVisible(!gameActive);

		playAgainButton = new JButton("Play Again");
		playAgainButton.setFont(normalFont);
		playAgainButton.setBackground(Color.BLACK);
		playAgainButton.setForeground(Color.GRAY);
//		playAgainButton.setOpaque(true);
//		playAgainButton.setBorderPainted(false);
		playAgainButton.addActionListener(this);
		menuPanel.add(playAgainButton);
		shopButton = new JButton("Shop");
		shopButton.setFont(normalFont);
		shopButton.setBackground(Color.BLACK);
		shopButton.setForeground(Color.GRAY);
//		shopButton.setOpaque(true);
//		shopButton.setBorderPainted(false);
		shopButton.addActionListener(this);
		menuPanel.add(shopButton);

		reset();

		add(mainTextPanel);
		add(choiceButtonPanel);
		add(playerPanel);
		add(menuPanel);

		// boardSetup();

	}

	public void boardSetup() {

		if (player1.getHealth() > 0) {
			hpLabelNumber.setText("" + player1.getHealth());
		} else {
			hpLabelNumber.setText("0");
		}
		if (enemy.getHealth() > 0) {
			enemyHpLabelNumber.setText("" + enemy.getHealth());
		} else {
			enemyHpLabelNumber.setText("0");
		}
		choice1.setText(player1.getAttacks().get(0).getName());
		choice2.setText(player1.getAttacks().get(1).getName());
		choice3.setText(player1.getAttacks().get(2).getName());
		choice4.setText(player1.getAttacks().get(3).getName());
		
		houseLabel.setText(player1.getHouse().getName());
		enemyHouseLabel.setText(enemy.getHouse().getName());

		mainTextArea.setText(player1Text + "\n\n" + enemyText);

		choiceButtonPanel.setVisible(gameActive);
		menuPanel.setVisible(!gameActive);
	}

	public void move(Attack a) {
		if (enemy.getOnCooldown()) {
			enemyAttack = enemy.getAttacks().get((int) (Math.random() * 3 + 1));
		} else {
			enemyAttack = enemy.getAttacks().get((int) (Math.random() * 3));
		}
		

		if (enemy.getSpeed() < player1.getSpeed()) {
			playerFirst(enemyAttack, a);
		} else if (enemy.getSpeed() > player1.getSpeed()) {
			enemyFirst(enemyAttack, a);
		} else {
			if (Math.random() > 0.49) {
				enemyFirst(enemyAttack, a);
			} else {
				playerFirst(enemyAttack, a);
			}
		}
		
		if (enemy.getHealth() == 0) {
			enemyText = "The enemy got obliterated!";
			player1.setMoney(player1.getMoney() + 100);
			youWon = true;
			gameActive = false;
		} else if (player1.getHealth() == 0) {
			player1Text = "You got destroyed! You Suck";
			youWon = false;
			gameActive = false;
		}
		boardSetup();
	}

	void enemyFirst(Attack e, Attack p) {

		switch (e.getName()) {
		case "Quick Spell":
			if (enemy.getOnCooldown()) {
				enemy.setOnCooldown(false);
			}
			if (player1.getIsProtected()) {
				enemyText = "The enemy used " + e.getName() + " . It was blocked";
				player1.setIsProtected(false);
			} else {
				player1.setHealth(player1.getHealth() - e.getDamage());
				enemyText = "The enemy used " + e.getName() + " . It did " + e.getDamage() + " damage.";
			}
			break;

		case "Magic Spell":
			if (enemy.getOnCooldown()) {
				enemy.setOnCooldown(false);
			}
			enemy.setAttackBoost(enemy.getAttackBoost() + 15);
			enemy.setHealth(enemy.getHealth() + 50);
			enemy.setSpeed(enemy.getSpeed() + 1);
			enemyText = "The enemy has been enhanced.";
			if (player1.getIsProtected()) {
				player1.setIsProtected(false);
			}
			break;
			
		case "Protection":
			if (enemy.getOnCooldown()) {
				enemy.setOnCooldown(false);
			}
			enemy.setIsProtected(true);
			enemyText = "The enemy is now protected.";
			if (player1.getIsProtected()) {
				player1.setIsProtected(false);
			}
			break;
			
		case "Special" :
			if (player1.getIsProtected()) {
				enemyText = "The enemy used " + e.getName() + " . It was blocked";
				player1.setIsProtected(false);
			} else {
				player1.setHealth(player1.getHealth() - e.getDamage());
				enemyText = "The enemy used " + e.getName() + " . It did " + e.getDamage() + " damage.";
				enemy.setOnCooldown(true);
			}
			break;
			
		}

		if (player1.getHealth() > 0) {
			switch (p.getName()) {
			case "Quick Spell":
				if (player1.getOnCooldown()) {
					player1.setOnCooldown(false);
				}
				if (enemy.getIsProtected()) {
					player1Text = "You used " + e.getName() + " . It was blocked";
					enemy.setIsProtected(false);
				} else {
					enemy.setHealth(enemy.getHealth() - p.getDamage());
					player1Text = "You used " + p.getName() + " . It did " + p.getDamage() + " damage.";
				}
				break;

			case "Magic Spell":
				if (player1.getOnCooldown()) {
					player1.setOnCooldown(false);
				}
				player1.setAttackBoost(player1.getAttackBoost() + 15);
				player1.setHealth(player1.getHealth() + 50);
				player1.setSpeed(player1.getSpeed() + 1);
				player1Text = "You have been enhanced.";
				if (enemy.getIsProtected()) {
					enemy.setIsProtected(false);
				}
				break;
				
			case "Protection":
				if (player1.getOnCooldown()) {
					player1.setOnCooldown(false);
				}
				player1.setIsProtected(true);
				player1Text = "You are now protected.";
				if (enemy.getIsProtected()) {
					enemy.setIsProtected(false);
				}
				break;
				
			case "Special" :
				if (enemy.getIsProtected()) {
					player1Text = "You used " + e.getName() + " . It was blocked";
					enemy.setIsProtected(false);
				} else {
					enemy.setHealth(enemy.getHealth() - p.getDamage());
					player1Text = "You used " + p.getName() + " . It did " + p.getDamage() + " damage.";
					player1.setOnCooldown(true);
				}
				break;
				
			}

			choice1.setEnabled(!player1.getOnCooldown());
		}
	}

	void playerFirst(Attack e, Attack p) {
		switch (p.getName()) {
		case "Quick Spell":
			if (player1.getOnCooldown()) {
				player1.setOnCooldown(false);
			}
			if (enemy.getIsProtected()) {
				player1Text = "You used " + e.getName() + " . It was blocked";
				enemy.setIsProtected(false);
			} else {
				enemy.setHealth(enemy.getHealth() - p.getDamage());
				player1Text = "You used " + p.getName() + " . It did " + p.getDamage() + " damage.";
			}
			break;

		case "Magic Spell":
			if (player1.getOnCooldown()) {
				player1.setOnCooldown(false);
			}
			player1.setAttackBoost(player1.getAttackBoost() + 15);
			player1.setHealth(player1.getHealth() + 50);
			player1.setSpeed(player1.getSpeed() + 1);
			player1Text = "You have been enhanced.";
			if (enemy.getIsProtected()) {
				enemy.setIsProtected(false);
			}
			break;
			
		case "Protection":
			if (player1.getOnCooldown()) {
				player1.setOnCooldown(false);
			}
			player1.setIsProtected(true);
			player1Text = "You are now protected.";
			if (enemy.getIsProtected()) {
				enemy.setIsProtected(false);
			}
			break;
			
		case "Special" :
			if (enemy.getIsProtected()) {
				player1Text = "You used " + e.getName() + " . It was blocked";
				enemy.setIsProtected(false);
			} else {
				enemy.setHealth(enemy.getHealth() - p.getDamage());
				player1Text = "You used " + p.getName() + " . It did " + p.getDamage() + " damage.";
				player1.setOnCooldown(true);
			}
			break;
			
		}
		choice1.setEnabled(!player1.getOnCooldown());
		
		if (enemy.getHealth() > 0) {
			switch (e.getName()) {
			case "Quick Spell":
				if (enemy.getOnCooldown()) {
					enemy.setOnCooldown(false);
				}
				if (player1.getIsProtected()) {
					enemyText = "The enemy used " + e.getName() + " . It was blocked";
					player1.setIsProtected(false);
				} else {
					player1.setHealth(player1.getHealth() - e.getDamage());
					enemyText = "The enemy used " + e.getName() + " . It did " + e.getDamage() + " damage.";
				}
				break;

			case "Magic Spell":
				if (enemy.getOnCooldown()) {
					enemy.setOnCooldown(false);
				}
				enemy.setAttackBoost(enemy.getAttackBoost() + 15);
				enemy.setHealth(enemy.getHealth() + 50);
				enemy.setSpeed(enemy.getSpeed() + 1);
				enemyText = "The enemy has been enhanced.";
				if (player1.getIsProtected()) {
					player1.setIsProtected(false);
				}
				break;
				
			case "Protection":
				if (enemy.getOnCooldown()) {
					enemy.setOnCooldown(false);
				}
				enemy.setIsProtected(true);
				enemyText = "The enemy is now protected.";
				if (player1.getIsProtected()) {
					player1.setIsProtected(false);
				}
				break;
				
			case "Special" :
				if (player1.getIsProtected()) {
					enemyText = "The enemy used " + e.getName() + " . It was blocked";
					player1.setIsProtected(false);
				} else {
					player1.setHealth(player1.getHealth() - e.getDamage());
					enemyText = "The enemy used " + e.getName() + " . It did " + e.getDamage() + " damage.";
					enemy.setOnCooldown(true);
				}
				break;
				
			}
		}
	}

	public void reset() {
		enemy = new Wizard();
		player1.setHealth(player1.getHouse().getHealth());
		gameActive = true;

		boardSetup();
		mainTextArea.setText("New Game");
	}

	public void createShop() {

		playerPanel.setVisible(false);

		moneyPanel = new JPanel();
		moneyPanel.setBounds(100, 15, 600, 50);
		moneyPanel.setBackground(Color.gray);
		moneyPanel.setLayout(new GridLayout(1, 3));
		moneyLabel = new JLabel("Money:", SwingConstants.CENTER);
		moneyLabel.setFont(normalFont);
		moneyLabel.setForeground(Color.white);
		moneyPanel.add(moneyLabel);
		moneyLabelNumber = new JLabel("" + player1.getMoney(), SwingConstants.CENTER);
		moneyLabelNumber.setFont(normalFont);
		moneyLabelNumber.setForeground(Color.white);
		moneyPanel.add(moneyLabelNumber);
		successLabel = new JLabel("", SwingConstants.CENTER);
		successLabel.setFont(normalFont);
		successLabel.setForeground(Color.white);
		moneyPanel.add(successLabel);

		mainTextPanel.setVisible(false);
		playerPanel.setVisible(false);

		shopPanel = new JPanel();
		shopPanel.setBounds(100, 100, 600, 350);
		shopPanel.setBackground(Color.gray);
		shopPanel.setLayout(new GridLayout(5, 3));

		itemLabel = new JLabel("Item", SwingConstants.CENTER);
		itemLabel.setFont(normalFont);
		itemLabel.setBackground(Color.BLACK);
		itemLabel.setForeground(Color.WHITE);
		shopPanel.add(itemLabel);
		priceLabel = new JLabel("Price", SwingConstants.CENTER);
		priceLabel.setFont(normalFont);
		priceLabel.setBackground(Color.BLACK);
		priceLabel.setForeground(Color.WHITE);
		shopPanel.add(priceLabel);
		blankLabel = new JLabel("");
		blankLabel.setFont(normalFont);
		blankLabel.setBackground(Color.BLACK);
		blankLabel.setForeground(Color.WHITE);
		shopPanel.add(blankLabel);

		sneakerPanel = new JPanel();
		sneakerPanel.setBackground(Color.gray);
		sneakerPanel.setLayout(new GridLayout(2,1));
		sneakerLabel = new JLabel("Sneakers", SwingConstants.CENTER);
		sneakerLabel.setFont(normalFont);
		sneakerLabel.setBackground(Color.BLACK);
		sneakerLabel.setForeground(Color.WHITE);
		sneakerDescLabel = new JLabel("+5 Speed", SwingConstants.CENTER);
		sneakerDescLabel.setFont(smallFont);
		sneakerDescLabel.setBackground(Color.BLACK);
		sneakerDescLabel.setForeground(Color.WHITE);
		sneakerPanel.add(sneakerLabel);
		sneakerPanel.add(sneakerDescLabel);
		shopPanel.add(sneakerPanel);
		sneakerPriceLabel = new JLabel("200", SwingConstants.CENTER);
		sneakerPriceLabel.setFont(normalFont);
		sneakerPriceLabel.setBackground(Color.BLACK);
		sneakerPriceLabel.setForeground(Color.WHITE);
		shopPanel.add(sneakerPriceLabel);
		sneakerButton = new JButton("Buy");
		sneakerButton.setFont(normalFont);
		sneakerButton.setBackground(Color.BLACK);
		sneakerButton.setForeground(Color.GRAY);
//		sneakerButton.setOpaque(true);
//		sneakerButton.setBorderPainted(false);
		sneakerButton.addActionListener(this);
		shopPanel.add(sneakerButton);

		broomPanel = new JPanel();
		broomPanel.setBackground(Color.gray);
		broomPanel.setLayout(new GridLayout(2,1));
		broomLabel = new JLabel("Broom", SwingConstants.CENTER);
		broomLabel.setFont(normalFont);
		broomLabel.setBackground(Color.BLACK);
		broomLabel.setForeground(Color.WHITE);
		broomDescLabel = new JLabel("+15 Speed", SwingConstants.CENTER);
		broomDescLabel.setFont(smallFont);
		broomDescLabel.setBackground(Color.BLACK);
		broomDescLabel.setForeground(Color.WHITE);
		broomPanel.add(broomLabel);
		broomPanel.add(broomDescLabel);
		shopPanel.add(broomPanel);
		broomPriceLabel = new JLabel("600", SwingConstants.CENTER);
		broomPriceLabel.setFont(normalFont);
		broomPriceLabel.setBackground(Color.BLACK);
		broomPriceLabel.setForeground(Color.WHITE);
		shopPanel.add(broomPriceLabel);
		broomButton = new JButton("Buy");
		broomButton.setFont(normalFont);
		broomButton.setBackground(Color.BLACK);
		broomButton.setForeground(Color.GRAY);
//		broomButton.setOpaque(true);
//		broomButton.setBorderPainted(false);
		broomButton.addActionListener(this);
		shopPanel.add(broomButton);

		robePanel = new JPanel();
		robePanel.setBackground(Color.gray);
		robePanel.setLayout(new GridLayout(2,1));
		robeLabel = new JLabel("Robe", SwingConstants.CENTER);
		robeLabel.setFont(normalFont);
		robeLabel.setBackground(Color.BLACK);
		robeLabel.setForeground(Color.WHITE);
		robeDescLabel = new JLabel("+100 health", SwingConstants.CENTER);
		robeDescLabel.setFont(smallFont);
		robeDescLabel.setBackground(Color.BLACK);
		robeDescLabel.setForeground(Color.WHITE);
		robePanel.add(robeLabel);
		robePanel.add(robeDescLabel);
		shopPanel.add(robePanel);
		robePriceLabel = new JLabel("800", SwingConstants.CENTER);
		robePriceLabel.setFont(normalFont);
		robePriceLabel.setBackground(Color.BLACK);
		robePriceLabel.setForeground(Color.WHITE);
		shopPanel.add(robePriceLabel);
		robeButton = new JButton("Buy");
		robeButton.setFont(normalFont);
		robeButton.setBackground(Color.BLACK);
		robeButton.setForeground(Color.GRAY);
//		robeButton.setOpaque(true);
//		robeButton.setBorderPainted(false);
		robeButton.addActionListener(this);
		shopPanel.add(robeButton);

		wandPanel = new JPanel();
		wandPanel.setBackground(Color.gray);
		wandPanel.setLayout(new GridLayout(2,1));
		wandLabel = new JLabel("Wand", SwingConstants.CENTER);
		wandLabel.setFont(normalFont);
		wandLabel.setBackground(Color.BLACK);
		wandLabel.setForeground(Color.WHITE);
		wandDescLabel = new JLabel("More Damage", SwingConstants.CENTER);
		wandDescLabel.setFont(smallFont);
		wandDescLabel.setBackground(Color.BLACK);
		wandDescLabel.setForeground(Color.WHITE);
		wandPanel.add(wandLabel);
		wandPanel.add(wandDescLabel);
		shopPanel.add(wandPanel);
		wandPriceLabel = new JLabel("1000", SwingConstants.CENTER);
		wandPriceLabel.setFont(normalFont);
		wandPriceLabel.setBackground(Color.BLACK);
		wandPriceLabel.setForeground(Color.WHITE);
		shopPanel.add(wandPriceLabel);
		wandButton = new JButton("Buy");
		wandButton.setFont(normalFont);
		wandButton.setBackground(Color.BLACK);
		wandButton.setForeground(Color.GRAY);
//		wandButton.setOpaque(true);
//		wandButton.setBorderPainted(false);
		wandButton.addActionListener(this);
		shopPanel.add(wandButton);

		menuPanel.setVisible(false);

		exitPanel = new JPanel();
		exitPanel.setBounds(300, 475, 200, 50);
		exitPanel.setBackground(Color.gray);
		exitPanel.setLayout(new GridLayout(1, 1));
//		exitPanel.setVisible(!gameActive);

		exitButton = new JButton("Exit");
		exitButton.setFont(normalFont);
		exitButton.setBackground(Color.BLACK);
		exitButton.setForeground(Color.GRAY);
//		exitButton.setOpaque(true);
//		exitButton.setBorderPainted(false);
		exitButton.addActionListener(this);
		exitPanel.add(exitButton);

		add(moneyPanel);
		add(shopPanel);
		add(exitPanel);

	}

}
