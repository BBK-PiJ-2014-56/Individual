package sml;

/**
 * This class ....
 *
 * @author someone
 */

public class OutInstruction extends Instruction {

    private int value;
    private int regNo;

    public OutInstruction(String label, String opcode) {
        super(label, opcode);
    }

    public OutInstruction(String label, int regNo) {
        super(label, "out");
        this.regNo = regNo;

    }

    @Override
    public void execute(Machine m) {
        //value = m.getProg().get(regNo)
        System.out.println(regNo);
        System.out.println("Output is " + value);
    }

    @Override
    public String toString() {
        return super.toString() + " register "; //+ register + " value is " + value;
    }
}
