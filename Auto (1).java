package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name = "Auto", group = "Auto")
public class Auto extends LinearOpMode {
    private DcMotor left_motor;
    private DcMotor right_motor;
    private CRServo lift_motor;
    private Servo drop;
    private ElapsedTime runtime = new ElapsedTime();


    @Override
    public void runOpMode() {

        left_motor = hardwareMap.dcMotor.get("left_motor");
        right_motor = hardwareMap.dcMotor.get("right_motor");
        lift_motor = hardwareMap.crservo.get("lift_motor");
        drop = hardwareMap.servo.get("drop");
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

        leftPower = left_motor.getPower();
        rightPower = right_motor.getPower();
        liftPower = lift_motor.getPower();
        Forward = 1;
        Reverse = -1;
        waitForStart();
        {
        stage1 = getRuntime();
        {
        lift_motor.setPower(-1);
        // Robot comes down from lander
        while (!(isStopRequested() || getRuntime() - stage1 > 1.3)) ;
        }
        stage2 = getRuntime();
        {
        left_motor.setPower(Reverse);
        right_motor.setPower(Forward);
        lift_motor.setPower(0);
        while (!(isStopRequested() || getRuntime() - stage2 > .32)) ;
        }
        stage3 = getRuntime();
        {
        left_motor.setPower(Forward);
        right_motor.setPower(Reverse);
        lift_motor.setPower(0);
        while (!(isStopRequested() || getRuntime() - stage3 > .32)) ;
        }
        stage4 = getRuntime();
        {
        left_motor.setPower(Reverse);
        right_motor.setPower(Reverse);
        while (!(isStopRequested() || getRuntime() - stage4 > .7)) ;
        }
        telemetry.addData("Status", "Run Time: " + runtime.toString());
        telemetry.addData("Servo Position", drop.getPosition());
        telemetry.addData("Motors", "left (%.2f), right (%.2f), lift (%.2f)", leftPower, rightPower, liftPower);
        telemetry.addData("Status", "Running");
        // Run time, motor power, and servo position show up on Driver Station phone
        telemetry.update();
        {
        }
    }
}
}



