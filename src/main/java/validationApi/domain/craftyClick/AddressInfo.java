package validationApi.domain.craftyClick;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AddressInfo {

	private List<Thoroughfare> thoroughfares;
	private String town;
	private String postcode;
	private String error_code;
	private String error_msg;

	public List<Thoroughfare> getThoroughfares() {
		return thoroughfares;
	}

	public void setThoroughfares(List<Thoroughfare> thoroughfares) {
		this.thoroughfares = thoroughfares;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getError_code() {
		return error_code;
	}

	public void setError_code(String error_code) {
		this.error_code = error_code;
	}

	public String getError_msg() {
		return error_msg;
	}

	public void setError_msg(String error_msg) {
		this.error_msg = error_msg;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((error_code == null) ? 0 : error_code.hashCode());
		result = prime * result + ((error_msg == null) ? 0 : error_msg.hashCode());
		result = prime * result + ((postcode == null) ? 0 : postcode.hashCode());
		result = prime * result + ((thoroughfares == null) ? 0 : thoroughfares.hashCode());
		result = prime * result + ((town == null) ? 0 : town.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AddressInfo other = (AddressInfo) obj;
		if (error_code == null) {
			if (other.error_code != null)
				return false;
		} else if (!error_code.equals(other.error_code))
			return false;
		if (error_msg == null) {
			if (other.error_msg != null)
				return false;
		} else if (!error_msg.equals(other.error_msg))
			return false;
		if (postcode == null) {
			if (other.postcode != null)
				return false;
		} else if (!postcode.equals(other.postcode))
			return false;
		if (thoroughfares == null) {
			if (other.thoroughfares != null)
				return false;
		} else if (!thoroughfares.equals(other.thoroughfares))
			return false;
		if (town == null) {
			if (other.town != null)
				return false;
		} else if (!town.equals(other.town))
			return false;
		return true;
	}

}
