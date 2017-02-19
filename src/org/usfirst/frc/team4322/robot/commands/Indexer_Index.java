package org.usfirst.frc.team4322.robot.commands;

import org.usfirst.frc.team4322.robot.Robot;
import org.usfirst.frc.team4322.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class Indexer_Index extends Command
{
    public Indexer_Index()
    {
        requires(Robot.indexer);
    }
    public static int i = 0;

    @Override
    public synchronized void start() {
        super.start();
        Robot.indexer.reset();
    }

    @Override
    protected void end()
    {
    }
    @Override
    public void execute() {
        Robot.indexer.set(1.5);
        i++;
    }
    
    @Override
    protected boolean isFinished()
    {
        // TODO Auto-generated method stub
        return true;
    }

}
 