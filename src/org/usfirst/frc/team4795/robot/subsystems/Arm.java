package org.usfirst.frc.team4795.robot.subsystems;

import org.usfirst.frc.team4795.robot.Robot;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Arm extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	CANTalon armMotor;
	
	public Arm(){
		super();
		
		armMotor = new CANTalon(5);
		armMotor.setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder);
	
		//Test TODO remove
		//armMotor.set(0.5);
		
	}
	
	public boolean zero() {
	
		while(canGoForward() && canGoReverse()) {
			setSpeed(-0.5);
		}
		armMotor.setPosition(0);
		return true;
		
	}
	
	//started at -701,ended at -916 
	public boolean grabTote() {
		SmartDashboard.putBoolean("Started tote", true);
		while(armMotor.getPosition() > -825) {
			SmartDashboard.putNumber("encoderPosition", armMotor.getPosition());
			setSpeed(.5);
		}
		setSpeed(0);
		return true;
		
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	
    }
    
    
    /*
     * set the speed of the arm motor
     */
    public void setSpeed(double speed){
    	armMotor.set(speed);
    }
    
    public double getPosition() {
    	return armMotor.getPosition();
    }
    
    public double getSpeed() {
    	return armMotor.getSpeed();
    }
    
    public boolean canGoForward() {
    	return !armMotor.isFwdLimitSwitchClosed();
    }
    
    public boolean canGoReverse() {
    	return !armMotor.isRevLimitSwitchClosed();
    }
    
    public double getCurrent() {
    	return armMotor.getOutputCurrent();
    }
}

