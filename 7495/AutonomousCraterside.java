package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@Autonomous(name = "AutonomousCraterside", group = "")
public class AutonomousCraterside extends LinearOpMode {

    Servo drop;
    DcMotor lift_motor;
    DcMotor right_motor;
    DcMotor left_motor;

  /**
   * This function is executed when this Op Mode is selected from the Driver Station.
   */
  @Override
  public void runOpMode() {
    double StartTime;
    double StartOtherTime;

    drop = hardwareMap.servo.get("drop");
    lift_motor = hardwareMap.dcMotor.get("lift_motor");
    right_motor = hardwareMap.dcMotor.get("right_motor");
    left_motor = hardwareMap.dcMotor.get("left_motor");

    // Put initialization blocks here.
    waitForStart();
    drop.scaleRange(0, 1);
    StartTime = getRuntime();
    lift_motor.setPower(-1);
    while (!(getRuntime() - StartTime > 1.6)) {
      // Let Motors Run
    }
    lift_motor.setPower(0);
    StartOtherTime = getRuntime();
    right_motor.setPower(1);
    left_motor.setPower(-1);
    while (!(getRuntime() - StartOtherTime > 0.3)) {
      // Let Motors Run
    }
    right_motor.setPower(0);
    left_motor.setPower(0);
  }
}
