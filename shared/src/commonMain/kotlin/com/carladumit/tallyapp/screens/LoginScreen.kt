package com.carladumit.tallyapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.material3.OutlinedButton
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
import tallyapp.shared.generated.resources.google

@Composable
fun LoginScreen() {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }
    var message by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(40.dp, 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        //verticalArrangement = Arrangement.Center
    ){
        Spacer(modifier = Modifier.height(52.dp))

        // LOGOTIPO
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
            text = "Inicia sesión",
            fontSize = 24.sp,
            color = TallyGreen
        )

        Spacer(modifier = Modifier.height(20.dp))

        // CAMPO DE CORREO
        InputField(
            value = email,
            onValueChange = { email = it },
            label = "Correo electrónico",
            placeholder = "ejemplo@email.com",
            keyboardType = KeyboardType.Email
        )

        Spacer(modifier = Modifier.height(20.dp))

        // CAMPO DE CONTRASEÑA
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

        // BOTÓN PRINCIPAL
        Button(
            onClick = {
                message = if (email.isBlank() || password.isBlank()) {
                    "Introduce tu correo y contraseña"
                } else {
                    "Iniciando sesión"
                }
            },
            modifier = Modifier.fillMaxWidth().height(52.dp),
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(containerColor = TallyGreen, contentColor = Color.White)
        ) {
            Text(
                text = "Iniciar Sesión",
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        // RECUPERAR CONTRASEÑA
        OutlinedButton(
            onClick = { },
            modifier = Modifier.fillMaxWidth().height(52.dp),
            shape = RoundedCornerShape(8.dp),
            border = androidx.compose.foundation.BorderStroke(1.dp, TallyGreen),
            colors = ButtonDefaults.outlinedButtonColors(contentColor = TallyGreen)
        ) {
            Text(
                text = "¿Olvidó su contraseña?",
                fontSize = 16.sp
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        // SEPARADOR O
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .height(1.dp)
                    .background(BorderColor)
            )

            Text(
                text = "  o  ",
                fontSize = 16.sp,
                color = BorderColor
            )

            Box(
                modifier = Modifier
                    .weight(1f)
                    .height(1.dp)
                    .background(BorderColor)
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        // BOTÓN GOOGLE
        OutlinedButton(
            onClick = { message = "Inicio de sesión con Google" },
            modifier = Modifier.fillMaxWidth().height(52.dp),
            shape = RoundedCornerShape(8.dp),
            border = androidx.compose.foundation.BorderStroke(1.dp, BorderColor),
            colors = ButtonDefaults.outlinedButtonColors(contentColor = BorderColor)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(Res.drawable.google),
                    contentDescription = "Google",
                    modifier = Modifier.size(width = 32.dp, height = 32.dp),
                    contentScale = ContentScale.Fit
                )

                Spacer(modifier = Modifier.width(20.dp))

                Text(
                    text = "Iniciar con Google",
                    fontSize = 16.sp
                )
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        // PIE DE PÁGINA
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Si no tienes cuenta, crea una ",
                fontSize = 16.sp,
                color = BorderColor
            )

            Text(
                text = "ahora",
                fontSize = 16.sp,
                color = TallyGreen,
                modifier = Modifier.clickable { message = "Crear una cuenta" }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    LoginScreen()
}
