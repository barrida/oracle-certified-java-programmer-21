package streams.advanced_concepts.chaining_optionals;

public class CoronavirusCase {
	private String country;
	private long numberOfCases;

	public CoronavirusCase(long numberOfCases, String country) {
		super();
		this.country = country;
		this.numberOfCases = numberOfCases;
	}

	public CoronavirusCase(String country, long numberOfCases) {
		super();
		this.country = country;
		this.numberOfCases = numberOfCases;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public long getNumberOfCases() {
		return numberOfCases;
	}

	public void setNumberOfCases(long numberOfCases) {
		this.numberOfCases = numberOfCases;
	}
}
