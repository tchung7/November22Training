package databaseaccessor;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

public class JDBCtests {
  @Test
  public void CanAccessDatabase(DatabaseAccessor dbAccess) {
	  var accessor = GetAccessor();
	  var result = accessor.Execute("dummySql");
	  
  }
  private DatabaseAccessor GetAccessor() {
	  return new DatabaseUtility();
}
@BeforeMethod
  public void beforeMethod() {
  }

}
