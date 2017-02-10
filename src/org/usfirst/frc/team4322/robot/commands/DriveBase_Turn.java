package org.usfirst.frc.team4322.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team4322.robot.Robot;

/**
 * Created by Software on 1/31/2017.
 */
public class DriveBase_Turn extends Command
{
    private double Angle;
    private double Power;
    public DriveBase_Turn(double Angle, double Power)
    {
        this.Angle = Angle;
        this.Power = Power;
        requires(Robot.driveBase);
    }

    @Override
    protected void initialize()
    {

    }

    @Override
    public void end()
    {
        Robot.driveBase.set(0,0);
    }

    @Override
    protected void interrupted()
    {

    }

    @Override
    public void execute()
    {
        if (Robot.driveBase.getAngle() < Angle)
        {
            Robot.driveBase.set(0,Power);
        }
        else if (Robot.driveBase.getAngle() > Angle)
        {
            Robot.driveBase.set(0,-Power);
        }
        else
        {
            Robot.driveBase.set(0,0);
            return;
        }
    }

    @Override
    public boolean isFinished()
    {
        return false;
    }
}
