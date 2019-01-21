package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name = "Auto", group = "Auto")
public class Auto extends LinearOpMode {
      DcMotor motorLeft;
      DcMotor motorRight;
      DcMotor motorLift;
      Servo servoTotem;
      ElapsedTime runtime = new ElapsedTime();

@Override 
    public void runOpMode() {

        motorLeft = hardwareMap.dcMotor.get("motorLeft");
        motorRight = hardwareMap.dcMotor.get("motorRight");
        motorLift = hardwareMap.dcMotor.get("motorLift");
        servoTotem = hardwareMap.servo.get("servoTotem");
        motorRight.setDirection(DcMotorSimple.Direction.REVERSE);
        while (opModeIsActive()) ;

        double leftPower;
        double rightPower;
        double liftPower;
        double stage1;
        double stage2;
        double stage3;
        double stage4;
        double stage5;
        double stage6;
        double stage7;
        double stage8;
        double stage9;
        double stage10;
        double stage11;
        double Forward;
        double Reverse;

        leftPower = motorLeft.getPower();
        rightPower = motorRight.getPower();
        liftPower = motorLift.getPower();
        Forward = 1;
        Reverse = -1;
        waitForStart();
        {
        stage1 = getRuntime();
        motorLift.setPower(Reverse);
        // Robot comes down from lander
        while (!(isStopRequested() || getRuntime() - stage1 > .85)) ;
        }
        {
        stage2 = getRuntime();
        motorLeft.setPower(Reverse);
        motorLift.setPower(0);
        // Robot turns
        while (!(isStopRequested() || getRuntime() - stage2 > .5)) ;
        }
        {
        stage3 = getRuntime();
        motorLeft.setPower(Reverse);
        motorRight.setPower(Reverse);
        // Robot reverses
        while (!(isStopRequested() || getRuntime() - stage3 > 1.6)) ;
        }
        {
        stage4 = getRuntime();
        motorLeft.setPower(Forward);
        motorRight.setPower(Reverse);
        // Robot turns
        while (!(isStopRequested() || getRuntime() - stage4 > .4)) ;
        {
        stage5 = getRuntime();
        motorLeft.setPower(Reverse);
        motorRight.setPower(Reverse);
        // Robot reverses
        while (!(isStopRequested() || getRuntime() - stage5 > .82)) ;
        }
        {
        stage6 = getRuntime();
        servoTotem.setPosition(1);
        motorLeft.setPower(0);
        motorRight.setPower(0);
        // Robot drops totem into Depot
        while (!(isStopRequested() || getRuntime() - stage6 > 1)) ;
        }
        {
        stage7 = getRuntime();
        sleep(1);
        motorLeft.setPower(Reverse);
        motorRight.setPower(Forward);
        // Robot turns
        while (!(isStopRequested() || getRuntime() - stage7 > .7)) ;
        }
        {
        stage8 = getRuntime();
        motorLeft.setPower(0);
        motorRight.setPower(0);
        sleep(1);
        motorLeft.setPower(.91);
        motorRight.setPower(Forward);
        // Robot moves forward 
        while (!(isStopRequested() || getRuntime() - stage8 > 6)) ;
        }
        {
        stage9 = getRuntime();
        motorLeft.setPower(0);
        motorRight.setPower(0);
        sleep(1);
        motorLeft.setPower(0);
        motorRight.setPower(0);
        motorLift.setPower(Forward);
        // Robot stops and lowers lift motor
        while (!(isStopRequested() || getRuntime() - stage9 > .5)) ;
        }
        telemetry.addData("Status", "Run Time: " + runtime.toString());
        telemetry.addData("Servo Position", servoTotem.getPosition());
        telemetry.addData("Motors", "left (%.2f), right (%.2f), lift (%.2f)", leftPower, rightPower, liftPower);
        telemetry.addData("Status", "Running");
        // Run time, motor power, and servo position show up on Driver Station phone
        telemetry.update();
        {
        }
    }
}
}

