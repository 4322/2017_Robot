package org.usfirst.frc.team4322.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team4322.robot.Robot;

/**
 * Created by software on 2/19/17.
 */
public class GearGrabber_RetractGrabber extends Command
{
    int cycleCounter = 0;

    public GearGrabber_RetractGrabber()
    {
        requires(Robot.gearGrabber);
    }

    @Override
    protected void execute()
    {
        Robot.gearGrabber.set(1.0);
        cycleCounter++;
    }

    @Override
    protected boolean isFinished()
    {
        if(cycleCounter > 50)
        {
            cycleCounter = 0;
            return true;
        }
        else
        {
            return false;
        }
    }
}
