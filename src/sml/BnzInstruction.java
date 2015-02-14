package sml;

/**
 * This class ....
 *
 * @author someone
 */

public class BnzInstruction extends Instruction {

    public BnzInstruction(String label, int register, String goToLabel) {
        super(label, "bnz", register, goToLabel);
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

        else if (regVal<0) {
            System.out.println("not a valid register number ");
        }
    }

    @Override
    public String toString() {
        return super.toString() + " go to instruction " + goToLabel;
    }
}
