package bean;

public class TicketBean {

	private Integer id;
	private String type;
	private double price;
	private int number;
	
	public TicketBean(Integer id, String type, double price) {
		super();
		this.id = id;
		this.type = type;
		this.price = price;
		this.number = 0;
	}
	
	public TicketBean() {}
	
	public Integer getId() {
		return id;
	}
	
	public String getType() {
		return type;
	}
	
	public double getPrice() {
		return price;
	}
	
	public int getNumber() {
		return number;
	}
	
	public void setNumber(int number) {
		this.number = number;
	}
}
