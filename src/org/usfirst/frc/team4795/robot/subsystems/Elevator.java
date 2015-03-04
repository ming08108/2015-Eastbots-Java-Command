package org.usfirst.frc.team4795.robot.subsystems;

import org.usfirst.frc.team4795.robot.RobotMap;
import org.usfirst.frc.team4795.robot.commands.HoldElevator;

import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Elevator extends Subsystem {
	
	private CANJaguar winchMotor;
	
	public Elevator(){
		winchMotor = new CANJaguar(RobotMap.winchMotor);
		
		winchMotor.configNeutralMode(CANJaguar.NeutralMode.Brake);
		
	}
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new HoldElevator());
    }
    
    public void startPid(double p, double i, double d){
    	winchMotor.disableControl();
    	winchMotor.setPositionMode(CANJaguar.kQuadEncoder, 2048, p, i, d);
		winchMotor.enableControl(0);
    }
    
    
    public void startSpeedMode(double p, double i, double d){
    	winchMotor.disableControl();
    	winchMotor.setSpeedMode(CANJaguar.kQuadEncoder, 2048, p, i, d);
		winchMotor.enableControl();
    }
    
    
    
    public void startPercentMode(){
    	winchMotor.disableControl();
    	winchMotor.setPercentMode();
    	winchMotor.enableControl();
    }
    
    
    /**
     * Sets the position of the winchMotor
     * @param posistion [0, 6]
     */
    public void setPosition(double posistion){
    	winchMotor.set(posistion);
    	
    	SmartDashboard.putNumber("encoder", winchMotor.getPosition());
    }
    
    /**
     * Sets the position of the winchMotor
     * @param speed [-1, 1]
     */
    public void setSpeed(double speed){
    	winchMotor.set(speed);
    }
    
    
    
    
    /*
     * get the position of the winchMotor encoder
     */
    public double getPosition(){
    	return winchMotor.getPosition();
    }
    
    /*
     * log relevant info to the smartdashboard
     */
    public void log(){
    	SmartDashboard.putNumber("encoder", winchMotor.getPosition());
    }
    
}

