package code;

public class Config {
	private int id;
	private String source;
	private String destination;
	private String u_source;
	private String u_des;
	private String pW_source;
	private String pW_des;
	private String delimeter;
	private String data_name;
	private String data_gender;
	private String data_Age;
	private String data_Address;

	public Config() {
		super();
	}

	

	

	public Config(int id, String source, String destination, String u_source, String u_des, String pW_source,
			String pW_des, String delimeter, String data_name, String data_gender, String data_Age,
			String data_Address) {
		super();
		this.id = id;
		this.source = source;
		this.destination = destination;
		this.u_source = u_source;
		this.u_des = u_des;
		this.pW_source = pW_source;
		this.pW_des = pW_des;
		this.delimeter = delimeter;
		this.data_name = data_name;
		this.data_gender = data_gender;
		this.data_Age = data_Age;
		this.data_Address = data_Address;
	}





	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getU_source() {
		return u_source;
	}

	public void setU_source(String u_source) {
		this.u_source = u_source;
	}

	public String getU_des() {
		return u_des;
	}

	public void setU_des(String u_des) {
		this.u_des = u_des;
	}

	public String getpW_source() {
		return pW_source;
	}

	public void setpW_source(String pW_source) {
		this.pW_source = pW_source;
	}

	public String getpW_des() {
		return pW_des;
	}

	public void setpW_des(String pW_des) {
		this.pW_des = pW_des;
	}


	public String getDelimeter() {
		return delimeter;
	}





	public void setDelimeter(String delimeter) {
		this.delimeter = delimeter;
	}





	public String getData_name() {
		return data_name;
	}

	public void setData_name(String data_name) {
		this.data_name = data_name;
	}

	public String getData_gender() {
		return data_gender;
	}

	public void setData_gender(String data_gender) {
		this.data_gender = data_gender;
	}

	public String getData_Age() {
		return data_Age;
	}

	public void setData_Age(String data_Age) {
		this.data_Age = data_Age;
	}

	public String getData_Address() {
		return data_Address;
	}

	public void setData_Address(String data_Address) {
		this.data_Address = data_Address;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}





	@Override
	public String toString() {
		return "Config [id=" + id + ", source=" + source + ", destination=" + destination + ", u_source=" + u_source
				+ ", u_des=" + u_des + ", pW_source=" + pW_source + ", pW_des=" + pW_des + ", delimeter=" + delimeter
				+ ", data_name=" + data_name + ", data_gender=" + data_gender + ", data_Age=" + data_Age
				+ ", data_Address=" + data_Address + "]";
	}



	
}
	

	