package org.firstinspires.ftc.team8898;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
@Autonomous(name="AutoR1", group="AutoR1")
public class AutoR1 extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {
        Bot robot = new Bot(this);
        robot.init(hardwareMap);
        robot.resetEncoder();
        waitForStart();
        robot.encoderDrive(1, -10, -10,60);
        robot.encoderDrive(.8, 20, 20,30);
        robot.gyroTurn(-90,.5);
        robot.encoderDrive(.8,63,63,30);
        robot.gyroTurn(0,.5);
        robot.setLatchPower(0.25);
        sleep(10);
        robot.setLatchPower(0);
        robot.encoderDrive(.8,13,13,30);
        robot.setLatchPower(0.25);
        sleep(10);
        robot.setLatchPower(0);
        robot.encoderDrive(.8,-13,-13,30);
        robot.gyroTurn(90,.5);
        robot.encoderDrive(.8,31,31,30);
        telemetry.addData("Front Left", robot.getFrontLeft());
        telemetry.addData("BackRight", robot.getBackRight());
        if (opModeIsActive()) {
            telemetry.update();
            robot.encoderDrive(1, 26, 26, 2);
            robot.rotate(0.5, 90, 5);

        }

    }
}
