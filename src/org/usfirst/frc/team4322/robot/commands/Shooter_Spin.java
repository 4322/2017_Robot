package org.usfirst.frc.team4322.robot.commands;

import org.usfirst.frc.team4322.robot.Robot;
import org.usfirst.frc.team4322.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Shooter_Spin extends Command
{
    public Shooter_Spin()
    {
        requires(Robot.shooter); 
    }
    
    @Override
    public void execute()
    {
        Robot.shooter.set(RobotMap.SHOOTER_RPM);
        SmartDashboard.putNumber("Shooter Actual RPM: ", Robot.shooter.get());
    }
    
    @Override
    protected boolean isFinished()
    {
        // TODO Auto-generated method stub
        return false;
    }

}
