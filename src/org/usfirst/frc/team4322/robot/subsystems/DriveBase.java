package org.usfirst.frc.team4322.robot.subsystems;

import org.usfirst.frc.team4322.robot.RobotMap;
import org.usfirst.frc.team4322.robot.commands.DriveBase_DriveManual;

import com.ctre.CANTalon;
import com.ctre.CANTalon.TalonControlMode;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.I2C.Port;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveBase extends Subsystem
{

    private CANTalon leftMaster,leftSlave,rightMaster,rightSlave;
    private AHRS navx;
    private RobotDrive drive;
    
    public DriveBase()
    {
        leftMaster = new CANTalon(RobotMap.DRIVEBASE_MOTORCONTROLLER_LEFT_MASTER_ADDR);
        leftMaster.changeControlMode(TalonControlMode.Voltage);
        rightMaster = new CANTalon(RobotMap.DRIVEBASE_MOTORCONTROLLER_RIGHT_MASTER_ADDR);
        rightMaster.changeControlMode(TalonControlMode.Voltage);
        leftSlave = new CANTalon(RobotMap.DRIVEBASE_MOTORCONTROLLER_LEFT_SLAVE_ADDR);
        leftSlave.changeControlMode(TalonControlMode.Follower);
        rightSlave = new CANTalon(RobotMap.DRIVEBASE_MOTORCONTROLLER_RIGHT_SLAVE_ADDR);
        rightSlave.changeControlMode(TalonControlMode.Follower);
        drive = new RobotDrive(left,right);
        navx = new AHRS(Port.kMXP);
    }
    
    @Override
    protected void initDefaultCommand()
    {
        setDefaultCommand(new DriveBase_DriveManual());
    }
    
    public void set(double pow, double rot)
    {
        drive.arcadeDrive(pow, rot);
    }

}
