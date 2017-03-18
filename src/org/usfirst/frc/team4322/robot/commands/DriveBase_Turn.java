package org.usfirst.frc.team4322.robot.commands;

import edu.wpi.first.wpilibj.RobotBase;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team4322.robot.Robot;
import org.usfirst.frc.team4322.robot.RobotMap;

/**
 * Created by Software on 1/31/2017.
 */
public class DriveBase_Turn extends Command
{
    private double angle, lastErr, acc;
    private int counter = 0;
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
        Robot.driveBase.resetNavX();
        Robot.driveBase.resetNavX();
        Robot.driveBase.resetNavX();
        done = false;
        counter = 0;
    }

    @Override
    protected void interrupted()
    {

    }

    @Override
    public void execute()
    {
        double err = (angle - Robot.driveBase.getAngle());
        SmartDashboard.putNumber("Turn Error: ",err);
        SmartDashboard.putNumber("Robot Yaw:",Robot.driveBase.getAngle());
        double out = err * RobotMap.DRIVEBASE_AIM_P/100 + lastErr*RobotMap.DRIVEBASE_AIM_D/100;
        out += Math.copySign(.4,out) + ((err <= RobotMap.DRIVEBASE_AIM_IZONE) ? acc* RobotMap.DRIVEBASE_AIM_I/100 : (acc=0));

        if(Math.abs(err)<=RobotMap.AUTON_DRIVE_TOLERANCE)
        {
            Robot.driveBase.drive(0,0);
            acc = 0;
            counter++;
            if(counter == 7)
                done = true;
        }
        else
        {
            counter = 0;
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
