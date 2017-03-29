package org.usfirst.frc.team4322.robot.commands;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team4322.robot.Robot;

/**
 * Created by software on 2/19/17.
 */
public class GearGrabber_EjectGear extends Command
{

    public GearGrabber_EjectGear()
    {
        requires(Robot.gearGrabber);
    }

    @Override
    protected void execute()
    {
        Robot.gearGrabber.set(Relay.Value.kForward);
    }

    @Override
    protected boolean isFinished()
    {
        return false;
    }
}
