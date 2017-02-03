package org.usfirst.frc.team4322.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team4322.dashboard.DashboardInputField;
import org.usfirst.frc.team4322.robot.Robot;
import org.usfirst.frc.team4322.robot.RobotMap;
import org.usfirst.frc.team4322.robot.subsystems.DriveBase;

import java.util.function.DoubleSupplier;

/**
 * Created by software on 2/2/17.
 */
public class DriveBase_DriveDistance extends Command
{
    private double Dist;
    private double Power;
    public DriveBase_DriveDistance (double Dist, double Power)
    {
        this.Dist = Dist;
        this.Power = Power;
        requires(Robot.driveBase);
    }
    @Override
    protected void initialize()
    {

    }

    @Override
    public void end()
    {
        Robot.driveBase.set(0,0);
    }

    @Override
    protected void interrupted()
    {

    }

    @Override
    public void execute()
    {
        if (Robot.driveBase.getDist() < Dist)
        {
            Robot.driveBase.set(0,Power);
        }
        else if (Robot.driveBase.getDist() > Dist)
        {
            Robot.driveBase.set(0,-Power);
        }
        else
        {
            Robot.driveBase.set(0,0);
            return;
        }

    }


    @Override
    protected boolean isFinished() {
        return false;
    }
}
