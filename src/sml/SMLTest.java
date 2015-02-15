package sml;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * This Test class unit tests add, sub, mul, div, and bnz
 *
 * @author James Thornton
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
        Instruction ins0 = new SubInstruction("sub", 3, 1, 0);
        ins0.execute(m);
        assertEquals(6, m.getRegisters().getRegister(3));
        Instruction ins = new SubInstruction("sub", 3, 1, 2);
        ins.execute(m);
        assertEquals(3, m.getRegisters().getRegister(3));
    }

    @Test
    public void MultiplyTest() {
        Instruction ins0 = new MulInstruction("mul", 3, 1, 0);
        ins0.execute(m);
        assertEquals(0, m.getRegisters().getRegister(3));
        Instruction ins = new MulInstruction("mul", 3, 1, 2);
        ins.execute(m);
        assertEquals(18, m.getRegisters().getRegister(3));
    }

    @Test
    public void DivideTest() {
        Instruction ins0 = new DivInstruction("div", 3, 0, 2);
        ins0.execute(m);
        assertEquals(0, m.getRegisters().getRegister(3));
        Instruction insdiv0 = new DivInstruction("div", 4, 1, 0);
        insdiv0.execute(m);
        assertEquals(0 , m.getRegisters().getRegister(4));
        Instruction ins = new DivInstruction("div", 3, 1, 2);
        ins.execute(m);
        assertEquals(2, m.getRegisters().getRegister(3));
    }

    @Test
    public void BNZTest() {
        Translator t = new Translator("bnzTest.sml");
        t.readAndTranslate(m.getLabels(), m.getProg());
        m.execute();
        assertEquals(720, m.getRegisters().getRegister(21));
        Translator t2 = new Translator("bnzTest2.sml");
        t2.readAndTranslate(m.getLabels(), m.getProg());
        m.execute();
        assertEquals(0, m.getRegisters().getRegister(21));
    }
    @Test
    public void OutTest() {
        Instruction ins1 = new OutInstruction("out", 1);
        assertEquals("out: output value from register 1" , ins1.toString());

    }
}
