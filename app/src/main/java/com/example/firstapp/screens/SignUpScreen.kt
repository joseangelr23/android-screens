package com.example.firstapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.firstapp.R
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.TextField
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

@Composable
fun RegisterScreen(navController: NavController, modifier: Modifier = Modifier) {

    var name by remember { mutableStateOf("") }
    var mail by remember { mutableStateOf("") }
    var pass by remember { mutableStateOf("") }
    var confirmPass by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var nameError by remember { mutableStateOf(false) }
    var phoneError by remember { mutableStateOf(false) }
    var passwordError by remember { mutableStateOf(false) }
    var mailError by remember { mutableStateOf(false) }


    fun isValidEmail(email: String): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    fun isValidName(name: String): Boolean {
        return name.all { it.isLetter() || it.isWhitespace() }
    }

    fun isValidPhone(phone: String): Boolean {
        return phone.length == 10 && phone.all { it.isDigit() }
    }

    fun passwordsMatch(pass: String, confirmPass: String): Boolean {
        return pass == confirmPass && pass.isNotEmpty()
    }

    val formValid = nameError && mailError && phoneError && passwordError

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(modifier = Modifier.height(40.dp))

            Image(
                painter = painterResource(id = R.drawable.register),
                contentDescription = null,
                modifier = Modifier
                    .height(170.dp)
                    .fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "Crear Cuenta",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold
            )


            Spacer(modifier = Modifier.height(32.dp))

            TextField(
                value = name,
                onValueChange = {
                    name = it
                    nameError = isValidName(it) },
                label = { Text("Nombre") },
                modifier = Modifier.fillMaxWidth(),
                isError = !nameError,
                shape = RoundedCornerShape(20.dp),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text
                )
            )


            Spacer(modifier = Modifier.height(12.dp))

            TextField(
                value = mail,
                onValueChange = {
                    mail = it
                    mailError = isValidEmail(it) },
                label = { Text("Correo") },
                modifier = Modifier.fillMaxWidth(),
                isError = !mailError,
                shape = RoundedCornerShape(20.dp),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Email
                )
            )

            Spacer(modifier = Modifier.height(12.dp))

            TextField(
                value = pass,
                onValueChange = {pass = it},
                label = { Text("Contraseña") },
                modifier = Modifier.fillMaxWidth(),
                visualTransformation = PasswordVisualTransformation(),
                shape = RoundedCornerShape(20.dp),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password
                )
            )

            Spacer(modifier = Modifier.height(12.dp))

            TextField(
                value = confirmPass,
                onValueChange = {
                    confirmPass = it
                    passwordError = passwordsMatch(pass, it) },
                label = { Text("Confirmar Contraseña") },
                modifier = Modifier.fillMaxWidth(),
                isError = !passwordError,
                visualTransformation = PasswordVisualTransformation(),
                shape = RoundedCornerShape(20.dp),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password
                )
            )

            Spacer(modifier = Modifier.height(12.dp))

            TextField(
                value = phone,
                onValueChange = {
                    phone = it
                    phoneError = isValidPhone(it) },
                label = { Text("Teléfono") },
                modifier = Modifier.fillMaxWidth(),
                isError = !phoneError,
                shape = RoundedCornerShape(20.dp),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number
                )
            )

            Spacer(modifier = Modifier.height(40.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
            ){
                Button(
                    onClick = {
                        navController.navigate("welcome")
                    },
                    modifier = Modifier
                        .weight(1f)
                        .height(60.dp),
                    shape = RoundedCornerShape(30.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Gray
                    )
                ) {
                    Text(
                        text = "Regresar",
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )
                }

                Spacer(modifier = Modifier.width(15.dp))

                Button(
                    onClick = {
                        navController.navigate("main")
                    },
                    enabled = formValid,
                    modifier = Modifier
                        .weight(1f)
                        .height(60.dp),
                    shape = RoundedCornerShape(30.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF4644AA)
                    )
                ) {
                    Text(
                        text = "Aceptar",
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )
                }
            }

        }
    }
}

@Preview
@Composable
fun RegisterPreview() {
    val navController = rememberNavController()

    RegisterScreen(navController = navController)
}