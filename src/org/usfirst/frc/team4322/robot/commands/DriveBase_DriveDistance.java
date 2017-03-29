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
    private double dist,last,cur;
    private boolean usesNavx, usesCeiling, caresAboutBacktrack;
    private boolean done = false;
    private int counter = 0;
    public DriveBase_DriveDistance (double dist)
    {
        this(dist,true,true);
    }
    public DriveBase_DriveDistance (double dist, boolean usesNavx)
    {
        this(dist,usesNavx,true);
    }
    public DriveBase_DriveDistance (double dist, boolean usesNavx, boolean usesCeiling)
    {
        this(dist,usesNavx,usesCeiling,true);
    }
    public DriveBase_DriveDistance (double dist, boolean usesNavx, boolean usesCeiling, boolean caresAboutBacktrack)
    {
        this.dist = dist;
        this.usesNavx = usesNavx;
        this.usesCeiling = usesCeiling;
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
        RobotLogger.getInstance().log("current distance is %d, current error is %d.",cur,dist-cur);
        SmartDashboard.putNumber("Drive Error: ",dist-cur);
        if(caresAboutBacktrack ? (Math.abs(dist-cur) <= RobotMap.AUTON_DRIVE_TOLERANCE) : Math.abs(cur) >= Math.abs(dist))
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
            out = usesCeiling ? (out > 0.8) ? 0.8 : ((out < -0.8) ? -.8 : out) : out; // (ಥ﹏ಥ) (ʘᗩʘ')
            double outRot = usesNavx ? ((-Robot.driveBase.getAngle() * RobotMap.DRIVEBASE_NAVX_P) + Math.copySign(.395,-Robot.driveBase.getAngle())) : 0;
            Robot.driveBase.drive(out, outRot);
        }
    }


    @Override
    protected boolean isFinished() {
        return done;
    }
}
