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
    	
    	double pos = Robot.arm.getPosition();
    	//TODO move the other way if the encoder value requires
    	
    	//if we are within tolerance then exit
    	if(Math.abs(pos - setPoint) < 20){
    		isFinished = true;
    	}
    	else if(pos > setPoint){
    		Robot.arm.setSpeed(0.5);
    	}
    	else if(pos < setPoint){
    		Robot.arm.setSpeed(-0.5);
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
