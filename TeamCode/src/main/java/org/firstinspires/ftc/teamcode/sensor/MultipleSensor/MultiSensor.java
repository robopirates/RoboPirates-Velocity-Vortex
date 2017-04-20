package org.firstinspires.ftc.teamcode.sensor.MultipleSensor;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.I2cAddr;
/**
 * Created by robot on 3/20/2017.
 */
@TeleOp(name = "MultiSensor", group = "Robot")

public class MultiSensor extends OpMode {
    ColorSensor color0;
    ColorSensor color1;

    public void init(){
        color0 = hardwareMap.colorSensor.get("0");
        color0.setI2cAddress(I2cAddr.create8bit(0x3c));
        color1 = hardwareMap.colorSensor.get("1");
        color1.setI2cAddress(I2cAddr.create8bit(0x4c));

    }

    public void loop(){
        telemetry.addData("0 reads:", color0.red());
        telemetry.addData("1 reads:", color1.red());
    }
}
