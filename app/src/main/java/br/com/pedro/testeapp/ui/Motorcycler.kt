package br.com.pedro.testeapp.ui

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.math.BigDecimal

@Parcelize
data class Motorcycler(
    val nameMotorCycler: String,
    val yearMotorCycler: String,
    val imagem: String? = null,
    val typeMot: String = "",
    val displacementMot: String = "",
    val engineMot: String = "",
    val powerMot: String = "",
    val torqueMot: String = "",
    val compressionMot: String = "",
    val bore_strokeMot: String = "",
    val valves_per_cylinderMot: String = "",
    val fuel_systemMot: String = "",
    val fuel_controlMot: String = "",
    val ignitionMot: String = "",
    val lubricationMot: String = "",
    val coolingMot: String = "",
    val gearboxMot: String = "",
    val transmissionMot: String = "",
    val clutchMot: String = "",
    val frameMot: String = "",
    val front_suspensionMot: String = "",
    val front_wheel_travelMot: String = "",
    val rear_suspensionMot: String = "",
    val rear_wheel_travelMot: String = "",
    val front_tireMot: String = "",
    val rear_tireMot: String = "",
    val front_brakesMot: String = "",
    val rear_brakesMot: String = "",
    val total_weightMot: String = "",
    val seat_heightMot: String = "",
    val total_heightMot: String = "",
    val total_lengthMot: String = "",
    val total_widthMot: String = "",
    val ground_clearanceMot: String = "",
    val wheelbaseMot: String = "",
    val fuel_capacityMot: String = "",
    val starterMot: String = "",
): Parcelable
{
}