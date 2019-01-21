package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@Autonomous(name = "Autonomous1", group = "")
public class Autonomous1 extends LinearOpMode {

    Servo drop;
    DcMotor lift_motor;
    DcMotor right_motor;
    DcMotor left_motor;

  /**
   * This function is executed when this Op Mode is selected from the Driver Station.
   */
  @Override
  public void runOpMode() {
    double stage1;
    double stage2;
    double stage3;
    double stage4;
    double stage5;
    double stage6;
    double Start;

    drop = hardwareMap.servo.get("drop");
    lift_motor = hardwareMap.dcMotor.get("lift_motor");
    right_motor = hardwareMap.dcMotor.get("right_motor");
    left_motor = hardwareMap.dcMotor.get("left_motor");

    // Put initialization blocks here.
    waitForStart();
    drop.scaleRange(0, 1);
    stage1 = getRuntime();
    lift_motor.setPower(-1);
    while (!(getRuntime() - stage1 > 1.5)) {
      // Let Motors Run
    }
    lift_motor.setPower(0);
    stage2 = getRuntime();
    right_motor.setPower(1);
    left_motor.setPower(-1);
    while (!(getRuntime() - stage2 > 0.1)) {
      // Let Motors Run
    }
    right_motor.setPower(0);
    left_motor.setPower(0);
    stage3 = getRuntime();
    right_motor.setPower(-1);
    left_motor.setPower(-1);
    while (!(getRuntime() - stage3 > 0.2)) {
      // Let Motors Run
    }
    right_motor.setPower(0);
    left_motor.setPower(0);
    stage4 = getRuntime();
    right_motor.setPower(-1);
    left_motor.setPower(1);
    while (!(getRuntime() - stage4 > 0.1)) {
      // Let Motors Run
    }
    right_motor.setPower(0);
    left_motor.setPower(0);
    Start = getRuntime();
    right_motor.setPower(-1);
    left_motor.setPower(-1);
    while (!(getRuntime() - Start > 1)) {
      // Let Motors Run
    }
    right_motor.setPower(0);
    left_motor.setPower(0);
    stage4 = getRuntime();
    drop.setPosition(1);
    while (!(getRuntime() - stage4 > 1)) {
      // Let Motors Run
    }
    stage5 = getRuntime();
    right_motor.setPower(0.5);
    left_motor.setPower(0.5);
    while (!(getRuntime() - stage5 > 0.5)) {
      // Let Motors Run
    }
    right_motor.setPower(0);
    left_motor.setPower(0);
  }
}
