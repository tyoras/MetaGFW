package yoan.game.framework.modules.game.model;

import static org.fest.assertions.api.Assertions.assertThat;

import org.junit.Test;

/**
 * 
 * @author yoan
 */
public class GameObjectTest {

	@Test
	public void getBotPosition_should_work() {
		//given
		GameObject tested = new GameObject(5, 8, 3, 4);
		
		//when
		float lowerPosition = tested.getBotPosition();
		
		//then
		assertThat(lowerPosition).isEqualTo(6);
	}
	
	@Test
	public void setWidth_should_update_bound_x_coordinate() {
		//given
		GameObject tested = new GameObject(5, 8, 3, 4);
		float y_beforeUpdate = tested.bounds.lowerLeft.y;
		
		//when
		tested.setWidth(7);
		
		//then
		assertThat(tested.bounds.lowerLeft.y).isEqualTo(y_beforeUpdate);
		assertThat(tested.bounds.lowerLeft.x).isEqualTo(1.5f);
	}
	
	@Test
	public void setHeight_should_update_bound_y_coordinate() {
		//given
		GameObject tested = new GameObject(5, 8, 3, 4);
		float x_beforeUpdate = tested.bounds.lowerLeft.x;
		
		//when
		tested.setHeight(7);
		
		//then
		assertThat(tested.bounds.lowerLeft.x).isEqualTo(x_beforeUpdate);
		assertThat(tested.bounds.lowerLeft.y).isEqualTo(4.5f);
	}
}