import java.io.Serializable;


public class PrepaidCustomer implements Serializable
{
	private long originatingNumber;
	private int durationOfCall;
	public PrepaidCustomer(long originatingNumber, int durationOfCall) 
	{
		super();
		this.originatingNumber = originatingNumber;
		this.durationOfCall = durationOfCall;
	}
	@Override
	public String toString() 
	{
		return "PrepaidCustomer [originatingNumber=" + originatingNumber
				+ ", durationOfCall=" + durationOfCall + "]";
	}
	public long getOriginatingNumber() 
	{
		return originatingNumber;
	}
	public void setOriginatingNumber(long originatingNumber) {
		this.originatingNumber = originatingNumber;
	}
	public int getDurationOfCall() {
		return durationOfCall;
	}
	public void setDurationOfCall(int durationOfCall) {
		this.durationOfCall = durationOfCall;
	}
	
}
