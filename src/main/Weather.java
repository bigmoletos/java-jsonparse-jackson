/**
 * @author franck Desmedt github/bigmoletos
 *
 */
public class Weather {

	private Long id;
	private String main;
	private String description;
	private String icon;

	public Weather() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMain() {
		return main;
	}

	public void setMain(String main) {
		this.main = main;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	@Override
	public String toString() {
		return "src.main.Weather{" + "id=" + id + ", main='" + main + '\'' + ", description='" + description + '\''
				+ ", icon='" + icon + '\'' + '}';
	}
}
