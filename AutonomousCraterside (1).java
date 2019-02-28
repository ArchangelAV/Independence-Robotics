package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.CRServo;
import java.util.Set;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@Autonomous(name = "AutonomousCraterside", group = "")
public class AutonomousCraterside extends LinearOpMode {


  private Servo drop;
  private CRServo lift_motor;
  private Servo bucket_servo;
  private Servo intake;
  private DcMotor right_motor;
  private DcMotor left_motor;
  private DcMotor armlift_motor;


  @Override
  public void runOpMode() {
    double Stage1;
    double Stage2;
    double Stage3;
    double Stage4;
    double Stage5;
    double Stage6;
    double Stage7;

    drop = hardwareMap.servo.get("drop");
    armlift_motor = hardwareMap.dcMotor.get("armlift_motor");
    right_motor = hardwareMap.dcMotor.get("right_motor");
    left_motor = hardwareMap.dcMotor.get("left_motor");
    lift_motor = hardwareMap.crservo.get("lift_motor");
    left_motor.setDirection(DcMotor.Direction.REVERSE);
    

    // Put initialization blocks here.
    waitForStart();
    drop.scaleRange(0, 1);
    //drop from the lander
    Stage1 = getRuntime();
    lift_motor.setPower(-1);
    while (!(getRuntime() - Stage1 > 1.4)) {}
    lift_motor.setPower(0);
    //unlatch from lander
    Stage2 = getRuntime();
    right_motor.setPower(1);
    left_motor.setPower(-1);
    while (!(getRuntime() - Stage2 > 0.7)) {}
    right_motor.setPower(0);
    left_motor.setPower(0);
    /*move away from lander
    Stage3=getRuntime();
    right_motor.setPower(-1);
    left_motor.setPower(-1);
    while(!(getRuntime()-Stage3 > 0.65)){}
    right_motor.setPower(0);
    left_motor.setPower(0);
    //align to depot
    Stage4=getRuntime();
    right_motor.setPower(1);
    left_motor.setPower(-1);
    while(!(getRuntime()-Stage4 > 0.32)){}
    right_motor.setPower(0);
    left_motor.setPower(0);
    //go to depot
    Stage5=getRuntime();
    right_motor.setPower(-1);
    left_motor.setPower(-1);
    while(!(getRuntime()-Stage5 > 1.2)){}
    right_motor.setPower(0);
    left_motor.setPower(0);
    //drop totem
    Stage6=getRuntime();
    drop.setPosition(0);
    while(!(getRuntime()-Stage6 > .5)){}
    //move to crater
    Stage7=getRuntime();
    right_motor.setPower(1);
    left_motor.setPower(1);
    while(!(getRuntime()-Stage7 > 1.45)){}
    right_motor.setPower(0);
    left_motor.setPower(0);
    */
    
  }
}
