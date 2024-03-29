package org.usfirst.frc.team4322.robot;

import edu.wpi.first.wpilibj.DigitalInput;

/**
 * Created by software on 3/24/17.
 */
public class AutoChooser {
    private DigitalInput d0, d1, d2, d3;

    public AutoChooser() {
        d0 = new DigitalInput(RobotMap.AUTO_SELECTOR_DIO_PORT_0);
        d1 = new DigitalInput(RobotMap.AUTO_SELECTOR_DIO_PORT_1);
        d2 = new DigitalInput(RobotMap.AUTO_SELECTOR_DIO_PORT_2);
        d3 = new DigitalInput(RobotMap.AUTO_SELECTOR_DIO_PORT_3);
    }

    public int get()
    {
        int out =  (d0.get() ? 1 : 0) + (d1.get() ? 2: 0) + (d2.get() ? 4 : 0) + (d3.get() ? 8 : 0);
        return out == 15 ? 8 : out;
    }
}
