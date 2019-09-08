package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "stuffstuff2020")
public class stuffstuff2020 extends LinearOpMode {
    private DcMotor frontLeftMotor;
    private DcMotor frontRightMotor;
    private DcMotor backLeftMotor;
    private DcMotor backRightMotor;
    @Override
    public void runOpMode() throws InterruptedException {
        //Maps motors for drive train and lift, respectively
        frontLeftMotor = hardwareMap.dcMotor.get("frontLeftMotor");
        frontRightMotor = hardwareMap.dcMotor.get("frontRightMotor");
        backLeftMotor = hardwareMap.dcMotor.get("backLeftMotor");
        backRightMotor = hardwareMap.dcMotor.get("backRightMotor");
        waitForStart();

        while(opModeIsActive()) {
            //Maps motors to the game controller
            frontLeftMotor.setPower(gamepad1.left_stick_y);
            backLeftMotor.setPower(gamepad1.left_stick_y);
            frontRightMotor.setPower(gamepad1.right_stick_y);
            backRightMotor.setPower(gamepad1.right_stick_y);

            if (gamepad1.left_bumper) {
                frontLeftMotor.setPower(-1);
                backLeftMotor.setPower(1);
                frontRightMotor.setPower(1);
                backRightMotor.setPower(-1);
            }

            if (gamepad1.right_bumper) {
                frontLeftMotor.setPower(1);
                backLeftMotor.setPower(-1);
                frontRightMotor.setPower(-1);
                backRightMotor.setPower(1);
            }

            idle();
        }
    }
}