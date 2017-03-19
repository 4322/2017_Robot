package org.usfirst.frc.team4322.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Created by software on 3/5/17.
 */
public class AutoGroup_DoNothing extends CommandGroup
{
    public AutoGroup_DoNothing()
    {
        addSequential(new DriveBase_DriveExperiment(0,60, true));
    }
}
