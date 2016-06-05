import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.Random;
import java.text.DecimalFormat;
import java.util.Arrays;

public class MEGAMILLIONS extends JFrame
{
    //Variables for Size of JFrame
    private final int WIDTH = 500;
    private final int HEIGHT = 500;
    //Constants for arrays
     private final int FIELD1 = 5;
     private final int WINNING = 5;
     private final int RANDOM = 5;
     private final int SHOW = 5;
     //Variables for single number
     private int single;
     private int winningSingle;
     //Declare Panels
     private JPanel northPanel;
     private JPanel centerPanel;
     private JPanel southPanel;
     private JPanel westPanel;
     private JPanel eastPanel;
     //Declare buttons
     private JButton playButton;
     private JButton randomButton;
     private JButton resetButton;
     //Extra buttons
     private JButton howButton;
     private JButton ruleButton;
     private JButton prizeButton;
     private JButton jackButton;
     private JButton yourMoneyButton;
     private JButton lastButton;
     //Declare Message Labels
     private JLabel number1;
     private JLabel number2;
     private JLabel number3;
     private JLabel number4;
     private JLabel number5;
     //Additional Labels
     private JLabel howTo;
     private JLabel rules;
     private JLabel prizes;
     private JLabel jackLabel;
     private JLabel myMoneyLabel;
     private JLabel lastWinningLabel;
     //Declare TextFields
     private JTextField space1;
     private JTextField space2;
     private JTextField space3;
     private JTextField space4;
     private JTextField space5;
     //Declare Label and Textfield
     //For the single number
     private JLabel singleNumber;
     private JTextField singleSpace;
     //Random number for Single number
     private int singleRandom;
     
     //Declare arrays that work with 
     //Storing numbers from fields
     private int[] lottery = new int[FIELD1];
     private int[] winning = new int[WINNING];
     private int[] random  = new int[RANDOM];
     private int[] show    = new int[SHOW];
     //Prizes
     public int jackpot = 9901700;
     private int myMoney = 0;
     private int prize = 0;
     private int copyPrize = 0;
     
     //Random object 
     Random randomNumbers = new Random();
     DecimalFormat formatter = new DecimalFormat("#,##0.00"); //Decimal object

     /////CONSTRUCTOR/////
     
     public MEGAMILLIONS()
     {
       //Define the Title, Size, Action and Position of JFrame Window
       setTitle("Megamillions Lottery");
       setSize(WIDTH, HEIGHT);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       setLocationRelativeTo(null);
       //Methos that add the Panels to the content pane
       theNorthPanel();
       add(northPanel, BorderLayout.NORTH);
       theCenterPanel();
       add(centerPanel, BorderLayout.CENTER);
       theSouthPanel();
       add(southPanel, BorderLayout.SOUTH);
       theWestPanel();
       add(westPanel, BorderLayout.WEST);       
       theEastPanel();      
       add(eastPanel, BorderLayout.EAST);   
       //Visibility
       setVisible(true);
   
       
    }
     
     private void theNorthPanel()
     {
       //Create the Panel
       northPanel = new JPanel();
         
       //Set the panel to a grid
       northPanel.setLayout(new GridLayout(5, 2, 1, 1));
         
       //Set EmptyBorder to Panel
       northPanel.setBorder(BorderFactory.createTitledBorder("Field 1")); 
                                                                     
       //Create the Labels
       number1 = new JLabel("First Number:");
       number2 = new JLabel("Second Number:");
       number3 = new JLabel("Thrid Number:");
       number4 = new JLabel("Forth Number:");
       number5 = new JLabel("Fifth Number:");
         
         //Create the TextFields
       space1 = new JTextField(5);
       space2 = new JTextField(5);
       space3 = new JTextField(5);
       space4 = new JTextField(5);
       space5 = new JTextField(5);
         
         //Set TextFields to 0's
       space1.setText("0");
       space2.setText("0");
       space3.setText("0");
       space4.setText("0");
       space5.setText("0");
       
         //Add components to Panel                              
       northPanel.add(number1);
       northPanel.add(space1);
       northPanel.add(number2);
       northPanel.add(space2);
       northPanel.add(number3);
       northPanel.add(space3);
       northPanel.add(number4);
       northPanel.add(space4);
       northPanel.add(number5);
       northPanel.add(space5);
       
     }
    
