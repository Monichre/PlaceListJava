import org.junit.*;
import static org.junit.Assert.*;

public class PlaceListTest {

	@Test
	public void PlaceList_instantiatesCorrectly_true() {
	PlaceList myPlaceList = new PlaceList("Thing");
	assertEquals(true, myPlaceList instanceof PlaceList);
	  }

	@Test
	public void PlaceList_instantiatesWithDescription_String() {
	PlaceList myPlaceList = new PlaceList("Other Thing");
	assertEquals("Other Thing", myPlaceList.getItem());
  }

}
