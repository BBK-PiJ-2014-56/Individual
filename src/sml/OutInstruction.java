package sml;

/**
 * This class prints out the contents of a specified register
 *
 * @author James Thornton
 */

public class OutInstruction extends Instruction {

    //private int value;
    public OutInstruction(String label, int regNo) {
        super(label, "out", regNo);
    }

    @Override
    public void execute(Machine m) {
        System.out.println("Output is " + m.getRegisters().getRegister(regNo));
    }

    @Override
    public String toString() {
        return super.toString() + "put value from register " + regNo;// + " value is " + value;
    }
}
