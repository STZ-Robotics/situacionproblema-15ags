package frc.robot.interfaces;

import com.stzteam.features.marsprocessor.Fallback;
import com.stzteam.mars.models.singlemodule.Data;
import com.stzteam.mars.models.singlemodule.IO;

@Fallback
public interface TurretIO extends IO<TurretIO.TurretInputs> {
  public static class TurretInputs extends Data<TurretInputs> {

    public double currentAngle = 0.0;
    public double targetAngle = 0.0;
    public double currentRps = 0.0;
    public double appliedVoltage = 0.0;
    public double appliedCurrent = 0.0;
  }

  public void moveWithVoltage(double voltage);

  public void moveWithDutyCycle(double dutyCycle);

  public void moveToPos(double pos);

  public void stopMotor();

  public void resetEncoder();
}
