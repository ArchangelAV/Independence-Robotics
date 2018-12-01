package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
@Disabled
@Autonomous(name = "Auto", group = "Auto")
public class Auto extends LinearOpMode
{
/** Autonomous code for 6625 robot, to use remove @Disabled from line 10.
Also may need to change OP Mode name to avoid any conflicts with the code on the phone**/
    private DcMotor motorLeft;
    private DcMotor motorRight;
    private DcMotor motorLift;
    private Servo   servoTotem;
    private ElapsedTime runtime = new ElapsedTime();


    @Override
    public void runOpMode() {

        motorLeft = hardwareMap.dcMotor.get("motorLeft");
        motorRight = hardwareMap.dcMotor.get("motorRight");
        motorLift = hardwareMap.dcMotor.get("motorLift");
        servoTotem = hardwareMap.servo.get("servoTotem");
        motorRight.setDirection(DcMotorSimple.Direction.REVERSE);
        while (opModeIsActive());

        double leftPower;
        double rightPower;
        double liftPower;
        double armPower;
        double stage1;
        double stage2;
        double stage3;
        double stage4;
        double stage5;
        double stage6;
        double stage7;
        double stage8;
        double stage9;
        double Forward;
        double Reverse;
        
        leftPower = motorLeft.getPower();
        rightPower = motorRight.getPower();
        liftPower = motorLift.getPower();
        Forward = 1;
        Reverse = -1;
        waitForStart();
        stage1 = getRuntime();
        motorLift.setPower(Reverse);
        // Robot comes down from lander
        while (!(isStopRequested() || getRuntime() - stage1 > .85));
        stage2 = getRuntime();
        motorLeft.setPower(Reverse);
        motorLift.setPower(0);
        // Robot turns
        while (!(isStopRequested() || getRuntime() - stage2 > .7));
        stage3 = getRuntime();
        motorLeft.setPower(Reverse);
        motorRight.setPower(Reverse);
        // Robot reverses toward scoring area
        while (!(isStopRequested() || getRuntime() - stage3 > .8));
        stage4 = getRuntime();
        motorLeft.setPower(Forward);
        motorRight.setPower(Reverse);
        // Robot turns
        while (!(isStopRequested() || getRuntime() - stage4 > .4)); 
        stage5 = getRuntime();
        motorLeft.setPower(Reverse);
        motorRight.setPower(Reverse);
        // Robot reverses
        while (!(isStopRequested() || getRuntime() - stage5 > 2)); 
        stage6 = getRuntime();
        motorLeft.setPower(Reverse);
        motorRight.setPower(Forward);
        // Robot turns
        while (!(isStopRequested() || getRuntime() - stage6 > .4)); 
        stage7 = getRuntime();
        motorLeft.setPower(Forward);
        motorRight.setPower(Reverse);
        // Robot turns
        while (!(isStopRequested() || getRuntime() - stage7 > .4)); 
        stage8 = getRuntime();
        servoTotem.setPosition(1);
        motorLeft.setPower(0);
        motorRight.setPower(0);
        while (!(isStopRequested() || getRuntime() - stage8 > 1));
        stage9 = getRuntime();
        motorLift.setPower(Forward);
        while (!(isStopRequested() || getRuntime() - stage9 > .85));
        // Robot claims scoring area with Totem

        telemetry.addData("Status", "Run Time: " + runtime.toString());
        telemetry.addData("Servo Position", servoTotem.getPosition());
        telemetry.addData("Motors", "left (%.2f), right (%.2f), lift (%.2f)", leftPower, rightPower, liftPower);
        telemetry.addData("Status", "Running");
        // Run time, motor power, and servo position show up on Driver Station phone
        telemetry.update();
        {




        } } }
