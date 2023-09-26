package anudip.com;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Country {
	@Id
	private int countryCode;
	private String countryName;
	
	@OneToMany(mappedBy="country",cascade=CascadeType.ALL)
	private List<States> states = new ArrayList<States>();
	
	public Country() {
		super();
	}
	public int getCountryCode() {
		return countryCode;
	}
	public String  getCountryName() {
		return countryName;
	}
	public List<States> getStates() {
		return states;
	}
	public void setStates(List<States> states) {
		this.states = states;
	}
	public void setCountryCode(int countryCode) {
		this.countryCode = countryCode;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	

}
