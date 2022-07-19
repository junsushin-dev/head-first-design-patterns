package state;

public class WinnerState implements State {
    GumballMachine gumballMachine;

    public WinnerState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    public void insertQuarter() {
        System.out.println("경품을 내보내고 있습니다");
    }

    public void ejectQuarter() {
        System.out.println("이미 경품을 뽑으셨습니다");
    }

    public void turnCrank() {
        System.out.println("손잡이는 한번만 돌려주세요");
    }
    public void dispense() {
        gumballMachine.releaseBall();
        if (gumballMachine.getCount() == 0) {
            gumballMachine.setState(gumballMachine.getSoldOutState());
        } else {
            System.out.println("축하합니다! 추가 경품에 당첨되셨습니다");
            gumballMachine.releaseBall();
            if(gumballMachine.getCount() > 0) {
                gumballMachine.setState(gumballMachine.getNoQuarterState());
            } else {
                System.out.println("경품이 떨어졌습니다");
                gumballMachine.setState(gumballMachine.getSoldOutState());
            }
        }
    }
}
