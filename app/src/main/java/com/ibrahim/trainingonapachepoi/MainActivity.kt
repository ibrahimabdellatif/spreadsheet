package com.ibrahim.trainingonapachepoi

import android.os.Bundle
import android.os.Environment
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts.GetContent
import androidx.appcompat.app.AppCompatActivity
import com.evrencoskun.tableview.TableView
import org.apache.poi.hssf.usermodel.HSSFWorkbook
import java.io.File
import java.io.FileInputStream


class MainActivity : AppCompatActivity() {

    private lateinit var inputET: TextView
    private lateinit var saveFileBtn: Button
    private lateinit var showDataTV: TextView

    private lateinit var tableView: TableView

    //private var filePath = File("${Environment.getExternalStorageDirectory()}/Demo.xlsx")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        inputET = findViewById(R.id.ed_file_name)
        saveFileBtn = findViewById(R.id.btn_safe_file)
        showDataTV = findViewById(R.id.tv_data)

        //to choose file form local storage and get file path
        val pick = registerForActivityResult(GetContent()) { result ->
            showDataTV.text = result.path
            //val inputStream: InputStream? = contentResolver.openInputStream(result.lastPathSegment)

        }

        saveFileBtn.setOnClickListener {
            //to choose file form local storage
            //pick.launch("*/*")

            getDataFromSheet()
        }

    }


    //this button to create an excel file
    private fun getDataFromSheet() {
        //here we specify to downloads folder then i put the specific file with his name inside it
        val folder = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)
        val myFile = File(folder, "Demo.xlsx")
        val fileInputStream = FileInputStream(myFile)

//        val factory = WorkbookFactory.create(input)
        val workbook = HSSFWorkbook(fileInputStream)
        val xlws = workbook.getSheetAt(0)
        val data = xlws.getRow(0).getCell(0)
        inputET.text = data.toString()


    }
}