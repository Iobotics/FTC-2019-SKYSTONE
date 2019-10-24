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
            robot.encoderDrive(0.8,-10,-10,20);
         



            }
        }
        }
