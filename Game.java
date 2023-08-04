package ProjectCalc;
import java.util.Random;
import java.util.Scanner;

public class Game {
	
	
	
	// Method to get Difficulty
	public static int getDifficulty() {
		int difficulty = -1; 
		while (difficulty < 0 || difficulty > 2) {
	        try {
	            System.out.println("Choose the difficulty level"
	                    + "\nPress 0 for Easy"
	                    + "\nPress 1 for Medium"
	                    + "\nPress 2 for Hard");
	            Scanner sc= new Scanner(System.in);
	            difficulty = Integer.parseInt(sc.nextLine());
	
	            if (difficulty < 0 || difficulty > 2) {
	                throw new Exception("Invalid input. Please select a valid difficulty level.");
	            }
	        } catch (NumberFormatException e) {
	            System.out.println("Invalid input. Please enter a number.");
	        } catch (Exception e) {
	            System.out.println(e.getMessage());
	        }
	    }
		return difficulty;
	} // end Method Difficulty
	
	
	
	
	
	// Method to get Problem Type
	
	public static int getProblemType() {
		int problemType = -1;
		
		while(problemType <0 || problemType >3) {
			 try {
				 System.out.println("Choose the Problem Type"
		                    + "\nPress 0 for Division"
		                    + "\nPress 1 for Multiplication"
		                    + "\nPress 2 for Addition"
		                    + "\nPress 3 for Subtraction");
				 		Scanner sc= new Scanner(System.in);
		            	problemType = Integer.parseInt(sc.nextLine());
	
	             if (problemType < 0 || problemType > 2) {
	                 throw new Exception("Invalid input. Please select a valid difficulty level.");
	             }
	         } catch (NumberFormatException e) {
	             System.out.println("Invalid input. Please enter a number.");
	         } catch (Exception e) {
	             System.out.println(e.getMessage());
	         }
			
		} // end while for problem type
		return problemType;
	}	// End Method getProblem Type
	
	
	//Method to know how many questions user wants to practice
		public static int gameQuestion() {
			int questionNo = 0;
			while(questionNo <1 || questionNo > 10) {
				try {
					System.out.println("Enter how many questions you want to Practice from 1 to 10");
			        Scanner sc= new Scanner(System.in);
			        questionNo = Integer.parseInt(sc.nextLine());
			        
				if (questionNo < 0 || questionNo > 11) {
	                throw new Exception("Invalid input. Please select a valid difficulty level.");
	            }
	        } catch (NumberFormatException e) {
	            System.out.println("Invalid input. Please enter a number.");
	        } catch (Exception e) {
	            System.out.println(e.getMessage());
	        
			}
	    
			}
			return questionNo;
	    }	// End Method gameQuestion
		
	//Method for Timer
		 public static String formatTime(long timeInMillis) {
		        long seconds = (timeInMillis / 1000) % 60;
		        long minutes = (timeInMillis / (1000 * 60)) % 60;
		        long hours = timeInMillis / (1000 * 60 * 60);
	
		        String formattedTime;
		        if (hours > 0) {
		            formattedTime = hours + " hr " + minutes + " min " + seconds + " sec";
		        } else if (minutes > 0) {
		            formattedTime = minutes + " min " + seconds + " sec";
		        } else {
		            formattedTime = seconds + " sec";
		        }
	
		        return formattedTime;
		    }
	
	
	
	
	
