package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.util.Range;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "DriverControlled", group = "DriverControlled")
public class DriverControlledjava extends LinearOpMode {

  private Servo drop;
  private CRServo intake;
  private CRServo lift_motor;
  private CRServo bucket_servo;
  private DcMotor left_motor;
  private DcMotor right_motor;
  private DcMotor armlift_motor;
  private DcMotor arm_motor;
  

  
  /**
   * This function is executed when this Op Mode is selected from the Driver Station.
   */
  @Override
  public void runOpMode() {
    
    intake = hardwareMap.crservo.get("intake");
    bucket_servo = hardwareMap.crservo.get("bucket_servo");
    drop = hardwareMap.servo.get("drop");
    lift_motor = hardwareMap.crservo.get("lift_motor");
    left_motor = hardwareMap.dcMotor.get("left_motor");
    right_motor = hardwareMap.dcMotor.get("right_motor");
    arm_motor = hardwareMap.dcMotor.get("arm_motor");
    armlift_motor =hardwareMap.dcMotor.get("armlift_motor");
    left_motor.setDirection(DcMotor.Direction.REVERSE);
    
    // Reverse one of the drive motors.
    waitForStart();
    // Put run blocks here.
    while (opModeIsActive()) {
      {
            double leftPower;
            double rightPower;
            double liftPower;
            double armPower;
            double lift2Power;
            double turn = -gamepad1.left_stick_y;
            double drive = gamepad1.left_stick_x;
            double lift = -gamepad1.right_stick_y;
            double armlift = gamepad2.left_stick_y;
            double lift2 = gamepad2.right_stick_y;
            leftPower = Range.clip(turn + drive , -0.6, 0.6);
            rightPower = Range.clip(turn - drive, -0.6, 0.6);
            liftPower = Range.clip(lift, -1.0, 1.0);
            lift2Power = Range.clip(lift2, -1.0, 1.0);
            armPower = Range.clip(armlift, -0.5, 0.5);
            left_motor.setPower(leftPower);
            right_motor.setPower(rightPower);
            lift_motor.setPower(liftPower);
            arm_motor.setPower(armPower);
            armlift_motor.setPower(lift2Power);
            
            
            
        drop.scaleRange(0, 1);

       if (gamepad2.dpad_up) {
         bucket_servo.setPower(0);}
         else if (gamepad2.dpad_down) {bucket_servo.setPower(1);
        }
        if (gamepad1.a) {
          drop.setPosition(1);}
         else if (gamepad1.b) {drop.setPosition(0);
        }
        if (gamepad2.left_bumper) {
         intake.setPower(0);}
         else if (gamepad2.right_bumper) {intake.setPower(1);
        }
      
        telemetry.addData("Servo Pos", drop.getPosition());
        telemetry.addData("Left Pow", right_motor.getPower());
        telemetry.addData("Right Pow", left_motor.getPower());
        telemetry.addData("Arm Pow", arm_motor.getPower());
        //telemetry.addData("ArmServo Pos", arm_servo.getPosition());
        telemetry.update();
      }
    }
  }
}

