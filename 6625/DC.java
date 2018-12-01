

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

@Disabled
@TeleOp(name = "Driver Control", group = "Driver Control")
public class DC extends LinearOpMode {
/** Driver control code for 6625 robot, to use remove @Disabled from line 13.
Also may need to change the OP Mode name to avoid any conflicts with the code on the phone**/
    
    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor motorLeft;
    private DcMotor motorRight;
    private DcMotor motorLift;
    private Servo   servoTotem;



    @Override
    public void runOpMode() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        motorLeft = hardwareMap.get(DcMotor.class, "motorLeft");
        motorRight = hardwareMap.get(DcMotor.class, "motorRight");
        motorLift = hardwareMap.get(DcMotor.class, "motorLift");
        servoTotem = hardwareMap.get(Servo.class, "servoTotem");
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
            leftPower = Range.clip(drive + turn, -1.0, 1.0);
            rightPower = Range.clip(drive - turn, -1.0, 1.0);
            liftPower = Range.clip(lift, -1.0, 1.0);


            motorLeft.setPower(leftPower);
            motorRight.setPower(rightPower);
            motorLift.setPower(liftPower);

                    telemetry.addData("Status", "Run Time: " + runtime.toString());
                    telemetry.addData("Motors", "left (%.2f), right (%.2f), lift (%.2f)", leftPower, rightPower, liftPower);
                    telemetry.addData("Servo Position", servoTotem.getPosition());
                    telemetry.addData("Status", "Running");
                    telemetry.update();
                } } }
