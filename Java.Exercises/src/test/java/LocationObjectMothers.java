
public class LocationObjectMothers {

	public static LocationObjectMother SanFrancisco() {
		// TODO Auto-generated method stub
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
