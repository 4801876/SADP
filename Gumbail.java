interface State {
    void insertQuarter();
    void ejectQuarter();
    void turnCrank();
    void dispense();
}

class NoQuarterState implements State {
    GumballMachine gumballMachine;

    public NoQuarterState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("Quarter inserted");
        gumballMachine.setState(gumballMachine.getHasQuarterState());
    }

    @Override
    public void ejectQuarter() {
        System.out.println("No quarter to eject");
    }

    @Override
    public void turnCrank() {
        System.out.println("You need to insert a quarter first");
    }

    @Override
    public void dispense() {
        System.out.println("No gumball dispensed");
    }
}

class HasQuarterState implements State {
    GumballMachine gumballMachine;

    public HasQuarterState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("Quarter already inserted");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("Quarter ejected");
        gumballMachine.setState(gumballMachine.getNoQuarterState());
    }

    @Override
    public void turnCrank() {
        System.out.println("Crank turned...");
        gumballMachine.setState(gumballMachine.getSoldState());
    }

    @Override
    public void dispense() {
        System.out.println("No gumball dispensed");
    }
}

class SoldState implements State {
    GumballMachine gumballMachine;

    public SoldState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("Please wait, we're already dispensing a gumball");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("Cannot eject, already turned the crank");
    }

    @Override
    public void turnCrank() {
        System.out.println("Turning again won't get you another gumball");
    }

    @Override
    public void dispense() {
        gumballMachine.releaseBall();
        if (gumballMachine.getCount() > 0) {
            gumballMachine.setState(gumballMachine.getNoQuarterState());
        } else {
            System.out.println("Oops! Out of gumballs!");
            gumballMachine.setState(gumballMachine.getSoldOutState());
        }
    }
}

class SoldOutState implements State {
    GumballMachine gumballMachine;

    public SoldOutState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("Machine is sold out");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("No quarter to eject");
    }

    @Override
    public void turnCrank() {
        System.out.println("No gumball dispensed");
    }

    @Override
    public void dispense() {
        System.out.println("No gumball dispensed");
    }
}

class GumballMachine {
    State soldOutState;
    State noQuarterState;
    State hasQuarterState;
    State soldState;

    State state;
    int count = 0;

    public GumballMachine(int numberOfGumballs) {
        soldOutState = new SoldOutState(this);
        noQuarterState = new NoQuarterState(this);
        hasQuarterState = new HasQuarterState(this);
        soldState = new SoldState(this);

        this.count = numberOfGumballs;
        if (numberOfGumballs > 0) {
            state = noQuarterState;
        } else {
            state = soldOutState;
        }
    }

    public void insertQuarter() {
        state.insertQuarter();
    }

    public void ejectQuarter() {
        state.ejectQuarter();
    }

    public void turnCrank() {
        state.turnCrank();
        state.dispense();
    }

    void setState(State state) {
        this.state = state;
    }

    void releaseBall() {
        if (count > 0) {
            System.out.println("A gumball comes rolling out the slot...");
            count--;
        }
    }

    int getCount() {
        return count;
    }

    State getSoldOutState() {
        return soldOutState;
    }

    State getNoQuarterState() {
        return noQuarterState;
    }

    State getHasQuarterState() {
        return hasQuarterState;
    }

    State getSoldState() {
        return soldState;
    }
}

public class Gumbail {
    public static void main(String[] args) {
        GumballMachine gumballMachine = new GumballMachine(3);

        System.out.println("First customer:");
        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();

        System.out.println("\nSecond customer:");
        gumballMachine.insertQuarter();
        gumballMachine.ejectQuarter();
        gumballMachine.turnCrank();

        System.out.println("\nThird customer:");
        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();

        System.out.println("\nFourth customer:");
        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();

        System.out.println("\nFifth customer (should be sold out):");
        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();
    }
}
