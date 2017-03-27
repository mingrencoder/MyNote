package battle;

import org.junit.Test;

import battle.actor.Actor;

public class BattleTest {

	@Test
	public void testBattle(){
		Thread t = new Stage();
		t.start();
	}
}
