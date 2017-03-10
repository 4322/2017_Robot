package org.usfirst.frc.team4322.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Created by nicolasmachado on 2/23/16.
 * A simple class to implement a delay in a CommandGroup.
 */
public class Command_Delay extends Command
{

	long target,delay;

	public Command_Delay(int millis)
	{
		delay = millis;
	}

	@Override
	public synchronized void start() {
		super.start();
		target = System.currentTimeMillis() + delay;

	}

	@Override
	protected void initialize()
	{

	}

	@Override
	protected void execute()
	{
	}

	@Override
	protected boolean isFinished()
	{
		return System.currentTimeMillis() >= target;
	}

	@Override
	protected void end()
	{
	}

	@Override
	protected void interrupted()
	{
		end();
	}
}