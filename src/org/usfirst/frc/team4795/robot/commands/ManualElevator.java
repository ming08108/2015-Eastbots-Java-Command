package org.usfirst.frc.team4795.robot.commands;

import org.usfirst.frc.team4795.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ManualElevator extends Command {

    public ManualElevator() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.elevator);
    }
    
    

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(Robot.oi.getLeftJoy().getRawButton(4) || Robot.oi.getLeftJoy().getRawButton(6)){
			if(Robot.oi.getLeftJoy().getRawButton(4)){
				Robot.elevator.setSpeed(-0.50);
			}
			if(Robot.oi.getLeftJoy().getRawButton(6)){
				Robot.elevator.setSpeed(0.50);
			}
		}
		else{
			Robot.elevator.setSpeed(0);
		}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.elevator.setSpeed(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
