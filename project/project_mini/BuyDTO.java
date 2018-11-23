package project_mini;

public class BuyDTO {
	private String id;
	private String name;
	private String address;
	private int product_name;
	private int count;

	BuyDTO() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getProduct_name() {
		return product_name;
	}

	public void setProduct_name(int product_name) {
		this.product_name = product_name;
	}


	   
	   
	   
	}