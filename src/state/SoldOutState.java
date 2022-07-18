package state;

public class SoldOutState implements State {
    GumballMachine gumballMachine;

    public SoldOutState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    public void insertQuarter() {
        System.out.println("남은 경품이 없습니다");
    }

    public void ejectQuarter() {
        System.out.println("남은 경품이 없습니다");
    }

    public void turnCrank() {
        System.out.println("남은 경품이 없습니다");
    }

    public void dispense() {
        System.out.println("남은 경품이 없습니다");
    }
}

