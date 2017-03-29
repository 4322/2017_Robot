package org.usfirst.frc.team4322.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Created by software on 2/25/17.
 */
public class Group_EjectGear extends CommandGroup {
    public Group_EjectGear() {
        addParallel(new GearGrabber_EjectGear());
        addParallel(new GearPivot_Lower(),1);
        addSequential(new Command_Delay(750));
        addParallel(new Group_RaisePivot());
        addSequential(new DriveBase_StupidDriveDistance(30,true));

    }
}