    private void theCenterPanel()
    {
       //Create Panel
       centerPanel = new JPanel();
       
       //Set the panel to flow
       centerPanel.setLayout(new FlowLayout());
       
       //Set border
       centerPanel.setBorder(BorderFactory.createTitledBorder("Field 2"));
       
       //Create Label
       singleNumber = new JLabel("Megaball:");
       
       //Create TextField
       singleSpace = new JTextField(5);
       
       //Set field to 0
       singleSpace.setText("0");
       
       //Add components to Panel
       centerPanel.add(singleNumber);
       centerPanel.add(singleSpace);
    }
    
    private void theSouthPanel()
    {
       //Create Panel
       southPanel = new JPanel();
       
       //Set the panel to flow
       southPanel.setLayout(new FlowLayout());
       
       //Set EmptyBorder to Panel
       southPanel.setBorder(BorderFactory.createTitledBorder("Try your Luck"));
       
       //Create Buttons
       playButton = new JButton("Play");
       randomButton = new JButton("Random");
       resetButton = new JButton("Reset");
       
       //Add buttons to panel
       southPanel.add(playButton);
       southPanel.add(randomButton);
       southPanel.add(resetButton);
       
       //Action Listeners
       playButton.addActionListener(new PlayButton());
       randomButton.addActionListener(new RandomButton());
       resetButton.addActionListener(new ResetButton());
       
    }
    
