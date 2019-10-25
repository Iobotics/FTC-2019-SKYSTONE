package org.firstinspires.ftc.team8898;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
@Autonomous(name="AutoRed3", group="AutoRed3")
public class AutoRed3 extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {
        Bot robot = new Bot(this);
        robot.init(hardwareMap);
        robot.resetEncoder();
        waitForStart();
        robot.encoderDrive(.8,5,5,30);
        robot.gyroTurn(90,.8);
        robot.encoderDrive(.8,30,30,30);
        //change gyroTurn target to negative for blue

    }
}