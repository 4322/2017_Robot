package org.usfirst.frc.team4322.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Created by software on 3/5/17.
 */
public class AutoGroup_GearBoiler extends CommandGroup
{
    public AutoGroup_GearBoiler()
    {
//        addSequential(new DriveBase_DriveDistance(90, true)); //Drive a certain distance
//        addSequential(new DriveBase_Turn(60)); //Turn 30 degrees
//        addSequential(new DriveBase_DriveDistance(6, false)); //Drive up to peg

//        addSequential(new DriveBase_VisionTurn(() -> {
//            return SmartDashboard.getNumber("Vision Center X: ", 0.5) - .5;
//        }));


//        addSequential(new DriveBase_DriveDistance(-16,false)); // Back up a bit
//        addSequential(new DriveBase_Turn(-60)); // Straighten out
        addSequential(new DriveBase_DriveDistance(54,true)); // Drive to line
        addSequential(new DriveBase_Turn(45)); // turn some angle
        addSequential(new DriveBase_DriveDistance(200,true,false)); // DRIVE ALL THE WAY
        addSequential(new DriveBase_Turn(-45)); // face the retrieval zone
    }
}
