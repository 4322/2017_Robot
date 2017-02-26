package org.usfirst.frc.team4322.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team4322.robot.RobotMap;
import org.usfirst.frc.team4322.robot.commands.HopperFlopper_Idle;

/**
 * Created by software on 2/25/17.
 */
public class HopperFlopper extends Subsystem {

    private Spark spark;

    public HopperFlopper() {
        spark = new Spark(RobotMap.HOPPER_FLOPPER_SPARK_PORT);
    }

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new HopperFlopper_Idle());
    }

    public void set(double power)
    {
        spark.set(power);
    }
}
