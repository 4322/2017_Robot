package org.usfirst.frc.team4322.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Created by Garrett Luu on 3/5/2017.
 */
public class Group_StopIndex extends CommandGroup
{
    public Group_StopIndex()
    {
        addSequential(new Conveyor_Stop());
        addParallel(new Indexer_Stop());
    }
}