    private void theWestPanel()
    {
       westPanel = new JPanel();
       //Set the panel to flow
       westPanel.setLayout(new GridLayout(6,1,1,1));
       
       //Set EmptyBorder to Panel
       westPanel.setBorder(BorderFactory.createTitledBorder("Information"));
       
       howTo = new JLabel("How to Play:");
       howButton = new JButton("              ?              ");
       
       rules = new JLabel("Rules:");
       ruleButton = new JButton("        ?        ");
       
       prizes = new JLabel("Winning:");
       prizeButton = new JButton("        ?        ");
       
       westPanel.add(howTo);
       westPanel.add(howButton);
       westPanel.add(rules);
       westPanel.add(ruleButton);
       westPanel.add(prizes);
       westPanel.add(prizeButton);
       
       howButton.addActionListener(new HowButton());
       ruleButton.addActionListener(new RuleButton());
       prizeButton.addActionListener(new PrizesButton());

    }
     private void theEastPanel()
    {
       eastPanel = new JPanel();
       //Set the panel to flow
       eastPanel.setLayout(new GridLayout(6,1,1,1));
       
       //Set EmptyBorder to Panel
       eastPanel.setBorder(BorderFactory.createTitledBorder("Balances"));
       
       
       jackLabel = new JLabel("Today's Jackpot:");
       myMoneyLabel = new JLabel("Your money:");
       lastWinningLabel = new JLabel("Last prize:                        " );
       jackButton = new JButton("JACKPOT!");
       yourMoneyButton = new JButton("MONEY");
       lastButton = new JButton("LAST PRIZE");
       
       
       
       eastPanel.add(jackLabel);
       eastPanel.add(jackButton);
       eastPanel.add(myMoneyLabel);
       eastPanel.add(yourMoneyButton);
       eastPanel.add(lastWinningLabel);
       eastPanel.add(lastButton);
       
       jackButton.addActionListener(new JackButton());
       yourMoneyButton.addActionListener(new YourMoneyButton());
       lastButton.addActionListener(new LastButton());
    }
       
       

       

    
    //Implement Action Listeners
    private class HowButton implements ActionListener
    {
       public void actionPerformed(ActionEvent e)
       {
          JOptionPane.showMessageDialog(null,"Welcome to the Megamillions Lottery!!!\n\n" + "To play select 5 numbers from Field 1 in a range of 1 to 56.\n\n"
                                         + "Select your Megaball number in a range of 1 to 46.\n\n" + "Your numbers will be compared with the random winning numbers generated by the computer.\n\n" +
                                         "Please be aware that zeros or numbers outside the range are not allowed.\n\n" + "Select the Random button to randomly assing numbers to your fields.\n\n" +
                                         "Select the Reset button to clear the fields.\n\n" + "Select the Play button to see the results.\n\n" +
                                         "Check the Balances and Your Money in the Balance panel.\n\n" + "Good Luck!");
       }
       

    }
    private class RuleButton implements ActionListener
    {
       public void actionPerformed(ActionEvent e)
       {
       JOptionPane.showMessageDialog(null,"Rules of Megamillions Lottery.\n\nFill all spaces in Field1.\n\nSelect your Megaball number in Field2.\n\n" +
                                     "Numbers can't be zero or negative values.\n\nNo repeated numbers are allowed.\n\nThe Megaball can match a number in Field1.\n\n" +
                                     "Select you numbers again if a message window appears.\n\nJACKPOT INCREASES EVERYTIME YOU PLAY.");
       }

    }
    private class PrizesButton implements ActionListener
    {
       public void actionPerformed(ActionEvent e)
       {
       JOptionPane.showMessageDialog(null,"Prizes!!!\n\nMatching:\n\nMegaball only: $2.00\n\n1 number plus the Megaball is $3.00\n\n" +
                                    "2 numbers plus the Megaball is $10.00\n\n3 without matching the Megaball is $7.00\n\n"+
                                    "3 numbers plus the Megaball is $150.00\n\n4 numbers without matching the Megaball is $150.00\n\n" +
                                    "4 numbers plus the Megaball is $10,000.00\n\n5 numbers without matching the Megaball is $250,000.00\n\n" +
                                    "5 numbers plus the Megaball is the JACKPOT!");
                                    
             
         
       }

    }
    private class JackButton implements ActionListener
    {
       public void actionPerformed(ActionEvent e)
       {
          JOptionPane.showMessageDialog(null,"The Jackpot today is: $" + formatter.format(jackpot));
       }

    }
    private class YourMoneyButton implements ActionListener
    {
       public void actionPerformed(ActionEvent e)
       {
          JOptionPane.showMessageDialog(null,"Your Money Balance is: $" + formatter.format(myMoney));
       }

    }
    private class LastButton implements ActionListener
    {
       public void actionPerformed(ActionEvent e)
       {
          JOptionPane.showMessageDialog(null,"Last prize was: $" + formatter.format(copyPrize));
       }

    }
    private class PlayButton implements ActionListener
    {
       public void actionPerformed(ActionEvent e)
       {
       //Lottery array will be filled along with single number
       lottery[0] = Integer.parseInt(space1.getText());
       lottery[1] = Integer.parseInt(space2.getText());
       lottery[2] = Integer.parseInt(space3.getText());
       lottery[3] = Integer.parseInt(space4.getText());
       lottery[4] = Integer.parseInt(space5.getText());
       single     = Integer.parseInt(singleSpace.getText());
       //Get winning numbers
       
       int winningAssing;
       for (int index = 0; index < winning.length; index++)
          {
             winningAssing = randomNumbers.nextInt(56) + 1;
             for (int i = 0; i < winning.length; i++)
            {
                while( winning[i] == winningAssing )
                {
                    winningAssing = randomNumbers.nextInt(56) + 1;
                    i = 0; //Restarts the lool i in to check all elements again from 0
                }
             }
             winning[index] = winningAssing;
       }
       winningSingle = randomNumbers.nextInt(46) + 1;
       //PROOF CODE
       //winning[0] = 1;
       //winning[1] = 2;
       //winning[2] = 3;
       //winning[3] = 4;
       //winning[4] = 5;
       //winningSingle = 6;
       
       //Both Lottery and Winning Arrays are filled
       //NOW CHECKS AND BALANCES
       String num1 = ""; 
       String num2 = "";
       String num3 = ""; 
       String num4 = ""; 
       String num5 = "";
       String singleM ="";
       boolean assure = false;
       /////////////////////////////////////
       if(lottery[0] == 0)
       {
          num1 =  "The first number is zero.\n\n";
          assure = true;
       }
       
       else if(lottery[0] < 0 || lottery[0] > 56)
       {
          num1 =  "The first number is not in the range of 1 to 56.\n\n";
          assure = true;
       }
       else if(lottery[0] == lottery[1] || lottery[0] == lottery[2] || lottery[0] == lottery[3] || lottery[0] == lottery[4] ) 
       {
          num1 = "The first number matches another number in a different field.\n\n";
          assure = true;
       }
       ///////////////////////////////////////////
       if(lottery[1] == 0 )
       {
          num2 =  "The second number is zero.\n\n";
          assure = true;
       }
       else if(lottery[1] < 0 || lottery[1] > 56)
       {
          num2 =  "The second number is not in the range of 1 to 56.\n\n";
          assure = true;
       }
       else if(lottery[1] == lottery[2] || lottery[1] == lottery[3] || lottery[1] == lottery[4] ) 
       {
          num2 = "The second number matches another number in a different field.\n\n";
          assure = true;
       }

       /////////////////////////////////////////////
       
       if(lottery[2] == 0 )
       {
          num3 =  "The thrid number is zero.\n\n";
          assure = true;
       }
       else if(lottery[2] < 0 || lottery[2] > 56)
       {
          num3 =  "The third number is not in the range of 1 to 56.\n\n";
          assure = true;
       }
       else if(lottery[2] == lottery[3] || lottery[2] == lottery[4]) 
       {
          num3 = "The third number matches another number in a different field.\n\n";
          assure = true;
       }
       //////////////////////////////////////////


       if(lottery[3] == 0 )
       {
          num4 =  "The forth number is zero.\n\n";
          assure = true;
       }
       else if(lottery[3] < 0 || lottery[3] > 56)
       {
          num4 =  "The forth number is not in the range of 1 to 56.\n\n";
          assure = true;
       }
       else if(lottery[3] == lottery[4] ) 
       {
          num4 = "The forth number matches another number in a different field.\n\n";
          assure = true;
       }

       ///////////////////////////////////////////
       if(lottery[4] == 0)
       {
          num5 = "The fifth number is zero.\n\n";
          assure = true;
       }
       else if(lottery[4] < 0 || lottery[4] > 56)
       {
          num5 =  "The fifth number is not in the range of 1 to 56.\n\n";
          assure = true;
       }
       ////////////////////////////////////////////
       if(single == 0)
       {
          singleM = "The Megaball is zero.\n\n";
          assure = true;
       }
       else if(single < 0 || single > 46)
       {
          singleM = "The Megaball is not in the range of 1 to 46.\n\n";
          assure = true;
       }

       if(assure)
       {
          JOptionPane.showMessageDialog(null,num1 + num2 + num3 + num4 + num5 + singleM + "Please change your numbers." + 
                                                  "\n\nREMEMBER: Zeros are not allowed as playing numbers.");
       }
       
       if(!assure)
       {
          int matches = 0;
          boolean megaWin = false;
          
          for (int counter = 0; counter < winning.length; counter++)
          {
              for (int in = 0; in < winning.length; in++)
              {
                 if(lottery[counter] == winning[in])
                 {
                    show[matches] = lottery[counter];
                    matches++;
                 }
              }
           }
           
           if (single == winningSingle)
           {
              megaWin = true;
           }
           String notification = "";
           if(matches == 5 && megaWin)
           {  prize = jackpot;
              myMoney += jackpot;
              jackpot = 0;
              notification = "CONGRATULATIONS YOU HAVE WON THE LOTTERY.\n\nJACKPOT!!!!!!!!!\n\n";
           }
           else if(matches == 5)
           {
              prize = 250000;
              myMoney += prize;
              jackpot -= prize;
              notification = "You have matched 5 numbers without the Megaball.\n\nYOU WERE SO CLOSE!!!!!\n\n";
           }
           else if(matches == 4 && megaWin)
           {
              prize = 10000;
              myMoney += prize;
              jackpot -= prize;
              notification = "You have matched 4 numbers with the Megaball.\n\nYou were close!!!!\n\n";
           }
           else if(matches == 4)
           {
              prize = 150;
              myMoney += prize;
              jackpot -= prize;
              notification = "You have matched 4 numbers without the Megaball.\n\nYou are so lucky!!!\n\n";
           }
           else if(matches ==3 && megaWin)
           {
              prize = 150;
              myMoney += prize;
              jackpot -= prize;
              notification = "You have matched 3 numbers with the Megaball.\n\nYou are so lucky!!!\n\n";
           }
           else if(matches == 3)
           {
              prize = 7;
              myMoney += prize;
              jackpot -= prize;
              notification = "You have matched 3 numbers without the Megaball.\n\nYou are lucky!\n\n";
           }
           else if(matches == 2 && megaWin)
           {
              prize = 10;
              myMoney += prize;
              jackpot -= prize;
              notification = "You have matched 2 numbers with the Megaball.\n\nYou have luck today.\n\n";
           }
           else if(matches == 1 && megaWin)
           {
              prize = 3;
              myMoney += prize;
              jackpot -= prize;
              notification = "You have matched 1 number with the Megaball.\n\nLucky!\n\n";
           }
           else if(megaWin)
           {
              prize = 2;
              myMoney += prize;
              jackpot -= prize;
              notification = "You have matched the Megaball.\n\nNice try!\n\n";
           }
           else
           {
              notification = "Sorry, Try Again";
           }
           String megaText = "";
           if(megaWin)
           {
              megaText = "Did the Megaball match? YES!";
           }
           else
           {
              megaText = "Did the Megaball match? NO!";
           }
           copyPrize = prize;      
           JOptionPane.showMessageDialog(null,"Winning Numbers:    " + Arrays.toString(winning) +  "\nYour Numbers:           " 
                                          + Arrays.toString(lottery) +  "\nYour matches:            " + Arrays.toString(show) + "\n" 
                                         + "\nMegaball: " + winningSingle + "\nYour Megaball: " + single + "\n" +megaText + 
                                         "\n\nThe prize is: $" + formatter.format(prize) + "\n" +  notification );
           
           
           
           
          for (int cleaner = 0; cleaner < winning.length; cleaner++)
          {
             lottery[cleaner] = 0;
             winning[cleaner] = 0;
             show[cleaner] = 0;
          }
          jackpot += 11019000;
          prize = 0;
          notification = "";
          single = 0;
          winningSingle = 0;
          matches = 0;
          megaWin = false;
       }      
     }
    }
    
