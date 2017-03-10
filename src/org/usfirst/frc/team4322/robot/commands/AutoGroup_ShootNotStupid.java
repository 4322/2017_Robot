package org.usfirst.frc.team4322.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Created by software on 3/5/17.
 */
public class AutoGroup_ShootNotStupid extends CommandGroup
{
    public AutoGroup_ShootNotStupid()
    {
        addSequential(new Shooter_Spin(),2);
        addSequential(new Group_StartIndex());
	    addSequential(new Command_Delay(8000));
	    addParallel(new Group_StopIndex());
	    addSequential(new DriveBase_FMSDrive(100));
    }
}
