package org.firstinspires.ftc.team8898;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name="Basic: OpMode", group="Iterative Opmode")

public class Teleop extends LinearOpMode{
    private Bot robot = new Bot(this);

    double frontLeftPower;
    double frontRightPower;
    double backLeftPower;
    double backRightPower;

    @Override
    public void runOpMode() throws InterruptedException {
       robot.init(hardwareMap);
       waitForStart();

       while(opModeIsActive()) {
           robot.setPower(gamepad1.left_stick_y, gamepad1.right_stick_y);
       }
    }

}
