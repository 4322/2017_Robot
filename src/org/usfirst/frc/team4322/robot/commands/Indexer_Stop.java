package org.usfirst.frc.team4322.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team4322.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class Indexer_Stop extends Command
{
    public Indexer_Stop()
    {
        requires(Robot.indexer);
        SmartDashboard.putNumber("Indexer Stop: ",0.5);
    }
    
    @Override
    public void execute()
    {
        Robot.indexer.set(SmartDashboard.getNumber("Indexer Stop: ",0.0));
    }
    
    @Override
    protected boolean isFinished()
    {
        // TODO Auto-generated method stub
        return true;
    }

}
