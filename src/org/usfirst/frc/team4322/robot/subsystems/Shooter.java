package org.usfirst.frc.team4322.robot.subsystems;

import org.usfirst.frc.team4322.robot.RobotMap;

import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;
import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Shooter extends Subsystem
{

    private CANTalon master,slave;
    
    public Shooter()
    {
        // Shooter master on CAN Channel 11
        master = new CANTalon(RobotMap.SHOOTER_MOTORCONTROLLER_MASTER_ADDR);
        // Use the MAG Encoder in the Versa-Planetary as the feedback device
        master.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative);
        // Let's run closed-loop velocity control mode
        master.changeControlMode(TalonControlMode.Speed);
        // Our encoder generates 4096 ticks per rev
        master.configEncoderCodesPerRev(4096);
        // Set our starting PID Control Values (P, I, D, FF, IZ, RR, Profile)
        master.setPID(RobotMap.SHOOTER_P, RobotMap.SHOOTER_I , RobotMap.SHOOTER_D, RobotMap.SHOOTER_F, RobotMap.SHOOTER_IZ, RobotMap.SHOOTER_R, 0);
        master.enableBrakeMode(false);
        // Shooter slave on CAN Channel 13
        slave = new CANTalon(RobotMap.SHOOTER_MOTORCONTROLLER_SLAVE_ADDR);
        // Tell the slave to be a follower
        slave.changeControlMode(TalonControlMode.Follower);
        // Tell the slave to follow the master on Channel 11
        slave.set(RobotMap.SHOOTER_MOTORCONTROLLER_MASTER_ADDR);
        slave.enableBrakeMode(false);
    }
    
    @Override
    protected void initDefaultCommand()
    {
    }
    
    // This gets the current measured RPM
    public double get()
    {
        return master.getSpeed();
    }
    
    // This sets the RPM for the shooter wheel using velocity PID
    public void set(double rpm)
    {
        // If we are stopping the shooter...
        if(rpm == 0)
        {
            // Disable control and stop PID
            master.disableControl();
        }
        else
        {
            // Enable control for Velocity PID
            master.enableControl();
        }
        // Always drive the target RPMs
        master.set(rpm);
    }

}
