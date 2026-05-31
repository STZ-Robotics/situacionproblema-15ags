package frc.robot.interfaces;

import com.stzteam.mars.models.singlemodule.Data;
import com.stzteam.mars.models.singlemodule.IO;

public interface IntakeIO extends IO<IntakeIO.IntakeInputs> {
  public static class IntakeInputs extends Data<IntakeInputs> {

    public double currentSpeed = 0.0;
    public double motorTemp = 0.0;
    public double applieadVoltge = 0.0;
    public double applieadCurrent = 0.0;
  }

  public void moveWithVoltage(double voltage);

  public void setSpeed(double speed);

  public void stopIntake();
}
