

import java.io.Serializable;
import java.util.List;
import java.util.Map;



public class JsonMap implements Serializable{


	private static final long serialVersionUID = 1L;
	private String name;
	private List<String> topLevelDomain;
	private String alpha2Code;
	private String alpha3Code;
	private List<String> callingCodes;
	private String capital;
	private List<String> altSpellings;
	private String region;
	private String subregion;
	private long population;
	private List<Double> latlng;
	private String demonym;
	private double area;
	private double gini;
	private List<String> timezones;
	private List<String> borders;
	private String nativeName;
	private String numericCode;
	private List<String> currencies;
	private List<String> languages;
	private java.util.Map<String, String> translations;
	private String relevance;
	public JsonMap() {
		super();
		// TODO Auto-generated constructor stub
	}
	public JsonMap(String name, List<String> topLevelDomain, String alpha2Code,
			String alpha3Code, List<String> callingCodes, String capital,
			List<String> altSpellings, String region, String subregion,
			long population, List<Double> latlng, String demonym, long area,
			double gini, List<String> timezones, List<String> borders,
			String nativeName, String numericCode, List<String> currencies,
			List<String> languages, Map<String, String> translations,
			String relevance) {
		super();
		this.name = name;
		this.topLevelDomain = topLevelDomain;
		this.alpha2Code = alpha2Code;
		this.alpha3Code = alpha3Code;
		this.callingCodes = callingCodes;
		this.capital = capital;
		this.altSpellings = altSpellings;
		this.region = region;
		this.subregion = subregion;
		this.population = population;
		this.latlng = latlng;
		this.demonym = demonym;
		this.area = area;
		this.gini = gini;
		this.timezones = timezones;
		this.borders = borders;
		this.nativeName = nativeName;
		this.numericCode = numericCode;
		this.currencies = currencies;
		this.languages = languages;
		this.translations = translations;
		this.relevance = relevance;
	}
	public String getAlpha2Code() {
		return alpha2Code;
	}
	public String getAlpha3Code() {
		return alpha3Code;
	}
	public List<String> getAltSpellings() {
		return altSpellings;
	}
	public double getArea() {
		return area;
	}
	public List<String> getBorders() {
		return borders;
	}
	public List<String> getCallingCodes() {
		return callingCodes;
	}
	public String getCapital() {
		return capital;
	}
	public List<String> getCurrencies() {
		return currencies;
	}
	public String getDemonym() {
		return demonym;
	}
	public double getGini() {
		return gini;
	}
	public List<String> getLanguages() {
		return languages;
	}
	public List<Double> getLatlng() {
		return latlng;
	}
	public String getName() {
		return name;
	}
	public String getNativeName() {
		return nativeName;
	}
	public String getNumericCode() {
		return numericCode;
	}
	public long getPopulation() {
		return population;
	}
	public String getRegion() {
		return region;
	}
	public String getRelevance() {
		return relevance;
	}
	public String getSubregion() {
		return subregion;
	}
	public List<String> getTimezones() {
		return timezones;
	}
	public List<String> getTopLevelDomain() {
		return topLevelDomain;
	}
	public java.util.Map<String, String> getTranslations() {
		return translations;
	}
	public void setAlpha2Code(String alpha2Code) {
		this.alpha2Code = alpha2Code;
	}
	public void setAlpha3Code(String alpha3Code) {
		this.alpha3Code = alpha3Code;
	}
	public void setAltSpellings(List<String> altSpellings) {
		this.altSpellings = altSpellings;
	}
	public void setArea(double area) {
		this.area = area;
	}
	public void setBorders(List<String> borders) {
		this.borders = borders;
	}
	public void setCallingCodes(List<String> callingCodes) {
		this.callingCodes = callingCodes;
	}
	public void setCapital(String capital) {
		this.capital = capital;
	}
	public void setCurrencies(List<String> currencies) {
		this.currencies = currencies;
	}
	public void setDemonym(String demonym) {
		this.demonym = demonym;
	}
	public void setGini(double gini) {
		this.gini = gini;
	}
	public void setLanguages(List<String> languages) {
		this.languages = languages;
	}
	public void setLatlng(List<Double> latlng) {
		this.latlng = latlng;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setNativeName(String nativeName) {
		this.nativeName = nativeName;
	}
	public void setNumericCode(String numericCode) {
		this.numericCode = numericCode;
	}
	public void setPopulation(long population) {
		this.population = population;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public void setRelevance(String relevance) {
		this.relevance = relevance;
	}
	public void setSubregion(String subregion) {
		this.subregion = subregion;
	}
	public void setTimezones(List<String> timezones) {
		this.timezones = timezones;
	}
	public void setTopLevelDomain(List<String> topLevelDomain) {
		this.topLevelDomain = topLevelDomain;
	}
	public void setTranslations(java.util.Map<String, String> translations) {
		this.translations = translations;
	}
	@Override
	public String toString() {
		return "JsonMap [name=" + name + ", topLevelDomain=" + topLevelDomain
				+ ", alpha2Code=" + alpha2Code + ", alpha3Code=" + alpha3Code
				+ ", callingCodes=" + callingCodes + ", capital=" + capital
				+ ", altSpellings=" + altSpellings + ", region=" + region
				+ ", subregion=" + subregion + ", population=" + population
				+ ", latlng=" + latlng + ", demonym=" + demonym + ", area="
				+ area + ", gini=" + gini + ", timezones=" + timezones
				+ ", borders=" + borders + ", nativeName=" + nativeName
				+ ", numericCode=" + numericCode + ", currencies=" + currencies
				+ ", languages=" + languages + ", translations=" + translations
				+ ", relevance=" + relevance + "]";
	}
}
