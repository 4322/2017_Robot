package org.usfirst.frc.team4322.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team4322.robot.Robot;

/**
 * Created by software on 2/2/17.
 */
public class DriveBase_DriveDistance extends Command
{
    private double dist;
    private boolean done = false;
    public DriveBase_DriveDistance (double dist)
    {
        this.dist = dist;
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
        double cur = Robot.driveBase.getDist();
        SmartDashboard.putNumber("Drive Error: ",cur-dist);
        if(Math.abs(cur-dist )<=2)
        {
            Robot.driveBase.drive(0,0);
            done = true;
        }
        else if (cur < dist)
        {
            Robot.driveBase.drive(-.5,0);
        }
        else if (cur > dist)
        {
	        Robot.driveBase.drive(.5,0);
        }

    }


    @Override
    protected boolean isFinished() {
        return done;
    }
}
