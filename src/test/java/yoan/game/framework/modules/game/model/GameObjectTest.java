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
}