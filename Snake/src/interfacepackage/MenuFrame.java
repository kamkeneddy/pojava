package interfacepackage;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingWorker;

import resultspackage.Player;
import resultspackage.PlayerNamesfFile;
import resultspackage.Result;
import resultspackage.ResultsfFile;






public class MenuFrame extends JFrame{


	ImageBackgroundPanel mainMenuPanel;
	ImageBackgroundPanel optionsPanel;
	ImageBackgroundPanel resultsPanel;
	ImageBackgroundPanel gamePreparationPanel;
	ImageBackgroundPanel choosePlayerPanel, choosePlayersPanel;
	ImageBackgroundPanel addNewPlayerPanelfSingle,addNewPlayerPanelfMulti;
	
	JButton buttonStartGame;
	JButton buttonOptions;
	JButton buttonResults;
	JButton buttonExit;
	
	JLabel arenasLabel, snakeColorsLabelPlayerOne, snakeColorsLabelPlayerTwo;
	String [] arenas = {"Forest","Desert","Winter"};
	JComboBox<String> comboBoxBackground;
	JButton buttonToMenufOptions;
	String [] snakecolors = {"Blue", "Grey", "Red"};
	JComboBox<String> comboBoxSnakesPlayerOne;
	JComboBox<String> comboBoxSnakesPlayerTwo;
	
	JEditorPane resultsPane;
	JButton buttonToMenufResults;
	ResultsfFile  resultsToDisplay;
	
	JButton buttonToMenufGamePreparation,buttonContinue;
	JRadioButton rbuttonEasy, rbuttonMedium, rbuttonHard;
	JRadioButton rbuttonSingleplayer, rbuttonMultiplayer;
	JLabel difLevel, numOfPlayers;
	int levelfDifficulty;
	
	JLabel chooseOnlyPlayerLabel;
	JLabel choosePlayerOneLabel;
	JLabel choosePlayerTwoLabel;
	JButton buttonAddNewPlayer1,buttonAddNewPlayer2;
	JButton buttonToGameSingle, buttonToGameMulti;
	JButton toGamePrepPanelfChoosePlayer,toGamePrepPanelfChoosePlayers;
	JComboBox<String> chooseOnlyPlayerName;
	JComboBox<String> choosePlayerOneName;
	JComboBox<String> choosePlayerTwoName;
	String [] empty= {""};
	
	JTextField newNameFieldfSingle, newNameFieldfMulti;
	JButton buttonSubmitNewNamefSingle, buttonSubmitNewNamefMulti;
	
