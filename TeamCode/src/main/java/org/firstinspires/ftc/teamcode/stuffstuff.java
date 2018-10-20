package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "stuffstuff")
public class stuffstuff extends LinearOpMode {
    private DcMotor leftMotor;
    private DcMotor rightMotor;
    private DcMotor liftMotor;
    private Servo clawServo;
    private static final double  ARM_EXTENDED_POSITION = 1.0;
    private static final double ARM_RETRACTED_POSITION = 0.5;

    @Override
    public void runOpMode() throws InterruptedException {
        //Maps motors for drive train and lift, respectively
        leftMotor = hardwareMap.dcMotor.get("leftMotor");
        rightMotor = hardwareMap.dcMotor.get("rightMotor");
        liftMotor = hardwareMap.dcMotor.get("liftMotor");
        clawServo = hardwareMap.servo.get("clawServo");

        clawServo.setPosition(ARM_RETRACTED_POSITION);
        //Reverses motors
        leftMotor.setDirection(DcMotor.Direction.REVERSE);

        waitForStart();

        while(opModeIsActive()) {
            //Maps motors to the game controller
            leftMotor.setPower(-gamepad1.left_stick_y);
            rightMotor.setPower(-gamepad1.right_stick_y);
            liftMotor.setPower (-(gamepad2.left_stick_y * -gamepad2.left_stick_y));

            if (gamepad2.a) {
                clawServo.setPosition(ARM_EXTENDED_POSITION);
            }

            if (gamepad2.b) {
                clawServo.setPosition(ARM_RETRACTED_POSITION);
            }

            idle();
        }
    }
}
