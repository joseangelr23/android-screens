package com.example.firstapp.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.remote.creation.first
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.firstapp.components.Contact

@Composable
fun MainScreen(navController: NavController, modifier: Modifier = Modifier) {

    var name by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var contacts by remember { mutableStateOf(listOf<Pair<String, String>>()) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Spacer(modifier = Modifier.height(25.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            Button(
                onClick = {
                    navController.navigate("welcome")
                },
                modifier = Modifier
                    .height(45.dp),
                shape = RoundedCornerShape(30.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Gray
                )
            ) {
                Text(
                    text = "Regresar",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        Text(text = "Nombre", fontWeight = FontWeight.Medium)

        Spacer(modifier = Modifier.height(6.dp))

        TextField(
            value = name,
            onValueChange = { name = it },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp)
        )

        Spacer(modifier = Modifier.height(12.dp))
        
        Text(text = "Teléfono", fontWeight = FontWeight.Medium)

        Spacer(modifier = Modifier.height(6.dp))

        TextField(
            value = phone,
            onValueChange = { phone = it },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                if (name.isNotEmpty() && phone.isNotEmpty()) {
                    contacts = contacts + Pair(name, phone)
                    name = ""
                    phone = ""
                }
            },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp),
            enabled = name.isNotEmpty() && phone.isNotEmpty()
        ) {
            Text("Agregar Contacto")
        }

        Spacer(modifier = Modifier.height(8.dp))

        Button(
            onClick = {
                name = ""
                phone = ""
            },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(containerColor = Color.LightGray),
            shape = RoundedCornerShape(12.dp)
        ) {
            Text("Limpiar Campos", color = Color.Black)
        }

        Spacer(modifier = Modifier.height(25.dp))

        Text(
            text = "Lista de Contactos",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(5.dp))

        LazyColumn {
            items(contacts) { contact ->
                Contact(
                    name = contact.first,
                    phone = contact.second
                )
                Spacer(modifier = Modifier.height(10.dp))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    MainScreen(navController = rememberNavController())
}
