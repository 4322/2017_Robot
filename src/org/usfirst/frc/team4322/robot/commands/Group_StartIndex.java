package org.usfirst.frc.team4322.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Created by Garrett Luu on 3/5/2017.
 */
public class Group_StartIndex extends CommandGroup
{
    public Group_StartIndex()
    {
        addParallel(new Indexer_Index());
        addSequential(new Conveyor_Convey());
    }
}