		public void startGame(Scanner sc) {
			// TODO Auto-generated method stub
			String name; 
			int age =-1;
	      
			System.out.println("Enter your name");
			name = sc.nextLine();
			
			System.out.println("Enter your age: ");
			age = Integer.parseInt(sc.nextLine());
	
		    
		
		    
		    User user = new User(name, age);
		    boolean PLAY=true;
		    int score =0;
		    while (PLAY) {
		        // Using Methods	
		        		int difficulty = getDifficulty();
		        		int problemType = getProblemType();
		            	int questionNo = gameQuestion();

		            //Generating Random Integer
		            	Random rand = new Random();
		            	int rand1 = 0;
		            	int rand2=0;
		            
		            // Ask if the user is ready to start
		            	System.out.println("Hello " + name + "! Are you ready to start the practice? (y/n)");
		                String ready = "";

		                while (!ready.equalsIgnoreCase("y") && !ready.equalsIgnoreCase("n")) {
		                    ready = sc.nextLine();

		                    if (!ready.equalsIgnoreCase("y") && !ready.equalsIgnoreCase("n")) {
		                        System.out.println("Invalid input. Please enter 'y' or 'n'.");
		                    }
		                }

		                if (ready.equalsIgnoreCase("n")) {
		                    System.out.println("Take your time. When you're ready, come back and practice again!");
		                    continue; // Go back to the beginning of the loop to ask again
		                }
		            	
		            
		         // Start the timer
		            	long startTime = System.currentTimeMillis(); 
		            	
		            	

		            for(int i=1; i<=questionNo; i++) {
		            	
		            	if(difficulty == 0) {
		                    rand1= rand.nextInt(9) + 1;
		                    rand2 = rand.nextInt(9) + 1;
		                }
		                else if(difficulty == 1) {
		                    rand1 = rand.nextInt(90) + 10;
		                    rand2 = rand.nextInt(90) + 10;
		                }
		                else if(difficulty == 2) {
		                    rand1 = rand.nextInt(900) + 100;
		                    rand2 = rand.nextInt(900) + 100;
		                }
		                else {
		                    System.out.print("Select the appropriate option");
		                }
		                

		                if(problemType == 0) {
		                    System.out.println("Divide these numbers: " + rand1 + " / " + rand2 + " = ?");
		                    int answer = rand1 / rand2;
		                    int userAnswer = Integer.parseInt(sc.nextLine());
		                    if(answer == userAnswer) {
		                        System.out.println("Your answer is correct");
		                        score++;
		                    }
		                    else {
		                        System.out.println("Your answer is incorrect"
		                                + "\nCorrect answer is: " + answer);
		                    }
		                }
		                else if(problemType == 1) {
		                    System.out.println("Multiply these numbers: " + rand1 + " * " + rand2 + " = ?");
		                    int answer = rand1 * rand2;
		                    int userAnswer = Integer.parseInt(sc.nextLine());
		                    if(answer == userAnswer) {
		                        System.out.println("Your answer is correct");
		                        score++;
		                    }
		                    else {
		                        System.out.println("Your answer is incorrect"
		                                + "\nCorrect answer is: " + answer);
		                    }
		                }
		                else if(problemType == 2) {
		                    System.out.println("Add these numbers: " + rand1 + " + " + rand2 + " = ?");
		                    int answer = rand1 + rand2;
		                    int userAnswer = Integer.parseInt(sc.nextLine());
		                    if(answer == userAnswer) {
		                        System.out.println("Your answer is correct");
		                        score++;
		                    }
		                    else {
		                        System.out.println("Your answer is incorrect"
		                                + "\nCorrect answer is: " + answer);
		                    }
		                }
		                else if(problemType == 3) {
		                    System.out.println("Subtract these numbers: " + rand1 + " - " + rand2 + " = ?");
		                    int answer = rand1 - rand2;
		                    int userAnswer = Integer.parseInt(sc.nextLine());
		                    if(answer == userAnswer) {
		                        System.out.println("Your answer is correct");
		                        score++;
		                    }
		                    else {
		                        System.out.println("Your answer is incorrect"
		                                + "\nCorrect answer is: " + answer);
		                    }
		                }
		                else {
		                    System.out.println("You have Selected Invalid Option.");
		                }
		                System.out.println("Your Score = "+score);
		            }
		            
		            System.out.println("Your Total Score = "+score+ " / " +questionNo);
		             
		            //Timer End
		            long endTime = System.currentTimeMillis(); // Stop the timer
		            long timeTaken = endTime - startTime; // Calculate the time taken in milliseconds

		            String formattedTime = formatTime(timeTaken);
		            System.out.println("Time taken: " + formattedTime);

		            // Ask the user if they want to practice again
		            	System.out.println("Do you want to practice again? (y/n)");
		            	String playAgain = sc.nextLine();
		            	if (!playAgain.equalsIgnoreCase("y")) {
		            		PLAY = false;
		            		System.out.println("Thank you for practicing! Goodbye.");
		            	}
		        }
			
		}
			 
}
