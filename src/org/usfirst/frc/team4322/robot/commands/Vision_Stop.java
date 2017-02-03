package org.usfirst.frc.team4322.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team4322.robot.Robot;

/**
 * Created by software on 2/3/17.
 */
public class Vision_Stop extends Command {
    public Vision_Stop()
    {
        requires(Robot.vision);
    }

    @Override
    protected void execute() {
        SmartDashboard.putNumber("Vision RunMode: ",0);
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}
