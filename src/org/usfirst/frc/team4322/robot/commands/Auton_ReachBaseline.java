package org.usfirst.frc.team4322.robot.commands;

import org.usfirst.frc.team4322.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Auton_ReachBaseline extends Command
{

    public Auton_ReachBaseline()
    {
        requires(Robot.driveBase);
    }


    // Called just before this Command runs the first time
    protected void initialize()
    {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute()
    {
        Robot.driveBase.resetEncoder();
        if (Robot.driveBase.getDist() < 93.25) // if it hasn't traveled the distance to baseline
        {
            Robot.driveBase.drive(-.6, 0); // drive with some arbitrary power
        }
        else
        {
            Robot.driveBase.drive(0, 0); // don't drive
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished()
    {
        return false;
    }

    // Called once after isFinished returns true
    protected void end()
    {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted()
    {
    }
}
