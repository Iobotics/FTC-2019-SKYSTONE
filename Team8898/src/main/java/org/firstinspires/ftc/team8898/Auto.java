package org.firstinspires.ftc.team8898;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

public class Auto extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {
        Bot robot = new Bot(this);
        robot.resetEncoder();
        waitForStart();
        robot.encoderDrive(1, -10, -10,60);

    }
}
