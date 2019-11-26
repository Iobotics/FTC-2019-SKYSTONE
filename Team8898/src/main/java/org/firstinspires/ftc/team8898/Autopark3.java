package org.firstinspires.ftc.team8898;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
@Autonomous(name="Autopark3", group="Autopark3")
public class Autopark3 extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {
        Bot robot = new Bot(this);
        robot.init(hardwareMap);
        robot.resetEncoder();
        waitForStart();
        robot.encoderDrive(.8,-35,-35,30);


    }
}