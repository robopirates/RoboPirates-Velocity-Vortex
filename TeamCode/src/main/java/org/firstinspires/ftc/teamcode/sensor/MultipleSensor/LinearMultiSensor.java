package org.firstinspires.ftc.teamcode.sensor.MultipleSensor;

import android.graphics.Color;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.I2cAddr;

/**
 * Created by robot on 3/24/2017.
 */
@Autonomous (name = "LinearMultiSensor", group = "robot")
public class LinearMultiSensor extends LinearOpMode {
    ColorSensor color0;
    ColorSensor color1;

    @Override
    public void runOpMode() throws InterruptedException {

        color0 = hardwareMap.colorSensor.get("0");
        color0.setI2cAddress(I2cAddr.create8bit(0x3c));
        color1 = hardwareMap.colorSensor.get("1");
        color0.setI2cAddress(I2cAddr.create8bit(0x4c));
        waitForStart();


        while (opModeIsActive()) {
            color0.red();
            color1.red();

            telemetry.addData("0 reads:", color0.red());
            telemetry.addData("1 reads:", color1.red());
            telemetry.update();
            idle();
        }
    }

}
