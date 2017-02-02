package org.usfirst.frc.team4322.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team4322.robot.Robot;

/**
 * Created by Software on 1/31/2017.
 */
public class DriveBase_AlignWithLift extends Command
{
    public DriveBase_AlignWithLift()
    {
        requires(Robot.driveBase);
    }

    @Override
    protected void initialize()
    {

    }

    @Override
    public void end()
    {

    }

    @Override
    protected void interrupted()
    {

    }

    @Override
    public void execute()
    {
        // Right-triangle method
        double xDist = SmartDashboard.getNumber("Distance")*Math.cos(SmartDashboard.getNumber("Vision Angle X: ")); // Distance and Vision Angle X are just filler keys for now
        double yDist = SmartDashboard.getNumber("Distance")*Math.sin(SmartDashboard.getNumber("Vision Angle X: "));
        // crap i might need a gyro for this
        // TODO: turn a certain angle to be parallel with target
        // possibly use pid instead of bang-bang controller for this driving?
        if (Robot.driveBase.getDist() < xDist)
        {
            Robot.driveBase.set(.6, 0); // drive with some arbitrary power
        }
        else if (Robot.driveBase.getDist() > xDist)
        {
            Robot.driveBase.set(-.6,0);
        }
        else
        {
            Robot.driveBase.set(0, 0); // don't drive
        }
        // TODO: turn 90 degrees
        if (Robot.driveBase.getDist() < yDist)
        {
            Robot.driveBase.set(.6, 0); // drive with some arbitrary power
        }
        else if (Robot.driveBase.getDist() > yDist)
        {
            Robot.driveBase.set(-.6,0);
        }
        else
        {
            Robot.driveBase.set(0, 0); // don't drive
        }
    }

    @Override
    public boolean isFinished()
    {
        return false;
    }
}
