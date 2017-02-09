package org.usfirst.frc.team4322.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Vision extends Subsystem
{

	public enum RunMode
	{
		MODE_WAIT,
		MODE_BOILER,
		MODE_GEAR,
	}

    @Override
    protected void initDefaultCommand()
    {
        // TODO Auto-generated method stub
        
    }

    public void setRunMode(RunMode mode)
    {
	    SmartDashboard.putNumber("Vision RunMode: ",mode.ordinal());
    }

    public double getXPos()
    {
    	return SmartDashboard.getNumber("Vision Center X: ",-2);
    }

	public double getYPos()
	{
		return SmartDashboard.getNumber("Vision Center Y: ",-2);
	}

}
