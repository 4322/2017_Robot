package org.usfirst.frc.team4322.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team4322.robot.OI;
import org.usfirst.frc.team4322.robot.Robot;

public class DriveBase_ReallyStupidDrive extends Command
{

    public DriveBase_ReallyStupidDrive()
    {
        requires(Robot.driveBase);
    }
    
    @Override
    protected void execute()
    {
        // TODO Auto-generated method stub
        Robot.driveBase.drive(.8,0); //cancer
    }

    @Override
    protected boolean isFinished()
    {
        // TODO Auto-generated method stub
        return Robot.driveBase.getRoll() < 2; // beyond malignant cancer
    }
    
}
