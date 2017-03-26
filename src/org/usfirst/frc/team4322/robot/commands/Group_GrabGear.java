package org.usfirst.frc.team4322.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Created by software on 2/25/17.
 */
public class Group_GrabGear extends CommandGroup {
    public Group_GrabGear() {
        addParallel(new GearGrabber_PrepareForGear());
        addSequential(new GearPivot_Lower());
    }
}
