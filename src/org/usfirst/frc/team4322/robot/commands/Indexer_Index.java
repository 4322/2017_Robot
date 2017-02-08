package org.usfirst.frc.team4322.robot.commands;

import org.usfirst.frc.team4322.robot.Robot;
import org.usfirst.frc.team4322.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import java.util.function.DoubleSupplier;

public class Indexer_Index extends Command
{
    private double lastErr, acc;
    private DoubleSupplier err;
    public Indexer_Index(DoubleSupplier err)
    {
        this.err = err;
        requires(Robot.indexer);
    }
    public static int i = 0;
    @Override
    protected void initialize()
    {
        Robot.indexer.set(1);
    }
    @Override
    protected void end()
    {
        Robot.indexer.set(0);
    }
    @Override
    public void execute()
    {
//        Robot.indexer.set(RobotMap.INDEXER_POS);
        double current = err.getAsDouble();
        if(current <= -.6 || Math.abs(current) < .025)
        {
            Robot.indexer.set(0);
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
        Robot.indexer.set(out);
        acc += current;
        lastErr = current;
    }
    
    @Override
    protected boolean isFinished()
    {
        // TODO Auto-generated method stub
        return true;
    }

}
 