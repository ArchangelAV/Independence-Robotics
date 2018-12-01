package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;

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

    double leftPower;
    double rightPower;
    double armPower;
    double liftPower;
    double dropPos;
    double armPos;
    double drive = -gamepad1.left_stick_y;
    double turn = gamepad1.left_stick_x;
    double lift = gamepad1.right_stick_y;
    double arm = gamepad2.left_stick_y;
    leftPower = Range.clip(drive + turn, -1.0, 1.0);
    rightPower = Range.clip(drive - turn, -1.0, 1.0);
    liftPower = Range.clip(lift, -1.0, 1.0);
    armPower = Range.clip(arm, -1.0, 1.0);
    dropPos = drop.getPosition();
    armPos = arm_servo.getPosition();

    left_motor.setPower(leftPower);
    right_motor.setPower(rightPower);
    lift_motor.setPower(liftPower);
    arm_motor.setPower(armPower);

    waitForStart();
    while (opModeIsActive()) {
      drop.scaleRange(0, 1);
      arm_servo.scaleRange(0, 1);
      if (gamepad2.y) {
        arm_servo.setPosition(0);
      }
      if (gamepad2.a) {
        arm_servo.setPosition(1);
      }
      if (gamepad1.dpad_up) {
        drop.setPosition(1);
      }
      if (gamepad1.dpad_down) {
        drop.setPosition(0);
      }

      telemetry.addData("Servos", "drop (%.2f), arm(%.2f)", dropPos, armPos);
      telemetry.addData("Motors", "left (%.2f), right (%.2f), lift (%.2f), arm (%.2f)", leftPower, rightPower, liftPower, armPower);
      telemetry.update();
    }
  }
}
