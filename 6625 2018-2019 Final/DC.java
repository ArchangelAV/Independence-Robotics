

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;


@TeleOp(name = "Driver Control", group = "Driver Control")
public class DC extends LinearOpMode {
      ElapsedTime runtime = new ElapsedTime();
DcMotor motorLeft;
 DcMotor motorRight;



    @Override
    public void runOpMode() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        motorLeft = hardwareMap.get(DcMotor.class, "motorLeft");
        motorRight = hardwareMap.get(DcMotor.class, "motorRight");
        motorRight.setDirection(DcMotor.Direction.REVERSE);

        waitForStart();
        runtime.reset();

        while (opModeIsActive()) {

            double leftPower;
            double rightPower;
            double liftPower;
            double drive = -gamepad1.left_stick_y;
            double turn = gamepad1.left_stick_x;
            double lift = gamepad1.right_stick_y;
            leftPower = Range.clip(drive + turn, -0.9, 0.9);
            rightPower = Range.clip(drive - turn, -0.9, 0.9);
            liftPower = Range.clip(lift, -0.9, 0.9);
            // Robot drive controls on left joystick and motor power limited.

            motorLeft.setPower(leftPower);
            motorRight.setPower(rightPower);
            motorLift.setPower(liftPower);
            // Variables for telemetry data.

                if (gamepad1.x) {
                    servoTotem.setPosition(1);
            }
                else if (gamepad1.y) {
                servoTotem.setPosition(0);
            }
            // Servo controls
            
            telemetry.addData("Status", "Run Time: " + runtime.toString());
            telemetry.addData("Motors", "left (%.2f), right (%.2f), lift (%.2f)", leftPower, rightPower, liftPower);
            telemetry.addData("Servo Position", servoTotem.getPosition());
            telemetry.addData("Status", "Running");
            telemetry.update();
            /* Telemetry data to display Runtime, motor power, servo positions
            and runnign status on Driver Station phone. */
        }
    }
}

