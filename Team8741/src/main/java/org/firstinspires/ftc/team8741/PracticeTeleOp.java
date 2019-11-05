package org.firstinspires.ftc.team8741;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.HardwareMap;

@TeleOp(name="Practice TeleOP", group="Iterative Opmode")
public class PracticeTeleOp extends LinearOpMode {
    private PracticeBot robot = new PracticeBot(this);

    double frontLeftPower;
    double frontRightPower;
    double backLeftPower;
    double backRightPower;


double closerPosition=0;



    @Override
    public void runOpMode() throws InterruptedException {
        robot.init(hardwareMap);
        waitForStart();
        while (opModeIsActive()) {
            robot.setPower(gamepad2.left_stick_y, gamepad2.right_stick_y);

            robot.lifterPower(1.0);
if(gamepad1.a && closerPosition < 1.0){
  closerPosition += .05;
}


        }

    }
}
