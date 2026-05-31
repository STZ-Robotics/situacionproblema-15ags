package frc.robot.interfaces;

import com.stzteam.features.marsprocessor.Fallback;
import com.stzteam.mars.models.singlemodule.Data;
import com.stzteam.mars.models.singlemodule.IO;

@Fallback
public interface ShooterIO extends IO<ShooterIO.ShooterInputs> {
  public static class ShooterInputs extends Data<ShooterInputs> {
    public double currentRps = 0.0;
    public double currentTemp = 0.0;
    public boolean isPrjectileLoaded = false;
    public double appliedVoltage = 0.0;
    public double appliedCurrent = 0.0;
  }

  public void moveWithVoltage(double voltage);

  public void moveToTargetSpeed(double targetSpeed);

  public void stopMotor();

  public void invertMotor();
}
