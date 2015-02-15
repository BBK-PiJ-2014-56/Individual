package sml;

/**
 * This class ....
 *
 * @author someone
 */

public class DivInstruction extends Instruction {

    public DivInstruction(String label, int result, int op1, int op2) {
        super(label, "div", result, op1, op2);
    }

    @Override
    public void execute(Machine m) {
        int value1 = m.getRegisters().getRegister(op1);
        int value2 = m.getRegisters().getRegister(op2);
        try {
            m.getRegisters().setRegister(result, value1 / value2);
        } catch(Exception e) {
            System.out.println("division by zero exception");
        }
    }

    @Override
    public String toString() {
        return super.toString() + " " + op1 + " / " + op2 + " to " + result;
    }
}
