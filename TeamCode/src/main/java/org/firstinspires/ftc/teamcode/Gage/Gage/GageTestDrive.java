package org.firstinspires.ftc.teamcode.Gage.Gage;
//imports methods and hardware used within teleop

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
//Created by dream team memes on 10/17/2016.

@TeleOp(name = "Gagetestdrive", group = "Robot")

class GageTestDrive extends OpMode {
    gagestestrobot robot = new gagestestrobot();

    //This is for when you have something start when you press init
    @Override
    public void init() {
//meme
        //This initializes the hardware varibles
        robot.init(hardwareMap);
    }

    //This is for a constant loop that happens when you press init
    @Override
    public void init_loop() {
    }

    //This is for when you have something happen when you press start
    @Override
    public void start() {
    }

    //This is for a constant loop when you press start
    @Override
    public void loop() {

        //double variables, use these in methods that use (double)
        double Left;
        double Right;

        //defining double variables
        Left = -gamepad1.left_stick_x + gamepad1.left_stick_y;
        Right = -gamepad1.right_stick_x + gamepad1.right_stick_y;

        //setting power to motors using double variables
        robot.LeftUp.setPower(Left);
        robot.RightUp.setPower(Right);
    }

    //This is for a program to run after to stop
    @Override
    public void stop() {
        telemetry.addData("MEME MEME MEME MEME MEME", robot.hwMap);
    }
}


