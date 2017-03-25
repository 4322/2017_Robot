package org.usfirst.frc.team4322.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Created by software on 2/25/17.
 */
public class Group_EjectGear extends CommandGroup {
    public Group_EjectGear() {
        addParallel(new GearGrabber_EjectGear());
        addSequential(new GearPivot_Lower());
    }
}
