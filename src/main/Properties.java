import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 *
 */

/**
 * @author franck Desmedt github/bigmoletos
 *
 */
public class Properties {
//	"date_ech": "01-11-2019 00:00:00",
//	"valeur": 4,
//	"qualif": "Bon",
//	"source": "AtmoSud",
//	"type_zone": "commune",
//	"code_zone": "13055",
//	"lib_zone": "Marseille",
//	"val_no2": 2,
//	"val_so2": 0,
//	"val_o3": 3,
//	"val_pm10": 4,
//	"val_pm25": 0,
//	"couleur": "#8DA71E"

	private String date_ech; // "01-11-2019 00:00:00//",
	private Integer valeur; // 4,
	private String qualif; // "Bon//",
	private String source; // "AtmoSud//",
	@JsonProperty("type_zone")
	private String typeZone; // "commune//",
	@JsonProperty("code_zone")
	private String codeZone; // "13055//",
	@JsonProperty("lib_zone")
	private String libZone; // "Marseille//",
	@JsonProperty("val_no2")
	private Double valNo2; // 2,
	@JsonProperty("val_so2")
	private Double valSo2; // 0,
	@JsonProperty("val_o3")
	private Double valO3; // 3,
	@JsonProperty("val_pm10")
	private Double valPm10;// 4,
	@JsonProperty("val_pm25")
	private Double valPm25; // 0,
	private String couleur; // "#8DA71E//"

	/**
	 * 
	 */
	public Properties() {
	}

//getter et setter
	/**
	 * @return the date_ech
	 */
	public String getDate_ech() {
		return this.date_ech;
	}

	/**
	 * @param date_ech the date_ech to set
	 */
	public void setDate_ech(String date_ech) {
		this.date_ech = date_ech;
	}

	/**
	 * @return the valeur
	 */
	public Integer getValeur() {
		return this.valeur;
	}

	/**
	 * @param valeur the valeur to set
	 */
	public void setValeur(Integer valeur) {
		this.valeur = valeur;
	}

	/**
	 * @return the qualif
	 */
	public String getQualif() {
		return this.qualif;
	}

	/**
	 * @param qualif the qualif to set
	 */
	public void setQualif(String qualif) {
		this.qualif = qualif;
	}

	/**
	 * @return the source
	 */
	public String getSource() {
		return this.source;
	}

	/**
	 * @param source the source to set
	 */
	public void setSource(String source) {
		this.source = source;
	}

	/**
	 * @return the typeZone
	 */
	public String getTypeZone() {
		return this.typeZone;
	}

	/**
	 * @param typeZone the typeZone to set
	 */
	public void setTypeZone(String typeZone) {
		this.typeZone = typeZone;
	}

	/**
	 * @return the codeZone
	 */
	public String getCodeZone() {
		return this.codeZone;
	}

	/**
	 * @param codeZone the codeZone to set
	 */
	public void setCodeZone(String codeZone) {
		this.codeZone = codeZone;
	}

	/**
	 * @return the libZone
	 */
	public String getLibZone() {
		return this.libZone;
	}

	/**
	 * @param libZone the libZone to set
	 */
	public void setLibZone(String libZone) {
		this.libZone = libZone;
	}

	/**
	 * @return the valNo2
	 */
	public Double getValNo2() {
		return this.valNo2;
	}

	/**
	 * @param valNo2 the valNo2 to set
	 */
	public void setValNo2(Double valNo2) {
		this.valNo2 = valNo2;
	}

	/**
	 * @return the valSo2
	 */
	public Double getValSo2() {
		return this.valSo2;
	}

	/**
	 * @param valSo2 the valSo2 to set
	 */
	public void setValSo2(Double valSo2) {
		this.valSo2 = valSo2;
	}

	/**
	 * @return the valO3
	 */
	public Double getValO3() {
		return this.valO3;
	}

	/**
	 * @param valO3 the valO3 to set
	 */
	public void setValO3(Double valO3) {
		this.valO3 = valO3;
	}

	/**
	 * @return the valPm10
	 */
	public Double getValPm10() {
		return this.valPm10;
	}

	/**
	 * @param valPm10 the valPm10 to set
	 */
	public void setValPm10(Double valPm10) {
		this.valPm10 = valPm10;
	}

	/**
	 * @return the valPm25
	 */
	public Double getValPm25() {
		return this.valPm25;
	}

	/**
	 * @param valPm25 the valPm25 to set
	 */
	public void setValPm25(Double valPm25) {
		this.valPm25 = valPm25;
	}

	/**
	 * @return the couleur
	 */
	public String getCouleur() {
		return this.couleur;
	}

	/**
	 * @param couleur the couleur to set
	 */
	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

	@Override
	public String toString() {
		return "\nville: " + libZone + "\nindice qualite de l'air= " + qualif + "\nvaleur= " + valeur;
	}
}
