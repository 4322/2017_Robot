package org.usfirst.frc.team4322.robot.subsystems;

import org.usfirst.frc.team4322.robot.RobotMap;
import org.usfirst.frc.team4322.robot.commands.DriveBase_DriveManual;

import com.ctre.CANTalon;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.I2C.Port;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveBase extends Subsystem
{

    private CANTalon left,right;
    private AHRS navx;
    private RobotDrive drive;
    
    public DriveBase()
    {
        left = new CANTalon(RobotMap.DRIVEBASE_MOTORCONTROLLER_LEFT_MASTER_ADDR);
        right = new CANTalon(RobotMap.DRIVEBASE_MOTORCONTROLLER_RIGHT_MASTER_ADDR);
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
