public class Wind {

	private Double speed;
	private Double deg;

	public Wind() {
	}

	public Double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public Double getDeg() {
		return deg;
	}

	public void setDeg(double deg) {
		this.deg = deg;
	}

	@Override
	public String toString() {
		return "src.main.Wind{speed=" + speed + ", deg=" + deg + '}';
	}
}
