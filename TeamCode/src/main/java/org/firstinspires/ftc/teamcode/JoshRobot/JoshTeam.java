package org.firstinspires.ftc.teamcode.JoshRobot;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by Joshua on 10/17/2016.
 */
@TeleOp(name = "JoshTeam", group = "Robot")

public class JoshTeam extends OpMode {
    JoshRobot robot = new JoshRobot();
    final static double CLAW_MIN_RANGE = 0;
    final static double CLAW_MAX_RANGE = 1.0;




    //This is for when you have something start when you press init
    @Override
    public void init() {
        //This initializes the hardware varibles
        robot.init(hardwareMap);
        robot.rightMotor.setDirection(DcMotor.Direction.REVERSE);
        //robot.clawleft.setPosition(1);
        //robot.clawright.setPosition(1);



    }

    //This is for a constant loop that happens when you press init
    @Override
    public void init_loop() {

    }

    //This is for when you have something happen when you press start
    @Override
    public void start() {

    }

    //This is for a constant loop when you press star
    @Override
    public void loop() {
        double left;
        double right;
        double spin;
        double arm;
        double colormotorforward;
        double colormotorbackward;
        //double leftarm;
        //double rightarm;
        double claw_position = 1;
        double clawdelta = .5;

        left = gamepad1.left_stick_x - gamepad1.left_stick_y;
        right = gamepad1.right_stick_x + gamepad1.right_stick_y;
        spin = gamepad2.left_stick_x + gamepad2.left_stick_y;
        arm = gamepad2.right_stick_x + gamepad2.right_stick_y;
        colormotorforward = gamepad2.left_trigger;
        colormotorbackward = gamepad2.right_trigger;
        //leftarm = gamepad1.left_trigger;
        //rightarm = gamepad1.right_trigger;




        robot.leftMotor.setPower(left);
        robot.rightMotor.setPower(right);
        robot.spinMotor.setPower(spin/2);
        robot.armMotor.setPower(arm);
        robot.colorMotor.setPower(-colormotorforward);
        robot.colorMotor.setPower(colormotorbackward);
        //robot.leftarmMotor.setPower(leftarm);
        //robot.rightarmMotor.setPower(rightarm);
        //robot.BucketUp.setPosition; (180);

        /*if (gamepad2.a) {
            robot.BucketUp.setPosition(1);

        }
        else {
            robot.BucketUp.setPosition(.54);
        }
        if (gamepad2.b) {
            robot.BucketUp.setPosition(0);

        }
        else {
            robot.BucketUp.setPosition(.54);
        }
        if (gamepad1.a) {
            claw_position -= clawdelta;
        }
        if (gamepad1.b) {
            claw_position += clawdelta;
        }*/

        //claw_position = Range.clip(claw_position, CLAW_MIN_RANGE, CLAW_MAX_RANGE);

        //robot.clawleft.setPosition(claw_position);
        //robot.clawright.setPosition(claw_position);



        /*//This is for a program to run after to stop
        @Override
        public void stop() {
        }*/

    }
}


