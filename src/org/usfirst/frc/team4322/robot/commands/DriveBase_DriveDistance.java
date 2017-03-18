package org.usfirst.frc.team4322.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.opencv.core.Mat;
import org.usfirst.frc.team4322.robot.Robot;
import org.usfirst.frc.team4322.robot.RobotMap;

/**
 * Created by software on 2/2/17.
 */
public class DriveBase_DriveDistance extends Command
{
    private double dist,last,cur;
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

    }

    @Override
    public void end()
    {
        Robot.driveBase.drive(0,0);      done=false;
        counter = 0;
        last=0;      Robot.driveBase.resetEncoder();
        Robot.driveBase.resetNavX();
    }


    @Override
    public void execute()
    {
        last=cur-dist;
        cur = Robot.driveBase.getDist();
        SmartDashboard.putNumber("Drive Error: ",dist-cur);
        if(Math.abs(dist-cur) <= RobotMap.AUTON_DRIVE_TOLERANCE)
        {
            Robot.driveBase.drive(0,0);
            counter++;
            if(counter==7)
                done = true;

        }
        else
        {
            counter=0;
            double out = -(RobotMap.DRIVEBASE_DRIVE_P*(dist-cur)+RobotMap.DRIVEBASE_DRIVE_D*last);
            out += Math.copySign(.33,out);
            double outRot = -Robot.driveBase.getAngle() * RobotMap.DRIVEBASE_AIM_P;
            outRot += Math.copySign(.4,outRot);
            Robot.driveBase.drive(out, outRot);
        }
    }


    @Override
    protected boolean isFinished() {
        return done;
    }
}
