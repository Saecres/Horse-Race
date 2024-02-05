// App Name: Horse
// Description: An app that simlates a horse race.

import java.util.Random;

public class Horse 
{
    // Variables
    private String name;
    private int distanceCovered = 0;
    private Random random = new Random();

    public Horse(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public int getDistanceCovered()
    {
        return distanceCovered;
    }

    public void run()
    {
        distanceCovered += random.nextInt(2);
    }
}
