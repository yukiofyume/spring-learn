package com.lwh.learn.pattern.design.creation.factory.simple;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author lwh
 * @version 1.0
 * @date 2023-05-10 16:38:32
 * @describe --
 */
@Slf4j
class CarsFactoryTest {

    @Test
    void carsFactoryCreateTest() {
        Car car = CarsFactory.getCar(CarType.FORD);
        log.info("car:{}", car.getDescription());
    }
}