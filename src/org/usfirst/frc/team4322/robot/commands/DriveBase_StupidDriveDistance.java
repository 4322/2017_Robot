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
        max =  ticks;
        counter = 0;
        requires(Robot.driveBase);
    }

    @Override
    public synchronized void start()
    {
        super.start();
    }

    @Override
    public void end()
    {
        done = false;
        Robot.driveBase.drive(0,0);
    }


    @Override
    public void execute()
    {

	    Robot.driveBase.drive(-0.6,0);
	    counter+=1;
	    if(counter>=max) {
            done = true;
            counter = 0;
        }
    }


    @Override
    protected boolean isFinished() {
        return done;
    }
}
