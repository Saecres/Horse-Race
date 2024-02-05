// App Name: Horse Race
// Description: An app that simlates a horse race.

import java.util.Scanner;

public class HorseRace
{
    // Constants
    final static String SET_TITLE = "\033]0;%s\007";
    final static String CLEAR_TERMINAL = "\033c";
    final static String BANNER = """
    ===========================
    ==      Horse Race       ==
    ===========================
    """;
    static int DISTANCE_TO_WIN = 20;
    static int HALF_SECOND = 500;
    
    /**
     * Stops the code for a millisecond (1 second = 500ms)
     * @param args
     */
    static void waitHalfSecond()
    {
        try
        {
            Thread.sleep(HALF_SECOND);
        }
        catch(Exception exception){}
    }

    /**
     * 
     * @param args
     */
    public static void drawDistanceLine(Horse horse)
    {
        for(int i = 0; i < horse.getDistanceCovered(); i++)
        {
            System.out.print(".");
        }
        {
            // Prints horse name after the dots
            System.out.print(horse.getName());
            System.out.println();
        }
    }

    public static void main(String[] args) 
    {
        // Variables
        Scanner scanner = new Scanner(System.in);
        boolean noWinners = true;

        // Array of horses
        Horse[] horses = new Horse[5];
        horses[0] = new Horse("Midnight Majesty");
        horses[1] = new Horse("Stormrunner");
        horses[2] = new Horse("Silvermist");
        horses[3] = new Horse("Pinkie Pie");
        horses[4] = new Horse("Emberhoof");

        // Set title
        System.out.printf(SET_TITLE, "Horse Race - Kaitlin Penaranda");

        // print banner
        System.out.println(BANNER);

        // Keep counting until noWinners is true
        while(noWinners)
        {
            // Clear terminal
            System.out.print(CLEAR_TERMINAL + BANNER);

            for(Horse horse:horses)
            {
                horse.run();
                drawDistanceLine(horse);
                if(horse.getDistanceCovered() >= DISTANCE_TO_WIN)
                {
                    noWinners = false;
                }
                
                // Stop for half a second
                waitHalfSecond();
            }
        }
        System.out.println("We have a winner(s)!");
        for (Horse horse : horses) 
        {
            if (horse.getDistanceCovered() >= DISTANCE_TO_WIN) 
            {
                System.out.println(horse.getName() + " wins!");
            }
        }

        // Exit Prompt
        System.out.print("\nPress [enter] to exit: ");
        scanner.nextLine();
        scanner.close();
    }
}