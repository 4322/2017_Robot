package org.usfirst.frc.team4322.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team4322.robot.Robot;

/**
 * Created by software on 2/19/17.
 */
public class GearPivot_HomeToHigh extends Command
{

    public GearPivot_HomeToHigh()
    {
        requires(Robot.gearPivot);
    }

    @Override
    protected void execute()
    {
        Robot.gearPivot.set(-0.25);
    }

    @Override
    protected boolean isFinished()
    {
        return Robot.gearPivot.get() == 2;
    }

    @Override
    protected void end()
    {
        super.end();
        Robot.gearPivot.reset();
        Robot.gearPivot.high = true;
    }
}
