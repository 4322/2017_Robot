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
        addSequential(new Group_HomePivot());
        addSequential(new Shooter_Spin(),2);
        addSequential(new Group_StartIndex(),8);
	    addParallel(new Group_StopIndex(),.1);
        addParallel(new Shooter_Stop(),.1);
	    addSequential(new DriveBase_FMSDrive(100, false, 1, false, 0.7));
    }
}
