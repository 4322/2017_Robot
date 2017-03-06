package org.usfirst.frc.team4322.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Created by software on 3/5/17.
 */
public class Auton_GearMiddle extends CommandGroup
{
    public Auton_GearMiddle()
    {
        addSequential(new DriveBase_DriveDistance(-90,.6)); //Drive up to peg
        addSequential(new GearGrabber_EjectGear()); //Put gear on peg
        addSequential(new DriveBase_DriveDistance(6, .6)); //Back up a bit
    }
}
