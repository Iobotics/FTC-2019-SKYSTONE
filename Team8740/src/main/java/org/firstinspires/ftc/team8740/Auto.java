package org.firstinspires.ftc.team8740;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
    @Autonomous(name="Basic: OpMode", group="Iterative Opmode")
//yo
    public class Auto extends LinearOpMode {
        private Bot robot = new Bot(this);

        @Override
        public void runOpMode() throws InterruptedException {

            robot.init(hardwareMap);
            waitForStart();
            while (opModeIsActive()) {
            robot.encoderDrive(1,1,1,30);
            robot.gyroTurn(90,1);

            }
        }

        }


