package org.usfirst.frc.team4322.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team4322.robot.Robot;
import org.usfirst.frc.team4322.robot.RobotMap;

/**
 * Created by software on 2/2/17.
 */
public class DriveBase_DriveDistance extends Command
{
    private double dist;
    private boolean done = false;
    private int counter = 0;
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
      Robot.driveBase.resetNavX();
      done=false;
      counter = 0;
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
        if(Math.abs(cur-dist )<= RobotMap.AUTON_DRIVE_TOLERANCE)
        {
            Robot.driveBase.drive(0,0);
            counter++;
            if(counter==3)
                done = true;

        }
        else
        {
            counter=0;
            Robot.driveBase.drive(RobotMap.DRIVEBASE_DRIVE_P*(cur-dist), -Robot.driveBase.getAngle() * RobotMap.DRIVEBASE_AIM_P);
        }
    }


    @Override
    protected boolean isFinished() {
        return done;
    }
}
