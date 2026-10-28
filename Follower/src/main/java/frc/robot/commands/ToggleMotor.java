// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;

import frc.robot.RobotContainer; // Import RobotContainer to get the subsystem that you created in there

public class ToggleMotor extends Command {
  // Reminder that variables and objects go into here
  boolean toggle = true; // This variable checks if the motor is toggled or not
  boolean finish = false; // This variable determines if the command is ended or not --> change to true when command ends
 
  public ToggleMotor() {
    // The subsystem that this command is using needs to be added within addRequirements() (specifically the one in RobotContainer)
    addRequirements(RobotContainer.m_FollowerMotor);
  }

  // Runs once when the command is first started --> we will be using this one because it needs to run one sequence then end to toggle the motor
  @Override
  public void initialize() {
    if(toggle == true) {
      RobotContainer.m_FollowerMotor.moveMaster(0.1);
      // Refer to the subsystem used in addRequirements then use a method created in the subystem file --> see FollowerMotor.java to see the moveMaster method
      toggle = false;
      // Turn the toggle into false so next time the button is pressed it stops the motor
    } else {
      RobotContainer.m_FollowerMotor.moveMaster(0); // Stop the motor
      toggle = true;
      // Turn the toggle into true so next time the button is pressed it runs the motor 
    }
  }

  // Keeps looping until the command ends --> we don't need this one because we are only doing something once
  @Override
  public void execute() {}

  // Runs once when the command ends --> we could also use this for a toggle but we just use initialize usually
  @Override
  public void end(boolean interrupted) {}

  // When this commmand returns "true" then the command will end and stop
  @Override
  public boolean isFinished() {
    return finish; // The command will finish when the variable is equal to true;
  }
}
