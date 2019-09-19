package org.firstinspires.ftc.team8898;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name="Basic: OpMode", group="Iterative Opmode")

public class Teleop extends LinearOpMode{
    private Bot robot = new Bot(this);


    @Override
    
    public void runOpMode() throws InterruptedException {
       robot.init(hardwareMap);
       robot.setServo1(1);
       robot.setServo2(0);
       waitForStart();

       while(opModeIsActive()) {
           robot.setPower(gamepad1.left_stick_y, gamepad1.right_stick_y);
           if (gamepad1.a == true){
               robot.setServo1(0.5);
               robot.setServo2(0.5);
           }

           else{
               robot.setServo1(1);
               robot.setServo2(0);
           }
           if (gamepad1.b == true);{
               robot.setServo3(0);
               robot.setServo4(1);
           }
       }
    }

}
