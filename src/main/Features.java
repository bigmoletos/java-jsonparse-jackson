import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 *
 */

/**
 * @author franck Desmedt github/bigmoletos
 *
 */
public class Features {
//	"type":"Feature",
//	"id":"ind_sudpaca_agglo.fid--48cd4d03_16e2798e16e_6469",
//	"geometry":
//	{
//		"type": "MultiPoint",
//		"coordinates": [
//			[
//				894028.02826631,
//				6247112.77529318
//			]
//		]
//	},
//	"geometry_name":"geom",

	private String type;// "Feature//",
	private String id;// "ind_sudpaca_agglo.fid--48cd4d03_16e2798e16e_6469//",
	private Geometry geometry;

	/**
	 * @return the geometry
	 */
	public Geometry getGeometry() {
		return this.geometry;
	}

	/**
	 * @param geometry the geometry to set
	 */
	public void setGeometry(Geometry geometry) {
		this.geometry = geometry;
	}

	@JsonProperty("geometry_name")
	private String geometryName;// "geom//",

	private Properties properties;

	/**
	 * 
	 */
	public Features() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return this.type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return this.id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the geometryName
	 */
	public String getGeometryName() {
		return this.geometryName;
	}

	/**
	 * @param geometryName the geometryName to set
	 */
	public void setGeometryName(String geometryName) {
		this.geometryName = geometryName;
	}

	/**
	 * @return the properties
	 */
	public Properties getProperties() {
		return this.properties;
	}

	/**
	 * @param properties the properties to set
	 */
	public void setProperties(Properties properties) {
		this.properties = properties;
	}

//	public String retourneTabString() {
//		StringBuilder tab = new StringBuilder();
//		
//		for (String string : properties) {
//			tab.append(string.trim()).append("\t");
//		}
//		tab.append(System.getProperty("line.separator"));
//		return tab.toString();
//	}

	@Override
	public String toString() {
		return "{" + properties + "\ncoordonnées: " + geometry + "\n}";
	}
}
