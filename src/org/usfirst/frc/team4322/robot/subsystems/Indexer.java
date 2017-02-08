package org.usfirst.frc.team4322.robot.subsystems;


import org.usfirst.frc.team4322.robot.RobotMap;

import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;
import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Indexer extends Subsystem
{
    private CANTalon indexer;
    
    public Indexer()
    {
        // Indexer on CAN Channel 30
        indexer = new CANTalon(RobotMap.INDEXER_MOTORCONTROLLER_ADDR);
        // Use the MAG Encoder in the Versa-Planetary as the feedback device
        indexer.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Absolute);
        // Let's run closed-loop velocity control mode
        indexer.changeControlMode(TalonControlMode.Position);
        // Our encoder generates 4096 ticks per rev
        indexer.configEncoderCodesPerRev(8192);
        // Set our starting PID Control Values (P, I, D, FF, IZ, RR, Profile)
        indexer.setPID(RobotMap.INDEXER_P, RobotMap.INDEXER_I , RobotMap.INDEXER_D, RobotMap.INDEXER_F, RobotMap.INDEXER_IZ, RobotMap.INDEXER_R, 0);
    }
    
    @Override
    protected void initDefaultCommand()
    {
    }
    
    // This gets the current measured RPM
    public double get()
    {
        return indexer.getSpeed();
    }

    public void set(double pos)
    {
        // Always set the target RPMs
        indexer.set(pos);
    }
}
