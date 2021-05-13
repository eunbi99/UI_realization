package spms.vo;

public class ProductVO {
	private String p_id; 
	private String p_price;
	private String p_content;
	private String p_name;
	private int category;
	
	public String getP_id() {
		return p_id;
	}
	public void setP_id(String p_id) {
		this.p_id = p_id;
	}
	public String getP_price() {
		return p_price;
	}
	public void setP_price(String p_price) {
		this.p_price = p_price;
	}
	public String getP_content() {
		return p_content;
	}
	public void setP_content(String p_content) {
		this.p_content = p_content;
	}
	public int getCategory() {
		return category;
	}
	public void setCategory(int category) {
		this.category = category;
	}
	public String getP_name() {
		return p_name;
	}
	public void setP_name(String p_name) {
		this.p_name = p_name;
	}
	@Override
	public String toString() {
		return "Product [p_id=" + p_id + ", p_price=" + p_price + ", p_content=" + p_content + ", p_name=" + p_name
				+ ", category=" + category + "]";
	}
	

	
}
