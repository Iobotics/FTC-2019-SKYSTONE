package org.firstinspires.ftc.team8898;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name="AutoRed4", group="AutoRed4")
public class AutoRed4 extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {
        Bot robot = new Bot(this);
        robot.init(hardwareMap);
        robot.resetEncoder();
        waitForStart();
        robot.encoderDrive(.8,-10,-10,30);
        robot.gyroTurn(90,.8);
        robot.encoderDrive(.8,-30,-30,30);
        //change gyroTurn target to negative for blue

    }
}