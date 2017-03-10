package org.usfirst.frc.team4322.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team4322.robot.Robot;
import org.usfirst.frc.team4322.robot.RobotMap;

/**
 * Created by software on 2/2/17.
 */
public class DriveBase_StupidDriveDistance extends Command
{
    private boolean done = false;
    private int counter = 0, max = 0;
    public DriveBase_StupidDriveDistance(int ticks)
    {
        counter = max =  ticks;
        requires(Robot.driveBase);
    }

    @Override
    public synchronized void start()
    {
        super.start();
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

	    Robot.driveBase.drive(0.6,0);
	    counter++;
	    if(counter==max)
		    done = true;
    }


    @Override
    protected boolean isFinished() {
        return done;
    }
}
