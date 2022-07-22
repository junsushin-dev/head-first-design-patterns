package state;

import java.rmi.Naming;

public class GumballMachineTestDrive {
    public static void main(String[] args) {
        GumballMachine gumballMachine = null;
        int count;

        if (args.length < 2) {
            System.out.println("GumballMachine <name> <inventory>");
            System.exit(1);
        }

        try {
            count = Integer.parseInt(args[1]);
            gumballMachine = new GumballMachine(args[0], count);
            Naming.rebind("//" + args[0] + "/gumballmachine", gumballMachine);
        } catch (Exception e) {
            e.printStackTrace();
        }
//        System.out.println(gumballMachine.state);
//
//        gumballMachine.insertQuarter();
//        gumballMachine.turnCrank();
//
//        System.out.println(gumballMachine.state);
//
//        gumballMachine.insertQuarter();
//        gumballMachine.turnCrank();
//        gumballMachine.insertQuarter();
//        gumballMachine.turnCrank();
//
//        System.out.println(gumballMachine.state);
    }
}
