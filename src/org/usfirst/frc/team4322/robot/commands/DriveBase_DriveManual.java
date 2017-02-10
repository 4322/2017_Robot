package org.usfirst.frc.team4322.robot.commands;

import org.usfirst.frc.team4322.robot.OI;
import org.usfirst.frc.team4322.robot.Robot;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Command;

public class DriveBase_DriveManual extends Command
{

    public DriveBase_DriveManual()
    {
        requires(Robot.driveBase);
    }
    
    @Override
    protected void execute()
    {
        // TODO Auto-generated method stub
        Robot.driveBase.set(OI.pilot.leftStick.getY(), OI.pilot.rightStick.getX());
    }

    @Override
    protected boolean isFinished()
    {
        // TODO Auto-generated method stub
        return false;
    }
    
}
