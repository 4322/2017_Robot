package org.usfirst.frc.team4322.robot.commands;

import org.usfirst.frc.team4322.robot.Robot;
import org.usfirst.frc.team4322.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import java.util.function.DoubleSupplier;

public class Indexer_Index extends Command
{
    public Indexer_Index()
    {
        requires(Robot.indexer);
    }
    @Override
    public void execute()
    {
        Robot.indexer.set(RobotMap.INDEXER_POS);
    }
    
    @Override
    protected boolean isFinished()
    {
        // TODO Auto-generated method stub
        return true;
    }

}
 