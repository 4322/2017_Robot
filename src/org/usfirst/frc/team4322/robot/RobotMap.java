package org.usfirst.frc.team4322.robot;

import org.usfirst.frc.team4322.dashboard.DashboardInputField;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap
{
    @DashboardInputField(field="Drivebase Aim P: ")
    public static double DRIVEBASE_AIM_P;
    @DashboardInputField(field="Drivebase Aim I: ")
    public static double DRIVEBASE_AIM_I;
    @DashboardInputField(field="Drivebase Aim D: ")
    public static double DRIVEBASE_AIM_D;
}
