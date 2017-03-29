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
        addSequential(new Group_HomePivot());
        addSequential(new DriveBase_DriveDistance(86.5, true,0.6,true,0.31)); //Drive a certain distance
        addSequential(new DriveBase_FMSTurn(60)); //Turn 30 degrees
        addSequential(new DriveBase_DriveDistance(50, false,0.85,false)); //Drive up to peg
//        addSequential(new DriveBase_DriveExperiment(90,6,60,true));
        addSequential(new Group_EjectGear());
//        addSequential(new DriveBase_VisionTurn(() -> {
//            return SmartDashboard.getNumber("Vision Center X: ", 0.5) - .5;
//        }));

        addSequential(new DriveBase_DriveDistance(-30,false, 0.8, false)); // Back up a bit
        addSequential(new DriveBase_FMSTurn(-60)); // Straighten out

        addSequential(new DriveBase_DriveDistance(54,true, 0.8,false,0.54)); // Drive to line
//        addSequential(new DriveBase_FMSTurn(45)); // turn some angle
//        addSequential(new DriveBase_DriveDistance(200,true,false, false)); // DRIVE ALL THE WAY
//        addSequential(new DriveBase_FMSTurn(-45)); // face the retrieval zone
    }
}
