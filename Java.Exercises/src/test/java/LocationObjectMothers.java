
public class LocationObjectMothers {

	public static LocationObjectMother SanFrancisco() {
		return new LocationBuilder()
				.withState(States.California)
				.withCity(Cities.SanFrancisco)
				.build();
	}

	public static LocationObjectMother Houston() {
		return new LocationBuilder()
				.withState(States.Texas)
				.withCity(Cities.Houston)
				.build();
	}
}
