package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import java.util.Set;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
@Disabled
@Autonomous(name = "Autonomous", group = "Autonomous")
public class Auto extends LinearOpMode
{
/** Autonomous code for 6625 robot, to use remove @Disabled from line 8. **/
    private DcMotor motor1;
    private DcMotor motor2;
    private DcMotor motor3;
    private DcMotor motor4;
    private Servo   servo1;


    @Override
    public void runOpMode() {
        double StartTime;
        motor1 = hardwareMap.dcMotor.get("motor1");
        motor2 = hardwareMap.dcMotor.get("motor2");
        motor3 = hardwareMap.dcMotor.get("motor3");
        motor4 = hardwareMap.dcMotor.get("motor4");
        servo1 = hardwareMap.servo.get("servo1");
        motor1.setDirection(DcMotorSimple.Direction.REVERSE);
        while (opModeIsActive());

        telemetry.addData("M1 Power", motor1.getPower());
        telemetry.addData("M2 Power", motor2.getPower());
        telemetry.addData("M3 Power", motor3.getPower());
        telemetry.addData("M4 Power", motor4.getPower());
        // Motor power updates on driver station phone
        telemetry.update();
        waitForStart();
        StartTime = getRuntime();
        motor3.setPower(-1);
        motor2.setPower(-1);
        while (!(isStopRequested() || getRuntime() - StartTime > 1)) {



            // Drive motors off
        } } }
