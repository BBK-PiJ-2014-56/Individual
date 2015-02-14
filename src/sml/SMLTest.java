package sml;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by jimjohn_thornton on 07/02/15.
 */
public class SMLTest {
    private Machine m;

    @Before
    public void setUp() throws Exception {
        m = new Machine();
        m.setRegisters(new Registers());
        m.getRegisters().setRegister(1, 6);
        m.getRegisters().setRegister(2, 3);
        m.getRegisters().setRegister(0, 0);
    }

    @Test
    public void AddTest() {
        Instruction ins0 = new AddInstruction("add", 3, 1, 0);
        ins0.execute(m);
        assertEquals(6, m.getRegisters().getRegister(3));
        Instruction ins = new AddInstruction("add", 3, 1, 2);
        ins.execute(m);
        assertEquals(9, m.getRegisters().getRegister(3));
    }

    @Test
    public void SubtractTest() {
        Instruction ins0 = new SubtractInstruction("sub", 3, 1, 0);
        ins0.execute(m);
        assertEquals(6, m.getRegisters().getRegister(3));
        Instruction ins = new SubtractInstruction("sub", 3, 1, 2);
        ins.execute(m);
        assertEquals(3, m.getRegisters().getRegister(3));
    }

    @Test
    public void MultiplyTest() {
        Instruction ins0 = new MultiplyInstruction("mul", 3, 1, 0);
        ins0.execute(m);
        assertEquals(0, m.getRegisters().getRegister(3));
        Instruction ins = new MultiplyInstruction("mul", 3, 1, 2);
        ins.execute(m);
        assertEquals(18, m.getRegisters().getRegister(3));
    }

    @Test
    public void DivideTest() {
        Instruction ins0 = new DivideInstruction("div", 3, 0, 2);
        ins0.execute(m);
        assertEquals(0, m.getRegisters().getRegister(3));
        Instruction insdiv0 = new DivideInstruction("div", 4, 1, 0);
        insdiv0.execute(m);
        assertEquals(0 , m.getRegisters().getRegister(4));
        Instruction ins = new DivideInstruction("div", 3, 1, 2);
        ins.execute(m);
        assertEquals(2, m.getRegisters().getRegister(3));
    }

    @Test
    public void BNZTest() {
        Instruction ins0 = new SubtractInstruction("sub", 3, 1, 2);
        Instruction ins1 = new BnzInstruction("bnz", 3, "ins0");
        ins1.execute(m);
        //assertEquals(0, m.getRegisters().getRegister(3));
    }
}