	GamePanel gamePanel; 
	
	
	public MenuFrame()
	{
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(720,480);
		this.setResizable(false);
																					/*
																					 * mainMenuPanel Autor: Mateusz Konopka
																					 */
		mainMenuPanel = new ImageBackgroundPanel(new ImageIcon(getClass().getClassLoader().getResource("Background.jpg")).getImage());
		buttonStartGame = new JButton();
		buttonStartGame.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Nowa_gra.jpg")));
		buttonOptions = new JButton();
		buttonOptions.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Opcje.jpg")));
		buttonResults = new JButton();
		buttonResults.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Wyniki.jpg")));
		buttonExit = new JButton();
		buttonExit.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Wyjscie.jpg")));

		buttonExit.addActionListener(new ExitListener());
		buttonOptions.addActionListener(new OptionsListener());
		buttonResults.addActionListener(new ResultsListener());
		buttonStartGame.addActionListener(new ToGamePreparationListener());
		
		mainMenuPanel.setLayout(new GridLayout(4,1,0,66));
		mainMenuPanel.setBorder(BorderFactory.createEmptyBorder(66, 217, 66, 217));
		mainMenuPanel.add(buttonStartGame);
		mainMenuPanel.add(buttonOptions);
		mainMenuPanel.add(buttonResults);
		mainMenuPanel.add(buttonExit);
		
		this.add(mainMenuPanel);
																					/*
																				 	* optionsPanel Autor: Kamil Pasik
																				 	*/
		
		optionsPanel = new ImageBackgroundPanel(new ImageIcon(getClass().getClassLoader().getResource("Background.jpg")).getImage());
		optionsPanel.setLayout(new GridLayout(7,1,0,30));
		optionsPanel.setBorder(BorderFactory.createEmptyBorder(30,217,30,217));
		arenasLabel = new JLabel("Typ areny");
		comboBoxBackground = new JComboBox<String>(arenas);
		comboBoxBackground.addActionListener(new BackgroundColorListener());
		snakeColorsLabelPlayerOne = new JLabel("Kolor węży gracza I");
		snakeColorsLabelPlayerTwo = new JLabel("Kolor węży gracza II");
		comboBoxSnakesPlayerOne = new JComboBox<String>(snakecolors);
		comboBoxSnakesPlayerOne.addActionListener(new SnakesColorListenerPlayerOne());
		comboBoxSnakesPlayerTwo = new JComboBox<String>(snakecolors);
		comboBoxSnakesPlayerTwo.setSelectedIndex(2);
		comboBoxSnakesPlayerTwo.addActionListener(new SnakesColorListenerPlayerTwo());
		optionsPanel.add(arenasLabel);
		optionsPanel.add(comboBoxBackground);
		optionsPanel.add(snakeColorsLabelPlayerOne);
		optionsPanel.add(comboBoxSnakesPlayerOne);
		optionsPanel.add(snakeColorsLabelPlayerTwo);
		optionsPanel.add(comboBoxSnakesPlayerTwo);
		buttonToMenufOptions = new JButton();
		buttonToMenufOptions.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Wroc.jpg")));
		buttonToMenufOptions.addActionListener(new BackFromOptionsListener());
		optionsPanel.add(buttonToMenufOptions);
		
		
																						/*
																						 * resultsPanel Autor: Mateusz Konopka
																						 */
		resultsPanel = new ImageBackgroundPanel(new ImageIcon(getClass().getClassLoader().getResource("Background.jpg")).getImage());
		resultsPanel.setLayout(new BorderLayout(0,20));
		resultsPanel.setBorder(BorderFactory.createEmptyBorder(20, 130, 20, 130));
		resultsPane = new JEditorPane();
		buttonToMenufResults = new JButton();	
		buttonToMenufResults.setPreferredSize(new Dimension(130,50));
		buttonToMenufResults.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Wroc.jpg")));
		buttonToMenufResults.addActionListener(new BackFromResultsListener());
		resultsPanel.add(resultsPane, BorderLayout.CENTER);
		resultsPanel.add(buttonToMenufResults, BorderLayout.SOUTH);
																					/*
																					 * gamePreparationPanel Autor: Mateusz Konopka
																					 */
		
		gamePreparationPanel = new ImageBackgroundPanel(new ImageIcon(getClass().getClassLoader().getResource("Background.jpg")).getImage());
		rbuttonEasy = new JRadioButton("Łatwy");
		rbuttonMedium = new JRadioButton("Średni");
		rbuttonHard = new JRadioButton("Trudny");
		difLevel = new JLabel("Poziom Trudności:");
		numOfPlayers = new JLabel("Tryb Gry:");
		buttonToMenufGamePreparation = new JButton();
		buttonToMenufGamePreparation.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Wroc.jpg")));
		buttonToMenufGamePreparation.addActionListener(new BackFromGamePrepListener());
		buttonContinue = new JButton();
		buttonContinue.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Dalej.jpg")));
		buttonContinue.addActionListener(new ContinueToPlayerNameListener());
		
		ButtonGroup groupDifLevel = new ButtonGroup();
		groupDifLevel.add(rbuttonEasy);
		groupDifLevel.add(rbuttonMedium);
		groupDifLevel.add(rbuttonHard);
		rbuttonEasy.addActionListener(new EasyDifListener());
		rbuttonMedium.addActionListener(new MediumDifListener());
		rbuttonHard.addActionListener(new HardDifListener());
		rbuttonEasy.setSelected(true);
		
		rbuttonSingleplayer = new JRadioButton("Jeden Gracz");
		rbuttonMultiplayer = new JRadioButton("Wielu Graczy");
		ButtonGroup groupNumOfPlayers = new ButtonGroup();
		groupNumOfPlayers.add(rbuttonSingleplayer);
		groupNumOfPlayers.add(rbuttonMultiplayer);
		rbuttonSingleplayer.setSelected(true);
		
		gamePreparationPanel.setLayout(new GridLayout(9,1,0,25));
		gamePreparationPanel.setBorder(BorderFactory.createEmptyBorder(0, 217, 0, 217));
		gamePreparationPanel.add(difLevel);
		gamePreparationPanel.add(rbuttonEasy);
		gamePreparationPanel.add(rbuttonMedium);
		gamePreparationPanel.add(rbuttonHard);
		gamePreparationPanel.add(numOfPlayers);
		gamePreparationPanel.add(rbuttonSingleplayer);
		gamePreparationPanel.add(rbuttonMultiplayer);
		gamePreparationPanel.add(buttonToMenufGamePreparation);
		gamePreparationPanel.add(buttonContinue);
		
																						/*
																						 * choosePlayerPanel Autor: Mateusz Konopka
																						 */
		choosePlayerPanel = new ImageBackgroundPanel(new ImageIcon(getClass().getClassLoader().getResource("Background.jpg")).getImage());
		choosePlayerPanel.setLayout(new GridLayout(5,1,0,50));
		choosePlayerPanel.setBorder(BorderFactory.createEmptyBorder(50, 217, 50, 217));
		chooseOnlyPlayerLabel = new JLabel("Wybierz Gracza:");
		chooseOnlyPlayerName = new JComboBox<String>(empty);
		PlayerNamesfFile playerNames = new PlayerNamesfFile("player_names.txt");
			for(int i=0;i<playerNames.namesList.size();i++)
			chooseOnlyPlayerName.addItem(playerNames.namesList.get(i));

			
		buttonAddNewPlayer1 = new JButton();
		buttonAddNewPlayer1.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Nowy_gracz.jpg")));
		buttonAddNewPlayer1.addActionListener(new AddNewPlayerListenerfSingle());
		buttonToGameSingle = new JButton();
		buttonToGameSingle.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Start_gry.jpg")));
		buttonToGameSingle.addActionListener(new ToGameSingleListener());
		toGamePrepPanelfChoosePlayer = new JButton();
		toGamePrepPanelfChoosePlayer.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Wroc.jpg")));
		toGamePrepPanelfChoosePlayer.addActionListener(new BackFromChoosePlayerListener());
		
		choosePlayerPanel.add(chooseOnlyPlayerLabel);
		choosePlayerPanel.add(chooseOnlyPlayerName);
		choosePlayerPanel.add(buttonAddNewPlayer1);
		choosePlayerPanel.add(buttonToGameSingle);
		choosePlayerPanel.add(toGamePrepPanelfChoosePlayer);
		
																						/*
																						 * choosePlayersPanel Autor: Mateusz Konopka
																						 */
		choosePlayersPanel = new ImageBackgroundPanel(new ImageIcon(getClass().getClassLoader().getResource("Background.jpg")).getImage());
		choosePlayersPanel.setLayout(new GridLayout(7,1,0,30));
		choosePlayersPanel.setBorder(BorderFactory.createEmptyBorder(30,217,30,217));
		choosePlayerOneLabel = new JLabel("Wybierz Gracza I:");
		choosePlayerOneName = new JComboBox<String>(empty);
			for(int i=0;i<playerNames.namesList.size();i++)
			  choosePlayerOneName.addItem(playerNames.namesList.get(i));
		choosePlayerTwoLabel = new JLabel("Wybierz Gracza II:");
		choosePlayerTwoName = new JComboBox<String>(empty);
		for(int i=0;i<playerNames.namesList.size();i++)
			  choosePlayerTwoName.addItem(playerNames.namesList.get(i));
		buttonAddNewPlayer2 = new JButton();
		buttonAddNewPlayer2.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Nowy_gracz.jpg")));
		buttonAddNewPlayer2.addActionListener(new AddNewPlayerListenerfMulti());
		buttonToGameMulti = new JButton();
		buttonToGameMulti.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Start_gry.jpg")));
		buttonToGameMulti.addActionListener(new ToGameMultiListener());
		toGamePrepPanelfChoosePlayers = new JButton();
		toGamePrepPanelfChoosePlayers.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Wroc.jpg")));
		toGamePrepPanelfChoosePlayers.addActionListener(new BackFromChoosePlayerListeners());
		
		choosePlayersPanel.add(choosePlayerOneLabel);
		choosePlayersPanel.add(choosePlayerOneName);
		choosePlayersPanel.add(choosePlayerTwoLabel);
		choosePlayersPanel.add(choosePlayerTwoName);
		choosePlayersPanel.add(buttonAddNewPlayer2);
		choosePlayersPanel.add(buttonToGameMulti);
		choosePlayersPanel.add(toGamePrepPanelfChoosePlayers);
		
																							/*
																							 * addNewPlayerPanelfSingle Autor: Kamil Pasik
																							 */
		addNewPlayerPanelfSingle = new ImageBackgroundPanel(new ImageIcon(getClass().getClassLoader().getResource("Background.jpg")).getImage());
		addNewPlayerPanelfSingle.setLayout(new GridLayout(2,1,0,100));
		addNewPlayerPanelfSingle.setBorder(BorderFactory.createEmptyBorder(120,217,120,217));
		newNameFieldfSingle = new JTextField(20);
		buttonSubmitNewNamefSingle = new JButton();
		buttonSubmitNewNamefSingle.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Dodaj.jpg")));
		buttonSubmitNewNamefSingle.addActionListener(new SubmitNamefSingleListener());
		addNewPlayerPanelfSingle.add(newNameFieldfSingle);
		addNewPlayerPanelfSingle.add(buttonSubmitNewNamefSingle);
		
		
																								/*
																								 * addNewPlayerPanelfMulti Autor: Kamil Pasik
																								 */
		
		addNewPlayerPanelfMulti = new ImageBackgroundPanel(new ImageIcon(getClass().getClassLoader().getResource("Background.jpg")).getImage());
		addNewPlayerPanelfMulti.setLayout(new GridLayout(2,1,0,100));
		addNewPlayerPanelfMulti.setBorder(BorderFactory.createEmptyBorder(120,217,120,217));
		newNameFieldfMulti= new JTextField(20);
		buttonSubmitNewNamefMulti = new JButton();
		buttonSubmitNewNamefMulti.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Dodaj.jpg")));
		buttonSubmitNewNamefMulti.addActionListener(new SubmitNamefMultiListener());
		addNewPlayerPanelfMulti.add(newNameFieldfMulti);
		addNewPlayerPanelfMulti.add(buttonSubmitNewNamefMulti);
		
		
		gamePanel = new GamePanel(new ImageIcon(getClass().getClassLoader().getResource("Background.jpg")).getImage());
		gamePanel.setPlayerTwoSnakeTheme(
				 new SnakeTheme("RedHead_left.png","RedHead_right.png","RedHead_up.png","RedHead_down.png","RedBody.png"));
		levelfDifficulty = 1;
	}
	
