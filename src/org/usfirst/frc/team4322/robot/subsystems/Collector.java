package org.usfirst.frc.team4322.robot.subsystems;


import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;
import com.ctre.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team4322.robot.RobotMap;
import org.usfirst.frc.team4322.robot.commands.Collector_Stop;

public class Collector extends Subsystem
{
    private CANTalon collector;

    public Collector()
    {
        // Collector on CAN Channel 30
        collector = new CANTalon(RobotMap.COLLECTOR_MOTORCONTROLLER_ADDR);
        // Let's run closed-loop voltage-percentage control mode
        collector.changeControlMode(TalonControlMode.PercentVbus);

    }
    
    @Override
    protected void initDefaultCommand()
    {
        setDefaultCommand(new Collector_Stop());
    }

    public void set(double pos)
    {
        // Always set the target RPMs
        collector.set(pos);
    }

}
