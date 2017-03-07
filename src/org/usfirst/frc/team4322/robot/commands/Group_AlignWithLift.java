package org.usfirst.frc.team4322.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Created by software on 2/2/17.
 */
public class Group_AlignWithLift extends CommandGroup
{
    public Group_AlignWithLift()
    {
        double xDist = SmartDashboard.getNumber("Vision Distance (in): ",0)*Math.cos(SmartDashboard.getNumber("Vision Angle X: ", 0)); // Distance and Vision Angle X are just filler keys for now
        double yDist = SmartDashboard.getNumber("Vision Distance (in): ", 0)*Math.sin(SmartDashboard.getNumber("Vision Angle X: ", 0));
        addSequential(new DriveBase_Turn(SmartDashboard.getNumber("Vision Angle X: ",0), 0.6));
        addSequential(new DriveBase_DriveDistance(xDist));
        addSequential(new DriveBase_Turn(90, 0.6));
        addSequential(new DriveBase_DriveDistance(yDist));
    }
}
