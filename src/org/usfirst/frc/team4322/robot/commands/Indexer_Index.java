package org.usfirst.frc.team4322.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team4322.robot.Robot;
import org.usfirst.frc.team4322.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class Indexer_Index extends Command
{
    public Indexer_Index()
    {
        requires(Robot.indexer);
        SmartDashboard.putNumber("Indexer Start: ",0.5);
    }

    @Override
    public synchronized void start() {
        super.start();
    }

    @Override
    protected void end()
    {
    }
    @Override
    public void execute() {
        Robot.indexer.set(SmartDashboard.getNumber("Indexer Start: ",0.5));
    }
    
    @Override
    protected boolean isFinished()
    {
        // TODO Auto-generated method stub
        return false;
    }

}
 