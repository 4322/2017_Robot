package org.usfirst.frc.team4322.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team4322.robot.Robot;

/**
 * Created by software on 2/19/17.
 */
public class GearPivot_Lower extends Command
{

    public GearPivot_Lower()
    {
        requires(Robot.gearPivot);
    }

    @Override
    protected void execute()
    {
        Robot.gearPivot.set(-1.0);
    }

    @Override
    protected boolean isFinished()
    {
        return Robot.gearPivot.get() >= 44;
    }

    @Override
    protected void end()
    {
        super.end();
        Robot.gearPivot.reset();
    }
}
