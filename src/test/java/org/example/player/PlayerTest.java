package org.example.player;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;


public class PlayerTest {
    @Test
    public void looses_when_dice_number_is_too_low(){
        Dice dice = Mockito.mock(Dice.class);

        Mockito.when(dice.roll()).thenReturn(2);

        Player player = new Player(dice, 5);
        Assert.assertFalse(player.play());
    }

    @Test
    public void wins_when_dice_number_is_higher_than_min(){
        Dice dice = Mockito.mock(Dice.class);

        Mockito.when(dice.roll()).thenReturn(6);

        Player player = new Player(dice, 5);
        Assert.assertTrue(player.play());
    }

    @Test
    public void wins_when_dice_number_is_equal_to_min(){
        Dice dice = Mockito.mock(Dice.class);

        Mockito.when(dice.roll()).thenReturn(5);

        Player player = new Player(dice, 5);
        Assert.assertTrue(player.play());
    }

}