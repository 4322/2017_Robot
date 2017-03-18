package org.usfirst.frc.team4322.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Created by software on 3/5/17.
 */
public class AutoGroup_GearBoiler extends CommandGroup
{
    public AutoGroup_GearBoiler()
    {
        addSequential(new DriveBase_DriveDistance(90)); //Drive a certain distance
        addSequential(new DriveBase_Turn(60)); //Turn 30 degrees
        addSequential(new Command_Delay(250));
        addSequential(new DriveBase_DriveDistance(24)); //Drive up to peg
//        addSequential(new DriveBase_VisionTurn(() -> {
//            return SmartDashboard.getNumber("Vision Center X: ", 0.5) - .5;
//        }));
        addParallel(new GearGrabber_EjectGear()); //Put gear on peg
        addSequential(new Command_Delay(500));
        addSequential(new DriveBase_DriveDistance(6)); //Back up a bit
    }
}
