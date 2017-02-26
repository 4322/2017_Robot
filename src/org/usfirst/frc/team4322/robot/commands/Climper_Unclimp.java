package org.usfirst.frc.team4322.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team4322.robot.Robot;

/**
 * Created by software on 2/25/17.
 */
public class Climper_Unclimp extends Command
{
    public Climper_Unclimp()
    {
        requires(Robot.climper);
    }
    @Override
    public void execute()
    {
        Robot.climper.set(-1);
    }
    @Override
    public void end()
    {

    }
    @Override
    protected boolean isFinished() {
        return true;
    }
}
