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
	
	@Test(expected = IllegalArgumentException.class)
	public void constructor_should_fail_if_region_coordinates_greater_than_1() {
		//given
		float goodCoordinate = 0.5f;
		float wrongCoordinate = 1.2f;
		
		//when
		new RectangleRegion(goodCoordinate, goodCoordinate, goodCoordinate, wrongCoordinate);
		
		//then exception
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void constructor_should_fail_if_region_coordinates_below_0() {
		//given
		float goodCoordinate = 0.5f;
		float wrongCoordinate = -0.4f;
		
		//when
		new RectangleRegion(goodCoordinate, goodCoordinate, goodCoordinate, wrongCoordinate);
		
		//then exception
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void constructor_should_fail_if_u1_greater_than_u2() {
		//given
		float goodCoordinate = 0.5f;
		float u1 = 0.5f;
		float u2 = 0.4f;
		
		
		//when
		new RectangleRegion(u1, goodCoordinate, u2, goodCoordinate);
		
		//then exception
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void constructor_should_fail_if_v1_greater_than_v2() {
		//given
		float goodCoordinate = 0.5f;
		float v1 = 0.5f;
		float v2 = 0.4f;
		
		
		//when
		new RectangleRegion(goodCoordinate, v1, goodCoordinate, v2);
		
		//then exception
	}
	
	@Test
	public void getWidth_should_work() {
		//given
		RectangleRegion region = new RectangleRegion(0.27f,0.41f,0.83f,1.0f);
		
		//when
		float width = region.getWidth();
		
		//then
		assertThat(width).isEqualTo(0.55999994f);
	}
	
	@Test
	public void getHeight_should_work() {
		//given
		RectangleRegion region = new RectangleRegion(0.27f,0.41f,0.83f,1.0f);
		
		//whenXt
		float height = region.getHeight();
		
		//then
		assertThat(height).isEqualTo(0.59000003f);
	}
}
