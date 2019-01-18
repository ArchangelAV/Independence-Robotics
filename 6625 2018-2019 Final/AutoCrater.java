package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name = "Auto Crater Side", group = "Auto Crater Side")
public class AutoCrater extends LinearOpMode {
    private DcMotor motorLeft;
    private DcMotor motorRight;
    private DcMotor motorLift;
    private Servo servoTotem;
    private ElapsedTime runtime = new ElapsedTime();


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
        double Forward;
        double Reverse;
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
        leftPower = motorLeft.getPower();
        rightPower = motorRight.getPower();
        liftPower = motorLift.getPower();
        Forward = 1;
        Reverse = -1;

        telemetry.update();
        waitForStart();
        stage1 = getRuntime();
        motorLift.setPower(Reverse);
        // Robot comes down from lander
        while (!(isStopRequested() || getRuntime() - stage1 > .85)) ;
        stage2 = getRuntime();
        motorLeft.setPower(Reverse);
        motorLift.setPower(0);
        // Robot turns
        while (!(isStopRequested() || getRuntime() - stage2 > 1)) ;
        stage3 = getRuntime();
        motorLeft.setPower(Reverse);
        motorRight.setPower(Reverse);
        // Robot reverses
        while (!(isStopRequested() || getRuntime() - stage3 > .85)) ;
        stage4 = getRuntime();
        motorLeft.setPower(Reverse);
        motorRight.setPower(Forward);
        // Robot turns
        while (!(isStopRequested() || getRuntime() - stage4 > .45)) ;
        stage5 = getRuntime();
        motorLeft.setPower(Reverse);
        motorRight.setPower(Reverse);
        // Robot continues reversing
        while (!(isStopRequested() || getRuntime() - stage5 > 1.2)) ;
        stage6 = getRuntime();
        motorLeft.setPower(Reverse);
        motorRight.setPower(Forward);
        // Robot turns
        while (!(isStopRequested() || getRuntime() - stage6 > .24)) ;
        stage7 = getRuntime();
        motorLeft.setPower(Reverse);
        motorRight.setPower(Reverse);
        // Robot reverses
        while (!(isStopRequested() || getRuntime() - stage7 > 1.7)) ;
        stage8 = getRuntime();
        servoTotem.setPosition(1);
        motorLeft.setPower(0);
        motorRight.setPower(0);
        // Robot claims scoring area with totem
        while (!(isStopRequested() || getRuntime() - stage8 > .9)) ;
        stage9 = getRuntime();
        motorLift.setPower(Forward);
        // lift motor goes back down
        while (!(isStopRequested() || getRuntime() - stage9 > .85)) ;
        stage10 = getRuntime();
        motorLeft.setPower(.9);
        motorRight.setPower(Forward);
        motorLift.setPower(0);
        // Robot moves forward
        while (!(isStopRequested() || getRuntime() - stage10 > 6)) ;
        telemetry.addData("Status", "Run Time: " + runtime.toString());
        telemetry.addData("Motors", "left (%.2f), right (%.2f), lift (%.2f)", leftPower, rightPower, liftPower);
        telemetry.addData("Servo Position", servoTotem.getPosition());
        telemetry.addData("Status", "Running");
        // Runtime, motor power, and servo position show up on Driver Station phone
        telemetry.update();
        {
        }
    }
}

