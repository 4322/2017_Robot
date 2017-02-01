package org.usfirst.frc.team4322.robot.commands;

import org.usfirst.frc.team4322.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class Shooter_Stop extends Command
{
    public Shooter_Stop()
    {
        requires(Robot.shooter); 
    }
    
    @Override
    public void execute()
    {
        Robot.shooter.set(0);
    }
    
    @Override
    protected boolean isFinished()
    {
        // TODO Auto-generated method stub
        return true;
    }

}
