package org.usfirst.frc.team4322.robot.commands;

import org.usfirst.frc.team4322.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class Command_Interrupt extends Command
{

    public Command_Interrupt()
    {
        requires(Robot.driveBase);
        requires(Robot.shooter);
        requires(Robot.indexer);
    }
    
    @Override
    protected boolean isFinished()
    {
        // TODO Auto-generated method stub
        return true;
    }

}
