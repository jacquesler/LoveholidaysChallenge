package validationApi.domain.craftyClick;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Thoroughfare {
	private String line_1;
	private String line_2;
	
	public String getLine_1() {
		return line_1;
	}

	public void setLine_1(String line_1) {
		this.line_1 = line_1;
	}

	public String getLine_2() {
		return line_2;
	}

	public void setLine_2(String line_2) {
		this.line_2 = line_2;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((line_1 == null) ? 0 : line_1.hashCode());
		result = prime * result + ((line_2 == null) ? 0 : line_2.hashCode());
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
		Thoroughfare other = (Thoroughfare) obj;
		if (line_1 == null) {
			if (other.line_1 != null)
				return false;
		} else if (!line_1.equals(other.line_1))
			return false;
		if (line_2 == null) {
			if (other.line_2 != null)
				return false;
		} else if (!line_2.equals(other.line_2))
			return false;
		return true;
	}
	
}
