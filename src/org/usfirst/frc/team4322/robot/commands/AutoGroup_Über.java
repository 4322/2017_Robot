package org.usfirst.frc.team4322.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Created by teresamachado on 3/6/17.
 */
public class AutoGroup_Über extends CommandGroup
{
	public AutoGroup_Über()
	{
		addSequential(new DriveBase_DriveDistance(90)); //Drive a distance
		addSequential(new DriveBase_Turn(90)); //Turn 90 degrees
		addParallel(new HopperFlopper_LoadHopper()); //Ready for hopper
		addSequential(new DriveBase_DriveDistance(27/2)); //Drive up to hopper
		addSequential(new Vision_RunBoiler());
		addParallel(new Shooter_Spin());
		addSequential(new Group_StartIndex()); //start shooting

	}
}
