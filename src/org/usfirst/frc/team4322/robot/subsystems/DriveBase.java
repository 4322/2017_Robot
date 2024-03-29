package org.usfirst.frc.team4322.robot.subsystems;

import org.usfirst.frc.team4322.logging.RobotLogger;
import org.usfirst.frc.team4322.robot.RobotMap;
import org.usfirst.frc.team4322.robot.commands.DriveBase_DriveManual;

import com.ctre.CANTalon;
import com.ctre.CANTalon.TalonControlMode;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.SPI.Port;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveBase extends Subsystem
{

    private CANTalon leftMaster,leftSlave,rightMaster,rightSlave;
    private AHRS navx;
    private RobotDrive drive;
    private static final double ticksToDist = 4*Math.PI;
    double offset = 0.0;
    double offsetNavX = 0;

    public DriveBase()
    {
        try {
            leftMaster = new CANTalon(RobotMap.DRIVEBASE_MOTORCONTROLLER_LEFT_MASTER_ADDR);
            leftMaster.changeControlMode(TalonControlMode.PercentVbus);
            leftMaster.setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder);
            leftMaster.setCloseLoopRampRate(RobotMap.DRIVEBASE_TALON_RAMP_RATE);
            leftMaster.setVoltageRampRate(RobotMap.DRIVEBASE_TALON_RAMP_RATE);
            leftMaster.configEncoderCodesPerRev(RobotMap.DRIVEBASE_ENCODER_COUNTS_PER_REV);
            rightMaster = new CANTalon(RobotMap.DRIVEBASE_MOTORCONTROLLER_RIGHT_MASTER_ADDR);
            rightMaster.changeControlMode(TalonControlMode.PercentVbus);
            rightMaster.setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder);
            rightMaster.setCloseLoopRampRate(RobotMap.DRIVEBASE_TALON_RAMP_RATE);
            rightMaster.setVoltageRampRate(RobotMap.DRIVEBASE_TALON_RAMP_RATE);
            rightMaster.configEncoderCodesPerRev(RobotMap.DRIVEBASE_ENCODER_COUNTS_PER_REV);
            leftSlave = new CANTalon(RobotMap.DRIVEBASE_MOTORCONTROLLER_LEFT_SLAVE_ADDR);
            leftSlave.changeControlMode(TalonControlMode.Follower);
            leftSlave.set(RobotMap.DRIVEBASE_MOTORCONTROLLER_LEFT_MASTER_ADDR);
            rightSlave = new CANTalon(RobotMap.DRIVEBASE_MOTORCONTROLLER_RIGHT_SLAVE_ADDR);
            rightSlave.changeControlMode(TalonControlMode.Follower);
            rightSlave.set(RobotMap.DRIVEBASE_MOTORCONTROLLER_RIGHT_MASTER_ADDR);
            drive = new RobotDrive(leftMaster, rightMaster);
            navx = new AHRS(Port.kMXP);


            RobotLogger.getInstance().log("DriveBase subsystem initialized.");
        }
        catch (Exception ex)
        {
            RobotLogger.getInstance().err("DriveBase subsystem failed to initialize.");
        }
    }
    @Override
    protected void initDefaultCommand()
    {
        setDefaultCommand(new DriveBase_DriveManual());
    }

    public double getDist()
    {
        return ((leftMaster.getPosition() * ticksToDist ));
    }

    public double getSpeed() {return leftMaster.getEncVelocity(); }

    public double getRoll() {
        return navx.getRawAccelZ();
    }

    public double getAngle()
    {
        return (navx.getYaw() - offsetNavX);
    }

    public void resetNavX()
    {
        offsetNavX = navx.getYaw();

    }
    public void autoDrive(double pow, double rot)
    {
        drive.drive(pow,rot);
    }

    public void drive(double pow, double rot)
    {
        drive.arcadeDrive(pow, -rot, true);

    }


    public void resetEncoder()
    {
        leftMaster.reverseSensor(true);
        leftMaster.setPosition(0);
        leftMaster.setEncPosition(0);
        offset = leftMaster.getEncPosition();
        try {
            Thread.sleep(30);
        } catch (InterruptedException e) {
        }
    }
}
