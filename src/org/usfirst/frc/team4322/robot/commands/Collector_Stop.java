package org.usfirst.frc.team4322.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team4322.robot.Robot;

public class Collector_Stop extends Command
{
    public Collector_Stop()

    {
        requires(Robot.collector);
    }
    
    @Override
    public void execute()
    {
        Robot.collector.set(0);
    }
    
    @Override
    protected boolean isFinished()
    {
        // TODO Auto-generated method stub
        return true;
    }

}
