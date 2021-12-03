package com.ibrahim.trainingonapachepoi

import android.os.Bundle
import android.os.Environment
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import org.apache.poi.hssf.usermodel.HSSFWorkbook
import java.io.File
import java.io.FileOutputStream

//this code make you to write in first cell in excel sheet and create it with static name
class MainActivity : AppCompatActivity() {
    private lateinit var inputET: EditText
    private lateinit var saveFileBtn: Button
    private var filePath = File("${Environment.getExternalStorageDirectory()}/Demo.xlsx")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        inputET = findViewById(R.id.ed_file_name)
        saveFileBtn = findViewById(R.id.btn_safe_file)

        saveFileBtn.setOnClickListener {
            saveButton()
            Toast.makeText(this , filePath.toString() , Toast.LENGTH_LONG).show()

        }
    }

    //this button to create an excel file
    fun saveButton() {
        val workbook = HSSFWorkbook()
        val sheet = workbook.createSheet("My First Sheet")

        val row = sheet.createRow(0)
        val cell = row.createCell(0)

        cell.setCellValue(inputET.text.toString())

        if (!filePath.exists()) filePath.createNewFile()

        val fileOutputStream = FileOutputStream(filePath)

        workbook.write(fileOutputStream)

        fileOutputStream.flush()
        fileOutputStream.close()

    }
}