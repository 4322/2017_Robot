package org.usfirst.frc.team4322.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team4322.robot.RobotMap;
import org.usfirst.frc.team4322.robot.commands.Climper_Stop;

public class Climper extends Subsystem
{

    private Talon lift;
    public Climper()
    {
        lift = new Talon(RobotMap.CLIMPER_MOTORCONTROLLER_PORT);
    }
    public void set(double pow)
    {
        lift.set(pow);
    }
    @Override
    protected void initDefaultCommand()
    {
        setDefaultCommand(new Climper_Stop());
    }

}
