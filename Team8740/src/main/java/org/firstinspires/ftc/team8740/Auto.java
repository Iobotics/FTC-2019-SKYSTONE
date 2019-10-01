package org.firstinspires.ftc.team8740;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
    @Autonomous(name="Basic: OpMode", group="Iterative Opmode")

    public class Auto extends LinearOpMode {
        private Bot robot = new Bot(this);

        @Override
        public void runOpMode() throws InterruptedException {

            robot.init(hardwareMap);
            waitForStart();
        }

    }


