package org.usfirst.frc.team4322.robot.commands;

import org.usfirst.frc.team4322.robot.Robot;
import org.usfirst.frc.team4322.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Indexer_Index extends Command
{
    public Indexer_Index()
    {
        requires(Robot.indexer);
    }
    public static int i = 0;
    @Override
    public void execute()
    {
        Robot.indexer.set(RobotMap.INDEXER_POS+180.0*i++);
    }
    
    @Override
    protected boolean isFinished()
    {
        // TODO Auto-generated method stub
        return true;
    }

}
 