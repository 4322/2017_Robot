package org.usfirst.frc.team4322.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team4322.robot.RobotMap;
import org.usfirst.frc.team4322.robot.commands.GearGrabber_HoldGear;

public class GearGrabber extends Subsystem
{

    private Spark spark;

    public GearGrabber()
    {
        spark = new Spark(RobotMap.GEAR_GRABBER_SPARK_PORT);
    }
    @Override
    protected void initDefaultCommand()
    {
        setDefaultCommand(new GearGrabber_HoldGear());
    }

    public void set(double val)
    {
        spark.set(val);
    }

}
