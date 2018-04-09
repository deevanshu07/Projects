
abstract class Offer
{
	
	
	@Override
	public String toString() {
		return "Offer [OfferID=" + OfferID + ", OfferType=" + OfferType
				+ ", OfferName=" + OfferName + ", OfferExpiry=" + OfferExpiry
				+ ", OfferDays=" + OfferDays + "]";
	}

	int OfferID;
	String OfferType;
	String OfferName;
	String OfferExpiry;
	String OfferDays;
	
	Offer(int id, String type,String name, String expiry,String days)
	{
		super();
		this.OfferID=id;
		this.OfferType=type;
		this.OfferName=name;
		this.OfferExpiry=expiry;
		this.OfferDays=days;
		
	}
	
	Offer()
	{
		
	}

	public int getOfferID() {
		return OfferID;
	}

	public void setOfferID(int offerID) {
		OfferID = offerID;
	}

	public String getOfferType() {
		return OfferType;
	}

	public void setOfferType(String offerType) {
		OfferType = offerType;
	}

	public String getOfferName() {
		return OfferName;
	}

	public void setOfferName(String offerName) {
		OfferName = offerName;
	}

	public String getOfferExpiry() {
		return OfferExpiry;
	}

	public void setOfferExpiry(String offerExpiry) {
		OfferExpiry = offerExpiry;
	}

	public String getOfferDays() {
		return OfferDays;
	}

	public void setOfferDays(String offerDays) {
		OfferDays = offerDays;
	}

}







