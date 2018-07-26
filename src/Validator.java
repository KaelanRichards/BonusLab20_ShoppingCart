import java.util.Scanner;

// This is a helper class
// Used to validate data from users
//to use these methods in other classes (Validator.getString())
public class Validator
{
	
	// This method is used to validate strings from user
	// only returns 1 word
    public static String getString(Scanner sc, String prompt)
    {
        System.out.print(prompt);
        String s = sc.nextLine();  // read user entry
        //sc.nextLine();  // discard any other data entered on the line
        return s;
    }

    // validates integers from user  
    public static int getInt(Scanner sc, String prompt)
    {
        int i = 0;
        boolean isValid = false;
        while (isValid == false)
        {
            System.out.print(prompt);
            if (sc.hasNextInt())
            {
                i = sc.nextInt();
                isValid = true;
            }
            else
            {
                System.out.println("Error! Invalid integer value. Try again.");
            }
            sc.nextLine();  // discard any other data entered on the line
        }
        return i;
    }

    // takes in a range and validates if input is within that range and is a double
    public static int getInt(Scanner sc, String prompt,
    int min, int max)
    {
        int i = 0;
        boolean isValid = false;
        while (isValid == false)
        {
            i = getInt(sc, prompt);
            if (i < min)
                System.out.println(
                    "Error! Number must be " + min + " or greater.");
            else if (i > max)
                System.out.println(
                    "Error! Number must be " + max + " or less.");
            else
                isValid = true;
        }
        return i;
    }

    //validates if user input is an integer
    public static double getDouble(Scanner sc, String prompt)
    {
        double d = 0;
        boolean isValid = false;
        while (isValid == false)
        {
            System.out.print(prompt);
            if (sc.hasNextDouble())
            {
                d = sc.nextDouble();
                isValid = true;
            }
            else
            {
                System.out.println("Error! Invalid decimal value. Try again.");
            }
            sc.nextLine();  // discard any other data entered on the line
        }
        return d;
    }

    // takes in a range and validates if input is within that range and is a double
    public static double getDouble(Scanner sc, String prompt,
    double min, double max)
    {
        double d = 0;
        boolean isValid = false;
        while (isValid == false)
        {
            d = getDouble(sc, prompt);
            if (d < min)
                System.out.println(
                    "Error! Number must be " + min + " or greater.");
            else if (d > max)
                System.out.println(
                    "Error! Number must be " + max + " or less.");
            else
                isValid = true;
        }
        return d;
    }
}