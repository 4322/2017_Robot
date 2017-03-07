package org.usfirst.frc.team4322.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Created by software on 3/6/17.
 */
public class AutoGroup_ReachBaseline extends CommandGroup
{
    public AutoGroup_ReachBaseline()
    {
        addSequential(new DriveBase_DriveDistance(90));
    }
}
