package org.usfirst.frc.team4322.robot.subsystems;


import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;
import com.ctre.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team4322.robot.RobotMap;

public class Collector extends Subsystem
{
    private CANTalon collector;

    public Collector()
    {
        // Collector on CAN Channel 30
        collector = new CANTalon(RobotMap.COLLECTOR_MOTORCONTROLLER_ADDR);
        // Use the MAG Encoder on the shaft as the feedback device
        //collector.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Absolute);
        // Let's run closed-loop voltage-percentage control mode for now...
        collector.changeControlMode(TalonControlMode.PercentVbus);
        // Our encoder generates 4096 ticks per rev
        //collector.configEncoderCodesPerRev(4096);
        // Set our starting PID Control Values (P, I, D, FF, IZ, RR, Profile)
        //collector.setPID(RobotMap.INDEXER_P, RobotMap.INDEXER_I , RobotMap.INDEXER_D, RobotMap.INDEXER_F, RobotMap.INDEXER_IZ, RobotMap.INDEXER_R, 0);
        
    }
    
    @Override
    protected void initDefaultCommand()
    {
    }
    
    // This gets the current measured RPM
    public double get()
    {
        return collector.get();
        //return collector.getPosition();
    }

    public void set(double pos)
    {
        // Always set the target RPMs
        collector.set(pos);
    }
    public void stop()
    {
        collector.set(0);
        //collector.setEncPosition(0);
    }
}
