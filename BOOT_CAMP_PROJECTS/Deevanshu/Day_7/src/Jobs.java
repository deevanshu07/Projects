import java.io.Serializable;


public class Jobs implements Serializable
{

	
	


	public String toString() 
	{
		return "Jobs [jobId=" + jobId + ", jobTitle=" + jobTitle
				+ ", maxSalary=" + maxSalary + ", minSalary=" + minSalary + "]";
	}


	String jobId;
	String jobTitle;
	int maxSalary;
	int minSalary;
	
	
	public Jobs(String jobId, String jobTitle, int maxSalary, int minSalary) {
		super();
		this.jobId = jobId;
		this.jobTitle = jobTitle;
		this.maxSalary = maxSalary;
		this.minSalary = minSalary;
	}

	
	public String getJobId() {
		return jobId;
	}


	public void setJobId(String jobId) {
		this.jobId = jobId;
	}


	public String getJobTitle() {
		return jobTitle;
	}


	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}


	public int getMaxSalary() {
		return maxSalary;
	}


	public void setMaxSalary(int maxSalary) {
		this.maxSalary = maxSalary;
	}


	public int getMinSalary() {
		return minSalary;
	}


	public void setMinSalary(int minSalary) {
		this.minSalary = minSalary;
	}
}

