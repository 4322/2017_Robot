package org.usfirst.frc.team4322.robot.subsystems;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team4322.robot.RobotMap;
import org.usfirst.frc.team4322.robot.commands.GearGrabber_HoldGear;

public class GearGrabber extends Subsystem
{

    private Relay spike;

    public GearGrabber()
    {
        spike = new Relay(RobotMap.GEAR_GRABBER_RELAY_PORT);
    }
    @Override
    protected void initDefaultCommand()
    {
        setDefaultCommand(new GearGrabber_HoldGear());
    }

    public void set(Relay.Value val)
    {
        spike.set(val);
    }

}
