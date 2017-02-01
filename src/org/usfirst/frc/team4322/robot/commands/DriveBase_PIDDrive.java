package org.usfirst.frc.team4322.robot.commands;

import java.util.function.DoubleSupplier;

import org.usfirst.frc.team4322.dashboard.DashboardInputField;
import org.usfirst.frc.team4322.robot.Robot;
import org.usfirst.frc.team4322.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveBase_PIDDrive extends Command
{

    private double lastErr, acc;
    private DoubleSupplier err;
    @DashboardInputField(field="Drive Power: ")
    public static double drive;
    
    public DriveBase_PIDDrive(DoubleSupplier err)
    {
        this.err = err;
        requires(Robot.driveBase);
    }
    
    @Override
    protected void end()
    {
        Robot.driveBase.set(0,0);
    }

    @Override
    protected void execute()
    {
        double current = err.getAsDouble();
        if(current <= -.6 || Math.abs(current) < .025)
        {
            Robot.driveBase.set(0, 0);
            return;
        }
        SmartDashboard.putNumber("Current Error: ", current);
        double out = current*RobotMap.DRIVEBASE_AIM_P + lastErr*RobotMap.DRIVEBASE_AIM_D;
        if(Math.abs(current) <= RobotMap.DRIVEBASE_AIM_IZONE)
        {
            out += RobotMap.DRIVEBASE_AIM_I * acc;
        }
        else
        {
            acc = 0;
        }
        Robot.driveBase.set(drive,out);
        acc += current;
        lastErr = current;
    }

    @Override
    protected boolean isFinished()
    {
        // TODO Auto-generated method stub
        return false;
    }

}
