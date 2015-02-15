package sml;

/**
 * This class is the superclass of the classes for machine instructions
 *
 * @author James Thornton
 */

public abstract class Instruction {
    protected String label;
    protected String opcode;
    protected String goToLabel;
    protected int register;
    protected int regNo;
    protected int value;
    protected int result;
    protected int op1;
    protected int op2;

    // Constructor: an instruction with label l and opcode op
    // (op must be an operation of the language)

    public Instruction(String l, String op) {
        this.label = l;
        this.opcode = op;
    }
    public Instruction(String label, int register, int value) {
        this(label, "lin");
        this.register = register;
        this.value = value;
    }
    public Instruction(String label, String opcode, int regNo) {
        this(label, opcode);
        this.regNo = regNo;
    }
    public Instruction(String label, String opcode, int register, String goToLabel) {

        this(label, opcode);
        this.register = register;
        this.goToLabel = goToLabel;
    }

    public Instruction(String label, String opcode, int result, int op1, int op2) {

        this(label, opcode);
        this.result = result;
        this.op1 = op1;
        this.op2 = op2;
    }


    // = the representation "label: opcode" of this Instruction

    @Override
    public String toString() {
        return label + ": " + opcode;
    }

    // Execute this instruction on machine m.

    public abstract void execute(Machine m);
}
