package org.usfirst.frc.team4322.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team4322.robot.Robot;

/**
 * Created by Garrett Luu on 3/5/2017.
 */
public class Conveyor_Stop extends Command
{
    public Conveyor_Stop()
    {
        requires(Robot.conveyor);
    }
    @Override
    protected void initialize()
    {

    }

    @Override
    protected void execute()
    {
        Robot.conveyor.set(0);
    }

    @Override
    protected boolean isFinished()
    {
        return true;
    }

    @Override
    protected void end()
    {

    }

    @Override
    protected void interrupted()
    {

    }
}
