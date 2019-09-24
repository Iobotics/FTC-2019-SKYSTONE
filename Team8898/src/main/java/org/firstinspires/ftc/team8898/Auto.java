package org.firstinspires.ftc.team8898;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
@Autonomous(name="Auto: Auto Drive By Encoder", group="Auto")
public class Auto extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {
        Bot robot = new Bot(this);
        robot.init(hardwareMap);
        robot.resetEncoder();
        waitForStart();
        robot.encoderDrive(1, 10, 10,30);
        telemetry.addData("Front Left", robot.getFrontLeft());
        telemetry.addData("BackRight", robot.getBackRight());
        while(opModeIsActive()) {
            telemetry.update();
        }
    }
}
