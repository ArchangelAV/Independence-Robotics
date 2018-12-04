package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.Range;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "DriverControlled", group = "DriverControlled")
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
      {
            double leftPower;
            double rightPower;
            double liftPower;
            double armPower;
            double drive = -gamepad1.left_stick_x;
            double turn = gamepad1.left_stick_y;
            double lift = -gamepad1.right_stick_y;
            double armlift= gamepad2.left_stick_y;
            leftPower = Range.clip(drive - turn, -.5, .5);
            rightPower = Range.clip(drive + turn, -0.5, 0.5);
            liftPower = Range.clip(lift, -1.0, 1.0);
            armPower = Range.clip(armlift, -0.7, 0.7);
            left_motor.setPower(leftPower);
            right_motor.setPower(rightPower);
            lift_motor.setPower(liftPower);
            arm_motor.setPower(armPower);
            
        drop.scaleRange(0, 1);
        arm_servo.scaleRange(0, 1);
        if (gamepad2.y) {
          arm_servo.setPosition(0);}
          else if (gamepad2.a) {
          arm_servo.setPosition(1);
        }
        if (gamepad1.a) {
          drop.setPosition(1);}
         else if (gamepad1.b) {
          drop.setPosition(0);
        }
      
        telemetry.addData("Servo Pos", drop.getPosition());
        telemetry.addData("Left Pow", right_motor.getPower());
        telemetry.addData("Right Pow", left_motor.getPower());
        telemetry.addData("Arm Pow", arm_motor.getPower());
        telemetry.update();
      }
    }
  }
}

