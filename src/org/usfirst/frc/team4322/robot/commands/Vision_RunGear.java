package org.usfirst.frc.team4322.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team4322.robot.Robot;

/**
 * Created by software on 2/3/17.
 */
public class Vision_RunGear extends Command {
    public Vision_RunGear()
    {
        requires(Robot.vision);
    }

    @Override
    protected void execute() {
        SmartDashboard.putNumber("Vision RunMode: ",2);
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}
