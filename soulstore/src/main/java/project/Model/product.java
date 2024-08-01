package project.Model;

public class product {
	private int Id;
	private String name;
	private String category;
	private Double price;
	private String image;
	
	public product() {
		
	}
	
	

	public product(int id, String name, String category, Double price, String image) {
		
		Id = id;
		this.name = name;
		this.category = category;
		this.price = price;
		this.image = image;
	}



	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}



	@Override
	public String toString() {
		return "product [Id=" + Id + ", name=" + name + ", category=" + category + ", price=" + price + ", image="
				+ image + "]";
	}
	
	
	
}
