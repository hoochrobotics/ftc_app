package org.firstinspires.ftc.teamcode;

/**
 * Created by Ian Wood on 12/25/2018.
 */

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name = "AutonoMop")
public class AutonoMop extends LinearOpMode {

    //Defines motor variables
    private DcMotor leftMotor;
    private DcMotor rightMotor;
    private DcMotor hookMotor;

    @Override
    //This is run when INIT button is clicked
    public void runOpMode() throws InterruptedException{

        //Maps motors
        leftMotor = hardwareMap.dcMotor.get("leftMotor");
        rightMotor = hardwareMap.dcMotor.get("rightMotor");
        hookMotor = hardwareMap.dcMotor.get("hookMotor");

        //Defined timer object for time-based autonomous
        ElapsedTime eTime = new ElapsedTime();

        //Stops code until start button is clicked on driver station
        waitForStart();

        //Lowers robot to ground from robot
        hookMotor.setPower(-1.0);

        eTime.reset();

        //Empty while loops cause the code above run for a certain amount of time.
        //In this case the code above runs for 1.5 seconds
        while(eTime.time() < 1.5) {}

        //Robot moves away from hook
        hookMotor.setPower(0.0);
        rightMotor.setPower(1.0);
        leftMotor.setPower(1.0);

        eTime.reset();

        while(eTime.time() < 0.3) {}

        //Retracts hook arm and stops robot movement
        hookMotor.setPower(-1.0);
        rightMotor.setPower(0.0);
        leftMotor.setPower(0.0);

        eTime.reset();

        while(eTime.time() < 1.5) {}

        //Spins robot around
        rightMotor.setPower(-1.0);
        leftMotor.setPower(1.0);

        eTime.reset();

        while(eTime.time() < 0.5) {}

        //Robots moves forward to sample game pieces ahead
        rightMotor.setPower(1.0);
        leftMotor.setPower(1.0);
    }
}
