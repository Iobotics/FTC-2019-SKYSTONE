package org.firstinspires.ftc.team8740;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
    @Autonomous(name="auto", group="auto")
    public class Auto extends LinearOpMode {
        private Bot robot = new Bot(this);

        @Override
        public void runOpMode() throws InterruptedException {

            robot.init(hardwareMap);
            waitForStart();
            while (opModeIsActive()) {
            robot.encoderDrive(0.9,-10,-10,5);
            robot.encoderTurn(0.1,-45,5);
            robot.encoderDrive(0.1,-1,-1,5);

            }
        }
        }