	class ExitListener implements ActionListener{												//Autor: Mateusz Konopka

		@Override
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
			
		}	
	}
	
	class OptionsListener implements ActionListener{											//Autor: Kamil Pasik

		@Override
		public void actionPerformed(ActionEvent e) {
			
			
			MenuFrame.this.remove(mainMenuPanel);
			MenuFrame.this.add(optionsPanel);
			MenuFrame.this.revalidate();
			MenuFrame.this.repaint();	
		}
	}
	
	class ResultsListener implements ActionListener{											//Autor: Kamil Pasik
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			if( new File(getClass().getClassLoader().getResource("results.txt").getPath()).exists())
			try {
				resultsToDisplay = new ResultsfFile("results.txt");
				resultsPane.setText(resultsToDisplay.getResultsString());
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
			

			
			MenuFrame.this.remove(mainMenuPanel);
			MenuFrame.this.add(resultsPanel);
			MenuFrame.this.revalidate();
			MenuFrame.this.repaint();	
		}
	}
	
	class ToGamePreparationListener implements ActionListener{											//Autor: Mateusz Konpka
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			MenuFrame.this.remove(mainMenuPanel);
			MenuFrame.this.add(gamePreparationPanel);
			MenuFrame.this.revalidate();
			MenuFrame.this.repaint();
		}
	}
	
	class BackFromOptionsListener implements ActionListener{									//Autor: Kamil Pasik

		@Override
		public void actionPerformed(ActionEvent e) {
			
			MenuFrame.this.remove(optionsPanel);
			MenuFrame.this.add(mainMenuPanel);
			MenuFrame.this.revalidate();
			MenuFrame.this.repaint();
		}
	}
	
	class BackFromResultsListener implements ActionListener{									//Autor: Mateusz Konopka

		@Override
		public void actionPerformed(ActionEvent e) {
			
			MenuFrame.this.remove(resultsPanel);
			MenuFrame.this.add(mainMenuPanel);
			MenuFrame.this.revalidate();
			MenuFrame.this.repaint();
			
		}
		
	}
	
	class BackFromGamePrepListener implements ActionListener{									//Autor: Mateusz Konopka
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			MenuFrame.this.remove(gamePreparationPanel);
			MenuFrame.this.add(mainMenuPanel);
			MenuFrame.this.revalidate();
			MenuFrame.this.repaint();
		}
	}
	

	class EasyDifListener implements ActionListener{											//Autor: Mateusz Konopka

		@Override
		public void actionPerformed(ActionEvent e) {
			if(rbuttonEasy.isSelected())
				levelfDifficulty = 1;
		}
	}
	
	class MediumDifListener implements ActionListener{											//Autor: Mateusz Konopka

		@Override
		public void actionPerformed(ActionEvent e) {
			if(rbuttonMedium.isSelected())
				levelfDifficulty = 2;
		}
	}
	
	class HardDifListener implements ActionListener{											//Autor: Mateusz Konopka

		@Override
		public void actionPerformed(ActionEvent e) {
			if(rbuttonHard.isSelected())
				levelfDifficulty = 3;
			
		}
		
	}
	
	class ContinueToPlayerNameListener implements ActionListener{								//Autorzy: Mateusz Konopka

		@Override
		public void actionPerformed(ActionEvent e) {
			MenuFrame.this.remove(gamePreparationPanel);
				if(rbuttonSingleplayer.isSelected())
					MenuFrame.this.add(choosePlayerPanel);
				else
					MenuFrame.this.add(choosePlayersPanel);
			MenuFrame.this.revalidate();
			MenuFrame.this.repaint();
			
		}
		
	}
	
	class BackFromChoosePlayerListener implements ActionListener{								//Autor: Mateusz Konopka

		@Override
		public void actionPerformed(ActionEvent e) {
			MenuFrame.this.remove(choosePlayerPanel);
			MenuFrame.this.add(gamePreparationPanel);
			MenuFrame.this.revalidate();
			MenuFrame.this.repaint();
			
		}
		
	}
	
	class BackFromChoosePlayerListeners implements ActionListener{								//Autor: Mateusz Konopka
		
		@Override
		public void actionPerformed(ActionEvent e) {
			MenuFrame.this.remove(choosePlayersPanel);
			MenuFrame.this.add(gamePreparationPanel);
			MenuFrame.this.revalidate();
			MenuFrame.this.repaint();
		}
	}
	
	class AddNewPlayerListenerfSingle implements ActionListener{								//Autor: Kamil Pasik
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			MenuFrame.this.remove(choosePlayerPanel);
			MenuFrame.this.add(addNewPlayerPanelfSingle);
			MenuFrame.this.revalidate();
			MenuFrame.this.repaint();
			
		}
	}
	
	class AddNewPlayerListenerfMulti implements ActionListener{									//Autor: Kamil Pasik
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			MenuFrame.this.remove(choosePlayersPanel);
			MenuFrame.this.add(addNewPlayerPanelfMulti);
			MenuFrame.this.revalidate();
			MenuFrame.this.repaint();
			
		}
	}

	
	class SubmitNamefSingleListener implements ActionListener{									//Autor: Kamil Pasik
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			Player player = new Player(newNameFieldfSingle.getText());

			try {
				player.savePlayer();
				chooseOnlyPlayerName.addItem(newNameFieldfSingle.getText());
				choosePlayerOneName.addItem(newNameFieldfSingle.getText());
				choosePlayerTwoName.addItem(newNameFieldfSingle.getText());
			} catch (IOException e1) {
				e1.printStackTrace();
			}

			
			MenuFrame.this.remove(addNewPlayerPanelfSingle);
			MenuFrame.this.add(choosePlayerPanel);
			MenuFrame.this.revalidate();
			MenuFrame.this.repaint();
		}
	}
	
	class SubmitNamefMultiListener implements ActionListener{									//Autor Kamil Pasik
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			Player player = new Player(newNameFieldfMulti.getText());

			try {
				player.savePlayer();
				choosePlayerOneName.addItem(newNameFieldfMulti.getText());
				choosePlayerTwoName.addItem(newNameFieldfMulti.getText());
				chooseOnlyPlayerName.addItem(newNameFieldfMulti.getText());
			} catch (IOException e1) {
				e1.printStackTrace();
			}

			
			MenuFrame.this.remove(addNewPlayerPanelfMulti);
			MenuFrame.this.add(choosePlayersPanel);
			MenuFrame.this.revalidate();
			MenuFrame.this.repaint();
		}
	}
	
	
	class BackgroundColorListener implements ActionListener{									//Autor Mateusz Konopka

		@Override
		public void actionPerformed(ActionEvent e) {
			if(comboBoxBackground.getSelectedIndex()==0)
				{
				 gamePanel.changeBackgroud(new ImageIcon(getClass().getClassLoader().getResource("Background.jpg")).getImage());
				}
			if(comboBoxBackground.getSelectedIndex()==1)
				{
				 gamePanel.changeBackgroud(new ImageIcon(getClass().getClassLoader().getResource("Desert_Arena.jpg")).getImage());
				}
			if(comboBoxBackground.getSelectedIndex()==2)
				{
				gamePanel.changeBackgroud(new ImageIcon(getClass().getClassLoader().getResource("Winter_Arena.jpg")).getImage());
				}

		}	
	}
	
	class SnakesColorListenerPlayerOne implements ActionListener{								//Autor Kamil Pasik

		@Override
		public void actionPerformed(ActionEvent e) {
			if(comboBoxSnakesPlayerOne.getSelectedIndex()==0)
				{
				 gamePanel.setPlayerOneSnakeTheme(
						 new SnakeTheme("BlueHead_left.png","BlueHead_right.png","BlueHead_up.png","BlueHead_down.png","BlueBody.png"));
				}
			if(comboBoxSnakesPlayerOne.getSelectedIndex()==1)
				{
				 gamePanel.setPlayerOneSnakeTheme(
						 new SnakeTheme("GreyHead_left.png","GreyHead_right.png","GreyHead_up.png","GreyHead_down.png","GreyBody.png"));
				}
			if(comboBoxSnakesPlayerOne.getSelectedIndex()==2)
				{
				 gamePanel.setPlayerOneSnakeTheme(
						 new SnakeTheme("RedHead_left.png","RedHead_right.png","RedHead_up.png","RedHead_down.png","RedBody.png"));
				}

		}	
	}
	
	class SnakesColorListenerPlayerTwo implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(comboBoxSnakesPlayerTwo.getSelectedIndex()==0)
				{
				 gamePanel.setPlayerTwoSnakeTheme(
						 new SnakeTheme("BlueHead_left.png","BlueHead_right.png","BlueHead_up.png","BlueHead_down.png","BlueBody.png"));
				}
			if(comboBoxSnakesPlayerTwo.getSelectedIndex()==1)
				{
				 gamePanel.setPlayerTwoSnakeTheme(
						 new SnakeTheme("GreyHead_left.png","GreyHead_right.png","GreyHead_up.png","GreyHead_down.png","GreyBody.png"));
				}
			if(comboBoxSnakesPlayerTwo.getSelectedIndex()==2)
				{
				 gamePanel.setPlayerTwoSnakeTheme(
						 new SnakeTheme("RedHead_left.png","RedHead_right.png","RedHead_up.png","RedHead_down.png","RedBody.png"));
				}
		}	
	}
	
	
	class ToGameSingleListener implements ActionListener{													//Autor: Mateusz Konopka
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			gamePanel.setMulti(false);
			MenuFrame.this.remove(choosePlayerPanel);
			MenuFrame.this.add(gamePanel);
			gamePanel.setFocusable(true);
		    gamePanel.requestFocus();
		    gamePanel.setDifLevel(levelfDifficulty);
		    gamePanel.playerAvatarOne.preparefNewGame();
		    Result resultPlayerOne = new Result(false);
		    resultPlayerOne.setDifLevel(levelfDifficulty);
		    resultPlayerOne.setPlayerOneName(chooseOnlyPlayerName.getSelectedItem().toString());
			MenuFrame.this.revalidate();
			MenuFrame.this.repaint();
			
			Thread gamePanelThread = new Thread(gamePanel);
			
			SwingWorker swingWorker = new SwingWorker() {

	            @Override
	            protected Boolean doInBackground() throws Exception {
	            	
	            	gamePanelThread.start();
	            	gamePanelThread.join();
	            	
	            	JOptionPane.showMessageDialog(null,"Koniec Gry");
	            	resultPlayerOne.setfPlayerOne(gamePanel.playerAvatarOne.getScore());
        			resultPlayerOne.saveResult();
	            	
        			MenuFrame.this.remove(gamePanel);
        			MenuFrame.this.add(mainMenuPanel);
        			MenuFrame.this.revalidate();
        			MenuFrame.this.repaint();
        			
        			gamePanel.playerAvatarOne.preparefNewGame();
	                return null;
	            }
			};
			
			
			EventQueue.invokeLater(new Runnable() {
	            @Override
	            public void run() {
            			swingWorker.execute();
            			
	            }
	        });
	        

	}
	}
	
	class ToGameMultiListener implements ActionListener{													//Autor: Mateusz Konopka
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			gamePanel.setMulti(true);
			MenuFrame.this.remove(choosePlayersPanel);
			MenuFrame.this.add(gamePanel);
			gamePanel.setFocusable(true);
		    gamePanel.requestFocus();
		    gamePanel.setDifLevel(levelfDifficulty);
		    gamePanel.playerAvatarOne.preparefNewGame();
		    gamePanel.playerAvatarTwo.preparefNewGame();
		    Result resultfMulti = new Result(true);
		    resultfMulti.setDifLevel(levelfDifficulty);
		    resultfMulti.setPlayerOneName(choosePlayerOneName.getSelectedItem().toString());
		    resultfMulti.setPlayerTwoName(choosePlayerTwoName.getSelectedItem().toString());
			MenuFrame.this.revalidate();
			MenuFrame.this.repaint();
			
			Thread gamePanelThread = new Thread(gamePanel);
			
			SwingWorker swingWorker = new SwingWorker() {

	            @Override
	            protected Boolean doInBackground() throws Exception {
	            	
	            	gamePanelThread.start();
	            	gamePanelThread.join();
	            	
	            	JOptionPane.showMessageDialog(null,"Koniec Gry");
	            	resultfMulti.setfPlayerOne(gamePanel.playerAvatarOne.getScore());
	            	resultfMulti.setfPlayerTwo(gamePanel.playerAvatarTwo.getScore());
        			resultfMulti.saveResult();
	            	
        			MenuFrame.this.remove(gamePanel);
        			MenuFrame.this.add(mainMenuPanel);
        			MenuFrame.this.revalidate();
        			MenuFrame.this.repaint();
        			
        			gamePanel.playerAvatarOne.preparefNewGame();
        			gamePanel.playerAvatarTwo.preparefNewGame();
	                return null;
	            }
			};
			
			
			EventQueue.invokeLater(new Runnable() {
	            @Override
	            public void run() {
            			swingWorker.execute();
            			
	            }
	        });
	        

	}
	}

}//