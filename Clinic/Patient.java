
/**
 * Write a description of class Patient here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Patient
{
    // instance variables 
    private String name, id, phone;
    private int numberOfVisits;
    private Disease[] lastDiagnosis;

    /**
     * Constructor for objects of class Patient
     */
    public Patient(String name, String phone, String id)
    {
        this.name = name;
        this.phone = phone;
        this.id = id;
        this.numberOfVisits = 0;
        this.lastDiagnosis = new Disease[3];
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public int getVisits()
    {
        // put your code here
        return this.numberOfVisits;
    }
    public void addDiagnosis(Disease disease)
    {
        this.numberOfVisits += 1;
        if(numberOfVisits % 3 == 0)
        {
            this.lastDiagnosis[2] = disease;
        } else if(numberOfVisits % 2 == 0)
        {
            this.lastDiagnosis[1] = disease;
        } else 
        {
            this.lastDiagnosis[0] = disease;
        }
    }
    public String getDiagnosis()
    {
        String diagnosis = "";
        if(numberOfVisits == 0){
            diagnosis = "This patient hasn't been diagnosed yet.";
            return diagnosis;
        } 
            
        for(int i = 0; i < lastDiagnosis.length; i++)
        {   
                diagnosis += lastDiagnosis[i].getName();
                if(i <= (lastDiagnosis.length - 1))
                {
                    diagnosis += ", "; 
                }
        }
        diagnosis += ".";
        return diagnosis;
    }
    public String toString()
    {
        String details = "\nPatient name: " + this.name +
                        "\nPhone number: " + this.phone +
                        "\nNumber of visits: " + this.numberOfVisits +
                        "\nLast 3 diagnosis: " + this.getDiagnosis() +
                        "\nPatient ID: " + this.id;
        return details;
    }
}
