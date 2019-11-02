/**
 * 
 *
 */

/**
 * @author franck Desmedt github/bigmoletos
 *
 */
public class Geometry {
//	"type": "MultiPoint",
//	"coordinates": [
//		[
//			894028.02826631,
//			6247112.77529318
//		]
//		] 

	private String type;// "MultiPoint",
	private Double[][] coordinates;// ": [

	/**
	 * 
	 */
	public Geometry() {
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
	 * @return the coordinates
	 */
	public Double[][] getCoordinates() {
		return this.coordinates;
	}

	/**
	 * @param coordinates the coordinates to set
	 */
	public void setCoordinates(Double[][] coordinates) {
		this.coordinates = coordinates;
	}

	@Override
	public String toString() {
		Double latitude = null;
		Double longitude = null;
		for (int i = 0; i < coordinates.length; i++) {
			for (int j = 0; j < coordinates.length; j++) {
				latitude = coordinates[i][0];
				longitude = coordinates[i][j + 1];
			}
		}
		return "\nlatitude: " + latitude + "\nlongitude: " + longitude;
	}

}
