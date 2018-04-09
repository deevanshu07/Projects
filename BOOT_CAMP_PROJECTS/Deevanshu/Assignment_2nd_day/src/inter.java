interface IRestuarant
{
	void takeOrder();
	void showMenu();
	void checkStatus(int orderId);
	void showRegCustomerOffer(int corpId);
	void showCorpCustomerOffer(int corpId);
}