/*Write an application that calculates and displays the weekly salary for an employee. 
 * Create a class employee to consist the following information:-

Data members    ratePerHour float.

regularHrs int.   overtimeHrs int.

Member Functions

GetData () used to get the data from the user.

CalculateSalary() is used to calculate weekly salary, calculated in two ways. 
Normal rates are applicable for the regular hours. For overtime hours rate will be 1.5 times to the original one. 
This method returns the total weekly salary, which is the sum of both types.

Display () to display the result.
*/

class Employee
{
  private float ratePerHour;
  private float regularHrs;
  private float overtimeHrs;
  

  void getdata(float rate ,float regular, float over )
  {
  ratePerHour=rate;
  regularHrs=regular;
  overtimeHrs =over;
  
  
  }
  float calculateSalary ()
  {
	  float rate;
	  
	  
	  
	  
	   return rate =(this.ratePerHour + this.regularHrs + (this.overtimeHrs*1.5f));
	 
  }
  
 
}


public class deevanshu_1 {


	public static void main(String[] args)
	{
    Employee e1 = new Employee();
    e1.getdata(12.5f,40.5f,2.f);
    
   System.out.println( e1.calculateSalary());

	}

}
