package org.usfirst.frc.team4322.robot.commands;

import org.usfirst.frc.team4322.robot.Robot;
import org.usfirst.frc.team4322.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class Indexer_Index extends Command
{
    public Indexer_Index()
    {
        requires(Robot.indexer);
        i = (int)Robot.indexer.get()+1;
    }
    public static int i = 0;
    @Override
    protected void end()
    {
        i = (int)Robot.indexer.get()+3;
    }
    @Override
    public void execute() {
        Robot.indexer.set(RobotMap.INDEXER_POS * i);
    }
    
    @Override
    protected boolean isFinished()
    {
        // TODO Auto-generated method stub
        return true;
    }

}
 