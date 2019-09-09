package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "StuffStuff2020ReWrittenGangWeedMoney")
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
            //Maps motors to the game controller (Forward and Backward)
            frontLeftMotor.setPower(gamepad1.left_stick_y);
            backLeftMotor.setPower(gamepad1.left_stick_y);
            frontRightMotor.setPower(gamepad1.left_stick_y);
            backRightMotor.setPower(gamepad1.left_stick_y);

            //Controlling sideways movement
            frontLeftMotor.setPower(gamepad1.left_stick_x);
            backLeftMotor.setPower(-1 * gamepad1.left_stick_x);
            frontRightMotor.setPower(-1 * gamepad1.left_stick_x);
            backRightMotor.setPower(gamepad1.left_stick_x);

            //Turning Left and Right
            frontLeftMotor.setPower(gamepad1.right_stick_x);
            backLeftMotor.setPower(gamepad1.right_stick_x);
            frontRightMotor.setPower(-1 * gamepad1.right_stick_x);
            backRightMotor.setPower(-1 * gamepad1.right_stick_x);


            idle();
        }
    }
}