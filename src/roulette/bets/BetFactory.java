package roulette.bets;

import java.util.ArrayList;
import roulette.Bet;
import util.ConsoleReader;

public class BetFactory {
    
    public enum BetType {
        ODDEVEN(1), THREECONSECUTIVE(2), REDBLACK(3);
        
        private int myValue;
        
        BetType(int value) {
            myValue = value;
        }
        
        public int getValue() {
            return myValue;
        }
    }
    
    private BetType[] betTypes = {BetType.ODDEVEN, BetType.THREECONSECUTIVE, BetType.REDBLACK};

    public BetFactory () {}
    
    public Bet getBet(BetType bet) {
        switch(bet) {
            case ODDEVEN:
                return new OddEven("Odd or Even", 1);
            case THREECONSECUTIVE:
                return new ThreeConsecutive("Three in a Row", 11);
            case REDBLACK:
                return new RedBlack("Red or Black", 1);
            default:
                return null;
        }
    }
    
    /**
     * Prompt the user to make a bet from a menu of choices.
     */
    public Bet promptForBet () {
        System.out.println("You can make one of the following types of bets:");
        for (BetType k : BetType.values()) {
            System.out.println(String.format("%d) %s", k.getValue(), getBet(k)));
        }
        int response = ConsoleReader.promptRange("Please make a choice", 1, BetType.values().length);
        BetType betType = betTypes[response - 1];
        return getBet(betType);
    }
}
