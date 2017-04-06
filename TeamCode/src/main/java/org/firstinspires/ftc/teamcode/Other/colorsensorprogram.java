package org.firstinspires.ftc.teamcode.Other;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;

import org.firstinspires.ftc.teamcode.JoshRobot.JoshRobot;

/**
 * Created by robot on 1/25/2017.
 */
@Autonomous (name= "colorsensorprogram", group = "robot")
@Disabled
public class colorsensorprogram extends LinearOpMode{
    ColorSensor Colorsensor;
    ColorSensor whitesensor;
    JoshRobot robot = new JoshRobot();


    public void runOpMode() throws InterruptedException {
        robot.init(hardwareMap);

        Colorsensor = hardwareMap.colorSensor.get("sensor_color");
        whitesensor = hardwareMap.colorSensor.get("sensor_white");
        whitesensor.getI2cAddress();


        waitForStart();

        while (opModeIsActive()) {

            Colorsensor.enableLed(false);
            whitesensor.enableLed(true);
            Colorsensor.red();
            Colorsensor.blue();
            Colorsensor.green();
            Colorsensor.alpha();
            whitesensor.blue();
            whitesensor.green();
            whitesensor.red();
            whitesensor.alpha();



            telemetry.addData("2 Clear", whitesensor.alpha());
            telemetry.addData("3 Red  ", whitesensor.red());
            telemetry.addData("4 Green", whitesensor.green());
            telemetry.addData("5 Blue ", whitesensor.blue());
            telemetry.addData("6 Hue", whitesensor.argb());

            /*while (whitesensor.alpha() >= 20) {
                robot.rightMotor.setPower(.5);
            }*/
            idle();
        }
    }
}
