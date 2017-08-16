package mx.com.jrrs.vo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(namespace = "mx.com.jrrs.vo.customervo")
public class CustomerVO {
	
	Integer id;
	String name;
	String address;
	String phone;

	public CustomerVO() {
		super();
	}

	public CustomerVO(Integer id, String name, String address, String phone) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.phone = phone;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
