package org.usfirst.frc.team4322.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team4322.robot.Robot;

/**
 * Created by software on 3/5/17.
 */
public class AutoGroup_GearMiddle extends CommandGroup
{
    public AutoGroup_GearMiddle()
    {

        addSequential(new DriveBase_DriveDistance(-90)); //Drive up to peg
        addSequential(new GearGrabber_EjectGear()); //Put gear on peg
        addSequential(new DriveBase_DriveDistance(-6)); //Back up a bit
    }
}
