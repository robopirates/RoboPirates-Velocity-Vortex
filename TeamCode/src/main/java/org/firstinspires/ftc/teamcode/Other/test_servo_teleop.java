package org.firstinspires.ftc.teamcode.Other;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by robot on 1/17/2017.
 */

public class test_servo_teleop extends OpMode {
    Servo leftclaw;
    Servo rightclaw;

    @Override
    public void init() {
        leftclaw = hardwareMap.servo.get("leftclaw");
        rightclaw = hardwareMap.servo.get("rightclaw");
    }

    @Override
    public void loop() {

        if (gamepad1.x) {
            leftclaw.setPosition(1);
            rightclaw.setPosition(1);

        } else {
            leftclaw.setPosition(0);
            rightclaw.setPosition(0);
        }
    }
}
