
class Branch {
	private String code;
	private String city;
	private int rate;

	public Branch(String code, String city, int rate) {
		this.code = code;
		this.city = city;
		this.rate = rate;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}
}

class Account {
	private String accountNumber;
	private double balance;

	public Account(String accountNumber, double balance) {
		this.accountNumber = accountNumber;
		this.balance = balance;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
}

class CreditCard {
	private String cardNumber;
	private double credit;

	public CreditCard(String cardNumber, double credit) {
		this.cardNumber = cardNumber;
		this.credit = credit;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public double getCredit() {
		return credit;
	}

	public void setCredit(double credit) {
		this.credit = credit;
	}
}

class Customer {
	private String name;
	private Account account;
	private CreditCard creditCard;

	public Customer(String name, Account account, CreditCard creditCard) {
		super();
		this.name = name;
		this.account = account;
		this.creditCard = creditCard;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public CreditCard getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(CreditCard creditCard) {
		this.creditCard = creditCard;
	}

	public double calCustomerBalance() {
		return this.getCreditCard().getCredit()
				+ this.getAccount().getBalance();
	}
}

public class Bank {
	public static void main(String[] args) {
		Branch b = new Branch("Central1", "Tehran", 1);
		System.out.println(b.getCity()); // Tehran
		b.setCity("Mashhad");
		System.out.println(b.getCity()); // Mashhad
		Account a = new Account("000005618949046540", 10000.5);
		System.out.println(a.getAccountNumber()); // 000005618949046540
		CreditCard cc = new CreditCard("1234567812345678", 50000.4);
		Customer c = new Customer("Ali Alavi", a, cc);
		System.out.println(c.getName()); // Ali Alavi
		System.out.println(c.calCustomerBalance()); // 60000.9
	}
}
