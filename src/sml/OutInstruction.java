package sml;

/**
 * This class ....
 *
 * @author someone
 */

public class OutInstruction extends Instruction {

    //private int value;
    public OutInstruction(String label, int regNo) {
        super(label, "out", regNo);
    }

    /*
    private int regNo;

    public OutInstruction(String label, String opcode) {
        super(label, opcode);
    }

    public OutInstruction(String label, int regNo) {
        super(label, "out");
        this.regNo = regNo;

    }
    */

    @Override
    public void execute(Machine m) {
        System.out.println("Output is " + m.getRegisters().getRegister(regNo));
    }

    @Override
    public String toString() {
        return super.toString() + "put value from register " + regNo;// + " value is " + value;
    }
}
