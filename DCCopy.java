

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

@Disabled
@TeleOp(name = "Driver ControlCopy", group = "Driver ControlCopy")
public class DCCopy extends LinearOpMode {
// To use remove @Disabled from line 13 // 
    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor motor1;
    private DcMotor motor2;
    private DcMotor motor3;
    private DcMotor motor4;
    private Servo   servo1;


    @Override
    public void runOpMode() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        motor1  = hardwareMap.get(DcMotor.class, "motor1");
        motor2 = hardwareMap.get(DcMotor.class, "motor2");
        motor3 = hardwareMap.get(DcMotor.class, "motor3");
        servo1 = hardwareMap.get(Servo.class, "servo1");

        motor1.setDirection(DcMotor.Direction.REVERSE);

        waitForStart();
        runtime.reset();

        while (opModeIsActive()) {

            double leftPower;
            double rightPower;
            double liftPower;


            double drive = -gamepad1.left_stick_y;
            double turn  =  gamepad1.left_stick_x;
            double lift  =  gamepad1.right_stick_y;
            liftPower = Range.clip(lift, -1.0, 1.0);
            leftPower    = Range.clip(drive + turn, -1.0, 1.0) ;
            rightPower   = Range.clip(drive - turn, -1.0, 1.0) ;


            motor1.setPower(leftPower);
            motor2.setPower(rightPower);
            motor3.setPower(liftPower);

            if(gamepad1.y) {
                servo1.setPosition(0);
            } else if (gamepad1.x || gamepad1.b) {
                servo1.setPosition(0.5);
            } else if (gamepad1.a) {
                servo1.setPosition(1);
            }





            telemetry.addData("Status", "Run Time: " + runtime.toString());
            telemetry.addData("Motors", "left (%.2f), right (%.2f)", leftPower, rightPower, liftPower);
            telemetry.addData("Servo Position", servo1.getPosition());
            telemetry.addData("Status", "Running");
            telemetry.update();
        }
    }
}
