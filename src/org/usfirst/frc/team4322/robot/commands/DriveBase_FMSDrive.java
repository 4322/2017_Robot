package org.usfirst.frc.team4322.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team4322.robot.Robot;
import org.usfirst.frc.team4322.robot.RobotMap;

/**
 * Created by teresamachado on 3/10/17.
 */
public class DriveBase_FMSDrive extends Command
{

	private double dist,last,cur;
	private boolean done = false;
	private int counter = 0;
	public DriveBase_FMSDrive (double dist)
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
		dist = DriverStation.getInstance().getAlliance() == DriverStation.Alliance.Blue ? dist : -dist;
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
		last=cur-dist;
		cur = Robot.driveBase.getDist();
		SmartDashboard.putNumber("Drive Error: ",cur-dist);
		if(Math.abs(cur-dist )<= RobotMap.AUTON_DRIVE_TOLERANCE)
		{
			Robot.driveBase.drive(0,0);
			counter++;
			if(counter==7)
				done = true;

		}
		else
		{
			counter=0;

			Robot.driveBase.drive((cur<dist) ?  Math.min(.7,RobotMap.DRIVEBASE_DRIVE_P*(cur-dist)+RobotMap.DRIVEBASE_DRIVE_D*last) :  Math.max(-.7,RobotMap.DRIVEBASE_DRIVE_P*(cur-dist)+RobotMap.DRIVEBASE_DRIVE_D*last), -Robot.driveBase.getAngle() * RobotMap.DRIVEBASE_AIM_P);
		}
	}


	@Override
	protected boolean isFinished() {
		return done;
	}
}