package org.firstinspires.ftc.team8740;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

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
           robot.getLeftPosition();
           telemetry.addData("leftServoPosition", robot.getLeftPosition());
           telemetry.addData("rightServoPosition", robot.getRightPosition());
           robot.setPosition(gamepad1.left_trigger);
           telemetry.update();

       }
    }

}
