package org.usfirst.frc.team4322.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogTrigger;
import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team4322.robot.RobotMap;
import org.usfirst.frc.team4322.robot.commands.GearPivot_Hold;

public class GearPivot extends Subsystem
{

    private Spark spark;
    private Counter encoder;
    private AnalogTrigger trig;
    private DigitalInput limit;
    public boolean high = false;
    public GearPivot()
    {
        spark = new Spark(RobotMap.GEAR_PIVOT_SPARK_PORT);
        trig = new AnalogTrigger(RobotMap.GEAR_PIVOT_ENCODER_ANALOG_PORT);
        trig.setLimitsVoltage(3.2,3.4);
        encoder = new Counter(trig);
        limit = new DigitalInput(RobotMap.GEAR_PIVOT_LIMIT_DIO_PORT);
    }

    @Override
    protected void initDefaultCommand()
    {
        setDefaultCommand(new GearPivot_Hold());
    }

    public void set(double val)
    {
        spark.set(val);
    }

    public boolean home()
    {
        return !limit.get();
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
