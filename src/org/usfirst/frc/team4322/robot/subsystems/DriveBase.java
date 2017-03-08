package org.usfirst.frc.team4322.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogGyro;
import org.usfirst.frc.team4322.robot.RobotMap;
import org.usfirst.frc.team4322.robot.commands.DriveBase_DriveManual;

import com.ctre.CANTalon;
import com.ctre.CANTalon.TalonControlMode;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.I2C.Port;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveBase extends Subsystem
{

    private CANTalon leftMaster,leftSlave,rightMaster,rightSlave;
    private AHRS navx;
    private RobotDrive drive;
//    private static final double ticksToDist = 0.4*Math.PI;
    private static final double ticksToDist = 4*Math.PI;
    double offset = 0.0;

    public DriveBase()
    {
        leftMaster = new CANTalon(RobotMap.DRIVEBASE_MOTORCONTROLLER_LEFT_MASTER_ADDR);
        leftMaster.changeControlMode(TalonControlMode.PercentVbus);
        leftMaster.setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder);
        leftMaster.setCloseLoopRampRate(48);
        leftMaster.setVoltageRampRate(48);
        leftMaster.configEncoderCodesPerRev(256);
        rightMaster = new CANTalon(RobotMap.DRIVEBASE_MOTORCONTROLLER_RIGHT_MASTER_ADDR);
        rightMaster.changeControlMode(TalonControlMode.PercentVbus);
        rightMaster.setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder);
        rightMaster.setCloseLoopRampRate(48);
        rightMaster.setVoltageRampRate(48);
        rightMaster.configEncoderCodesPerRev(256);
        leftSlave = new CANTalon(RobotMap.DRIVEBASE_MOTORCONTROLLER_LEFT_SLAVE_ADDR);
        leftSlave.changeControlMode(TalonControlMode.Follower);
        leftSlave.set(RobotMap.DRIVEBASE_MOTORCONTROLLER_LEFT_MASTER_ADDR);
        rightSlave = new CANTalon(RobotMap.DRIVEBASE_MOTORCONTROLLER_RIGHT_SLAVE_ADDR);
        rightSlave.changeControlMode(TalonControlMode.Follower);
        rightSlave.set(RobotMap.DRIVEBASE_MOTORCONTROLLER_RIGHT_MASTER_ADDR);
        drive = new RobotDrive(leftMaster,rightMaster);
        navx = new AHRS(Port.kMXP);
    }
    @Override
    protected void initDefaultCommand()
    {
        setDefaultCommand(new DriveBase_DriveManual());
    }

    public double getDist()
    {
        return (leftMaster.getEncPosition()) * (ticksToDist);
    }

    public double getSpeed() { return leftMaster.getEncVelocity(); }

    public double getAngle()
    {
        return navx.getYaw();
    }

    public void resetNavX()
    {
        navx.zeroYaw();
    }
    
    public void drive(double pow, double rot)
    {
        drive.arcadeDrive(pow, -rot, true);

    }

    public void resetEncoder()
    {
        leftMaster.setPosition(0);
        leftMaster.setEncPosition(0);
        offset = leftMaster.getEncPosition();
        try {
            Thread.sleep(30);
        } catch (InterruptedException e) {
        }
    }
}
