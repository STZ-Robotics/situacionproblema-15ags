package frc.robot.subsystems;

import com.revrobotics.PersistMode;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.ResetMode;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.SparkMaxConfig;

import frc.robot.interfaces.ShooterIO;

public class Shooter implements ShooterIO {
  private SparkMax flywheel;
  private RelativeEncoder flywheelEncoder;

  public Shooter() {
    this.flywheel = new SparkMax(0, MotorType.kBrushless);
    SparkMaxConfig config = new SparkMaxConfig();
    flywheel.configure(config, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    flywheelEncoder = flywheel.getEncoder();
  }

  @Override
  public void moveWithVoltage(double voltage) {
    flywheel.setVoltage(voltage);
  }

  @Override
  public void moveToTargetSpeed(double targetSpeed) {
    flywheel.set(targetSpeed);
  }

  @Override
  public void stopMotor() {
    flywheel.stopMotor();
  }

  @Override
  public void invertMotor() {
  }

  @Override
  public void updateInputs(ShooterInputs inputs) {
    inputs.currentRpm = flywheelEncoder.getVelocity();
  }
}
