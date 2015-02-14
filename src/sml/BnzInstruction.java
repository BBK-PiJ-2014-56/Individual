package sml;

/**
 * This class ....
 *
 * @author someone
 */

public class BnzInstruction extends Instruction {
    private int register;
    private String goToLabel;

    public BnzInstruction(String label, String opcode) {
        super(label, opcode);
    }

    public BnzInstruction(String label, int register, String goToLabel) {
        super(label, "bnz");
        this.register = register;
        this.goToLabel = goToLabel;

    }

    @Override
    public void execute(Machine m) {
        int regVal = m.getRegisters().getRegister(register);
        if (regVal != 0) {
            if (regVal > 0) {
                int goToIndex = m.getLabels().indexOf(goToLabel);
                m.setPc(goToIndex);
            }
        }

        //fix this bit

        /*else {
            System.out.println(regVal);
            System.out.println("not a valid register number ");
        }*/
        //m.getRegisters().setRegister(register, value);
    }

    @Override
    public String toString() {
        return super.toString() + " go to instruction " + goToLabel;
    }
}
