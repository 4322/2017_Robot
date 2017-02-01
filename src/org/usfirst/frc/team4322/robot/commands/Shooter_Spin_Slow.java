package org.usfirst.frc.team4322.robot.commands;

import org.usfirst.frc.team4322.robot.Robot;
import org.usfirst.frc.team4322.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Shooter_Spin_Slow extends Command
{
    public Shooter_Spin_Slow()
    {
        requires(Robot.shooter); 
    }
    
    @Override
    public void execute()
    {
        Robot.shooter.set(RobotMap.SHOOTER_RPM_SINGLE);
        SmartDashboard.putNumber("Shooter Actual RPM: ", Robot.shooter.get());
    }
    
    @Override
    protected boolean isFinished()
    {
        // TODO Auto-generated method stub
        return false;
    }

}
