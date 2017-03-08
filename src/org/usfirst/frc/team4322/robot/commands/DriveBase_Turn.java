package org.usfirst.frc.team4322.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team4322.robot.Robot;
import org.usfirst.frc.team4322.robot.RobotMap;

/**
 * Created by Software on 1/31/2017.
 */
public class DriveBase_Turn extends Command
{
    private double angle, lastErr, acc;
    private boolean done = false;
    public DriveBase_Turn(double angle)
    {
        this.angle = angle;
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
        double out = err * RobotMap.DRIVEBASE_AIM_P + acc*RobotMap.DRIVEBASE_AIM_I + lastErr*RobotMap.DRIVEBASE_AIM_D;
        if(Math.abs(err)<=2)
        {
            Robot.driveBase.drive(0,0);
            acc = 0;
            done = false;
        }
        else
        {
            Robot.driveBase.drive(0, out);
        }
        acc += err;
        lastErr = err;
    }

    @Override
    public boolean isFinished()
    {
        return done;
    }
}
