package org.usfirst.frc.team4322.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Created by teresamachado on 3/6/17.
 */
public class AutoGroup_Hopper extends CommandGroup
{
	public AutoGroup_Hopper()
	{
		addParallel(new DriveBase_DriveDistance(-82)); //Drive up to peg
		addSequential(new DriveBase_VisionTurn(() -> {
			return SmartDashboard.getNumber("Vision Center X: ", 0.5) - .5;
		}));
		addSequential(new GearGrabber_EjectGear()); //Put gear on peg
		addSequential(new DriveBase_DriveDistance(6)); //Back up a bit
		addSequential(new DriveBase_Turn(90)); //Turn 90 degrees
		addParallel(new HopperFlopper_LoadHopper()); //Ready for hopper
		addSequential(new DriveBase_DriveDistance(27/2)); //Drive up to hopper
		addSequential(new Vision_RunBoiler());
		addParallel(new Shooter_Spin());
		addSequential(new Group_StartIndex()); //start shooting

	}
}
