package org.usfirst.frc.team4322.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Created by software on 3/5/17.
 */
public class AutoGroup_GearRetrieval extends CommandGroup
{
    public AutoGroup_GearRetrieval()
    {
        addSequential(new DriveBase_DriveDistance(90, true)); //Drive a certain distance
        addSequential(new DriveBase_FMSTurn(60)); //Turn 30 degrees
        addSequential(new DriveBase_DriveDistance(3, false)); //Drive up to peg
        addSequential(new GearGrabber_EjectGear()); //Put gear on peg
        addSequential(new DriveBase_DriveDistance(-16,false, true, false)); // Back up a bit
        addSequential(new DriveBase_FMSTurn(-60)); // Straighten out

        addSequential(new DriveBase_DriveDistance(54,true, true,false)); // Drive to line
        addSequential(new DriveBase_FMSTurn(45)); // turn some angle
        addSequential(new DriveBase_DriveDistance(200,true,false, false)); // DRIVE ALL THE WAY

    }
}
