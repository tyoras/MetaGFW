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
		assertThat(tested.y).isEqualTo(11);
	}
	
	@Test
	public void add_vector_should_work() {
		//given
		Vector2 tested = new Vector2(2, 3);
		Vector2	added = new Vector2(3, 8);	
		
		//when
		tested.add(added);
		
		//then
		assertThat(tested.x).isEqualTo(5);
		assertThat(tested.y).isEqualTo(11);
	}
	
	@Test
	public void sub_should_work() {
		//given
		Vector2 tested = new Vector2(2, 3);
		
		//when
		tested.sub(3, 8);
		
		//then
		assertThat(tested.x).isEqualTo(-1);
		assertThat(tested.y).isEqualTo(-5);
	}
	
	@Test
	public void sub_vector_should_work() {
		//given
		Vector2 tested = new Vector2(2, 3);
		Vector2	subed = new Vector2(3, 8);	
		
		//when
		tested.sub(subed);
		
		//then
		assertThat(tested.x).isEqualTo(-1);
		assertThat(tested.y).isEqualTo(-5);
	}
	
	@Test
	public void set_should_work() {
		//given
		Vector2 tested = new Vector2(2, 3);
		
		//when
		tested.set(3, 8);
		
		//then
		assertThat(tested.x).isEqualTo(3);
		assertThat(tested.y).isEqualTo(8);
	}
	
	@Test
	public void cpy_should_work() {
		//given
		Vector2 origin = new Vector2(2, 3);
		
		//when
		Vector2 copy = origin.cpy();
		
		//then
		assertThat(copy == origin).isFalse();
		assertThat(copy.equals(origin)).isTrue();
		assertThat(copy.x).isEqualTo(origin.x);
		assertThat(copy.y).isEqualTo(origin.y);
	}
	
	@Test
	public void mul_should_work() {
		//given
		Vector2 tested = new Vector2(2, 3);
		
		//when
		tested.mul(3);
		
		//then
		assertThat(tested.x).isEqualTo(6);
		assertThat(tested.y).isEqualTo(9);
	}
	
	@Test
	public void len_should_work() {
		//given
		Vector2 tested = new Vector2(4, 3);
		
		//when
		float length = tested.len();
		
		//then
		assertThat(length).isEqualTo(5);
	}
	
	@Test
	public void nor_should_work() {
		//given
		Vector2 tested = new Vector2(4, 3);
		
		//when
		tested.nor();
		
		//then
		assertThat(tested.x).isEqualTo(0.8f);
		assertThat(tested.y).isEqualTo(0.6f);
	}
	
	@Test
	public void angle_should_work() {
		//given
		Vector2 tested1 = new Vector2(0, 0); Vector2 tested2 = new Vector2(1, 1);
		Vector2 tested3 = new Vector2(0, 1); Vector2 tested4 = new Vector2(-1, 1);
		Vector2 tested5 = new Vector2(-1, 0); Vector2 tested6 = new Vector2(-1, -1);
		Vector2 tested7 = new Vector2(0, -1); Vector2 tested8 = new Vector2(1, -1);
		
		//when
		float angle1 = tested1.angle(); float angle2 = tested2.angle(); 
		float angle3 = tested3.angle(); float angle4 = tested4.angle();
		float angle5 = tested5.angle(); float angle6 = tested6.angle();
		float angle7 = tested7.angle(); float angle8 = tested8.angle();
		
		//then
		assertThat(angle1).isEqualTo(0); assertThat(angle2).isEqualTo(45);
		assertThat(angle3).isEqualTo(90); assertThat(angle4).isEqualTo(135);
		assertThat(angle5).isEqualTo(180); assertThat(angle6).isEqualTo(225);
		assertThat(angle7).isEqualTo(270); assertThat(angle8).isEqualTo(315);
	}
	
	@Test
	public void rotate_should_work() {
		//given
		Vector2 tested = new Vector2(1, 0);
		
		//when
		tested.rotate(90);

		//then
		float dist = tested.dist(new Vector2(0, 1));
		assertThat(dist >= 0 && dist <= 0.000001).isTrue(); 
	}
}