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
    public static int i = 0;
<<<<<<< HEAD
    @Override
    protected void end()
    {

    }
    @Override
    public void execute()
    {
        Robot.indexer.reset();
        Robot.indexer.set(RobotMap.INDEXER_POS*i);
        i++;
=======
    @Override
    public void execute()
    {
        Robot.indexer.set(RobotMap.INDEXER_POS);
>>>>>>> 8e76860f9f1af2d7588c9e69711fdfba4b9a1dc2
    }
    
    @Override
    protected boolean isFinished()
    {
        // TODO Auto-generated method stub
        return true;
    }

}
 