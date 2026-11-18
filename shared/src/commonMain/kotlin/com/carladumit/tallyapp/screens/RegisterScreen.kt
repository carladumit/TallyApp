package com.carladumit.tallyapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.carladumit.tallyapp.TallyGreen
import com.carladumit.tallyapp.BorderColor
import com.carladumit.tallyapp.components.InputField
import org.jetbrains.compose.resources.painterResource
import tallyapp.shared.generated.resources.Res
import tallyapp.shared.generated.resources.logo

@Composable
fun RegisterScreen(
    onNavigateToLogin: () -> Unit
) {
    var nombre by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }
    var pais by remember { mutableStateOf("") }
    var message by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(40.dp, 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ){
        Spacer(modifier = Modifier.height(52.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ){
            Image(
                painter = painterResource(Res.drawable.logo),
                contentDescription = "Logo de Tally",
                modifier = Modifier.size(width = 100.dp, height = 100.dp),contentScale = ContentScale.Fit
            )

            Spacer(modifier = Modifier.width(16.dp))

            Text(
                text = "Tally",
                fontSize = 72.sp,
                fontWeight = FontWeight.Bold,
                lineHeight = 86.4.sp,
                color = Color.Black,
                letterSpacing = (-1.5).sp
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Crea una cuenta",
            fontSize = 24.sp,
            color = TallyGreen
        )

        Spacer(modifier = Modifier.height(20.dp))

        InputField(
            value = nombre,
            onValueChange = { nombre = it },
            label = "Nombre y Apellidos",
            placeholder = "Nombre",
        )

        Spacer(modifier = Modifier.height(20.dp))

        InputField(
            value = email,
            onValueChange = { email = it },
            label = "Correo electrónico",
            placeholder = "ejemplo@email.com",
            keyboardType = KeyboardType.Email
        )

        Spacer(modifier = Modifier.height(20.dp))

        InputField(
            value = password,
            onValueChange = { password = it },
            label = "Contraseña",
            placeholder = "**********",
            password = true,
            passwordVisible = passwordVisible,
            onTogglePassword = { passwordVisible = !passwordVisible }
        )

        Spacer(modifier = Modifier.height(20.dp))

        InputField(
            value = confirmPassword,
            onValueChange = { confirmPassword = it },
            label = "Repetir contraseña",
            placeholder = "**********",
            password = true,
            passwordVisible = passwordVisible,
            onTogglePassword = { passwordVisible = !passwordVisible }
        )

        Spacer(modifier = Modifier.height(20.dp))

        InputField(
            value = pais,
            onValueChange = { pais = it },
            label = "País",
            placeholder = "España",
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {
                message = when {
                    nombre.isBlank() && email.isBlank() && password.isBlank() && confirmPassword.isBlank() && pais.isBlank() -> "Todos los campos son obligatorios"
                    nombre.isBlank() -> "Introduce tu nombre y apellidos"
                    email.isBlank() -> "Introduce tu correo electrónico"
                    !email.contains("@") -> "Introduce un correo electrónico válido"
                    password.isBlank() -> "Introduce una contraseña"
                    password.length < 8 -> "La contraseña debe tener al menos 8 caracteres"
                    confirmPassword != password -> "Las contraseñas no coinciden"
                    pais.isBlank() -> "Introduce tu país"
                    else -> "Validacion correcta"
                }
            },
            modifier = Modifier.fillMaxWidth().height(52.dp),
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(containerColor = TallyGreen, contentColor = Color.White)
        ) {
            Text(
                text = "Crear Cuenta",
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal
            )
        }

        if (message.isNotEmpty()) {
            Text(
                text = message,
                color = TallyGreen,
                fontSize = 14.sp
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "¿Ya tienes cuenta? Inicia sesión ",
                fontSize = 16.sp,
                color = BorderColor
            )

            Text(
                text = "aquí",
                fontSize = 16.sp,
                color = TallyGreen,
                modifier = Modifier.clickable { onNavigateToLogin() }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RegisterScreenPreview() {
    RegisterScreen(onNavigateToLogin = {})
}
