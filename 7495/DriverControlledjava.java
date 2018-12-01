package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "DriverControlled", group = "")
public class DriverControlledjava extends LinearOpMode {

  private Servo drop;
  private Servo arm_servo;
  private DcMotor lift_motor;
  private DcMotor left_motor;
  private DcMotor right_motor;
  private DcMotor arm_motor;

  /**
   * This function is executed when this Op Mode is selected from the Driver Station.
   */
  @Override
  public void runOpMode() {
    drop = hardwareMap.servo.get("drop");
    arm_servo = hardwareMap.servo.get("arm_servo");
    lift_motor = hardwareMap.dcMotor.get("lift_motor");
    left_motor = hardwareMap.dcMotor.get("left_motor");
    right_motor = hardwareMap.dcMotor.get("right_motor");
    arm_motor = hardwareMap.dcMotor.get("arm_motor");

    // Reverse one of the drive motors.
    waitForStart();
    // Put run blocks here.
    while (opModeIsActive()) {
      drop.scaleRange(0, 1);
      arm_servo.scaleRange(0, 1);
      if (gamepad2.y) {
        arm_servo.setPosition(0);
      }
      if (gamepad2.a) {
        arm_servo.setPosition(1);
      }
      if (gamepad1.a) {
        drop.setPosition(1);
      }
      if (gamepad1.b) {
        drop.setPosition(0);
      }
      // Rack Pinion
      lift_motor.setPower(gamepad1.right_stick_y);
      //Forward
      left_motor.setPower(-gamepad1.left_stick_y);
      right_motor.setPower(-gamepad1.left_stick_y);
      //turning
      left_motor.setPower(-gamepad1.left_stick_x);
      right_motor.setPower(gamepad1.left_stick_x);
      //arm
      arm_motor.setPower(gamepad2.left_stick_y);
      //telemetry
      telemetry.addData("Servo Pos", drop.getPosition());
      telemetry.addData("Left Pow", right_motor.getPower());
      telemetry.addData("Right Pow", left_motor.getPower());
      telemetry.update();
    }
  }
}
