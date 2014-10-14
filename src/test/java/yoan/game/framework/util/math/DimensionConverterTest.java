package yoan.game.framework.util.math;

import static org.fest.assertions.api.Assertions.assertThat;

import org.junit.Test;

import yoan.game.framework.util.DimensionConverter;

/**
 * 
 * @author yoan
 */
public class DimensionConverterTest {
	private final DimensionConverter dimConverter10 = new DimensionConverter(10);
	private final DimensionConverter dimConverter32 = new DimensionConverter(32);
	private final DimensionConverter dimConverter42 = new DimensionConverter(42);
	
	@Test
	public void pixelsToGameSize_should_work_with_various_basic_sizes() {
		//given
		int sizeInPixel = 42;
		
		//when
		float resultInGameSize10 = dimConverter10.pixelsToGameSize(sizeInPixel);
		float resultInGameSize32 = dimConverter32.pixelsToGameSize(sizeInPixel);
		float resultInGameSize42 = dimConverter42.pixelsToGameSize(sizeInPixel);
		
		//then
		assertThat(resultInGameSize10).as("result with basic size 10").isEqualTo(4.2f);
		assertThat(resultInGameSize32).as("result with basic size 32").isEqualTo(1.3125f);
		assertThat(resultInGameSize42).as("result with basic size 42").isEqualTo(1.0f);
	}
	
	@Test
	public void gameSizeToPixels_should_work_with_various_basic_sizes() {
		//given
		float inGameSize = 4.2f;
		
		//when
		int resultInPixel10 = dimConverter10.gameSizeToPixels(inGameSize);
		int resultInPixel32 = dimConverter32.gameSizeToPixels(inGameSize);
		int resultInPixel42 = dimConverter42.gameSizeToPixels(inGameSize);
		
		//then
		assertThat(resultInPixel10).as("result with basic size 10").isEqualTo(42);
		assertThat(resultInPixel32).as("result with basic size 32").isEqualTo(134);
		assertThat(resultInPixel42).as("result with basic size 42").isEqualTo(176);
	}
}
