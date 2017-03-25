package org.usfirst.frc.team4322.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Created by software on 3/6/17.
 */
public class AutoGroup_ThisIsStupid extends CommandGroup
{
    public AutoGroup_ThisIsStupid()
    {
        addSequential(new Group_HomePivot());
        addSequential(new DriveBase_StupidDriveDistance(150));
    }
}
