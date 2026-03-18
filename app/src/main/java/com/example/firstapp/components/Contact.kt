package com.example.firstapp.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.firstapp.R


@Composable
fun Contact(name:String, phone:String){
    Row {
        Image(
            painter = painterResource(id = R.drawable.contact),
            contentDescription = "Foto de contacto",
            modifier = Modifier.size(64.dp)
        )

        Spacer(modifier = Modifier.size(18.dp))

        Column {
            Text(
                text = name,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.size(5.dp))

            Text(
                text = phone,
                fontSize = 15.sp)
        }
    }
    }

@Preview(showBackground = true)
@Composable
fun ContactPreview(){
    Contact("Jose Angel", "6121522842")
}