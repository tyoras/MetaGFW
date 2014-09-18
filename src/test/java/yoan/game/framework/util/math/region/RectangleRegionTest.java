package yoan.game.framework.util.math.region;

import static org.fest.assertions.api.Assertions.assertThat;

import org.junit.Test;

import yoan.game.framework.util.math.Rectangle;
import yoan.game.framework.util.math.shape.RectangleShape;

public class RectangleRegionTest {
	
	@Test
	public void region_coordinates_from_existing_rectangle_should_be_between_0_and_1() {
		//given
		RectangleShape existingRectangle = new Rectangle(2, 8, 5, 4);
		
		//when
		RectangleRegion region = new RectangleRegion(existingRectangle, 2, 1, 3, 2);
		
		//then
		assertThat(region.u1).isGreaterThanOrEqualTo(0).isLessThanOrEqualTo(1);
		assertThat(region.u2).isGreaterThanOrEqualTo(0).isLessThanOrEqualTo(1);
		assertThat(region.v1).isGreaterThanOrEqualTo(0).isLessThanOrEqualTo(1);
		assertThat(region.v2).isGreaterThanOrEqualTo(0).isLessThanOrEqualTo(1);
	}
}
