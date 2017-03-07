package org.usfirst.frc.team4322.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Created by software on 3/5/17.
 */
public class AutoGroup_GearMiddle extends CommandGroup
{
    public AutoGroup_GearMiddle()
    {

        addParallel(new DriveBase_DriveDistance(90)); //Drive up to peg
        addSequential(new DriveBase_VisionTurn(() -> {
            return SmartDashboard.getNumber("Vision Center X: ", 0.5) - .5;
        }));
        addSequential(new GearGrabber_EjectGear()); //Put gear on peg
        addSequential(new DriveBase_DriveDistance(-6)); //Back up a bit
    }
}
