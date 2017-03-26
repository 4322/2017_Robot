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
    public synchronized void start() {
        super.start();
        if(!Robot.gearPivot.high)
        {
            this.cancel();
        }
    }

    @Override
    protected void execute()

    {
        if(Robot.gearPivot.get()  >= 40)
        {
            Robot.gearPivot.reset();
            Robot.gearPivot.high = false;
            Robot.gearPivot.set(0);
        }
        else
            Robot.gearPivot.set(-1);
    }

    @Override
    protected boolean isFinished()
    {
        return false;
    }

    @Override
    protected void end()
    {
        super.end();
    }
}
