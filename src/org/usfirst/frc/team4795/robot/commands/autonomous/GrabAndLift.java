package org.usfirst.frc.team4795.robot.commands.autonomous;

import org.usfirst.frc.team4795.robot.commands.ArmSetpoint;
import org.usfirst.frc.team4795.robot.commands.ElevatorSetpoint;
import org.usfirst.frc.team4795.robot.commands.HomeArm;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class GrabAndLift extends CommandGroup {
    
    public  GrabAndLift() {
    	
    	
    	//Make sure arm is in the home position
    	addSequential(new HomeArm());
    	
    	//close the arm in the correct position TODO find correct position
    	addSequential(new ArmSetpoint(-825));
    	
    	
    	//TODO test
    	
    	//lift 2 revs
    	addSequential(new ElevatorSetpoint(2));
    	
    	//go back down
    	addSequential(new ElevatorSetpoint(0));
    	
    	
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}
