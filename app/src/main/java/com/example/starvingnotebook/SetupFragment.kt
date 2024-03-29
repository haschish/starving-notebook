package com.example.starvingnotebook

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.google.android.material.textfield.TextInputEditText

const val APP_PREFERENCES = "APP_PREFERENCES"
const val PREF_SETUP_USER_NAME = "PREF_SETUP_USER_NAME"
const val PREF_SETUP_WEIGHT_USER = "PREF_SETUP_WEIGHT_USER"
const val PREF_SETUP_HEIGHT_USER = "PREF_SETUP_HEIGHT_USER"

class SetupFragment : Fragment() {

    private lateinit var preferences: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        preferences =  requireActivity().getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE)

        val view = inflater.inflate(R.layout.fragment_setup, container, false)

        view.findViewById<TextInputEditText>(R.id.inputSetupNameUser).setText(preferences.getString(
            PREF_SETUP_USER_NAME, ""))
        view.findViewById<TextInputEditText>(R.id.inputSetupWeightUser).setText(preferences.getString(
            PREF_SETUP_WEIGHT_USER, ""))
        view.findViewById<TextInputEditText>(R.id.inputSetupHeightUser).setText(preferences.getString(
            PREF_SETUP_HEIGHT_USER, ""))

        view.findViewById<Button>(R.id.saveSetupButton).setOnClickListener {
            val  valueName = requireView().findViewById<TextInputEditText>(R.id.inputSetupNameUser).text.toString()
            val valueWeight = requireView().findViewById<TextInputEditText>(R.id.inputSetupWeightUser).text.toString()
            val valueHeight = requireView().findViewById<TextInputEditText>(R.id.inputSetupHeightUser).text.toString()
            preferences.edit()
                .putString(PREF_SETUP_USER_NAME, valueName)
                .putString(PREF_SETUP_WEIGHT_USER, valueWeight)
                .putString(PREF_SETUP_HEIGHT_USER, valueHeight)
                .apply()
        }
        return view
    }
}