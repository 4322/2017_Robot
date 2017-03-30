package org.usfirst.frc.team4322.robot.commands;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team4322.robot.Robot;

/**
 * Created by software on 2/19/17.
 */
public class GearGrabber_HoldGear extends Command
{

    public GearGrabber_HoldGear()
    {
        requires(Robot.gearGrabber);
    }

    @Override
    protected void execute()
    {
        Robot.gearGrabber.set(0);
    }

    @Override
    protected boolean isFinished()
    {
        return false;
    }
}
