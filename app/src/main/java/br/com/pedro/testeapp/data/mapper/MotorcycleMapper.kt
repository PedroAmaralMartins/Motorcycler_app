package br.com.pedro.testeapp.data.mapper

import br.com.pedro.testeapp.data.model.MotorcycleInfo
import br.com.pedro.testeapp.ui.Motorcycler

fun MotorcycleInfo.toDomain(): Motorcycler {
    return Motorcycler(
        nameMotorCycler = "$make $model",
        yearMotorCycler = year.orEmpty(),
        imagem = null,
        typeMot = type.orEmpty(),
        displacementMot = displacement.orEmpty(),
        engineMot = engine.orEmpty(),
        powerMot = power.orEmpty(),
        torqueMot = torque.orEmpty(),
        compressionMot = compression.orEmpty(),
        bore_strokeMot = bore_stroke.orEmpty(),
        valves_per_cylinderMot = valves_per_cylinder.orEmpty(),
        fuel_systemMot = fuel_system.orEmpty(),
        fuel_controlMot = fuel_control.orEmpty(),
        ignitionMot = ignition.orEmpty(),
        lubricationMot = lubrication.orEmpty(),
        coolingMot = cooling.orEmpty(),
        gearboxMot = gearbox.orEmpty(),
        transmissionMot = transmission.orEmpty(),
        clutchMot = clutch.orEmpty(),
        frameMot = frame.orEmpty(),
        front_suspensionMot = front_suspension.orEmpty(),
        front_wheel_travelMot = front_wheel_travel.orEmpty(),
        rear_suspensionMot = rear_suspension.orEmpty(),
        rear_wheel_travelMot = rear_wheel_travel.orEmpty(),
        front_tireMot = front_tire.orEmpty(),
        rear_tireMot = rear_tire.orEmpty(),
        front_brakesMot = front_brakes.orEmpty(),
        rear_brakesMot = rear_brakes.orEmpty(),
        total_weightMot = total_weight.orEmpty(),
        seat_heightMot = seat_height.orEmpty(),
        total_heightMot = total_height.orEmpty(),
        total_lengthMot = total_length.orEmpty(),
        total_widthMot = total_width.orEmpty(),
        ground_clearanceMot = ground_clearance.orEmpty(),
        wheelbaseMot = wheelbase.orEmpty(),
        fuel_capacityMot = fuel_capacity.orEmpty(),
        starterMot = starter.orEmpty()
    )
}
