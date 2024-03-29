package org.usfirst.frc.team4322.robot.subsystems;


import org.usfirst.frc.team4322.robot.RobotMap;

import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;
import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team4322.robot.commands.Indexer_Index;
import org.usfirst.frc.team4322.robot.commands.Indexer_Stop;

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
        indexer.changeControlMode(TalonControlMode.Speed);
        // Our encoder generates 4096 ticks per rev
        indexer.configEncoderCodesPerRev(4096);
        // Set our starting PID Control Values (P, I, D, FF, IZ, RR, Profile)
        indexer.setPID(RobotMap.INDEXER_P, RobotMap.INDEXER_I , RobotMap.INDEXER_D, RobotMap.INDEXER_F, RobotMap.INDEXER_IZ, RobotMap.INDEXER_R, 0);
        indexer.reverseSensor(false);
    }
    
    @Override
    protected void initDefaultCommand()
    {
        setDefaultCommand(new Indexer_Stop() );
    }
    
    // This gets the current measured RPM
    public double get() {
        return indexer.getPulseWidthPosition();
    }

    public void set(double pos)
    {
        if(pos == 0)
            indexer.disableControl();
        else
            indexer.enableControl();
        // Always drive the target RPMs
        indexer.set(pos);
    }
}
