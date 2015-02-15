package sml;

/**
 * This class adds an instruction into a register
 *
 * @author James Thornton
 */

public class LinInstruction extends Instruction {

    public LinInstruction(String label, int register, int value) {
        super(label, register, value);
    }

    @Override
    public void execute(Machine m) {
        m.getRegisters().setRegister(register, value);
    }

    @Override
    public String toString() {
        return super.toString() + " register " + register + " value is " + value;
    }
}
