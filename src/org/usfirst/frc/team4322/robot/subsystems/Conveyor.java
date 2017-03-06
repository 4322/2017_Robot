package org.usfirst.frc.team4322.robot.subsystems;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team4322.robot.Robot;
import org.usfirst.frc.team4322.robot.commands.Conveyor_Stop;

/**
 * Created by software on 3/5/17.
 */
public class Conveyor extends Subsystem {
    private Talon conveyer;
    public Conveyor()
    {
        conveyer = new Talon(2);
    }
    public void set(double pow)
    {
        conveyer.set(pow);
    }
    @Override
    protected void initDefaultCommand()
    {
        setDefaultCommand(new Conveyor_Stop());
    }
}