     private class RandomButton implements ActionListener
    {
       public void actionPerformed(ActionEvent e)
       {
          int assing;
          
          for (int index = 0; index < random.length; index++)
          {
             assing = randomNumbers.nextInt(56) + 1;
             for (int i = 0; i < random.length; i++)
             {
                while( random[i] == assing )
                {
                    assing = randomNumbers.nextInt(56) + 1;
                    i = 0; //Restarts the lool i in to check all elements again from 0
                }
             }
             random[index] = assing;
          }
                    
          singleRandom = randomNumbers.nextInt(46) + 1;
          
          space1.setText("" + random[0]);
          space2.setText("" + random[1]);
          space3.setText("" + random[2]);
          space4.setText("" + random[3]);
          space5.setText("" + random[4]);
          singleSpace.setText("" + singleRandom);
          
          
          //Code to ensure that the RANDOM array stays empty
          ///For the next generation of numbers
           for (int index = 0; index < random.length; index++)
          {
             random[index] = 0;
          }          
               
       }
    }
    
     private class ResetButton implements ActionListener
    {
       public void actionPerformed(ActionEvent e)
       {
          space1.setText("0");
          space2.setText("0");
          space3.setText("0");
          space4.setText("0");
          space5.setText("0");
          singleSpace.setText("0");
          
           for (int index = 0; index < random.length; index++)
          {
             random[index] = 0;
          }

       
       }
    }


          
    public static void main(String[] args)
    {
       new MEGAMILLIONS();
    }
 }