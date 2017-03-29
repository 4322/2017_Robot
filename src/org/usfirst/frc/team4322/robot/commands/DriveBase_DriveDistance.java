package org.usfirst.frc.team4322.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.opencv.core.Mat;
import org.usfirst.frc.team4322.logging.RobotLogger;
import org.usfirst.frc.team4322.robot.Robot;
import org.usfirst.frc.team4322.robot.RobotMap;
import org.usfirst.frc.team4322.robot.subsystems.DriveBase;

/**
 * Created by software on 2/2/17.
 */
public class DriveBase_DriveDistance extends Command
{
    private double dist,last,cur,ceiling;
    private boolean usesNavx, caresAboutBacktrack;
    private boolean done = false;
    private int counter = 0;
    public DriveBase_DriveDistance (double dist)
    {
        this(dist,true,0.8);
    }
    public DriveBase_DriveDistance (double dist, boolean usesNavx)
    {
        this(dist,usesNavx,0.8);
    }
    public DriveBase_DriveDistance(double dist, boolean usesNavx, double ceiling)
    {
        this(dist,usesNavx,ceiling,true);
    }
    public DriveBase_DriveDistance (double dist, boolean usesNavx, double ceiling, boolean caresAboutBacktrack)
    {
        this.dist = dist;
        this.usesNavx = usesNavx;
        this.ceiling = ceiling;
        this.caresAboutBacktrack = caresAboutBacktrack;
        requires(Robot.driveBase);
    }

    @Override
    protected void initialize()
    {

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
        Robot.driveBase.drive(0,0);
        done=false;
        counter = 0;
        last=0;
        Robot.driveBase.resetEncoder();
        Robot.driveBase.resetNavX();
    }

    @Override
    protected void interrupted()
    {

    }


    @Override
    public void execute()
    {
        last=cur-dist;
        cur = Robot.driveBase.getDist();
        RobotLogger.getInstance().log("Target distance: %f",dist);
        RobotLogger.getInstance().log("Current distance: %f.",cur);
        RobotLogger.getInstance().log("Current error: %f.",dist-cur);
        RobotLogger.getInstance().update(false);
        SmartDashboard.putNumber("Drive Error: ",dist-cur);
        if(arrived()) // Are we there yet?
        {
            Robot.driveBase.drive(0,0); // Stop
            counter++; //increment end counter
            if(counter==7)
                done = true;

        }
        else
        {
            counter=0;
            double out = -(RobotMap.DRIVEBASE_DRIVE_P*(dist-cur)+RobotMap.DRIVEBASE_DRIVE_D*last); //PD Controller
            out += Math.copySign(.33,out); // Feed forward
            out = clamp(out,ceiling); // clamp to ceiling
            double outRot = 0;
            if(usesNavx)
            {
                outRot = ((Robot.driveBase.getAngle() * RobotMap.DRIVEBASE_NAVX_P)); // P controller
                outRot += Math.copySign(.395,Robot.driveBase.getAngle()); // feed forward
            }
            Robot.driveBase.autoDrive(out, outRot); //drive
        }
    }

    public double clamp(double val,double max)
    {
        if(val > max)
        {
            return max;
        }
        else if(val < -max)
        {
            return -max;
        }
        else
        {
            return val;
        }
    }

    private boolean arrived()
    {
        if(caresAboutBacktrack)
        {
            return (Math.abs(dist-cur) <= RobotMap.AUTON_DRIVE_TOLERANCE);
        }
        else
        {
            return Math.abs(cur) >= Math.abs(dist);
        }
    }

    @Override
    protected boolean isFinished() {
        return done;
    }
}
