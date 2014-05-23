package yoan.game.framework.util.math.region;

import static org.fest.assertions.api.Assertions.assertThat;

import org.junit.Test;

import yoan.game.framework.util.math.Vector2;

public class Vector2Test {
	
	@Test
	public void add_should_work() {
		//given
		Vector2 tested = new Vector2(2, 3);
		
		//when
		tested.add(3, 8);
		
		//then
		assertThat(tested.x).isEqualTo(5);
	}
}
