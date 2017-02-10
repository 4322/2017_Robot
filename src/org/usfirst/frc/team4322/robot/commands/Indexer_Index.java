package org.usfirst.frc.team4322.robot.commands;

import org.usfirst.frc.team4322.robot.Robot;
import org.usfirst.frc.team4322.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class Indexer_Index extends Command
{
    public Indexer_Index()
    {
        requires(Robot.indexer);
        i = (int)Math.round(Robot.indexer.get()*2)/2;
    }
    public static int i = 0;
    @Override
    protected void end()
    {

    }
    @Override
    public void execute() {
        Robot.indexer.reset();
        Robot.indexer.set(RobotMap.INDEXER_POS * i);
        i++;
    }
    
    @Override
    protected boolean isFinished()
    {
        // TODO Auto-generated method stub
        return true;
    }

}
 