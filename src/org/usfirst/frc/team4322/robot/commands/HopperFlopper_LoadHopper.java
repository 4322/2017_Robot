package org.usfirst.frc.team4322.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team4322.robot.Robot;

/**
 * Created by software on 2/19/17.
 */
public class HopperFlopper_LoadHopper extends Command {

    public HopperFlopper_LoadHopper()
    {
        requires(Robot.hopperFlopper);
    }
    @Override
    protected void execute() {
        Robot.hopperFlopper.set(-1);
    }

    @Override
    protected boolean isFinished() {
        return true;
    }
}