package br.com.pedro.testeapp.data.mapper

import br.com.pedro.testeapp.data.model.MotorcycleInfo
import br.com.pedro.testeapp.domain.Motorcycler

fun MotorcycleInfo.toDomain(): Motorcycler {
    return Motorcycler(
        nameMotorCycler = "$make $model",
        yearMotorCycler = year.orEmpty(),
        imagem = null,
        type = type.orEmpty(),
        displacement = displacement.orEmpty(),
        engine = engine.orEmpty(),
        power = power.orEmpty(),
        torque = torque.orEmpty(),
        compression = compression.orEmpty(),
        boreStroke = bore_stroke.orEmpty(),
        valvesPerCylinder = valves_per_cylinder.orEmpty(),
        fuelSystem = fuel_system.orEmpty(),
        fuelControl = fuel_control.orEmpty(),
        ignition = ignition.orEmpty(),
        lubrication= lubrication.orEmpty(),
        cooling = cooling.orEmpty(),
        gearbox = gearbox.orEmpty(),
        transmission = transmission.orEmpty(),
        clutch = clutch.orEmpty(),
        frame = frame.orEmpty(),
        frontSuspension = front_suspension.orEmpty(),
        frontWheelTravel = front_wheel_travel.orEmpty(),
        rearSuspension = rear_suspension.orEmpty(),
        rearWheelTravel = rear_wheel_travel.orEmpty(),
        frontTire = front_tire.orEmpty(),
        rearTire = rear_tire.orEmpty(),
        frontBrakes = front_brakes.orEmpty(),
        rearBrakes = rear_brakes.orEmpty(),
        totalWeight = total_weight.orEmpty(),
        seatHeight = seat_height.orEmpty(),
        totalHeight = total_height.orEmpty(),
        totalLength = total_length.orEmpty(),
        totalWidth = total_width.orEmpty(),
        groundClearance = ground_clearance.orEmpty(),
        wheelbase = wheelbase.orEmpty(),
        fuelCapacity = fuel_capacity.orEmpty(),
        starter = starter.orEmpty()
    )
}
