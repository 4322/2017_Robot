package org.usfirst.frc.team4322.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team4322.robot.Robot;
import org.usfirst.frc.team4322.robot.subsystems.Conveyor;

/**
 * Created by Garrett Luu on 3/5/2017.
 */
public class Conveyor_Convey extends Command
{
    public Conveyor_Convey()
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
        Robot.conveyor.set(1);
    }

    @Override
    protected boolean isFinished()
    {
        return false;
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
