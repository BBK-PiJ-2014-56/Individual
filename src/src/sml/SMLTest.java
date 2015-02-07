package src.sml;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by jimjohn_thornton on 07/02/15.
 */
public class SMLTest {
    private Machine m;

    @Before
    public void setUp() throws Exception {
        m = new Machine();
        m.setRegisters(new Registers());
        //Registers r2 = new Registers();
        //Registers r3 = new Registers();
    }
    @Test
    public void AddTest() {
        m.getRegisters().setRegister(1, 6);
        m.getRegisters().setRegister(2, 3);
        //m.getRegisters().setRegister(1, 6);

        Instruction ins = new AddInstruction("add", 3, 1, 2);
        ins.execute(m);
        assertEquals(9, m.getRegisters().getRegister(3));

    }
}
