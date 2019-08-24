package buu.informatics.s59160586.bookparking

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import android.app.Activity



class MainActivity : AppCompatActivity() {
    var parking = listOf<ParkData>(ParkData() , ParkData() , ParkData())
    var pickSlot = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setListener()
    }

    fun setListener () {
        var slotClick = listOf<TextView>(findViewById(R.id.park1_button) , findViewById(R.id.park2_button) , findViewById(R.id.park3_button))
        for (i in slotClick) {
            i.setOnClickListener{
                fectInfo(i)
            }
        }
        findViewById<Button>(R.id.update_button).setOnClickListener{setInfo()}
        findViewById<Button>(R.id.delete_button).setOnClickListener{deleteInfo()}
    }

    fun fectInfo(view: TextView){

        pickSlot = view.id.toString()
        //Toast.makeText(this , pickSlot , Toast.LENGTH_SHORT).show()
        checkSlot()
        when(view.id){
            R.id.park1_button -> {
                findViewById<TextView>(R.id.carNum_text).requestFocus()
                findViewById<TextView>(R.id.carNum_text).text = parking.get(0).carId
                findViewById<TextView>(R.id.name_text).text = parking.get(0).ownerName
                findViewById<TextView>(R.id.brand_text).text = parking.get(0).carBrand
            }
            R.id.park2_button -> {
                findViewById<TextView>(R.id.carNum_text).requestFocus()
                findViewById<TextView>(R.id.carNum_text).text = parking.get(1).carId
                findViewById<TextView>(R.id.name_text).text = parking.get(1).ownerName
                findViewById<TextView>(R.id.brand_text).text = parking.get(1).carBrand
            }
            R.id.park3_button -> {
                findViewById<TextView>(R.id.carNum_text).requestFocus()
                findViewById<TextView>(R.id.carNum_text).text = parking.get(2).carId
                findViewById<TextView>(R.id.name_text).text = parking.get(2).ownerName
                findViewById<TextView>(R.id.brand_text).text = parking.get(2).carBrand
            }
        }
    }

    fun setInfo () {
        if(selected()){
            if(checkInput()){
                when (pickSlot){
                    R.id.park1_button.toString() -> {
                        parking[0].carId = findViewById<TextView>(R.id.carNum_text).text.toString()
                        parking[0].ownerName = findViewById<TextView>(R.id.name_text).text.toString()
                        parking[0].carBrand = findViewById<TextView>(R.id.brand_text).text.toString()
                    }
                    R.id.park2_button.toString() -> {
                        parking[1].carId = findViewById<TextView>(R.id.carNum_text).text.toString()
                        parking[1].ownerName = findViewById<TextView>(R.id.name_text).text.toString()
                        parking[1].carBrand = findViewById<TextView>(R.id.brand_text).text.toString()
                    }
                    R.id.park3_button.toString() -> {
                        parking[2].carId = findViewById<TextView>(R.id.carNum_text).text.toString()
                        parking[2].ownerName = findViewById<TextView>(R.id.name_text).text.toString()
                        parking[2].carBrand = findViewById<TextView>(R.id.brand_text).text.toString()
                    }
                }
                clearTextInput()
                Toast.makeText(this , "Successes " , Toast.LENGTH_SHORT).show()
                checkSlot()
                pickSlot = ""
            }else{
                Toast.makeText(this , "Please fill all in put text. " , Toast.LENGTH_SHORT).show()
            }
        }else{
            Toast.makeText(this , "Please select parking slot." , Toast.LENGTH_SHORT).show()
        }
    }

    fun selected() : Boolean {
        if(pickSlot == ""){
            return false
        }else{
            return true
        }
    }

    fun clearTextInput() {
        var input = listOf<TextView>(findViewById(R.id.carNum_text) , findViewById(R.id.name_text) , findViewById(R.id.brand_text))
        for (i in input){
            i.text = ""
        }
    }

    fun checkSlot() {
        for ( i in 0..parking.size-1){
            if(parking[i].ownerName != ""){
                if(i == 0){
                    findViewById<TextView>(R.id.park1_button).text = "Full"
                }else if(i == 1) {
                    findViewById<TextView>(R.id.park2_button).text = "Full"
                }else{
                    findViewById<TextView>(R.id.park3_button).text = "Full"
                }
            }else{
                if(i == 0){
                    findViewById<TextView>(R.id.park1_button).text = "Empty"
                }else if(i == 1) {
                    findViewById<TextView>(R.id.park2_button).text = "Empty"
                }else{
                    findViewById<TextView>(R.id.park3_button).text = "Empty"
                }
            }
        }
    }

    fun checkInput() : Boolean {
        var slotClick = listOf<TextView>(findViewById(R.id.carNum_text) , findViewById(R.id.name_text) , findViewById(R.id.brand_text))
        var flag = true
        for (i in slotClick){
            if(i.text.toString() == ""){
                flag = false
                break
            }
        }

        return flag
    }

    fun deleteInfo() {
        when(pickSlot){

            R.id.park1_button.toString() ->{
                parking[0].carId = ""
                parking[0].ownerName = ""
                parking[0].carBrand = ""
            }
            R.id.park2_button.toString() ->{
                parking[1].carId = ""
                parking[1].ownerName = ""
                parking[1].carBrand = ""
            }
            R.id.park3_button.toString() ->{
                parking[2].carId = ""
                parking[2].ownerName = ""
                parking[2].carBrand = ""
            }

        }
        checkSlot()
        clearTextInput()
    }

}
