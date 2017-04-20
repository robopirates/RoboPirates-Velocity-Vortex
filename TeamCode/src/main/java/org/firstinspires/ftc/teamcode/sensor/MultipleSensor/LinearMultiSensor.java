package org.firstinspires.ftc.teamcode.sensor.MultipleSensor;

import android.graphics.Color;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.I2cAddr;

import org.firstinspires.ftc.teamcode.TestRobots.TestRobot;

/**
 * Created by robot on 3/24/2017.
 */
@Autonomous (name = "LinearMultiSensor", group = "robot")
public class LinearMultiSensor extends LinearOpMode {
    TestRobot robot = new TestRobot();
    ColorSensor color0;
    ColorSensor color1;


    @Override
    public void runOpMode() throws InterruptedException {

        color0 = hardwareMap.colorSensor.get("0");
        color0.setI2cAddress(I2cAddr.create8bit(0x3c));
        color1 = hardwareMap.colorSensor.get("1");
        color1.setI2cAddress(I2cAddr.create8bit(0x4c));
        waitForStart();


        while (opModeIsActive()) {
            if (color0.red()>= 200) {
                robot.leftMotor.setPower(.5);
                sleep(1000);
            }
            else{
                robot.leftMotor.setPower(0);
            }
            sleep(5000);
            if (color1.red()>= 200) {
                robot.rightMotor.setPower(.5);
                sleep(1000);
            }
            else{
                robot.rightMotor.setPower(0);
            }
            sleep(5000);
            color0.red();
            color1.red();

            telemetry.addData("0 reads:", color0.red());
            telemetry.addData("1 reads:", color1.red());
            telemetry.update();

            idle();
        }
    }

}
