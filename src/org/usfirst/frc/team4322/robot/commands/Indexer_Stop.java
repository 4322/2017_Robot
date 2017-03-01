package org.usfirst.frc.team4322.robot.commands;

import org.usfirst.frc.team4322.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class Indexer_Stop extends Command
{
    public Indexer_Stop()
    {
        requires(Robot.indexer);
    }
    
    @Override
    public void execute()
    {
        Robot.indexer.set(0.75);
    }
    
    @Override
    protected boolean isFinished()
    {
        // TODO Auto-generated method stub
        return true;
    }

}
