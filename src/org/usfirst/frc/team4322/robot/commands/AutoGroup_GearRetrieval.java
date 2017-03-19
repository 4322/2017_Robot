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
        addSequential(new DriveBase_DriveDistance(90)); //Drive a certain distance
        addSequential(new DriveBase_Turn(DriverStation.getInstance().getAlliance() == DriverStation.Alliance.Blue ? -60 : 60)); //Turn 30 degrees
        addSequential(new DriveBase_DriveDistance(6, false)); //Drive up to peg
        addSequential(new GearGrabber_EjectGear()); //Put gear on peg
        addSequential(new DriveBase_DriveDistance(-6, false)); //Back up a bit
    }
}
