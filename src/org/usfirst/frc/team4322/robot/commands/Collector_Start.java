package org.usfirst.frc.team4322.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team4322.robot.Robot;

public class Collector_Start extends Command
{
    public Collector_Start()
    {
        requires(Robot.collector);
    }
    
    @Override
    public void execute()
    {
        Robot.collector.set(1);
    }
    
    @Override
    protected boolean isFinished()
    {
        // TODO Auto-generated method stub
        return false;
    }

}
