//filename : RPS.java
//author: Eric
//date: 2/6/19
//Basic game of rock, paper, scissors. 
/*Java application that will have the user enter/type a string of text from a menu which represents one of the 3 items(rock, paper or scissors). Computer will randomly select a choice representing the 3 items. Game will determine a winner or a tie based on the outcome of the users choice and the computer*/

import javax.swing.JOptionPane;

public class RPS2
{
	public static void main(String[] args)
	{
		//Variables and constants
		
		int user; // take this out tomorrow 
		int com;
		String userPick = "";
		String comPick = "";
		String message = "";
		int gameCount = 1;
		int userWins = 0;
		int comWins = 0;
		int tieGames = 0;
		final int NUM_GAMES = 3;
		
		
		//While loop controls the overall game structure 
		while(gameCount <= NUM_GAMES)
		{
				
			//Computer randomly chooses a number between 1 and 3
			com = 1 + (int)(Math.random()*3);
			
			//Reset the strings each time a new round is played 
			userPick ="";
			message = "";
			
			//Validate the player data allowing for some misplellings, loop the dialog box if the user does not give a valid selection
			while(!userPick.equalsIgnoreCase("rock") && !userPick.equalsIgnoreCase("paper") && !userPick.equalsIgnoreCase("scissors"))
			{
				userPick = JOptionPane.showInputDialog(null, "Please type one of the following: \nRock \nPaper \nScissors");
				
				userPick = userPick.toLowerCase();
				
				//now we have what the user typed, check if the first two character are correct, assign the proper selection from the
				if(userPick.startsWith("ro"))
				{
					userPick = "rock";
				}
				else
				{
					if(userPick.startsWith("pa"))
					{
						userPick = "paper";
					}
					else
					{
						if(userPick.startsWith("sc"))
						{
							userPick = "scissors";
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Invalid selection");
						}
					}
				}
			}
			
			//Decision process for the computer which assigns a string with the item name to the numeric choices
			//Computer's string
			if(com == 1)
			{
				comPick="ROCK";
			}
			else
			{
				if(com == 2)
				{
					comPick="PAPER";
				}
				else
				{
					comPick="SCISSORS";
				}
			}
			
			//Game mechanics
			if(userPick.equalsIgnoreCase(comPick))//checks for tie games first
			{
				tieGames++; 
				message= "We have a tie";
			}
			else //what if it's not a tie?
			{
				if(userPick.equalsIgnoreCase("rock"))
				{
					if(comPick.equalsIgnoreCase("paper"))
					{
						//computer wins
						comWins++;
						message = "Computer wins!";
					}
					else
					{
						//player wins
						userWins++;
						message = "You win!";
					}
				}
				//What if the player didn't pick rock
				else
				{
					if(userPick.equalsIgnoreCase("paper"))
					{
						if(comPick.equalsIgnoreCase("scissors"))
						{
							//computer wins
							comWins++;
							message = "Computer wins!";
						}
						else
						{
							//player wins
							userWins++;
							message = "You win!";
						}
					}
					//What if the player didn't pick paper? It must be scissors
					else
					{
						if(comPick.equalsIgnoreCase("rock"))
						{
							//computer wins
							comWins++;
							message = "Computer wins!";
						}
						else
						{
							//player wins
							userWins++;
							message = "You win!";
						}
					}
				}
			}
			
			
			//We have everything we need, this is the output
			JOptionPane.showMessageDialog(null, "You selected "+ userPick + "\nComputer selected " + comPick + "\nOutcome: "+ message);
			
			//Increment the game count variable by 1
			gameCount++;
		}
		//All rounds are done, display a final score summary
		JOptionPane.showMessageDialog(null, "Score after " + NUM_GAMES + " games. \nUser wins: " + userWins + "\nComputer wins: " + comWins + "\nTie games: " + tieGames);
		
	}
}