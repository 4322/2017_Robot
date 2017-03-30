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
        addSequential(new Group_HomePivot());
        addSequential(new DriveBase_DriveDistance(93, true,0.6,true,0.31)); //Drive a certain distance
        addSequential(new DriveBase_FMSTurn(-60)); //Turn 30 degrees
        addSequential(new DriveBase_DriveDistance(25, false,0.8,false,0.32)); //Drive up to peg
        addSequential(new Group_EjectGear()); //Put gear on peg
        addSequential(new DriveBase_DriveDistance(-24,false, 0.8, false)); // Back up a bit
        addSequential(new DriveBase_FMSTurn(60)); // Straighten out
        addSequential(new DriveBase_DriveDistance(54,true, 1,false,.7)); // DRIVE ALL THE WAY

    }
}
