package cwk4; 


/**
 * Details of your team
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Teamwork
{
    private String[] details = new String[12];
    
    public Teamwork()
    {   // in each line replace the contents of the String 
        // with the details of your team member
        // Please list the member details alphabetically by surname 
        // i.e. the surname of member1 should come alphabetically 
        // before the surname of member 2...etc
        details[0] = "9";
        
        details[1] = "McGowan";
        details[2] = "Bradley";
        details[3] = "20032495";

        details[4] = "Poremski";
        details[5] = "Timofei";
        details[6] = "20059822";

        details[7] = "Silver";
        details[8] = "Aimee";
        details[9] = "20045187";


        details[10] = "Smith";
        details[11] = "Harry";
        details[12] = "16048438";

    }
    
    public String[] getTeamDetails()
    {
        return details;
    }
    
    public void displayDetails()
    {
        for(String temp:details)
        {
            System.out.println(temp.toString());
        }
    }
}
        
