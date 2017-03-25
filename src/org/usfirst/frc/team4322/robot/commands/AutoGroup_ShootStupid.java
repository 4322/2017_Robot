package org.usfirst.frc.team4322.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Created by software on 3/5/17.
 */
public class AutoGroup_ShootStupid extends CommandGroup
{
    public AutoGroup_ShootStupid()
    {
        addSequential(new Group_HomePivot());
        addSequential(new Shooter_Spin(),4);
        addSequential(new Group_StartIndex(),6);
	    addParallel(new Group_StopIndex(),.1);
	    addParallel(new Shooter_Stop(),.1);
	    addSequential(new DriveBase_StupidFMSDrive(150),3);
    }
}
