package org.usfirst.frc.team4322.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team4322.robot.Robot;

/**
 * Created by Software on 1/31/2017.
 */
public class DriveBase_Turn extends Command
{
    private double angle;
    private double power;
    public DriveBase_Turn(double angle, double power)
    {
        this.angle = angle;
        this.power = power;
        requires(Robot.driveBase);
    }

    @Override
    public synchronized void start()
    {
        super.start();
        Robot.driveBase.resetNavX();
    }


    @Override
    public void end()
    {
        Robot.driveBase.drive(0,0);
    }

    @Override
    protected void interrupted()
    {

    }

    @Override
    public void execute()
    {
        double err = angle - Robot.driveBase.getAngle();
        Robot.driveBase.drive(0,power*-err);
    }

    @Override
    public boolean isFinished()
    {
        return false;
    }
}
