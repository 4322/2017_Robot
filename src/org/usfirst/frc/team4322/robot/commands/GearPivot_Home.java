package org.usfirst.frc.team4322.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team4322.robot.Robot;

/**
 * Created by software on 2/19/17.
 */
public class GearPivot_Home extends Command
{

    public GearPivot_Home()
    {
        requires(Robot.gearPivot);
    }

    @Override
    protected void execute()
    {
        if(!Robot.gearPivot.home())
        {
            Robot.gearPivot.set(0.6);   // <- this should not happen if we are already home
                                        // This may not be needed if the command framework checks isFinished() before the first execute().
        }
        else
        {
            Robot.gearPivot.set(-0.1);
        }
    }

    @Override
    protected boolean isFinished()
    {
        return Robot.gearPivot.home();
    }

    @Override
    protected void end()
    {
        super.end();
        Robot.gearPivot.reset();
    }
}
