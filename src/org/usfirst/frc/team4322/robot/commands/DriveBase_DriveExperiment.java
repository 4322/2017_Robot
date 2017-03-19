package org.usfirst.frc.team4322.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team4322.robot.Robot;
import org.usfirst.frc.team4322.robot.RobotMap;

/**
 * Created by software on 2/2/17.
 */
public class DriveBase_DriveExperiment extends Command
{
    private double dist,dist2,angle,last,cur;
    private boolean usesNavx;
    private boolean done = false;
    private int counter = 0;
    public DriveBase_DriveExperiment(double dist, double dist2, double angle, boolean usesNavx)
    {
        this.dist = dist;
        this.dist2 = dist2;
        this.angle = angle;
        this.usesNavx = usesNavx;
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
        last=0;      Robot.driveBase.resetEncoder();
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
            double outRot = usesNavx ? ((Math.atan(Math.tan(angle*Math.PI/180)/(1+Math.pow(Math.E,(-RobotMap.TURN_GAIN)*(cur-(dist)))) * 180 / Math.PI)-Robot.driveBase.getAngle() * RobotMap.DRIVEBASE_NAVX_P) + Math.copySign(.395,-Robot.driveBase.getAngle())) : 0;
            Robot.driveBase.drive(out, outRot);
        }
    }


    @Override
    protected boolean isFinished() {
        return done;
    }
}
