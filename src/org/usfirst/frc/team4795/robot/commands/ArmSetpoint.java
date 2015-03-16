package org.usfirst.frc.team4795.robot.commands;

import org.usfirst.frc.team4795.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Sets the arm to a predefined position 
 */
public class ArmSetpoint extends Command {

	double setPoint;
	
	boolean isFinished = false;
    public ArmSetpoint(double setPoint) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.arm);
    	this.setPoint = setPoint;
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	//TODO move the other way if the encoder value requires
    	if(Robot.arm.getPosition() > setPoint){
    		Robot.arm.setSpeed(0.5);
    	}
    	else{
    		isFinished = true;
    	}
    	
    	Robot.arm.log();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isFinished;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.arm.setSpeed(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
