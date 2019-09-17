package org.firstinspires.ftc.team8898;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

public class Auto extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {
        Bot robot = new Bot(this);
        waitForStart();
        while( robot.getRunTime() < 10) {
            robot.setPower(1,1);
        }
        robot.setPower(0,0);

    }
}
