// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.configs.MotionMagicConfigs;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.controls.MotionMagicVoltage;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class PositionMotor extends SubsystemBase {
  TalonFX positionMotor = new TalonFX(0);
  TalonFXConfiguration configs = new TalonFXConfiguration();
  public double Target = 0;
  
  /** Creates a new PositionMotor. */
  public PositionMotor() {
    var motionMagicConfigs = configs.MotionMagic;
    configs.Slot0.kP = 0.1;
    configs.Slot0.kI = 0.1;
    configs.Slot0.kD = 0.1;

    motionMagicConfigs.MotionMagicAcceleration = 10;
    motionMagicConfigs.MotionMagicCruiseVelocity = 10;

    positionMotor.getConfigurator().apply(configs);
  }

  public void move(double target){
    Target = target;
    positionMotor.setControl(new MotionMagicVoltage(target));
  }

  public double getPos(){
    return positionMotor.getPosition().getValueAsDouble();
  }

  public void setPos(double target){
    Target = target;
    positionMotor.setPosition(target);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    Target = SmartDashboard.getNumber("Target", Target);
    SmartDashboard.putNumber("Target", Target);

    SmartDashboard.putNumber("Position", getPos());

    move(Target);
  }
}
