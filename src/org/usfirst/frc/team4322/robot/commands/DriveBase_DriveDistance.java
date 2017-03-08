package org.usfirst.frc.team4322.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team4322.robot.Robot;
import org.usfirst.frc.team4322.robot.RobotMap;

import java.util.function.DoubleSupplier;

/**
 * Created by software on 2/2/17.
 */
public class DriveBase_DriveDistance extends Command
{
    private double dist, lastErr, acc, err, out;
    private double current, lastErrTurn, accTurn, outTurn;
    private DoubleSupplier errTurn;
    private boolean isUsingVisionTurn = false;
    private boolean done = false;
    public DriveBase_DriveDistance (double dist)
    {
        this.dist = dist;
        requires(Robot.driveBase);
    }
    public DriveBase_DriveDistance (double dist, boolean isUsingVisionTurn, DoubleSupplier errTurn)
    {
        this.dist = dist;
        this.isUsingVisionTurn = isUsingVisionTurn;
        this.errTurn = errTurn;
        requires(Robot.driveBase);
    }

    @Override
    public synchronized void start()
    {
        super.start();
      Robot.driveBase.resetEncoder();
      done=false;
    }

    @Override
    public void end()
    {
        Robot.driveBase.drive(0,0);
    }


    @Override
    public void execute()
    {
        //Vision stuff
        if (isUsingVisionTurn)
        {
            double current = errTurn.getAsDouble();
            if(current <= -.6 || Math.abs(current) < .025)
            {
                outTurn = 0;
            }
            else {
                outTurn = current * RobotMap.DRIVEBASE_AIM_P + lastErr * RobotMap.DRIVEBASE_AIM_D;
                if (Math.abs(current) <= RobotMap.DRIVEBASE_AIM_IZONE) {
                    outTurn += RobotMap.DRIVEBASE_AIM_I * acc;
                } else {
                    accTurn = 0;
                }
                accTurn += current;
                lastErrTurn = current;
            }
        }
        else
        {
            outTurn = 0;
        }

        //Drive distance PID
        double cur = Robot.driveBase.getDist();
        err = (dist-cur);
        out = -err*(RobotMap.DRIVEBASE_DRIVE_P/10) - acc*(RobotMap.DRIVEBASE_DRIVE_I/100) + lastErr*RobotMap.DRIVEBASE_DRIVE_D;
        SmartDashboard.putNumber("Drive Error: ",cur-dist);
        if(Math.abs(err)<=2)
        {
            Robot.driveBase.drive(0,0);
            acc = 0;
            done = true;
        }
        else if (cur < dist)
        {
            Robot.driveBase.drive(out,outTurn);
        }
        else if (cur > dist)
        {
	        Robot.driveBase.drive(out,outTurn);
        }
        acc += err;
        lastErr = err;
    }


    @Override
    protected boolean isFinished() {
        return done;
    }
}
