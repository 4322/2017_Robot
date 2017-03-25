package org.usfirst.frc.team4322.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Created by software on 2/25/17.
 */
public class Group_HomePivot extends CommandGroup {
    public Group_HomePivot() {
        addParallel(new GearPivot_Home());
        addSequential(new GearPivot_HomeToHigh());
    }
}
