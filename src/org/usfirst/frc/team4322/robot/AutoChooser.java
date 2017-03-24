package org.usfirst.frc.team4322.robot;

import edu.wpi.first.wpilibj.DigitalInput;

/**
 * Created by software on 3/24/17.
 */
public class AutoChooser {
    private DigitalInput d0, d1, d2, d3;

    public AutoChooser() {
        d0 = new DigitalInput(0);
        d1 = new DigitalInput(1);
        d2 = new DigitalInput(2);
        d3 = new DigitalInput(3);
    }

    public int get()
    {
        return (d0.get() ? 1 : 0) + (d1.get() ? 2: 0) + (d2.get() ? 4 : 0) + (d3.get() ? 8 : 0);
    }
}
