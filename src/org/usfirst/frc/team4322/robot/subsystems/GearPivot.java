package org.usfirst.frc.team4322.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogTrigger;
import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team4322.robot.RobotMap;
import org.usfirst.frc.team4322.robot.commands.GearPivot_Hold;

public class GearPivot extends Subsystem
{

    private Victor victor;
    private Counter encoder;
    private AnalogTrigger trig;

    public GearPivot()
    {
        victor = new Victor(RobotMap.GEAR_PIVOT_VICTOR_PORT);
        trig = new AnalogTrigger(0);
        trig.setLimitsVoltage(3.2,4.7);
        encoder = new Counter(trig);
    }

    @Override
    protected void initDefaultCommand()
    {
        setDefaultCommand(new GearPivot_Hold());
    }

    public void set(double val)
    {
        victor.set(val);
    }

    public int get()
    {
        return encoder.get();
    }
    public void reset()
    {
        encoder.reset();
    }


}
