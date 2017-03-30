package org.usfirst.frc.team4322.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Created by teresamachado on 3/6/17.
 */
public class AutoGroup_Hopper extends CommandGroup
{
	public AutoGroup_Hopper()
	{
		addSequential(new Group_HomePivot());
		addSequential(new DriveBase_DriveDistance(-78,true,0.6,true,0.31)); //Drive a distance
		addSequential(new DriveBase_Turn(90)); //Turn 90 degrees
		addSequential(new DriveBase_DriveDistance(-60,true,0.6,true,0.31)); //Drive up to hopper
//		addSequential(new Vision_RunBoiler());
//		addParallel(new Shooter_Spin());
//		addSequential(new Group_StartIndex()); //start shooting

	}
}
