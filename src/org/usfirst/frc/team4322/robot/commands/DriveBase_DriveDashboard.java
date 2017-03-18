package org.usfirst.frc.team4322.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team4322.robot.Robot;
import org.usfirst.frc.team4322.robot.RobotMap;

/**
 * Created by software on 2/2/17.
 */
public class DriveBase_DriveDashboard extends Command
{
    private double dist,last,cur;
    private boolean done = false;
    private int counter = 0;
    public DriveBase_DriveDashboard()
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

    }


    @Override
    public void execute()
    {
        Robot.driveBase.drive(0, SmartDashboard.getNumber("Drive Power: "));
    }


    @Override
    protected boolean isFinished() {
        return false;
    }
}
